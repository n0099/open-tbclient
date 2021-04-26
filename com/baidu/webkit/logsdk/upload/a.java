package com.baidu.webkit.logsdk.upload;

import android.text.TextUtils;
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public String f27520a;

    /* renamed from: b  reason: collision with root package name */
    public int f27521b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f27522c;

    /* renamed from: d  reason: collision with root package name */
    public long f27523d;

    /* renamed from: e  reason: collision with root package name */
    public com.baidu.webkit.logsdk.b.a f27524e;

    /* renamed from: f  reason: collision with root package name */
    public String f27525f;

    /* renamed from: g  reason: collision with root package name */
    public String f27526g;

    /* renamed from: h  reason: collision with root package name */
    public String f27527h;

    /* renamed from: i  reason: collision with root package name */
    public String f27528i;

    public a(com.baidu.webkit.logsdk.b.a aVar, String str) {
        this(aVar, str, null);
    }

    public a(com.baidu.webkit.logsdk.b.a aVar, String str, String str2) {
        this.f27520a = str;
        this.f27521b = 0;
        this.f27522c = false;
        this.f27524e = aVar;
        int a2 = !TextUtils.isEmpty(str2) ? com.baidu.webkit.logsdk.d.c.a(str2) : -1;
        if (a2 <= 1 && a2 >= 0) {
            this.f27525f = str2;
            return;
        }
        this.f27525f = aVar.f27491c;
        this.f27526g = aVar.f27492d;
    }
}
