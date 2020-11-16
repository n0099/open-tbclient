package com.baidu.webkit.internal.daemon;

import android.content.Context;
import com.baidu.webkit.internal.CfgFileUtils;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidu.webkit.internal.resource.IResourceTask;
import com.baidu.webkit.internal.resource.ResourceSchedulerEngine;
import com.baidu.webkit.net.BdNet;
import com.baidu.webkit.net.BdNetTask;
import com.baidu.webkit.net.INetListener;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import com.baidu.webkit.sdk.WebSettings;
import com.baidu.webkit.sdk.WebViewFactory;
import com.baidubce.http.Headers;
import java.io.ByteArrayOutputStream;
import java.util.Map;
/* loaded from: classes5.dex */
public class PacDownload implements IResourceTask, INetListener {
    private static final String LOG_TAG = "PacDownload";
    private static boolean mDownloading;
    public static boolean mPacFreeFlowSucced;
    public static boolean mPacSucced;
    private static WebSettings.ProxyType mPacType = WebSettings.ProxyType.NO_PROXY;
    private ByteArrayOutputStream mData = null;
    private boolean mFreeFlowEnabled;
    private Map<String, String> mHeader;

    private boolean getFreeFlowEnabled() {
        return this.mFreeFlowEnabled;
    }

    public static String getUrl(Context context, boolean z) {
        String str = (((WebSettingsGlobalBlink.getPacUrl() + "?ProxyType=") + WebSettingsGlobalBlink.getProxyType()) + "&SdkVer=") + WebKitFactory.getSdkVersionName();
        mPacType = WebSettingsGlobalBlink.getProxyType();
        if (z) {
            str = str + "&mianliu=true";
        }
        Log.w(LOG_TAG, "get url " + str);
        return str;
    }

