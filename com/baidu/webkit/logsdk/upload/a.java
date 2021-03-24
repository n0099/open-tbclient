package com.baidu.webkit.logsdk.upload;

import android.text.TextUtils;
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public String f27016a;

    /* renamed from: b  reason: collision with root package name */
    public int f27017b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f27018c;

    /* renamed from: d  reason: collision with root package name */
    public long f27019d;

    /* renamed from: e  reason: collision with root package name */
    public com.baidu.webkit.logsdk.b.a f27020e;

    /* renamed from: f  reason: collision with root package name */
    public String f27021f;

    /* renamed from: g  reason: collision with root package name */
    public String f27022g;

    /* renamed from: h  reason: collision with root package name */
    public String f27023h;
    public String i;

    public a(com.baidu.webkit.logsdk.b.a aVar, String str) {
        this(aVar, str, null);
    }

    public a(com.baidu.webkit.logsdk.b.a aVar, String str, String str2) {
        this.f27016a = str;
        this.f27017b = 0;
        this.f27018c = false;
        this.f27020e = aVar;
        int a2 = !TextUtils.isEmpty(str2) ? com.baidu.webkit.logsdk.d.c.a(str2) : -1;
        if (a2 <= 1 && a2 >= 0) {
            this.f27021f = str2;
            return;
        }
        this.f27021f = aVar.f26987c;
        this.f27022g = aVar.f26988d;
    }
}
