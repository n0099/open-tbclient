package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.sdk.openadsdk.utils.ak;
/* loaded from: classes6.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public final Context f28357a;

    /* renamed from: b  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.core.d.l f28358b;

    /* renamed from: c  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.downloadnew.core.a f28359c;

    /* renamed from: d  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.nativeexpress.e f28360d;

    /* renamed from: e  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.nativeexpress.d f28361e;

    /* renamed from: f  reason: collision with root package name */
    public View f28362f;

    /* renamed from: g  reason: collision with root package name */
    public String f28363g;

    public j(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, View view, String str) {
        this.f28363g = "rewarded_video";
        this.f28358b = lVar;
        this.f28357a = context;
        this.f28362f = view;
        if (TextUtils.isEmpty(str)) {
            this.f28363g = ak.b(ak.c(lVar.ap()));
        } else {
            this.f28363g = str;
        }
        if (this.f28358b.Z() == 4) {
            this.f28359c = com.bytedance.sdk.openadsdk.downloadnew.a.a(this.f28357a, this.f28358b, this.f28363g);
        }
        String str2 = this.f28363g;
        com.bytedance.sdk.openadsdk.core.nativeexpress.e eVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.e(context, lVar, str2, ak.a(str2));
        this.f28360d = eVar;
        eVar.a(this.f28362f);
        this.f28360d.a(this.f28359c);
        String str3 = this.f28363g;
        com.bytedance.sdk.openadsdk.core.nativeexpress.d dVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.d(context, lVar, str3, ak.a(str3));
        this.f28361e = dVar;
        dVar.a(this.f28362f);
        this.f28361e.a(this.f28359c);
    }

    public void a(int i2, com.bytedance.sdk.openadsdk.core.d.j jVar) {
        com.bytedance.sdk.openadsdk.core.nativeexpress.d dVar;
        if (i2 == -1 || jVar == null) {
            return;
        }
        int i3 = jVar.f28056a;
        int i4 = jVar.f28057b;
        int i5 = jVar.f28058c;
        int i6 = jVar.f28059d;
        if (i2 != 1) {
            if (i2 == 2 && (dVar = this.f28361e) != null) {
                dVar.a(jVar);
                this.f28361e.a(this.f28362f, i3, i4, i5, i6);
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.core.nativeexpress.e eVar = this.f28360d;
        if (eVar != null) {
            eVar.a(jVar);
            this.f28360d.a(this.f28362f, i3, i4, i5, i6);
        }
    }
}
