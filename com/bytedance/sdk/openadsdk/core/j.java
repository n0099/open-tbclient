package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.sdk.openadsdk.utils.ak;
/* loaded from: classes6.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public final Context f28443a;

    /* renamed from: b  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.core.d.l f28444b;

    /* renamed from: c  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.downloadnew.core.a f28445c;

    /* renamed from: d  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.nativeexpress.e f28446d;

    /* renamed from: e  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.nativeexpress.d f28447e;

    /* renamed from: f  reason: collision with root package name */
    public View f28448f;

    /* renamed from: g  reason: collision with root package name */
    public String f28449g;

    public j(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, View view, String str) {
        this.f28449g = "rewarded_video";
        this.f28444b = lVar;
        this.f28443a = context;
        this.f28448f = view;
        if (TextUtils.isEmpty(str)) {
            this.f28449g = ak.b(ak.c(lVar.ap()));
        } else {
            this.f28449g = str;
        }
        if (this.f28444b.Z() == 4) {
            this.f28445c = com.bytedance.sdk.openadsdk.downloadnew.a.a(this.f28443a, this.f28444b, this.f28449g);
        }
        String str2 = this.f28449g;
        com.bytedance.sdk.openadsdk.core.nativeexpress.e eVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.e(context, lVar, str2, ak.a(str2));
        this.f28446d = eVar;
        eVar.a(this.f28448f);
        this.f28446d.a(this.f28445c);
        String str3 = this.f28449g;
        com.bytedance.sdk.openadsdk.core.nativeexpress.d dVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.d(context, lVar, str3, ak.a(str3));
        this.f28447e = dVar;
        dVar.a(this.f28448f);
        this.f28447e.a(this.f28445c);
    }

    public void a(int i, com.bytedance.sdk.openadsdk.core.d.j jVar) {
        com.bytedance.sdk.openadsdk.core.nativeexpress.d dVar;
        if (i == -1 || jVar == null) {
            return;
        }
        int i2 = jVar.f28157a;
        int i3 = jVar.f28158b;
        int i4 = jVar.f28159c;
        int i5 = jVar.f28160d;
        if (i != 1) {
            if (i == 2 && (dVar = this.f28447e) != null) {
                dVar.a(jVar);
                this.f28447e.a(this.f28448f, i2, i3, i4, i5);
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.core.nativeexpress.e eVar = this.f28446d;
        if (eVar != null) {
            eVar.a(jVar);
            this.f28446d.a(this.f28448f, i2, i3, i4, i5);
        }
    }
}
