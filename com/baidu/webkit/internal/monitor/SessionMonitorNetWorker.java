package com.baidu.webkit.internal.monitor;

import android.text.TextUtils;
import com.baidu.webkit.internal.Base64;
import com.baidu.webkit.internal.INoProGuard;
import com.baidu.webkit.internal.RC4;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidu.webkit.internal.daemon.ZeusThreadPoolUtil;
import com.baidu.webkit.net.BdNet;
import com.baidu.webkit.net.BdNetTask;
import com.baidu.webkit.net.INetListener;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import com.baidubce.http.Headers;
import java.io.IOException;
import java.util.HashMap;
import org.apache.http.protocol.HTTP;
/* loaded from: classes9.dex */
public class SessionMonitorNetWorker implements INoProGuard, INetListener {
    public static final String LOG_TAG = "ZeusMonitorEngine";
    public static boolean mLogSdkInit;

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
                if (bArr.length <= 0) {
                    return;
                }
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
            } catch (Exception e) {
                Log.d(LOG_TAG, "upload error ".concat(String.valueOf(e)));
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

    public void upload(final String str, final String str2, final String str3, final boolean z) {
        if (WebSettingsGlobalBlink.isSFSwitchEnabled()) {
            Log.i(LOG_TAG, "upload closed by isSFSwitchEnabled");
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.baidu.webkit.internal.monitor.SessionMonitorNetWorker.2
            @Override // java.lang.Runnable
            public final void run() {
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                if (WebSettingsGlobalBlink.isSessionDataEnable()) {
                    Log.i(SessionMonitorNetWorker.LOG_TAG, "aContent=" + str2);
                    String GetCloudSettingsValue = WebSettingsGlobalBlink.GetCloudSettingsValue("gzip_support");
                    if (GetCloudSettingsValue == null || !GetCloudSettingsValue.equals("false")) {
                        try {
                            if (!WebSettingsGlobalBlink.getLogsdkEnabled() && !WebSettingsGlobalBlink.getDoubleLogEnabled()) {
                                SessionMonitorNetWorker.this.sendStatisticsDataToServer(RC4.kernelEncrypt(RC4.kernelGzipCompress(str2.getBytes())), str3, z);
                            }
                            if (!SessionMonitorNetWorker.mLogSdkInit) {
                                Log.i(SessionMonitorNetWorker.LOG_TAG, "BdLogSDK.init1");
                                com.baidu.webkit.logsdk.a.a(WebKitFactory.getContext(), new c());
                                boolean unused = SessionMonitorNetWorker.mLogSdkInit = true;
                            }
                            com.baidu.webkit.logsdk.a.a(str, str2);
                            if (WebSettingsGlobalBlink.getDoubleLogEnabled()) {
                                SessionMonitorNetWorker.this.sendStatisticsDataToServer(RC4.kernelEncrypt(RC4.kernelGzipCompress(str2.getBytes())), str3, z);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else if (WebSettingsGlobalBlink.useLogSdk()) {
                        if (!SessionMonitorNetWorker.mLogSdkInit) {
                            Log.i(SessionMonitorNetWorker.LOG_TAG, "BdLogSDK.init2");
                            com.baidu.webkit.logsdk.a.a(WebKitFactory.getContext(), new c());
                            boolean unused2 = SessionMonitorNetWorker.mLogSdkInit = true;
                        }
                        com.baidu.webkit.logsdk.a.a(str, str2);
                    } else {
                        SessionMonitorNetWorker.this.sendStatisticsDataToServer(RC4.kernelEncrypt(Base64.encode(str2.getBytes(), false)), str3, z);
                    }
                }
                if (WebSettingsGlobalBlink.useT5Log()) {
                    SessionMonitorNetWorker.this.sendStatisticsDataToServer(RC4.kernelEncrypt(Base64.encode(str2.getBytes(), false)), str3, z);
                }
            }
        };
        if (z) {
            ZeusThreadPoolUtil.executeIgnoreZeus(runnable);
        } else {
            runnable.run();
        }
    }

    public void uploadFromFile(String str, final byte[] bArr, final String str2) {
        if (WebSettingsGlobalBlink.isSFSwitchEnabled()) {
            Log.i(LOG_TAG, "upload closed by isSFSwitchEnabled");
        } else {
            ZeusThreadPoolUtil.executeIgnoreZeus(new Runnable() { // from class: com.baidu.webkit.internal.monitor.SessionMonitorNetWorker.1
                @Override // java.lang.Runnable
                public final void run() {
                    byte[] bArr2 = bArr;
                    if (bArr2 == null || bArr2.length == 0 || !WebSettingsGlobalBlink.isSessionDataEnable()) {
                        return;
                    }
                    String GetCloudSettingsValue = WebSettingsGlobalBlink.GetCloudSettingsValue("gzip_support");
                    if (GetCloudSettingsValue == null || !GetCloudSettingsValue.equals("false")) {
                        SessionMonitorNetWorker.this.sendStatisticsDataToServer(bArr, str2, true);
                    }
                }
            });
        }
    }
}
