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
    public final /* synthetic */ String f26640a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f26641b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f26642c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f26643d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ SessionMonitorNetWorker f26644e;

    public d(SessionMonitorNetWorker sessionMonitorNetWorker, String str, String str2, String str3, boolean z) {
        this.f26644e = sessionMonitorNetWorker;
        this.f26640a = str;
        this.f26641b = str2;
        this.f26642c = str3;
        this.f26643d = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        boolean z2;
        if (TextUtils.isEmpty(this.f26640a)) {
            return;
        }
        if (WebSettingsGlobalBlink.isSessionDataEnable()) {
            Log.i(SessionMonitorNetWorker.LOG_TAG, "aContent=" + this.f26640a);
            String GetCloudSettingsValue = WebSettingsGlobalBlink.GetCloudSettingsValue("gzip_support");
            if (GetCloudSettingsValue == null || !GetCloudSettingsValue.equals("false")) {
                try {
                    if (!WebSettingsGlobalBlink.getLogsdkEnabled() && !WebSettingsGlobalBlink.getDoubleLogEnabled()) {
                        this.f26644e.sendStatisticsDataToServer(com.baidu.webkit.internal.d.b(com.baidu.webkit.internal.d.c(this.f26640a.getBytes())), this.f26642c, this.f26643d);
                    }
                    z = SessionMonitorNetWorker.mLogSdkInit;
                    if (!z) {
                        Log.i(SessionMonitorNetWorker.LOG_TAG, "BdLogSDK.init1");
                        com.baidu.webkit.logsdk.a.a(WebKitFactory.getContext(), new c());
                        boolean unused = SessionMonitorNetWorker.mLogSdkInit = true;
                    }
                    com.baidu.webkit.logsdk.a.a(this.f26641b, this.f26640a);
                    if (WebSettingsGlobalBlink.getDoubleLogEnabled()) {
                        this.f26644e.sendStatisticsDataToServer(com.baidu.webkit.internal.d.b(com.baidu.webkit.internal.d.c(this.f26640a.getBytes())), this.f26642c, this.f26643d);
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
                com.baidu.webkit.logsdk.a.a(this.f26641b, this.f26640a);
            } else {
                this.f26644e.sendStatisticsDataToServer(com.baidu.webkit.internal.d.b(Base64.encode(this.f26640a.getBytes(), false)), this.f26642c, this.f26643d);
            }
        }
        if (WebSettingsGlobalBlink.useT5Log()) {
            this.f26644e.sendStatisticsDataToServer(com.baidu.webkit.internal.d.b(Base64.encode(this.f26640a.getBytes(), false)), this.f26642c, this.f26643d);
        }
    }
}
