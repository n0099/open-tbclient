package com.bytedance.embedapplog.util;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f5837a = {"https://toblog.ctobsnssdk.com", "https://tobapplog.ctobsnssdk.com"};

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f5838b = {"https://toblog.tobsnssdk.com", "https://tobapplog.tobsnssdk.com"};
    private static final String[] c = {"https://toblog.itobsnssdk.com", "https://tobapplog.itobsnssdk.com"};
    private String d;
    private String e;
    private String f;
    private String g;
    private String[] h;
    private String i;

    private void a() {
        this.d = "https://toblog.ctobsnssdk.com/service/2/device_register_only/";
        this.e = "https://toblog.ctobsnssdk.com/service/2/app_alert_check/";
        this.f = "https://toblog.ctobsnssdk.com/service/2/log_settings/";
        this.g = "https://toblog.ctobsnssdk.com/service/2/abtest_config/";
        this.h = f5837a;
        this.i = "https://success.ctobsnssdk.com";
    }

    private void b() {
        this.d = "https://toblog.tobsnssdk.com/service/2/device_register_only/";
        this.e = "https://toblog.tobsnssdk.com/service/2/app_alert_check/";
        this.f = "https://toblog.tobsnssdk.com/service/2/log_settings/";
        this.g = "https://toblog.tobsnssdk.com/service/2/abtest_config/";
        this.h = f5838b;
        this.i = "https://success.tobsnssdk.com";
    }

    private void c() {
        this.d = "https://toblog.itobsnssdk.com/service/2/device_register_only/";
        this.e = "https://toblog.itobsnssdk.com/service/2/app_alert_check/";
        this.f = "https://toblog.itobsnssdk.com/service/2/log_settings/";
        this.g = "https://toblog.itobsnssdk.com/service/2/abtest_config/";
        this.h = c;
        this.i = "https://success.itobsnssdk.com";
    }

    private a() {
        a();
    }

    public static a Or(int i) {
        a aVar = new a();
        switch (i) {
            case 0:
                aVar.a();
                break;
            case 1:
                aVar.b();
                break;
            case 2:
                aVar.c();
                break;
            default:
                aVar.a();
                break;
        }
        return aVar;
    }

    public String enZ() {
        return this.d;
    }

    public String eoa() {
        return this.e;
    }

    public String eob() {
        return this.f;
    }

    public String eoc() {
        return this.g;
    }

    public String[] eod() {
        return this.h;
    }

    public String eoe() {
        return this.i;
    }
}
