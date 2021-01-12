package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.utils.aj;
/* loaded from: classes4.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private final Context f6603a;

    /* renamed from: b  reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.core.d.l f6604b;
    private com.bytedance.sdk.openadsdk.downloadnew.core.a c;
    private com.bytedance.sdk.openadsdk.core.nativeexpress.e d;
    private com.bytedance.sdk.openadsdk.core.nativeexpress.d e;
    private View f;
    private String g;

    public j(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, View view) {
        this.g = "rewarded_video";
        this.f6604b = lVar;
        this.f6603a = context;
        this.f = view;
        this.g = aj.b(aj.c(lVar.W()));
        if (this.f6604b.H() == 4) {
            this.c = com.bytedance.sdk.openadsdk.downloadnew.a.a(this.f6603a, this.f6604b, this.g);
        }
        this.d = new com.bytedance.sdk.openadsdk.core.nativeexpress.e(context, lVar, this.g, aj.a(this.g));
        this.d.a(this.f);
        this.d.a(this.c);
        this.e = new com.bytedance.sdk.openadsdk.core.nativeexpress.d(context, lVar, this.g, aj.a(this.g));
        this.e.a(this.f);
        this.e.a(this.c);
    }

    public void a(int i, com.bytedance.sdk.openadsdk.core.d.j jVar) {
        if (i != -1 && jVar != null) {
            int i2 = jVar.f6503a;
            int i3 = jVar.f6504b;
            int i4 = jVar.c;
            int i5 = jVar.d;
            switch (i) {
                case 1:
                    if (this.d != null) {
                        this.d.a(jVar);
                        this.d.a(this.f, i2, i3, i4, i5);
                        return;
                    }
                    return;
                case 2:
                    if (this.e != null) {
                        this.e.a(jVar);
                        this.e.a(this.f, i2, i3, i4, i5);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
