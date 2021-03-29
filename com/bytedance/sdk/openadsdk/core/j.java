package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.sdk.openadsdk.utils.ak;
/* loaded from: classes6.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public final Context f28444a;

    /* renamed from: b  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.core.d.l f28445b;

    /* renamed from: c  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.downloadnew.core.a f28446c;

    /* renamed from: d  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.nativeexpress.e f28447d;

    /* renamed from: e  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.nativeexpress.d f28448e;

    /* renamed from: f  reason: collision with root package name */
    public View f28449f;

    /* renamed from: g  reason: collision with root package name */
    public String f28450g;

    public j(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, View view, String str) {
        this.f28450g = "rewarded_video";
        this.f28445b = lVar;
        this.f28444a = context;
        this.f28449f = view;
        if (TextUtils.isEmpty(str)) {
            this.f28450g = ak.b(ak.c(lVar.ap()));
        } else {
            this.f28450g = str;
        }
        if (this.f28445b.Z() == 4) {
            this.f28446c = com.bytedance.sdk.openadsdk.downloadnew.a.a(this.f28444a, this.f28445b, this.f28450g);
        }
        String str2 = this.f28450g;
        com.bytedance.sdk.openadsdk.core.nativeexpress.e eVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.e(context, lVar, str2, ak.a(str2));
        this.f28447d = eVar;
        eVar.a(this.f28449f);
        this.f28447d.a(this.f28446c);
        String str3 = this.f28450g;
        com.bytedance.sdk.openadsdk.core.nativeexpress.d dVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.d(context, lVar, str3, ak.a(str3));
        this.f28448e = dVar;
        dVar.a(this.f28449f);
        this.f28448e.a(this.f28446c);
    }

    public void a(int i, com.bytedance.sdk.openadsdk.core.d.j jVar) {
        com.bytedance.sdk.openadsdk.core.nativeexpress.d dVar;
        if (i == -1 || jVar == null) {
            return;
        }
        int i2 = jVar.f28158a;
        int i3 = jVar.f28159b;
        int i4 = jVar.f28160c;
        int i5 = jVar.f28161d;
        if (i != 1) {
            if (i == 2 && (dVar = this.f28448e) != null) {
                dVar.a(jVar);
                this.f28448e.a(this.f28449f, i2, i3, i4, i5);
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.core.nativeexpress.e eVar = this.f28447d;
        if (eVar != null) {
            eVar.a(jVar);
            this.f28447d.a(this.f28449f, i2, i3, i4, i5);
        }
    }
}
