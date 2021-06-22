package com.baidu.webkit.logsdk.upload;

import android.text.TextUtils;
import com.baidu.webkit.logsdk.d.c;
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public String f26879a;

    /* renamed from: b  reason: collision with root package name */
    public int f26880b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f26881c;

    /* renamed from: d  reason: collision with root package name */
    public long f26882d;

    /* renamed from: e  reason: collision with root package name */
    public com.baidu.webkit.logsdk.b.a f26883e;

    /* renamed from: f  reason: collision with root package name */
    public String f26884f;

    /* renamed from: g  reason: collision with root package name */
    public String f26885g;

    /* renamed from: h  reason: collision with root package name */
    public String f26886h;

    /* renamed from: i  reason: collision with root package name */
    public String f26887i;

    public a(com.baidu.webkit.logsdk.b.a aVar, String str) {
        this(aVar, str, null);
    }

    public a(com.baidu.webkit.logsdk.b.a aVar, String str, String str2) {
        this.f26879a = str;
        this.f26880b = 0;
        this.f26881c = false;
        this.f26883e = aVar;
        int a2 = !TextUtils.isEmpty(str2) ? c.a(str2) : -1;
        if (a2 <= 1 && a2 >= 0) {
            this.f26884f = str2;
            return;
        }
        this.f26884f = aVar.f26850c;
        this.f26885g = aVar.f26851d;
    }
}
