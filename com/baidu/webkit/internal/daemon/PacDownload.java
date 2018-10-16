package com.baidu.webkit.internal.daemon;

import android.content.Context;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidu.webkit.net.BdNet;
import com.baidu.webkit.net.BdNetTask;
import com.baidu.webkit.net.INetListener;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import com.baidu.webkit.sdk.WebSettings;
import java.io.ByteArrayOutputStream;
/* loaded from: classes2.dex */
public class PacDownload implements INetListener {
    private static final String LOG_TAG = "PacDownload";
    private ByteArrayOutputStream mData;
    private boolean mFreeFlowEnabled = false;
    private static WebSettings.ProxyType mPacType = WebSettings.ProxyType.NO_PROXY;
    public static boolean mPacSucced = false;
    public static boolean mPacFreeFlowSucced = false;
    private static boolean mDownloading = false;

    public PacDownload() {
        this.mData = null;
        this.mData = null;
    }

    private boolean getFreeFlowEnabled() {
        return this.mFreeFlowEnabled;
    }

    private static String getUrl(Context context, boolean z) {
        String str = (((WebSettingsGlobalBlink.getPacUrl() + "&ProxyType=") + WebSettingsGlobalBlink.getProxyType()) + "&SdkVer=") + WebKitFactory.getSdkVersionName();
        mPacType = WebSettingsGlobalBlink.getProxyType();
        if (z) {
            str = str + "&mianliu=true";
        }
        Log.w(LOG_TAG, "run url " + str);
        return str;
    }

    public static void tryToDownLoadAsync(Context context) {
        String pacUrl;
        if (WebSettingsGlobalBlink.getProxyType() != WebSettings.ProxyType.NO_PROXY || WebSettingsGlobalBlink.getHijackEnv()) {
            if ((mPacFreeFlowSucced && mPacSucced) || mDownloading || (pacUrl = WebSettingsGlobalBlink.getPacUrl()) == null || pacUrl.length() == 0) {
                return;
            }
            mDownloading = true;
            try {
                BdNet bdNet = new BdNet(context);
                bdNet.setEventListener(new PacDownload());
                BdNetTask bdNetTask = new BdNetTask();
                bdNetTask.setNet(bdNet);
                bdNetTask.setUrl(getUrl(context, false));
                bdNet.start(bdNetTask, false);
                BdNet bdNet2 = new BdNet(context);
                PacDownload pacDownload = new PacDownload();
                pacDownload.setFreeFlowEnabled(true);
                bdNet2.setEventListener(pacDownload);
                BdNetTask bdNetTask2 = new BdNetTask();
                bdNetTask2.setNet(bdNet2);
                bdNetTask2.setUrl(getUrl(context, true));
                bdNet2.start(bdNetTask2, false);
            } catch (Exception e) {
                com.a.a.a.a.a.a.a.a(e);
            }
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetDownloadComplete(BdNet bdNet) {
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetDownloadError(BdNet bdNet, BdNetTask bdNetTask, BdNet.NetError netError, int i) {
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
                mPacFreeFlowSucced = true;
                WebSettingsGlobalBlink.setPacDataFreeFlow(str);
            } else {
                mPacSucced = true;
                WebSettingsGlobalBlink.setPacData(str);
            }
        } catch (Exception e) {
            com.a.a.a.a.a.a.a.a(e);
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

    public void setFreeFlowEnabled(boolean z) {
        this.mFreeFlowEnabled = z;
    }
}
