package com.baidu.webkit.logsdk.upload;

import android.text.TextUtils;
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public String f26710a;

    /* renamed from: b  reason: collision with root package name */
    public int f26711b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f26712c;

    /* renamed from: d  reason: collision with root package name */
    public long f26713d;

    /* renamed from: e  reason: collision with root package name */
    public com.baidu.webkit.logsdk.b.a f26714e;

    /* renamed from: f  reason: collision with root package name */
    public String f26715f;

    /* renamed from: g  reason: collision with root package name */
    public String f26716g;

    /* renamed from: h  reason: collision with root package name */
    public String f26717h;
    public String i;

    public a(com.baidu.webkit.logsdk.b.a aVar, String str) {
        this(aVar, str, null);
    }

    public a(com.baidu.webkit.logsdk.b.a aVar, String str, String str2) {
        this.f26710a = str;
        this.f26711b = 0;
        this.f26712c = false;
        this.f26714e = aVar;
        int a2 = !TextUtils.isEmpty(str2) ? com.baidu.webkit.logsdk.d.c.a(str2) : -1;
        if (a2 <= 1 && a2 >= 0) {
            this.f26715f = str2;
            return;
        }
        this.f26715f = aVar.f26681c;
        this.f26716g = aVar.f26682d;
    }
}
