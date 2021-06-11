package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.sdk.openadsdk.utils.ak;
/* loaded from: classes6.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public final Context f28275a;

    /* renamed from: b  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.core.d.l f28276b;

    /* renamed from: c  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.downloadnew.core.a f28277c;

    /* renamed from: d  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.nativeexpress.e f28278d;

    /* renamed from: e  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.nativeexpress.d f28279e;

    /* renamed from: f  reason: collision with root package name */
    public View f28280f;

    /* renamed from: g  reason: collision with root package name */
    public String f28281g;

    public j(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, View view, String str) {
        this.f28281g = "rewarded_video";
        this.f28276b = lVar;
        this.f28275a = context;
        this.f28280f = view;
        if (TextUtils.isEmpty(str)) {
            this.f28281g = ak.b(ak.c(lVar.ap()));
        } else {
            this.f28281g = str;
        }
        if (this.f28276b.Z() == 4) {
            this.f28277c = com.bytedance.sdk.openadsdk.downloadnew.a.a(this.f28275a, this.f28276b, this.f28281g);
        }
        String str2 = this.f28281g;
        com.bytedance.sdk.openadsdk.core.nativeexpress.e eVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.e(context, lVar, str2, ak.a(str2));
        this.f28278d = eVar;
        eVar.a(this.f28280f);
        this.f28278d.a(this.f28277c);
        String str3 = this.f28281g;
        com.bytedance.sdk.openadsdk.core.nativeexpress.d dVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.d(context, lVar, str3, ak.a(str3));
        this.f28279e = dVar;
        dVar.a(this.f28280f);
        this.f28279e.a(this.f28277c);
    }

    public void a(int i2, com.bytedance.sdk.openadsdk.core.d.j jVar) {
        com.bytedance.sdk.openadsdk.core.nativeexpress.d dVar;
        if (i2 == -1 || jVar == null) {
            return;
        }
        int i3 = jVar.f27974a;
        int i4 = jVar.f27975b;
        int i5 = jVar.f27976c;
        int i6 = jVar.f27977d;
        if (i2 != 1) {
            if (i2 == 2 && (dVar = this.f28279e) != null) {
                dVar.a(jVar);
                this.f28279e.a(this.f28280f, i3, i4, i5, i6);
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.core.nativeexpress.e eVar = this.f28278d;
        if (eVar != null) {
            eVar.a(jVar);
            this.f28278d.a(this.f28280f, i3, i4, i5, i6);
        }
    }
}
