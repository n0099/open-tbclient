package com.baidu.webkit.internal.daemon;

import android.content.Context;
import com.baidu.webkit.internal.CfgFileUtils;
import com.baidu.webkit.internal.blink.VideoFreeFlowConfigManager;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidu.webkit.internal.resource.IResourceTask;
import com.baidu.webkit.internal.resource.ResourceSchedulerEngine;
import com.baidu.webkit.net.BdNet;
import com.baidu.webkit.net.BdNetTask;
import com.baidu.webkit.net.INetListener;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import com.baidu.webkit.sdk.WebSettings;
import com.baidubce.http.Headers;
import java.io.ByteArrayOutputStream;
import java.util.Map;
/* loaded from: classes11.dex */
public class VideoPacDownload implements IResourceTask, INetListener {
    private static final String LOG_TAG = "VideoPacDownload";
    private static boolean mDownloading;
    private static boolean mSuccessDownload;
    private ByteArrayOutputStream mData = null;
    private Map<String, String> mHeader;
    private static WebSettings.ProxyType mPacType = WebSettings.ProxyType.NO_PROXY;
    private static String sPacUrl = "https://browserkernel.baidu.com/newpac31/videoproxy.conf.txt";

    public static String getPacUrl() {
        return sPacUrl;
    }

    public static void restoreLastData() {
        try {
            String str = CfgFileUtils.get(CfgFileUtils.KEY_VIDEO_PROXY_DATA, (String) null);
            if (str == null) {
                Log.w(LOG_TAG, "restoreLastData null");
            } else {
                Log.w(LOG_TAG, "restoreLastData  " + str);
                VideoFreeFlowConfigManager.getInstance().setPacData(str);
            }
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
    }

    public static void tryToDownLoadAsync(Context context) {
        String pacUrl;
        if (!WebKitFactory.getNeedDownloadCloudResource()) {
            Log.w(LOG_TAG, " tryToDownLoadAsync  return");
            restoreLastData();
            return;
        }
        restoreLastData();
        if (WebSettingsGlobalBlink.getProxyType() == WebSettings.ProxyType.NO_PROXY || mSuccessDownload || mDownloading || (pacUrl = getPacUrl()) == null || pacUrl.length() == 0) {
            return;
        }
        mDownloading = true;
        if (WebSettingsGlobalBlink.isSFSwitchEnabled()) {
            Log.i(LOG_TAG, "tryToDownLoadAsync canceled by spring_festival_switch");
            VideoFreeFlowConfigManager.getInstance().initLocalRule();
            mSuccessDownload = true;
            mDownloading = false;
            return;
        }
        try {
            VideoPacDownload videoPacDownload = new VideoPacDownload();
            if (ResourceSchedulerEngine.getInstance().registTaskAndListener(videoPacDownload, null)) {
                return;
            }
            BdNet bdNet = new BdNet(context);
            bdNet.setEventListener(videoPacDownload);
            BdNetTask bdNetTask = new BdNetTask();
            bdNetTask.setNet(bdNet);
            bdNetTask.setUrl(getPacUrl());
            bdNet.start(bdNetTask, false);
        } catch (Exception e) {
            com.a.a.a.a.a.a.a.a(e);
        }
    }

    @Override // com.baidu.webkit.internal.resource.IResourceTask
    public String getCacheFileName() {
        return "videopacdownload.dat";
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
        return "videopacdownload";
    }

    @Override // com.baidu.webkit.internal.resource.IResourceTask
    public String getTaskUrl() {
        return getPacUrl();
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetDownloadComplete(BdNet bdNet) {
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetDownloadError(BdNet bdNet, BdNetTask bdNetTask, BdNet.NetError netError, int i) {
        mDownloading = false;
        Log.w(LOG_TAG, "onNetDownloadError  " + bdNetTask.getUrl());
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
        if (this.mHeader != null) {
            String str = this.mHeader.get(Headers.LAST_MODIFIED);
            Log.w(LOG_TAG, "lastModify " + str);
            if (str != null) {
                Log.w(LOG_TAG, "lastModify1 " + str);
                CfgFileUtils.set(CfgFileUtils.KEY_VIDEO_PROXY_LASTMODIFY, str);
            }
        }
        byte[] byteArray = this.mData.toByteArray();
        Log.w(LOG_TAG, "onNetDownloadComplete " + byteArray.length);
        mSuccessDownload = true;
        try {
            String str2 = new String(byteArray, "UTF-8");
            VideoFreeFlowConfigManager.getInstance().setPacData(str2);
            CfgFileUtils.set(CfgFileUtils.KEY_VIDEO_PROXY_DATA, str2);
        } catch (Exception e) {
            Log.w(LOG_TAG, "mTimgConfData1 " + e);
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
            VideoFreeFlowConfigManager.getInstance().setPacData(str);
            CfgFileUtils.set(CfgFileUtils.KEY_VIDEO_PROXY_DATA, str);
        }
        ResourceSchedulerEngine.getInstance().unregistTaskAndListener(this);
    }

    @Override // com.baidu.webkit.internal.resource.IResourceTask
    public boolean shouldForceLoadFromFile() {
        return false;
    }
}
