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
/* loaded from: classes6.dex */
public class b implements TTAdDislike {

    /* renamed from: a  reason: collision with root package name */
    public String f29133a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f29134b;

    /* renamed from: c  reason: collision with root package name */
    public l f29135c;

    /* renamed from: d  reason: collision with root package name */
    public d f29136d;

    /* renamed from: e  reason: collision with root package name */
    public c f29137e;

    /* renamed from: f  reason: collision with root package name */
    public String f29138f;

    /* renamed from: g  reason: collision with root package name */
    public Boolean f29139g;

    /* renamed from: h  reason: collision with root package name */
    public AtomicBoolean f29140h;
    public boolean i;
    public TTAdDislike.DislikeInteractionCallback j;

    public b(Context context, l lVar) {
        this(context, lVar, null);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void sendDislikeSource(String str) {
        this.f29135c.c(str);
        this.f29138f = str;
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
        Context context = this.f29134b;
        if (((context instanceof Activity) && !((Activity) context).isFinishing()) && !this.f29136d.isShowing() && !this.f29137e.isShowing()) {
            this.f29136d.show();
            this.f29140h.set(false);
            return;
        }
        TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback = this.j;
        if (dislikeInteractionCallback != null) {
            dislikeInteractionCallback.onRefuse();
        }
    }

    public b(Context context, l lVar, String str) {
        this.f29139g = Boolean.FALSE;
        this.f29140h = new AtomicBoolean(false);
        this.i = false;
        this.f29133a = str;
        z.a(context, "Dislike 初始化必须使用activity,请在TTAdManager.createAdNative(activity)中传入");
        this.f29134b = context;
        lVar.c("other");
        this.f29135c = lVar;
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Context context = this.f29134b;
        if (!((context instanceof Activity) && !((Activity) context).isFinishing()) || this.f29136d.isShowing() || this.f29137e.isShowing()) {
            return;
        }
        this.f29137e.show();
    }

    private void a() {
        d dVar = new d(this.f29134b, this.f29135c, this.f29133a);
        this.f29136d = dVar;
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
                        b.this.f29140h.set(true);
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
        c cVar = new c(this.f29134b, this.f29135c);
        this.f29137e = cVar;
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
                    b.this.f29140h.set(true);
                    b.this.f29139g = Boolean.TRUE;
                } catch (Throwable th) {
                    u.c("TTAdDislikeImpl", "comment callback selected error: ", th);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.dislike.c.a
            public void b() {
                try {
                    if (b.this.f29139g.booleanValue()) {
                        return;
                    }
                    b.this.f29136d.show();
                } catch (Throwable th) {
                    u.c("TTAdDislikeImpl", "dislike callback selected error: ", th);
                }
            }
        });
    }

    public void a(l lVar) {
        this.f29136d.a(lVar);
        this.f29137e.a(lVar);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void showDislikeDialog(int i) {
        if (this.i) {
            showDislikeDialog();
            return;
        }
        Context context = this.f29134b;
        if (((context instanceof Activity) && !((Activity) context).isFinishing()) && !this.f29136d.isShowing() && !this.f29137e.isShowing()) {
            this.f29136d.a(this.f29138f);
            this.f29136d.show();
            this.f29140h.set(false);
            return;
        }
        TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback = this.j;
        if (dislikeInteractionCallback != null) {
            dislikeInteractionCallback.onRefuse();
        }
    }
}
