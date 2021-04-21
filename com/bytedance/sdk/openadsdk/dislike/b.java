package com.bytedance.sdk.openadsdk.dislike;

import android.app.Activity;
import android.content.Context;
import com.baidu.android.common.others.lang.StringUtil;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.dislike.c;
import com.bytedance.sdk.openadsdk.dislike.d;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.z;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class b implements TTAdDislike {

    /* renamed from: a  reason: collision with root package name */
    public String f28826a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f28827b;

    /* renamed from: c  reason: collision with root package name */
    public l f28828c;

    /* renamed from: d  reason: collision with root package name */
    public d f28829d;

    /* renamed from: e  reason: collision with root package name */
    public c f28830e;

    /* renamed from: f  reason: collision with root package name */
    public String f28831f;

    /* renamed from: g  reason: collision with root package name */
    public Boolean f28832g;

    /* renamed from: h  reason: collision with root package name */
    public AtomicBoolean f28833h;
    public boolean i;
    public TTAdDislike.DislikeInteractionCallback j;

    public b(Context context, l lVar) {
        this(context, lVar, null);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void sendDislikeSource(String str) {
        this.f28828c.c(str);
        this.f28831f = str;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void setDislikeInteractionCallback(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        this.j = dislikeInteractionCallback;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void setIsInteractionAd() {
        this.i = true;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void showDislikeDialog() {
        Context context = this.f28827b;
        if (((context instanceof Activity) && !((Activity) context).isFinishing()) && !this.f28829d.isShowing() && !this.f28830e.isShowing()) {
            this.f28829d.show();
            this.f28833h.set(false);
            return;
        }
        TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback = this.j;
        if (dislikeInteractionCallback != null) {
            dislikeInteractionCallback.onRefuse();
        }
    }

    public b(Context context, l lVar, String str) {
        this.f28832g = Boolean.FALSE;
        this.f28833h = new AtomicBoolean(false);
        this.i = false;
        this.f28826a = str;
        z.a(context, "Dislike 初始化必须使用activity,请在TTAdManager.createAdNative(activity)中传入");
        this.f28827b = context;
        lVar.c("other");
        this.f28828c = lVar;
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Context context = this.f28827b;
        if (!((context instanceof Activity) && !((Activity) context).isFinishing()) || this.f28829d.isShowing() || this.f28830e.isShowing()) {
            return;
        }
        this.f28830e.show();
    }

    private void a() {
        d dVar = new d(this.f28827b, this.f28828c, this.f28826a);
        this.f28829d = dVar;
        dVar.a(new d.a() { // from class: com.bytedance.sdk.openadsdk.dislike.b.1
            @Override // com.bytedance.sdk.openadsdk.dislike.d.a
            public void a() {
                u.b("TTAdDislikeImpl", "onDislikeShow: ");
            }

            @Override // com.bytedance.sdk.openadsdk.dislike.d.a
            public void b() {
                b.this.b();
            }

            @Override // com.bytedance.sdk.openadsdk.dislike.d.a
            public void a(int i, FilterWord filterWord) {
                try {
                    if (!filterWord.hasSecondOptions()) {
                        if (b.this.j != null) {
                            b.this.j.onSelected(i, filterWord.getName());
                        }
                        b.this.f28833h.set(true);
                    }
                    u.f("TTAdDislikeImpl", "onDislikeSelected: " + i + StringUtil.ARRAY_ELEMENT_SEPARATOR + String.valueOf(filterWord.getName()));
                } catch (Throwable th) {
                    u.c("TTAdDislikeImpl", "dislike callback selected error: ", th);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.dislike.d.a
            public void a(boolean z) {
                u.f("TTAdDislikeImpl", "onDislikeCancel: ");
                try {
                    if (b.this.j == null || z) {
                        return;
                    }
                    b.this.j.onCancel();
                } catch (Throwable th) {
                    u.c("TTAdDislikeImpl", "dislike callback cancel error: ", th);
                }
            }
        });
        c cVar = new c(this.f28827b, this.f28828c);
        this.f28830e = cVar;
        cVar.a(new c.a() { // from class: com.bytedance.sdk.openadsdk.dislike.b.2
            @Override // com.bytedance.sdk.openadsdk.dislike.c.a
            public void a() {
            }

            @Override // com.bytedance.sdk.openadsdk.dislike.c.a
            public void a(int i, FilterWord filterWord) {
                try {
                    if (filterWord.hasSecondOptions()) {
                        return;
                    }
                    if (b.this.j != null) {
                        b.this.j.onSelected(i, filterWord.getName());
                    }
                    b.this.f28833h.set(true);
                    b.this.f28832g = Boolean.TRUE;
                } catch (Throwable th) {
                    u.c("TTAdDislikeImpl", "comment callback selected error: ", th);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.dislike.c.a
            public void b() {
                try {
                    if (b.this.f28832g.booleanValue()) {
                        return;
                    }
                    b.this.f28829d.show();
                } catch (Throwable th) {
                    u.c("TTAdDislikeImpl", "dislike callback selected error: ", th);
                }
            }
        });
    }

    public void a(l lVar) {
        this.f28829d.a(lVar);
        this.f28830e.a(lVar);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void showDislikeDialog(int i) {
        if (this.i) {
            showDislikeDialog();
            return;
        }
        Context context = this.f28827b;
        if (((context instanceof Activity) && !((Activity) context).isFinishing()) && !this.f28829d.isShowing() && !this.f28830e.isShowing()) {
            this.f28829d.a(this.f28831f);
            this.f28829d.show();
            this.f28833h.set(false);
            return;
        }
        TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback = this.j;
        if (dislikeInteractionCallback != null) {
            dislikeInteractionCallback.onRefuse();
        }
    }
}
