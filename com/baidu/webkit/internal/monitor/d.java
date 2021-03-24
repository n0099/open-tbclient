package com.baidu.webkit.internal.monitor;

import android.text.TextUtils;
import com.baidu.webkit.internal.Base64;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import java.io.IOException;
/* loaded from: classes5.dex */
public final class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f26946a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f26947b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f26948c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f26949d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ SessionMonitorNetWorker f26950e;

    public d(SessionMonitorNetWorker sessionMonitorNetWorker, String str, String str2, String str3, boolean z) {
        this.f26950e = sessionMonitorNetWorker;
        this.f26946a = str;
        this.f26947b = str2;
        this.f26948c = str3;
        this.f26949d = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        boolean z2;
        if (TextUtils.isEmpty(this.f26946a)) {
            return;
        }
        if (WebSettingsGlobalBlink.isSessionDataEnable()) {
            Log.i(SessionMonitorNetWorker.LOG_TAG, "aContent=" + this.f26946a);
            String GetCloudSettingsValue = WebSettingsGlobalBlink.GetCloudSettingsValue("gzip_support");
            if (GetCloudSettingsValue == null || !GetCloudSettingsValue.equals("false")) {
                try {
                    if (!WebSettingsGlobalBlink.getLogsdkEnabled() && !WebSettingsGlobalBlink.getDoubleLogEnabled()) {
                        this.f26950e.sendStatisticsDataToServer(com.baidu.webkit.internal.d.b(com.baidu.webkit.internal.d.c(this.f26946a.getBytes())), this.f26948c, this.f26949d);
                    }
                    z = SessionMonitorNetWorker.mLogSdkInit;
                    if (!z) {
                        Log.i(SessionMonitorNetWorker.LOG_TAG, "BdLogSDK.init1");
                        com.baidu.webkit.logsdk.a.a(WebKitFactory.getContext(), new c());
                        boolean unused = SessionMonitorNetWorker.mLogSdkInit = true;
                    }
                    com.baidu.webkit.logsdk.a.a(this.f26947b, this.f26946a);
                    if (WebSettingsGlobalBlink.getDoubleLogEnabled()) {
                        this.f26950e.sendStatisticsDataToServer(com.baidu.webkit.internal.d.b(com.baidu.webkit.internal.d.c(this.f26946a.getBytes())), this.f26948c, this.f26949d);
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            } else if (WebSettingsGlobalBlink.useLogSdk()) {
                z2 = SessionMonitorNetWorker.mLogSdkInit;
                if (!z2) {
                    Log.i(SessionMonitorNetWorker.LOG_TAG, "BdLogSDK.init2");
                    com.baidu.webkit.logsdk.a.a(WebKitFactory.getContext(), new c());
                    boolean unused2 = SessionMonitorNetWorker.mLogSdkInit = true;
                }
                com.baidu.webkit.logsdk.a.a(this.f26947b, this.f26946a);
            } else {
                this.f26950e.sendStatisticsDataToServer(com.baidu.webkit.internal.d.b(Base64.encode(this.f26946a.getBytes(), false)), this.f26948c, this.f26949d);
            }
        }
        if (WebSettingsGlobalBlink.useT5Log()) {
            this.f26950e.sendStatisticsDataToServer(com.baidu.webkit.internal.d.b(Base64.encode(this.f26946a.getBytes(), false)), this.f26948c, this.f26949d);
        }
    }
}
