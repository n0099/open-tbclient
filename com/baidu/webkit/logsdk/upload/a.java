package com.baidu.webkit.logsdk.upload;

import android.text.TextUtils;
import com.baidu.webkit.logsdk.d.c;
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public String f26797a;

    /* renamed from: b  reason: collision with root package name */
    public int f26798b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f26799c;

    /* renamed from: d  reason: collision with root package name */
    public long f26800d;

    /* renamed from: e  reason: collision with root package name */
    public com.baidu.webkit.logsdk.b.a f26801e;

    /* renamed from: f  reason: collision with root package name */
    public String f26802f;

    /* renamed from: g  reason: collision with root package name */
    public String f26803g;

    /* renamed from: h  reason: collision with root package name */
    public String f26804h;

    /* renamed from: i  reason: collision with root package name */
    public String f26805i;

    public a(com.baidu.webkit.logsdk.b.a aVar, String str) {
        this(aVar, str, null);
    }

    public a(com.baidu.webkit.logsdk.b.a aVar, String str, String str2) {
        this.f26797a = str;
        this.f26798b = 0;
        this.f26799c = false;
        this.f26801e = aVar;
        int a2 = !TextUtils.isEmpty(str2) ? c.a(str2) : -1;
        if (a2 <= 1 && a2 >= 0) {
            this.f26802f = str2;
            return;
        }
        this.f26802f = aVar.f26768c;
        this.f26803g = aVar.f26769d;
    }
}
