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
    public String f29072a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f29073b;

    /* renamed from: c  reason: collision with root package name */
    public l f29074c;

    /* renamed from: d  reason: collision with root package name */
    public d f29075d;

    /* renamed from: e  reason: collision with root package name */
    public c f29076e;

    /* renamed from: f  reason: collision with root package name */
    public String f29077f;

    /* renamed from: g  reason: collision with root package name */
    public Boolean f29078g;

    /* renamed from: h  reason: collision with root package name */
    public AtomicBoolean f29079h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f29080i;
    public TTAdDislike.DislikeInteractionCallback j;

    public b(Context context, l lVar) {
        this(context, lVar, null);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void sendDislikeSource(String str) {
        this.f29074c.c(str);
        this.f29077f = str;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void setDislikeInteractionCallback(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        this.j = dislikeInteractionCallback;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void setIsInteractionAd() {
        this.f29080i = true;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void showDislikeDialog() {
        Context context = this.f29073b;
        if (((context instanceof Activity) && !((Activity) context).isFinishing()) && !this.f29075d.isShowing() && !this.f29076e.isShowing()) {
            this.f29075d.show();
            this.f29079h.set(false);
            return;
        }
        TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback = this.j;
        if (dislikeInteractionCallback != null) {
            dislikeInteractionCallback.onRefuse();
        }
    }

    public b(Context context, l lVar, String str) {
        this.f29078g = Boolean.FALSE;
        this.f29079h = new AtomicBoolean(false);
        this.f29080i = false;
        this.f29072a = str;
        z.a(context, "Dislike 初始化必须使用activity,请在TTAdManager.createAdNative(activity)中传入");
        this.f29073b = context;
        lVar.c("other");
        this.f29074c = lVar;
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Context context = this.f29073b;
        if (!((context instanceof Activity) && !((Activity) context).isFinishing()) || this.f29075d.isShowing() || this.f29076e.isShowing()) {
            return;
        }
        this.f29076e.show();
    }

    private void a() {
        d dVar = new d(this.f29073b, this.f29074c, this.f29072a);
        this.f29075d = dVar;
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
            public void a(int i2, FilterWord filterWord) {
                try {
                    if (!filterWord.hasSecondOptions()) {
                        if (b.this.j != null) {
                            b.this.j.onSelected(i2, filterWord.getName());
                        }
                        b.this.f29079h.set(true);
                    }
                    u.f("TTAdDislikeImpl", "onDislikeSelected: " + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + String.valueOf(filterWord.getName()));
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
        c cVar = new c(this.f29073b, this.f29074c);
        this.f29076e = cVar;
        cVar.a(new c.a() { // from class: com.bytedance.sdk.openadsdk.dislike.b.2
            @Override // com.bytedance.sdk.openadsdk.dislike.c.a
            public void a() {
            }

            @Override // com.bytedance.sdk.openadsdk.dislike.c.a
            public void a(int i2, FilterWord filterWord) {
                try {
                    if (filterWord.hasSecondOptions()) {
                        return;
                    }
                    if (b.this.j != null) {
                        b.this.j.onSelected(i2, filterWord.getName());
                    }
                    b.this.f29079h.set(true);
                    b.this.f29078g = Boolean.TRUE;
                } catch (Throwable th) {
                    u.c("TTAdDislikeImpl", "comment callback selected error: ", th);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.dislike.c.a
            public void b() {
                try {
                    if (b.this.f29078g.booleanValue()) {
                        return;
                    }
                    b.this.f29075d.show();
                } catch (Throwable th) {
                    u.c("TTAdDislikeImpl", "dislike callback selected error: ", th);
                }
            }
        });
    }

    public void a(l lVar) {
        this.f29075d.a(lVar);
        this.f29076e.a(lVar);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void showDislikeDialog(int i2) {
        if (this.f29080i) {
            showDislikeDialog();
            return;
        }
        Context context = this.f29073b;
        if (((context instanceof Activity) && !((Activity) context).isFinishing()) && !this.f29075d.isShowing() && !this.f29076e.isShowing()) {
            this.f29075d.a(this.f29077f);
            this.f29075d.show();
            this.f29079h.set(false);
            return;
        }
        TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback = this.j;
        if (dislikeInteractionCallback != null) {
            dislikeInteractionCallback.onRefuse();
        }
    }
}
