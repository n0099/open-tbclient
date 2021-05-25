package com.baidu.webkit.logsdk.upload;

import android.text.TextUtils;
import com.baidu.webkit.logsdk.d.c;
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public String f26694a;

    /* renamed from: b  reason: collision with root package name */
    public int f26695b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f26696c;

    /* renamed from: d  reason: collision with root package name */
    public long f26697d;

    /* renamed from: e  reason: collision with root package name */
    public com.baidu.webkit.logsdk.b.a f26698e;

    /* renamed from: f  reason: collision with root package name */
    public String f26699f;

    /* renamed from: g  reason: collision with root package name */
    public String f26700g;

    /* renamed from: h  reason: collision with root package name */
    public String f26701h;

    /* renamed from: i  reason: collision with root package name */
    public String f26702i;

    public a(com.baidu.webkit.logsdk.b.a aVar, String str) {
        this(aVar, str, null);
    }

    public a(com.baidu.webkit.logsdk.b.a aVar, String str, String str2) {
        this.f26694a = str;
        this.f26695b = 0;
        this.f26696c = false;
        this.f26698e = aVar;
        int a2 = !TextUtils.isEmpty(str2) ? c.a(str2) : -1;
        if (a2 <= 1 && a2 >= 0) {
            this.f26699f = str2;
            return;
        }
        this.f26699f = aVar.f26665c;
        this.f26700g = aVar.f26666d;
    }
}
