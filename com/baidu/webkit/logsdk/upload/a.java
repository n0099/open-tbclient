package com.baidu.webkit.logsdk.upload;

import android.text.TextUtils;
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public String f26702a;

    /* renamed from: b  reason: collision with root package name */
    public int f26703b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f26704c;

    /* renamed from: d  reason: collision with root package name */
    public long f26705d;

    /* renamed from: e  reason: collision with root package name */
    public com.baidu.webkit.logsdk.b.a f26706e;

    /* renamed from: f  reason: collision with root package name */
    public String f26707f;

    /* renamed from: g  reason: collision with root package name */
    public String f26708g;

    /* renamed from: h  reason: collision with root package name */
    public String f26709h;
    public String i;

    public a(com.baidu.webkit.logsdk.b.a aVar, String str) {
        this(aVar, str, null);
    }

    public a(com.baidu.webkit.logsdk.b.a aVar, String str, String str2) {
        this.f26702a = str;
        this.f26703b = 0;
        this.f26704c = false;
        this.f26706e = aVar;
        int a2 = !TextUtils.isEmpty(str2) ? com.baidu.webkit.logsdk.d.c.a(str2) : -1;
        if (a2 <= 1 && a2 >= 0) {
            this.f26707f = str2;
            return;
        }
        this.f26707f = aVar.f26673c;
        this.f26708g = aVar.f26674d;
    }
}
