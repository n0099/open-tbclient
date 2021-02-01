package com.bytedance.sdk.openadsdk.component.reward;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.activity.base.TTFullScreenExpressVideoActivity;
import com.bytedance.sdk.openadsdk.activity.base.TTFullScreenVideoActivity;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.b;
import com.bytedance.sdk.openadsdk.utils.k;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes6.dex */
class i implements TTFullScreenVideoAd {

    /* renamed from: a  reason: collision with root package name */
    private final Context f6340a;

    /* renamed from: b  reason: collision with root package name */
    private final l f6341b;
    private final AdSlot c;
    private TTFullScreenVideoAd.FullScreenVideoAdInteractionListener d;
    private com.bytedance.sdk.openadsdk.downloadnew.core.a e;
    private boolean g;
    private String h;
    private String i;
    private String l;
    private boolean f = true;
    private AtomicBoolean j = new AtomicBoolean(false);
    private boolean k = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(Context context, l lVar, AdSlot adSlot) {
        this.f6340a = context;
        this.f6341b = lVar;
        this.c = adSlot;
        if (getInteractionType() == 4) {
            this.e = com.bytedance.sdk.openadsdk.downloadnew.a.a(this.f6340a, this.f6341b, "fullscreen_interstitial_ad");
        }
        this.g = false;
        this.l = com.bytedance.sdk.openadsdk.utils.j.a(this.f6341b.hashCode() + this.f6341b.am().toString());
    }

    public void a(boolean z) {
        this.k = z;
    }

    public void a(String str) {
        if (!this.j.get()) {
            this.g = true;
            this.h = str;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void setFullScreenVideoAdInteractionListener(TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        this.d = fullScreenVideoAdInteractionListener;
        a(1);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        if (this.e != null) {
            this.e.a(tTAppDownloadListener);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public int getInteractionType() {
        if (this.f6341b == null) {
            return -1;
        }
        return this.f6341b.H();
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void showFullScreenVideoAd(Activity activity) {
        Intent intent;
        if (activity != null && activity.isFinishing()) {
            u.f("TTFullScreenVideoAdImpl", "showFullScreenVideoAd error1: activity is finishing");
        } else if (Looper.getMainLooper() != Looper.myLooper()) {
            u.f("TTFullScreenVideoAdImpl", "showFullScreenVideoAd error2: not main looper");
            throw new IllegalStateException("不能在子线程调用 TTFullScreenVideoAd.showFullScreenVideoAd");
        } else if (!this.j.get()) {
            this.j.set(true);
            if (this.f6341b != null && this.f6341b.F() != null) {
                Context context = activity == null ? this.f6340a : activity;
                if (context == null) {
                    context = p.a();
                }
                if (this.f6341b.B() != null) {
                    intent = new Intent(context, TTFullScreenExpressVideoActivity.class);
                } else {
                    intent = new Intent(context, TTFullScreenVideoActivity.class);
                }
                if (activity == null) {
                    intent.addFlags(268435456);
                }
                intent.putExtra("show_download_bar", this.f);
                intent.putExtra("orientation", this.c.getOrientation());
                intent.putExtra("is_verity_playable", this.k);
                if (!TextUtils.isEmpty(this.i)) {
                    intent.putExtra("rit_scene", this.i);
                }
                if (this.g) {
                    intent.putExtra("video_cache_url", this.h);
                }
                k.d(this.f6341b.am().toString());
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    intent.putExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA, this.f6341b.am().toString());
                    intent.putExtra("multi_process_meta_md5", this.l);
                } else {
                    com.bytedance.sdk.openadsdk.core.u.a().g();
                    com.bytedance.sdk.openadsdk.core.u.a().a(this.f6341b);
                    com.bytedance.sdk.openadsdk.core.u.a().a(this.d);
                    com.bytedance.sdk.openadsdk.core.u.a().a(this.e);
                    this.d = null;
                }
                com.bytedance.sdk.openadsdk.utils.b.a(context, intent, new b.a() { // from class: com.bytedance.sdk.openadsdk.component.reward.i.1
                    @Override // com.bytedance.sdk.openadsdk.utils.b.a
                    public void a() {
                        if (i.this.k) {
                            try {
                                com.bytedance.sdk.openadsdk.h.a.a().a(i.this.f6341b.F().i());
                            } catch (Throwable th) {
                            }
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.utils.b.a
                    public void a(Throwable th) {
                        u.c("TTFullScreenVideoAdImpl", "show full screen video error: ", th);
                        if (i.this.k) {
                            try {
                                com.bytedance.sdk.openadsdk.h.a.a().a(i.this.f6341b.F().i(), -1, th != null ? th.getMessage() : "playable tool error open");
                            } catch (Throwable th2) {
                            }
                        }
                    }
                });
                if (!TextUtils.isEmpty(this.f6341b.W())) {
                    try {
                        String optString = new JSONObject(this.f6341b.W()).optString("rit", null);
                        AdSlot b2 = c.a(this.f6340a).b(optString);
                        c.a(this.f6340a).a(optString);
                        if (b2 != null) {
                            if (this.g && !TextUtils.isEmpty(this.h)) {
                                c.a(this.f6340a).b(b2);
                            } else {
                                c.a(this.f6340a).a(b2);
                            }
                        }
                    } catch (Throwable th) {
                    }
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void showFullScreenVideoAd(Activity activity, TTAdConstant.RitScenes ritScenes, String str) {
        if (ritScenes == null) {
            u.f("TTFullScreenVideoAdImpl", "The param ritScenes can not be null!");
            return;
        }
        if (ritScenes == TTAdConstant.RitScenes.CUSTOMIZE_SCENES) {
            this.i = str;
        } else {
            this.i = ritScenes.getScenesName();
        }
        showFullScreenVideoAd(activity);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void setShowDownLoadBar(boolean z) {
        this.f = z;
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public Map<String, Object> getMediaExtraInfo() {
        if (this.f6341b != null) {
            return this.f6341b.ae();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public int getFullVideoAdType() {
        if (this.f6341b == null) {
            return -1;
        }
        if (this.f6341b.s() && this.f6341b.c() == 1) {
            return 2;
        }
        return (this.f6341b.s() && this.f6341b.c() == 0) ? 1 : 0;
    }

    private void a(final int i) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.k.a.a().a(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.i.2
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.multipro.aidl.a a2 = com.bytedance.sdk.openadsdk.multipro.aidl.a.a(i.this.f6340a);
                    switch (i) {
                        case 1:
                            if (i.this.d != null) {
                                u.b("MultiProcess", "start registerFullScreenVideoListener ! ");
                                com.bytedance.sdk.openadsdk.multipro.aidl.b.c cVar = new com.bytedance.sdk.openadsdk.multipro.aidl.b.c(i.this.d);
                                IListenerManager asInterface = com.bytedance.sdk.openadsdk.multipro.aidl.a.e.asInterface(a2.a(1));
                                if (asInterface != null) {
                                    try {
                                        asInterface.registerFullVideoListener(i.this.l, cVar);
                                        u.b("MultiProcess", "end registerFullScreenVideoListener ! ");
                                        return;
                                    } catch (RemoteException e) {
                                        e.printStackTrace();
                                        return;
                                    }
                                }
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
            }, 5);
        }
    }
}
