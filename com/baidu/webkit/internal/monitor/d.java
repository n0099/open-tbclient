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
    public final /* synthetic */ String f27448a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f27449b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f27450c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f27451d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ SessionMonitorNetWorker f27452e;

    public d(SessionMonitorNetWorker sessionMonitorNetWorker, String str, String str2, String str3, boolean z) {
        this.f27452e = sessionMonitorNetWorker;
        this.f27448a = str;
        this.f27449b = str2;
        this.f27450c = str3;
        this.f27451d = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        boolean z2;
        if (TextUtils.isEmpty(this.f27448a)) {
            return;
        }
        if (WebSettingsGlobalBlink.isSessionDataEnable()) {
            Log.i(SessionMonitorNetWorker.LOG_TAG, "aContent=" + this.f27448a);
            String GetCloudSettingsValue = WebSettingsGlobalBlink.GetCloudSettingsValue("gzip_support");
            if (GetCloudSettingsValue == null || !GetCloudSettingsValue.equals("false")) {
                try {
                    if (!WebSettingsGlobalBlink.getLogsdkEnabled() && !WebSettingsGlobalBlink.getDoubleLogEnabled()) {
                        this.f27452e.sendStatisticsDataToServer(com.baidu.webkit.internal.d.b(com.baidu.webkit.internal.d.c(this.f27448a.getBytes())), this.f27450c, this.f27451d);
                    }
                    z = SessionMonitorNetWorker.mLogSdkInit;
                    if (!z) {
                        Log.i(SessionMonitorNetWorker.LOG_TAG, "BdLogSDK.init1");
                        com.baidu.webkit.logsdk.a.a(WebKitFactory.getContext(), new c());
                        boolean unused = SessionMonitorNetWorker.mLogSdkInit = true;
                    }
                    com.baidu.webkit.logsdk.a.a(this.f27449b, this.f27448a);
                    if (WebSettingsGlobalBlink.getDoubleLogEnabled()) {
                        this.f27452e.sendStatisticsDataToServer(com.baidu.webkit.internal.d.b(com.baidu.webkit.internal.d.c(this.f27448a.getBytes())), this.f27450c, this.f27451d);
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
                com.baidu.webkit.logsdk.a.a(this.f27449b, this.f27448a);
            } else {
                this.f27452e.sendStatisticsDataToServer(com.baidu.webkit.internal.d.b(Base64.encode(this.f27448a.getBytes(), false)), this.f27450c, this.f27451d);
            }
        }
        if (WebSettingsGlobalBlink.useT5Log()) {
            this.f27452e.sendStatisticsDataToServer(com.baidu.webkit.internal.d.b(Base64.encode(this.f27448a.getBytes(), false)), this.f27450c, this.f27451d);
        }
    }
}
