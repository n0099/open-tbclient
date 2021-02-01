package com.bytedance.sdk.openadsdk.dislike;

import android.app.Activity;
import android.content.Context;
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
    private final Context f7035a;

    /* renamed from: b  reason: collision with root package name */
    private l f7036b;
    private d c;
    private c d;
    private String e;
    private Boolean f = false;
    private AtomicBoolean g = new AtomicBoolean(false);
    private int h = -1;
    private TTAdDislike.DislikeInteractionCallback i;

    public b(Context context, l lVar) {
        z.a(context, "Dislike 初始化必须使用activity,请在TTAdManager.createAdNative(activity)中传入");
        this.f7035a = context;
        lVar.b("other");
        this.f7036b = lVar;
        a();
    }

    private void a() {
        this.c = new d(this.f7035a, this.f7036b);
        this.c.a(new d.a() { // from class: com.bytedance.sdk.openadsdk.dislike.b.1
            @Override // com.bytedance.sdk.openadsdk.dislike.d.a
            public void a() {
                u.b("TTAdDislikeImpl", "onDislikeShow: ");
            }

            @Override // com.bytedance.sdk.openadsdk.dislike.d.a
            public void a(int i, FilterWord filterWord) {
                try {
                    if (!filterWord.hasSecondOptions()) {
                        if (b.this.i != null) {
                            b.this.i.onSelected(i, filterWord.getName());
                        }
                        b.this.g.set(true);
                    }
                    u.f("TTAdDislikeImpl", "onDislikeSelected: " + i + ", " + String.valueOf(filterWord.getName()));
                } catch (Throwable th) {
                    u.c("TTAdDislikeImpl", "dislike callback selected error: ", th);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.dislike.d.a
            public void b() {
                u.f("TTAdDislikeImpl", "onDislikeCancel: ");
                try {
                    if (b.this.i != null) {
                        b.this.i.onCancel();
                    }
                } catch (Throwable th) {
                    u.c("TTAdDislikeImpl", "dislike callback cancel error: ", th);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.dislike.d.a
            public void c() {
                b.this.b();
            }
        });
        this.d = new c(this.f7035a, this.f7036b);
        this.d.a(new c.a() { // from class: com.bytedance.sdk.openadsdk.dislike.b.2
            @Override // com.bytedance.sdk.openadsdk.dislike.c.a
            public void a() {
            }

            @Override // com.bytedance.sdk.openadsdk.dislike.c.a
            public void b() {
                try {
                    if (b.this.i != null) {
                        b.this.i.onCancel();
                    }
                    if (!b.this.f.booleanValue()) {
                        b.this.c.show();
                    }
                } catch (Throwable th) {
                    u.c("TTAdDislikeImpl", "dislike callback selected error: ", th);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.dislike.c.a
            public void a(int i, FilterWord filterWord) {
                try {
                    if (!filterWord.hasSecondOptions()) {
                        if (b.this.i != null) {
                            b.this.i.onSelected(i, filterWord.getName());
                        }
                        b.this.g.set(true);
                        b.this.f = true;
                    }
                } catch (Throwable th) {
                    u.c("TTAdDislikeImpl", "comment callback selected error: ", th);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void sendDislikeSource(String str) {
        this.f7036b.b(str);
        this.e = str;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void showDislikeDialog() {
        if (((this.f7035a instanceof Activity) && !((Activity) this.f7035a).isFinishing()) && !this.g.get()) {
            this.c.a(this.e);
            this.c.show();
            return;
        }
        this.i.onRefuse();
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void showDislikeDialog(int i) {
        if (this.h == 1) {
            showDislikeDialog();
        }
        if ((this.f7035a instanceof Activity) && !((Activity) this.f7035a).isFinishing()) {
            this.c.a(this.e);
            this.c.show();
            this.g.set(false);
            return;
        }
        this.i.onRefuse();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if ((this.f7035a instanceof Activity) && !((Activity) this.f7035a).isFinishing()) {
            this.d.show();
        }
    }

    public void a(l lVar) {
        this.c.a(lVar);
        this.d.a(lVar);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void setDislikeInteractionCallback(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        this.i = dislikeInteractionCallback;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void setIsInteractionAd() {
        this.h = 1;
    }
}
