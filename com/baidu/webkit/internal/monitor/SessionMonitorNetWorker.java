package com.baidu.webkit.internal.monitor;

import android.text.TextUtils;
import com.baidu.webkit.internal.ABTestConstants;
import com.baidu.webkit.internal.Base64;
import com.baidu.webkit.internal.INoProGuard;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidu.webkit.net.BdNet;
import com.baidu.webkit.net.BdNetTask;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import java.io.IOException;
import java.util.HashMap;
import org.apache.http.protocol.HTTP;
/* loaded from: classes2.dex */
public class SessionMonitorNetWorker implements INoProGuard {
    private static final String LOG_TAG = "ZeusMonitorEngine";

    private String getUploadUrl() {
        return WebSettingsGlobalBlink.getSessionUploadUrl();
    }

    private void sendStatisticsDataToServer(byte[] bArr, String str) {
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
                    hashMap.put("Cache-Control", "no-cache");
                    if (WebSettingsGlobalBlink.isSessionDataEnable() && ((GetCloudSettingsValue = WebSettingsGlobalBlink.GetCloudSettingsValue("gzip_support")) == null || !GetCloudSettingsValue.equals(ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE))) {
                        hashMap.put("Content-Type", "application/x-gzip");
                    }
                    bdNetTask.setHeaders(hashMap);
                    bdNet.start(bdNetTask, false);
                }
            } catch (Exception e) {
                Log.d(LOG_TAG, "upload error " + e);
            }
        }
    }

    public void upload(String str, String str2, String str3) {
        if (WebSettingsGlobalBlink.isSessionDataEnable()) {
            Log.i(LOG_TAG, "aContent=" + str2);
            String GetCloudSettingsValue = WebSettingsGlobalBlink.GetCloudSettingsValue("gzip_support");
            if (GetCloudSettingsValue == null || !GetCloudSettingsValue.equals(ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE)) {
                try {
                    sendStatisticsDataToServer(com.baidu.webkit.internal.a.b(com.baidu.webkit.internal.a.c(str2.getBytes())), str3);
                } catch (IOException e) {
                    com.a.a.a.a.a.a.a.a(e);
                }
            } else if (WebSettingsGlobalBlink.useLogSdk()) {
                com.baidu.webkit.logsdk.a.a(str, str2);
            } else {
                sendStatisticsDataToServer(com.baidu.webkit.internal.a.b(Base64.encode(str2.getBytes(), false)), str3);
            }
        }
        if (WebSettingsGlobalBlink.useT5Log()) {
            sendStatisticsDataToServer(com.baidu.webkit.internal.a.b(Base64.encode(str2.getBytes(), false)), str3);
        }
    }
}
