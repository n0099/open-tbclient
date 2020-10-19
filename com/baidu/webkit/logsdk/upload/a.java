package com.baidu.webkit.logsdk.upload;

import android.text.TextUtils;
/* loaded from: classes11.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public String f3965a;
    public int b;
    boolean c;
    public long d;
    public com.baidu.webkit.logsdk.b.a e;
    public String f;
    public String g;
    public String h;
    public String i;

    public a(com.baidu.webkit.logsdk.b.a aVar, String str) {
        this(aVar, str, null);
    }

    public a(com.baidu.webkit.logsdk.b.a aVar, String str, String str2) {
        this.f3965a = str;
        this.b = 0;
        this.c = false;
        this.e = aVar;
        int a2 = TextUtils.isEmpty(str2) ? -1 : com.baidu.webkit.logsdk.d.c.a(str2);
        if (a2 <= 1 && a2 >= 0) {
            this.f = str2;
            return;
        }
        this.f = aVar.c;
        this.g = aVar.d;
    }
}
