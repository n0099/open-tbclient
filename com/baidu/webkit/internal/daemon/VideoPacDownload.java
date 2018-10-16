package com.baidu.webkit.internal.daemon;

import android.content.Context;
import com.baidu.webkit.internal.blink.VideoFreeFlowConfigManager;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidu.webkit.net.BdNet;
import com.baidu.webkit.net.BdNetTask;
import com.baidu.webkit.net.INetListener;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebSettings;
import java.io.ByteArrayOutputStream;
/* loaded from: classes2.dex */
public class VideoPacDownload implements INetListener {
    private static final String LOG_TAG = "VideoPacDownload";
    private ByteArrayOutputStream mData;
    private static WebSettings.ProxyType mPacType = WebSettings.ProxyType.NO_PROXY;
    private static boolean mDownloading = false;
    private static boolean mSuccessDownload = false;
    private static String sPacUrl = "https://browserkernel.baidu.com/newpac31/videoproxy.conf.txt";

    public VideoPacDownload() {
        this.mData = null;
        this.mData = null;
    }

    private static String getPacUrl() {
        return sPacUrl;
    }

    private static String getUrl(Context context) {
        String pacUrl = getPacUrl();
        mPacType = WebSettingsGlobalBlink.getProxyType();
        Log.w(LOG_TAG, "run url " + pacUrl);
        return pacUrl;
    }

    public static void tryToDownLoadAsync(Context context) {
        String pacUrl;
        if (WebSettingsGlobalBlink.getProxyType() == WebSettings.ProxyType.NO_PROXY || mSuccessDownload || mDownloading || (pacUrl = getPacUrl()) == null || pacUrl.length() == 0) {
            return;
        }
        mDownloading = true;
        try {
            BdNet bdNet = new BdNet(context);
            bdNet.setEventListener(new VideoPacDownload());
            BdNetTask bdNetTask = new BdNetTask();
            bdNetTask.setNet(bdNet);
            bdNetTask.setUrl(getUrl(context));
            bdNet.start(bdNetTask, false);
        } catch (Exception e) {
            com.a.a.a.a.a.a.a.a(e);
        }
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
        mSuccessDownload = true;
        try {
            VideoFreeFlowConfigManager.getInstance().setPacData(new String(byteArray, "UTF-8"));
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
}
