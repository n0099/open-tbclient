package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.sdk.openadsdk.utils.ak;
/* loaded from: classes6.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public final Context f28243a;

    /* renamed from: b  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.core.d.l f28244b;

    /* renamed from: c  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.downloadnew.core.a f28245c;

    /* renamed from: d  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.nativeexpress.e f28246d;

    /* renamed from: e  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.nativeexpress.d f28247e;

    /* renamed from: f  reason: collision with root package name */
    public View f28248f;

    /* renamed from: g  reason: collision with root package name */
    public String f28249g;

    public j(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, View view, String str) {
        this.f28249g = "rewarded_video";
        this.f28244b = lVar;
        this.f28243a = context;
        this.f28248f = view;
        if (TextUtils.isEmpty(str)) {
            this.f28249g = ak.b(ak.c(lVar.ap()));
        } else {
            this.f28249g = str;
        }
        if (this.f28244b.Z() == 4) {
            this.f28245c = com.bytedance.sdk.openadsdk.downloadnew.a.a(this.f28243a, this.f28244b, this.f28249g);
        }
        String str2 = this.f28249g;
        com.bytedance.sdk.openadsdk.core.nativeexpress.e eVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.e(context, lVar, str2, ak.a(str2));
        this.f28246d = eVar;
        eVar.a(this.f28248f);
        this.f28246d.a(this.f28245c);
        String str3 = this.f28249g;
        com.bytedance.sdk.openadsdk.core.nativeexpress.d dVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.d(context, lVar, str3, ak.a(str3));
        this.f28247e = dVar;
        dVar.a(this.f28248f);
        this.f28247e.a(this.f28245c);
    }

    public void a(int i2, com.bytedance.sdk.openadsdk.core.d.j jVar) {
        com.bytedance.sdk.openadsdk.core.nativeexpress.d dVar;
        if (i2 == -1 || jVar == null) {
            return;
        }
        int i3 = jVar.f27942a;
        int i4 = jVar.f27943b;
        int i5 = jVar.f27944c;
        int i6 = jVar.f27945d;
        if (i2 != 1) {
            if (i2 == 2 && (dVar = this.f28247e) != null) {
                dVar.a(jVar);
                this.f28247e.a(this.f28248f, i3, i4, i5, i6);
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.core.nativeexpress.e eVar = this.f28246d;
        if (eVar != null) {
            eVar.a(jVar);
            this.f28246d.a(this.f28248f, i3, i4, i5, i6);
        }
    }
}
