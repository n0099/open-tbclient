package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.sdk.openadsdk.utils.ak;
/* loaded from: classes5.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public final Context f28129a;

    /* renamed from: b  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.core.d.l f28130b;

    /* renamed from: c  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.downloadnew.core.a f28131c;

    /* renamed from: d  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.nativeexpress.e f28132d;

    /* renamed from: e  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.nativeexpress.d f28133e;

    /* renamed from: f  reason: collision with root package name */
    public View f28134f;

    /* renamed from: g  reason: collision with root package name */
    public String f28135g;

    public j(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, View view, String str) {
        this.f28135g = "rewarded_video";
        this.f28130b = lVar;
        this.f28129a = context;
        this.f28134f = view;
        if (TextUtils.isEmpty(str)) {
            this.f28135g = ak.b(ak.c(lVar.ap()));
        } else {
            this.f28135g = str;
        }
        if (this.f28130b.Z() == 4) {
            this.f28131c = com.bytedance.sdk.openadsdk.downloadnew.a.a(this.f28129a, this.f28130b, this.f28135g);
        }
        String str2 = this.f28135g;
        com.bytedance.sdk.openadsdk.core.nativeexpress.e eVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.e(context, lVar, str2, ak.a(str2));
        this.f28132d = eVar;
        eVar.a(this.f28134f);
        this.f28132d.a(this.f28131c);
        String str3 = this.f28135g;
        com.bytedance.sdk.openadsdk.core.nativeexpress.d dVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.d(context, lVar, str3, ak.a(str3));
        this.f28133e = dVar;
        dVar.a(this.f28134f);
        this.f28133e.a(this.f28131c);
    }

    public void a(int i, com.bytedance.sdk.openadsdk.core.d.j jVar) {
        com.bytedance.sdk.openadsdk.core.nativeexpress.d dVar;
        if (i == -1 || jVar == null) {
            return;
        }
        int i2 = jVar.f27843a;
        int i3 = jVar.f27844b;
        int i4 = jVar.f27845c;
        int i5 = jVar.f27846d;
        if (i != 1) {
            if (i == 2 && (dVar = this.f28133e) != null) {
                dVar.a(jVar);
                this.f28133e.a(this.f28134f, i2, i3, i4, i5);
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.core.nativeexpress.e eVar = this.f28132d;
        if (eVar != null) {
            eVar.a(jVar);
            this.f28132d.a(this.f28134f, i2, i3, i4, i5);
        }
    }
}
