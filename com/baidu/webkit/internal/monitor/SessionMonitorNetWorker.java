package com.baidu.webkit.internal.monitor;

import android.text.TextUtils;
import com.baidu.webkit.internal.INoProGuard;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidu.webkit.internal.daemon.ZeusThreadPoolUtil;
import com.baidu.webkit.net.BdNet;
import com.baidu.webkit.net.BdNetTask;
import com.baidu.webkit.net.INetListener;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import com.baidubce.http.Headers;
import java.util.HashMap;
import org.apache.http.protocol.HTTP;
/* loaded from: classes12.dex */
public class SessionMonitorNetWorker implements INoProGuard, INetListener {
    private static final String LOG_TAG = "ZeusMonitorEngine";
    private static boolean mLogSdkInit;

    private String getUploadUrl() {
        return WebSettingsGlobalBlink.getSessionUploadUrl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendStatisticsDataToServer(byte[] bArr, String str, boolean z) {
        String GetCloudSettingsValue;
        String uploadUrl = getUploadUrl();
        if (TextUtils.isEmpty(uploadUrl)) {
            return;
        }
        String str2 = uploadUrl + str;
        if (bArr != null) {
            try {
                if (bArr.length > 0) {
                    HashMap hashMap = new HashMap();
                    BdNet bdNet = new BdNet(WebKitFactory.getContext());
                    BdNetTask bdNetTask = new BdNetTask();
                    bdNetTask.setMethod(BdNet.HttpMethod.METHOD_POST);
                    bdNetTask.setNet(bdNet);
                    bdNetTask.setUrl(str2);
                    bdNetTask.setContent(bArr);
                    hashMap.put(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
                    hashMap.put(Headers.CACHE_CONTROL, "no-cache");
                    if (WebSettingsGlobalBlink.isSessionDataEnable() && ((GetCloudSettingsValue = WebSettingsGlobalBlink.GetCloudSettingsValue("gzip_support")) == null || !GetCloudSettingsValue.equals("false"))) {
                        hashMap.put("Content-Type", "application/x-gzip");
                    }
                    if (WebKitFactory.getCurEngine() != 1) {
                        hashMap.put("Kernel-Status", "0");
                    }
                    bdNetTask.setHeaders(hashMap);
                    if (!z) {
                        bdNet.setEventListener(this);
                    }
                    bdNet.start(bdNetTask, false);
                    if (z) {
                        return;
                    }
                    synchronized (bdNetTask) {
                        bdNetTask.wait();
                    }
                }
            } catch (Exception e) {
                Log.d(LOG_TAG, "upload error " + e);
            }
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetDownloadComplete(BdNet bdNet) {
        Log.i(LOG_TAG, "onNetDownloadComplete()");
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetDownloadError(BdNet bdNet, BdNetTask bdNetTask, BdNet.NetError netError, int i) {
        Log.i(LOG_TAG, "onNetDownloadError()");
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetReceiveData(BdNet bdNet, BdNetTask bdNetTask, byte[] bArr, int i) {
        Log.i(LOG_TAG, "onNetReceiveData()");
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetReceiveHeaders(BdNet bdNet, BdNetTask bdNetTask) {
    }

    @Override // com.baidu.webkit.net.INetListener
    public boolean onNetRedirect(BdNet bdNet, BdNetTask bdNetTask, int i) {
        Log.i(LOG_TAG, "onNetRedirect()");
        return false;
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetResponseCode(BdNet bdNet, BdNetTask bdNetTask, int i) {
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetStateChanged(BdNet bdNet, BdNetTask bdNetTask, BdNet.NetState netState, int i) {
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetTaskComplete(BdNet bdNet, BdNetTask bdNetTask) {
        Log.i(LOG_TAG, "onNetTaskComplete()");
        synchronized (bdNetTask) {
            bdNetTask.notify();
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetTaskStart(BdNet bdNet, BdNetTask bdNetTask) {
        Log.i(LOG_TAG, "onNetTaskStart()");
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetUploadComplete(BdNet bdNet, BdNetTask bdNetTask) {
        Log.i(LOG_TAG, "onNetUploadComplete()");
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetUploadData(BdNet bdNet, BdNetTask bdNetTask, int i, int i2) {
    }

    public void upload(String str, String str2, String str3) {
        upload(str, str2, str3, true);
    }

    public void upload(String str, String str2, String str3, boolean z) {
        if (WebSettingsGlobalBlink.isSFSwitchEnabled()) {
            Log.i(LOG_TAG, "upload closed by isSFSwitchEnabled");
            return;
        }
        d dVar = new d(this, str2, str, str3, z);
        if (z) {
            ZeusThreadPoolUtil.executeIgnoreZeus(dVar);
        } else {
            dVar.run();
        }
    }
}
