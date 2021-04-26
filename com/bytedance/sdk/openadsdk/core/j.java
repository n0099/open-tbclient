package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.sdk.openadsdk.utils.ak;
/* loaded from: classes5.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public final Context f28998a;

    /* renamed from: b  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.core.d.l f28999b;

    /* renamed from: c  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.downloadnew.core.a f29000c;

    /* renamed from: d  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.nativeexpress.e f29001d;

    /* renamed from: e  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.nativeexpress.d f29002e;

    /* renamed from: f  reason: collision with root package name */
    public View f29003f;

    /* renamed from: g  reason: collision with root package name */
    public String f29004g;

    public j(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, View view, String str) {
        this.f29004g = "rewarded_video";
        this.f28999b = lVar;
        this.f28998a = context;
        this.f29003f = view;
        if (TextUtils.isEmpty(str)) {
            this.f29004g = ak.b(ak.c(lVar.ap()));
        } else {
            this.f29004g = str;
        }
        if (this.f28999b.Z() == 4) {
            this.f29000c = com.bytedance.sdk.openadsdk.downloadnew.a.a(this.f28998a, this.f28999b, this.f29004g);
        }
        String str2 = this.f29004g;
        com.bytedance.sdk.openadsdk.core.nativeexpress.e eVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.e(context, lVar, str2, ak.a(str2));
        this.f29001d = eVar;
        eVar.a(this.f29003f);
        this.f29001d.a(this.f29000c);
        String str3 = this.f29004g;
        com.bytedance.sdk.openadsdk.core.nativeexpress.d dVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.d(context, lVar, str3, ak.a(str3));
        this.f29002e = dVar;
        dVar.a(this.f29003f);
        this.f29002e.a(this.f29000c);
    }

    public void a(int i2, com.bytedance.sdk.openadsdk.core.d.j jVar) {
        com.bytedance.sdk.openadsdk.core.nativeexpress.d dVar;
        if (i2 == -1 || jVar == null) {
            return;
        }
        int i3 = jVar.f28697a;
        int i4 = jVar.f28698b;
        int i5 = jVar.f28699c;
        int i6 = jVar.f28700d;
        if (i2 != 1) {
            if (i2 == 2 && (dVar = this.f29002e) != null) {
                dVar.a(jVar);
                this.f29002e.a(this.f29003f, i3, i4, i5, i6);
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.core.nativeexpress.e eVar = this.f29001d;
        if (eVar != null) {
            eVar.a(jVar);
            this.f29001d.a(this.f29003f, i3, i4, i5, i6);
        }
    }
}
