package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.sdk.openadsdk.utils.ak;
/* loaded from: classes6.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public final Context f28172a;

    /* renamed from: b  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.core.d.l f28173b;

    /* renamed from: c  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.downloadnew.core.a f28174c;

    /* renamed from: d  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.nativeexpress.e f28175d;

    /* renamed from: e  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.nativeexpress.d f28176e;

    /* renamed from: f  reason: collision with root package name */
    public View f28177f;

    /* renamed from: g  reason: collision with root package name */
    public String f28178g;

    public j(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, View view, String str) {
        this.f28178g = "rewarded_video";
        this.f28173b = lVar;
        this.f28172a = context;
        this.f28177f = view;
        if (TextUtils.isEmpty(str)) {
            this.f28178g = ak.b(ak.c(lVar.ap()));
        } else {
            this.f28178g = str;
        }
        if (this.f28173b.Z() == 4) {
            this.f28174c = com.bytedance.sdk.openadsdk.downloadnew.a.a(this.f28172a, this.f28173b, this.f28178g);
        }
        String str2 = this.f28178g;
        com.bytedance.sdk.openadsdk.core.nativeexpress.e eVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.e(context, lVar, str2, ak.a(str2));
        this.f28175d = eVar;
        eVar.a(this.f28177f);
        this.f28175d.a(this.f28174c);
        String str3 = this.f28178g;
        com.bytedance.sdk.openadsdk.core.nativeexpress.d dVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.d(context, lVar, str3, ak.a(str3));
        this.f28176e = dVar;
        dVar.a(this.f28177f);
        this.f28176e.a(this.f28174c);
    }

    public void a(int i2, com.bytedance.sdk.openadsdk.core.d.j jVar) {
        com.bytedance.sdk.openadsdk.core.nativeexpress.d dVar;
        if (i2 == -1 || jVar == null) {
            return;
        }
        int i3 = jVar.f27871a;
        int i4 = jVar.f27872b;
        int i5 = jVar.f27873c;
        int i6 = jVar.f27874d;
        if (i2 != 1) {
            if (i2 == 2 && (dVar = this.f28176e) != null) {
                dVar.a(jVar);
                this.f28176e.a(this.f28177f, i3, i4, i5, i6);
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.core.nativeexpress.e eVar = this.f28175d;
        if (eVar != null) {
            eVar.a(jVar);
            this.f28175d.a(this.f28177f, i3, i4, i5, i6);
        }
    }
}
