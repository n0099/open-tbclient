package com.baidu.webkit.internal.monitor;

import android.text.TextUtils;
import com.baidu.webkit.internal.Base64;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidu.webkit.internal.e;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public final class d implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ boolean d;
    final /* synthetic */ SessionMonitorNetWorker e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(SessionMonitorNetWorker sessionMonitorNetWorker, String str, String str2, String str3, boolean z) {
        this.e = sessionMonitorNetWorker;
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        boolean z2;
        if (TextUtils.isEmpty(this.a)) {
            return;
        }
        if (WebSettingsGlobalBlink.isSessionDataEnable()) {
            Log.i("ZeusMonitorEngine", "aContent=" + this.a);
            String GetCloudSettingsValue = WebSettingsGlobalBlink.GetCloudSettingsValue("gzip_support");
            if (GetCloudSettingsValue == null || !GetCloudSettingsValue.equals("false")) {
                try {
                    if (WebSettingsGlobalBlink.getLogsdkEnabled() || WebSettingsGlobalBlink.getDoubleLogEnabled()) {
                        z = SessionMonitorNetWorker.mLogSdkInit;
                        if (!z) {
                            Log.i("ZeusMonitorEngine", "BdLogSDK.init1");
                            com.baidu.webkit.logsdk.a.a(WebKitFactory.getContext(), new c());
                            boolean unused = SessionMonitorNetWorker.mLogSdkInit = true;
                        }
                        com.baidu.webkit.logsdk.a.a(this.b, this.a);
                        if (WebSettingsGlobalBlink.getDoubleLogEnabled()) {
                            this.e.sendStatisticsDataToServer(e.b(e.c(this.a.getBytes())), this.c, this.d);
                        }
                    } else {
                        this.e.sendStatisticsDataToServer(e.b(e.c(this.a.getBytes())), this.c, this.d);
                    }
                } catch (IOException e) {
                    com.a.a.a.a.a.a.a.a(e);
                }
            } else if (WebSettingsGlobalBlink.useLogSdk()) {
                z2 = SessionMonitorNetWorker.mLogSdkInit;
                if (!z2) {
                    Log.i("ZeusMonitorEngine", "BdLogSDK.init2");
                    com.baidu.webkit.logsdk.a.a(WebKitFactory.getContext(), new c());
                    boolean unused2 = SessionMonitorNetWorker.mLogSdkInit = true;
                }
                com.baidu.webkit.logsdk.a.a(this.b, this.a);
            } else {
                this.e.sendStatisticsDataToServer(e.b(Base64.encode(this.a.getBytes(), false)), this.c, this.d);
            }
        }
        if (WebSettingsGlobalBlink.useT5Log()) {
            this.e.sendStatisticsDataToServer(e.b(Base64.encode(this.a.getBytes(), false)), this.c, this.d);
        }
    }
}
