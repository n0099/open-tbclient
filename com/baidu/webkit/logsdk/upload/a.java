package com.baidu.webkit.logsdk.upload;

import android.text.TextUtils;
import com.baidu.webkit.logsdk.d.c;
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public String f26765a;

    /* renamed from: b  reason: collision with root package name */
    public int f26766b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f26767c;

    /* renamed from: d  reason: collision with root package name */
    public long f26768d;

    /* renamed from: e  reason: collision with root package name */
    public com.baidu.webkit.logsdk.b.a f26769e;

    /* renamed from: f  reason: collision with root package name */
    public String f26770f;

    /* renamed from: g  reason: collision with root package name */
    public String f26771g;

    /* renamed from: h  reason: collision with root package name */
    public String f26772h;

    /* renamed from: i  reason: collision with root package name */
    public String f26773i;

    public a(com.baidu.webkit.logsdk.b.a aVar, String str) {
        this(aVar, str, null);
    }

    public a(com.baidu.webkit.logsdk.b.a aVar, String str, String str2) {
        this.f26765a = str;
        this.f26766b = 0;
        this.f26767c = false;
        this.f26769e = aVar;
        int a2 = !TextUtils.isEmpty(str2) ? c.a(str2) : -1;
        if (a2 <= 1 && a2 >= 0) {
            this.f26770f = str2;
            return;
        }
        this.f26770f = aVar.f26736c;
        this.f26771g = aVar.f26737d;
    }
}
