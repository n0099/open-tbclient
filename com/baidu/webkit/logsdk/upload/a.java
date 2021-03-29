package com.baidu.webkit.logsdk.upload;

import android.text.TextUtils;
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public String f27017a;

    /* renamed from: b  reason: collision with root package name */
    public int f27018b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f27019c;

    /* renamed from: d  reason: collision with root package name */
    public long f27020d;

    /* renamed from: e  reason: collision with root package name */
    public com.baidu.webkit.logsdk.b.a f27021e;

    /* renamed from: f  reason: collision with root package name */
    public String f27022f;

    /* renamed from: g  reason: collision with root package name */
    public String f27023g;

    /* renamed from: h  reason: collision with root package name */
    public String f27024h;
    public String i;

    public a(com.baidu.webkit.logsdk.b.a aVar, String str) {
        this(aVar, str, null);
    }

    public a(com.baidu.webkit.logsdk.b.a aVar, String str, String str2) {
        this.f27017a = str;
        this.f27018b = 0;
        this.f27019c = false;
        this.f27021e = aVar;
        int a2 = !TextUtils.isEmpty(str2) ? com.baidu.webkit.logsdk.d.c.a(str2) : -1;
        if (a2 <= 1 && a2 >= 0) {
            this.f27022f = str2;
            return;
        }
        this.f27022f = aVar.f26988c;
        this.f27023g = aVar.f26989d;
    }
}
