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
    public String f28958a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f28959b;

    /* renamed from: c  reason: collision with root package name */
    public l f28960c;

    /* renamed from: d  reason: collision with root package name */
    public d f28961d;

    /* renamed from: e  reason: collision with root package name */
    public c f28962e;

    /* renamed from: f  reason: collision with root package name */
    public String f28963f;

    /* renamed from: g  reason: collision with root package name */
    public Boolean f28964g;

    /* renamed from: h  reason: collision with root package name */
    public AtomicBoolean f28965h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f28966i;
    public TTAdDislike.DislikeInteractionCallback j;

    public b(Context context, l lVar) {
        this(context, lVar, null);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void sendDislikeSource(String str) {
        this.f28960c.c(str);
        this.f28963f = str;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void setDislikeInteractionCallback(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        this.j = dislikeInteractionCallback;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void setIsInteractionAd() {
        this.f28966i = true;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void showDislikeDialog() {
        Context context = this.f28959b;
        if (((context instanceof Activity) && !((Activity) context).isFinishing()) && !this.f28961d.isShowing() && !this.f28962e.isShowing()) {
            this.f28961d.show();
            this.f28965h.set(false);
            return;
        }
        TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback = this.j;
        if (dislikeInteractionCallback != null) {
            dislikeInteractionCallback.onRefuse();
        }
    }

    public b(Context context, l lVar, String str) {
        this.f28964g = Boolean.FALSE;
        this.f28965h = new AtomicBoolean(false);
        this.f28966i = false;
        this.f28958a = str;
        z.a(context, "Dislike 初始化必须使用activity,请在TTAdManager.createAdNative(activity)中传入");
        this.f28959b = context;
        lVar.c("other");
        this.f28960c = lVar;
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Context context = this.f28959b;
        if (!((context instanceof Activity) && !((Activity) context).isFinishing()) || this.f28961d.isShowing() || this.f28962e.isShowing()) {
            return;
        }
        this.f28962e.show();
    }

    private void a() {
        d dVar = new d(this.f28959b, this.f28960c, this.f28958a);
        this.f28961d = dVar;
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
                        b.this.f28965h.set(true);
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
        c cVar = new c(this.f28959b, this.f28960c);
        this.f28962e = cVar;
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
                    b.this.f28965h.set(true);
                    b.this.f28964g = Boolean.TRUE;
                } catch (Throwable th) {
                    u.c("TTAdDislikeImpl", "comment callback selected error: ", th);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.dislike.c.a
            public void b() {
                try {
                    if (b.this.f28964g.booleanValue()) {
                        return;
                    }
                    b.this.f28961d.show();
                } catch (Throwable th) {
                    u.c("TTAdDislikeImpl", "dislike callback selected error: ", th);
                }
            }
        });
    }

    public void a(l lVar) {
        this.f28961d.a(lVar);
        this.f28962e.a(lVar);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void showDislikeDialog(int i2) {
        if (this.f28966i) {
            showDislikeDialog();
            return;
        }
        Context context = this.f28959b;
        if (((context instanceof Activity) && !((Activity) context).isFinishing()) && !this.f28961d.isShowing() && !this.f28962e.isShowing()) {
            this.f28961d.a(this.f28963f);
            this.f28961d.show();
            this.f28965h.set(false);
            return;
        }
        TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback = this.j;
        if (dislikeInteractionCallback != null) {
            dislikeInteractionCallback.onRefuse();
        }
    }
}
