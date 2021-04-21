package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.sdk.openadsdk.utils.ak;
/* loaded from: classes5.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public final Context f28137a;

    /* renamed from: b  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.core.d.l f28138b;

    /* renamed from: c  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.downloadnew.core.a f28139c;

    /* renamed from: d  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.nativeexpress.e f28140d;

    /* renamed from: e  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.nativeexpress.d f28141e;

    /* renamed from: f  reason: collision with root package name */
    public View f28142f;

    /* renamed from: g  reason: collision with root package name */
    public String f28143g;

    public j(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, View view, String str) {
        this.f28143g = "rewarded_video";
        this.f28138b = lVar;
        this.f28137a = context;
        this.f28142f = view;
        if (TextUtils.isEmpty(str)) {
            this.f28143g = ak.b(ak.c(lVar.ap()));
        } else {
            this.f28143g = str;
        }
        if (this.f28138b.Z() == 4) {
            this.f28139c = com.bytedance.sdk.openadsdk.downloadnew.a.a(this.f28137a, this.f28138b, this.f28143g);
        }
        String str2 = this.f28143g;
        com.bytedance.sdk.openadsdk.core.nativeexpress.e eVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.e(context, lVar, str2, ak.a(str2));
        this.f28140d = eVar;
        eVar.a(this.f28142f);
        this.f28140d.a(this.f28139c);
        String str3 = this.f28143g;
        com.bytedance.sdk.openadsdk.core.nativeexpress.d dVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.d(context, lVar, str3, ak.a(str3));
        this.f28141e = dVar;
        dVar.a(this.f28142f);
        this.f28141e.a(this.f28139c);
    }

    public void a(int i, com.bytedance.sdk.openadsdk.core.d.j jVar) {
        com.bytedance.sdk.openadsdk.core.nativeexpress.d dVar;
        if (i == -1 || jVar == null) {
            return;
        }
        int i2 = jVar.f27851a;
        int i3 = jVar.f27852b;
        int i4 = jVar.f27853c;
        int i5 = jVar.f27854d;
        if (i != 1) {
            if (i == 2 && (dVar = this.f28141e) != null) {
                dVar.a(jVar);
                this.f28141e.a(this.f28142f, i2, i3, i4, i5);
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.core.nativeexpress.e eVar = this.f28140d;
        if (eVar != null) {
            eVar.a(jVar);
            this.f28140d.a(this.f28142f, i2, i3, i4, i5);
        }
    }
}