    public static void restoreLastData() {
        try {
            String str = CfgFileUtils.get(CfgFileUtils.KEY_PAC_DATA, (String) null);
            if (str == null) {
                Log.w(LOG_TAG, "restoreLastData null");
            } else {
                Log.w(LOG_TAG, "restoreLastData  " + str);
                WebSettingsGlobalBlink.setPacData(str);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void restoreLastDataFreeFLow() {
        try {
            String str = CfgFileUtils.get(CfgFileUtils.KEY_PAC_FREE_FLOW_DATA, (String) null);
            if (str == null) {
                Log.w(LOG_TAG, "restoreLastDataFreeFLow null");
            } else {
                Log.w(LOG_TAG, "restoreLastDataFreeFLow  " + str);
                WebSettingsGlobalBlink.setPacDataFreeFlow(str);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void tryToDownLoadAsync(Context context) {
        String pacUrl;
        if (WebSettingsGlobalBlink.isSFSwitchEnabled()) {
            Log.i(LOG_TAG, "tryToDownLoadAsync return");
        } else if (WebKitFactory.getCurEngine() != 1) {
            Log.w(LOG_TAG, "tryToDownLoadAsync engine not ok ");
        } else if (!WebKitFactory.getNeedDownloadCloudResource()) {
            Log.w(LOG_TAG, " tryToDownLoadAsync1  return");
            restoreLastData();
        } else {
            restoreLastData();
            if (WebSettingsGlobalBlink.getProxyType() != WebSettings.ProxyType.NO_PROXY || WebSettingsGlobalBlink.getHijackEnv()) {
                if ((mPacFreeFlowSucced && mPacSucced) || (pacUrl = WebSettingsGlobalBlink.getPacUrl()) == null || pacUrl.length() == 0) {
                    return;
                }
                try {
                    PacDownload pacDownload = new PacDownload();
                    if (ResourceSchedulerEngine.getInstance().registTaskAndListener(pacDownload, null)) {
                        return;
                    }
                    BdNet bdNet = new BdNet(context);
                    bdNet.setEventListener(pacDownload);
                    BdNetTask bdNetTask = new BdNetTask();
                    bdNetTask.setNet(bdNet);
                    bdNetTask.setUrl(getUrl(context, false));
                    bdNet.start(bdNetTask, false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void tryToDownLoadAsyncFreeFlow(Context context) {
        String pacUrl;
        if (WebSettingsGlobalBlink.isSFSwitchEnabled()) {
            Log.i(LOG_TAG, "tryToDownLoadAsyncFreeFlow return");
        } else if (WebKitFactory.getCurEngine() != 1) {
            Log.w(LOG_TAG, "tryToDownLoadAsyncFreeFlow engine not ok ");
        } else if (!WebKitFactory.getNeedDownloadCloudResource()) {
            Log.w(LOG_TAG, " tryToDownLoadAsyncFreeFlow1  return");
            restoreLastDataFreeFLow();
        } else {
            restoreLastDataFreeFLow();
            if ((WebSettingsGlobalBlink.getProxyType() == WebSettings.ProxyType.NO_PROXY && !WebSettingsGlobalBlink.getHijackEnv()) || mPacFreeFlowSucced || (pacUrl = WebSettingsGlobalBlink.getPacUrl()) == null || pacUrl.length() == 0) {
                return;
            }
            try {
                PacDownload pacDownload = new PacDownload();
                pacDownload.setFreeFlowEnabled(true);
                if (ResourceSchedulerEngine.getInstance().registTaskAndListener(pacDownload, null)) {
                    return;
                }
                BdNet bdNet = new BdNet(context);
                bdNet.setEventListener(pacDownload);
                BdNetTask bdNetTask = new BdNetTask();
                bdNetTask.setNet(bdNet);
                bdNetTask.setUrl(getUrl(context, true));
                bdNet.start(bdNetTask, false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.webkit.internal.resource.IResourceTask
    public String getCacheFileName() {
        return getFreeFlowEnabled() ? "pacdownloadfreeflow.dat" : "pacdownload.dat";
    }

    @Override // com.baidu.webkit.internal.resource.IResourceTask
    public IResourceTask.OutputType getOutputType() {
        return IResourceTask.OutputType.STRING;
    }

    @Override // com.baidu.webkit.internal.resource.IResourceTask
    public int getPriority() {
        return 0;
    }

    @Override // com.baidu.webkit.internal.resource.IResourceTask
    public String getTaskName() {
        return getFreeFlowEnabled() ? "pacdownloadfreeflow" : "pacdownload";
    }

    @Override // com.baidu.webkit.internal.resource.IResourceTask
    public String getTaskUrl() {
        return getFreeFlowEnabled() ? getUrl(WebViewFactory.getContext(), true) : getUrl(WebViewFactory.getContext(), false);
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetDownloadComplete(BdNet bdNet) {
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetDownloadError(BdNet bdNet, BdNetTask bdNetTask, BdNet.NetError netError, int i) {
        Log.w(LOG_TAG, "onNetDownloadError  " + bdNetTask.getUrl());
        mDownloading = false;
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetReceiveData(BdNet bdNet, BdNetTask bdNetTask, byte[] bArr, int i) {
        if (this.mData == null) {
            this.mData = new ByteArrayOutputStream();
        }
        this.mData.write(bArr, 0, i);
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetReceiveHeaders(BdNet bdNet, BdNetTask bdNetTask) {
        this.mHeader = bdNetTask.getResHeaders();
    }

    @Override // com.baidu.webkit.net.INetListener
    public boolean onNetRedirect(BdNet bdNet, BdNetTask bdNetTask, int i) {
        return false;
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetResponseCode(BdNet bdNet, BdNetTask bdNetTask, int i) {
        Log.w(LOG_TAG, "onNetResponseCode  " + i + " url " + bdNetTask.getUrl());
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetStateChanged(BdNet bdNet, BdNetTask bdNetTask, BdNet.NetState netState, int i) {
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetTaskComplete(BdNet bdNet, BdNetTask bdNetTask) {
        mDownloading = false;
        if (this.mData == null) {
            Log.w(LOG_TAG, "mData==null");
            return;
        }
        byte[] byteArray = this.mData.toByteArray();
        Log.w(LOG_TAG, "onNetDownloadComplete " + byteArray.length);
        try {
            String str = new String(byteArray, "UTF-8");
            if (getFreeFlowEnabled()) {
                if (this.mHeader != null) {
                    String str2 = this.mHeader.get(Headers.LAST_MODIFIED);
                    Log.w(LOG_TAG, "lastModify freeflow  " + str2);
                    if (str2 != null) {
                        Log.w(LOG_TAG, "lastModify1 " + str2);
                        CfgFileUtils.set(CfgFileUtils.KEY_PAC_FREE_FLOW_LASTMODIFY, str2);
                    }
                }
                CfgFileUtils.set(CfgFileUtils.KEY_PAC_FREE_FLOW_DATA, str);
                mPacFreeFlowSucced = true;
                WebSettingsGlobalBlink.setPacDataFreeFlow(str);
                return;
            }
            if (this.mHeader != null) {
                String str3 = this.mHeader.get(Headers.LAST_MODIFIED);
                Log.w(LOG_TAG, "lastModify " + str3);
                if (str3 != null) {
                    Log.w(LOG_TAG, "lastModify1 " + str3);
                    CfgFileUtils.set(CfgFileUtils.KEY_PAC_LASTMODIFY, str3);
                }
            }
            CfgFileUtils.set(CfgFileUtils.KEY_PAC_DATA, str);
            mPacSucced = true;
            WebSettingsGlobalBlink.setPacData(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetTaskStart(BdNet bdNet, BdNetTask bdNetTask) {
        Log.w(LOG_TAG, "onNetTaskStart  " + bdNetTask.getUrl());
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetUploadComplete(BdNet bdNet, BdNetTask bdNetTask) {
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetUploadData(BdNet bdNet, BdNetTask bdNetTask, int i, int i2) {
    }

    @Override // com.baidu.webkit.internal.resource.IResourceTask
    public void onResourceReady(String str, IResourceTask.ResultType resultType) {
        Log.w(LOG_TAG, "onResourceReady1 " + resultType);
        if (str != null) {
            Log.w(LOG_TAG, "onResourceReady2 " + str.length());
            if (getFreeFlowEnabled()) {
                Log.w(LOG_TAG, "onResourceReady3");
                CfgFileUtils.set(CfgFileUtils.KEY_PAC_FREE_FLOW_DATA, str);
                WebSettingsGlobalBlink.setPacDataFreeFlow(str);
            } else {
                Log.w(LOG_TAG, "onResourceReady4");
                CfgFileUtils.set(CfgFileUtils.KEY_PAC_DATA, str);
                WebSettingsGlobalBlink.setPacData(str);
            }
        }
        ResourceSchedulerEngine.getInstance().unregistTaskAndListener(this);
    }

    public void setFreeFlowEnabled(boolean z) {
        this.mFreeFlowEnabled = z;
    }

    @Override // com.baidu.webkit.internal.resource.IResourceTask
    public boolean shouldForceLoadFromFile() {
        return false;
    }
}
