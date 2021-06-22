package com.bytedance.sdk.openadsdk.component.reward;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.alibaba.fastjson.asm.Label;
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
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class j implements TTFullScreenVideoAd {

    /* renamed from: a  reason: collision with root package name */
    public final Context f27696a;

    /* renamed from: b  reason: collision with root package name */
    public final l f27697b;

    /* renamed from: c  reason: collision with root package name */
    public final AdSlot f27698c;

    /* renamed from: d  reason: collision with root package name */
    public TTFullScreenVideoAd.FullScreenVideoAdInteractionListener f27699d;

    /* renamed from: e  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.downloadnew.core.a f27700e;

    /* renamed from: g  reason: collision with root package name */
    public boolean f27702g;

    /* renamed from: h  reason: collision with root package name */
    public String f27703h;

    /* renamed from: i  reason: collision with root package name */
    public String f27704i;
    public String l;

    /* renamed from: f  reason: collision with root package name */
    public boolean f27701f = true;
    public AtomicBoolean j = new AtomicBoolean(false);
    public boolean k = false;

    public j(Context context, l lVar, AdSlot adSlot) {
        this.f27696a = context;
        this.f27697b = lVar;
        this.f27698c = adSlot;
        if (getInteractionType() == 4) {
            this.f27700e = com.bytedance.sdk.openadsdk.downloadnew.a.a(this.f27696a, this.f27697b, "fullscreen_interstitial_ad");
        }
        this.f27702g = false;
        this.l = com.bytedance.sdk.openadsdk.utils.j.a(this.f27697b.hashCode() + this.f27697b.aL().toString());
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public int getFullVideoAdType() {
        l lVar = this.f27697b;
        if (lVar == null) {
            return -1;
        }
        if (lVar.C() && this.f27697b.i() == 1) {
            return 2;
        }
        return (this.f27697b.C() && this.f27697b.i() == 0) ? 1 : 0;
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public int getInteractionType() {
        l lVar = this.f27697b;
        if (lVar == null) {
            return -1;
        }
        return lVar.Z();
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public Map<String, Object> getMediaExtraInfo() {
        l lVar = this.f27697b;
        if (lVar != null) {
            return lVar.ay();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = this.f27700e;
        if (aVar != null) {
            aVar.a(tTAppDownloadListener);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void setFullScreenVideoAdInteractionListener(TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        this.f27699d = fullScreenVideoAdInteractionListener;
        a(1);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void setShowDownLoadBar(boolean z) {
        this.f27701f = z;
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void showFullScreenVideoAd(Activity activity) {
        Intent intent;
        if (activity != null && activity.isFinishing()) {
            u.f("TTFullScreenVideoAdImpl", "showFullScreenVideoAd error1: activity is finishing");
            activity = null;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            if (this.j.get()) {
                return;
            }
            this.j.set(true);
            l lVar = this.f27697b;
            if (lVar == null || lVar.X() == null) {
                return;
            }
            Context context = activity == null ? this.f27696a : activity;
            if (context == null) {
                context = p.a();
            }
            if (this.f27697b.d() == 2) {
                intent = new Intent(context, TTFullScreenExpressVideoActivity.class);
            } else {
                intent = new Intent(context, TTFullScreenVideoActivity.class);
            }
            if (activity == null) {
                intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            }
            intent.putExtra("show_download_bar", this.f27701f);
            intent.putExtra("orientation", this.f27698c.getOrientation());
            intent.putExtra("is_verity_playable", this.k);
            if (!TextUtils.isEmpty(this.f27704i)) {
                intent.putExtra("rit_scene", this.f27704i);
            }
            if (this.f27702g) {
                intent.putExtra("video_cache_url", this.f27703h);
            }
            com.bytedance.sdk.openadsdk.utils.k.e(this.f27697b.aL().toString());
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                intent.putExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA, this.f27697b.aL().toString());
                intent.putExtra("multi_process_meta_md5", this.l);
            } else {
                com.bytedance.sdk.openadsdk.core.u.a().g();
                com.bytedance.sdk.openadsdk.core.u.a().a(this.f27697b);
                com.bytedance.sdk.openadsdk.core.u.a().a(this.f27699d);
                com.bytedance.sdk.openadsdk.core.u.a().a(this.f27700e);
                this.f27699d = null;
            }
            com.bytedance.sdk.openadsdk.utils.b.a(context, intent, new b.a() { // from class: com.bytedance.sdk.openadsdk.component.reward.j.1
                @Override // com.bytedance.sdk.openadsdk.utils.b.a
                public void a() {
                    if (j.this.k) {
                        try {
                            com.bytedance.sdk.openadsdk.h.a.a().a(j.this.f27697b.X().j());
                        } catch (Throwable unused) {
                        }
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.utils.b.a
                public void a(Throwable th) {
                    u.c("TTFullScreenVideoAdImpl", "show full screen video error: ", th);
                    if (j.this.k) {
                        try {
                            com.bytedance.sdk.openadsdk.h.a.a().a(j.this.f27697b.X().j(), -1, th != null ? th.getMessage() : "playable tool error open");
                        } catch (Throwable unused) {
                        }
                    }
                }
            });
            if (TextUtils.isEmpty(this.f27697b.ap())) {
                return;
            }
            try {
                String optString = new JSONObject(this.f27697b.ap()).optString("rit", null);
                AdSlot b2 = c.a(this.f27696a).b(optString);
                c.a(this.f27696a).a(optString);
                if (b2 != null) {
                    if (this.f27702g && !TextUtils.isEmpty(this.f27703h)) {
                        c.a(this.f27696a).b(b2);
                    } else {
                        c.a(this.f27696a).a(b2);
                    }
                }
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        u.f("TTFullScreenVideoAdImpl", "showFullScreenVideoAd error2: not main looper");
        throw new IllegalStateException("不能在子线程调用 TTFullScreenVideoAd.showFullScreenVideoAd");
    }

    public void a(boolean z) {
        this.k = z;
    }

    public void a(String str) {
        if (this.j.get()) {
            return;
        }
        this.f27702g = true;
        this.f27703h = str;
    }

    private void a(final int i2) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.l.e.b(new com.bytedance.sdk.openadsdk.l.g("registerMultiProcessListener") { // from class: com.bytedance.sdk.openadsdk.component.reward.j.2
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.multipro.aidl.a a2 = com.bytedance.sdk.openadsdk.multipro.aidl.a.a(j.this.f27696a);
                    if (i2 == 1 && j.this.f27699d != null) {
                        u.b("MultiProcess", "start registerFullScreenVideoListener ! ");
                        com.bytedance.sdk.openadsdk.multipro.aidl.b.c cVar = new com.bytedance.sdk.openadsdk.multipro.aidl.b.c(j.this.f27699d);
                        IListenerManager asInterface = IListenerManager.Stub.asInterface(a2.a(1));
                        if (asInterface != null) {
                            try {
                                asInterface.registerFullVideoListener(j.this.l, cVar);
                                u.b("MultiProcess", "end registerFullScreenVideoListener ! ");
                            } catch (RemoteException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                }
            }, 5);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void showFullScreenVideoAd(Activity activity, TTAdConstant.RitScenes ritScenes, String str) {
        if (ritScenes == null) {
            u.f("TTFullScreenVideoAdImpl", "The param ritScenes can not be null!");
            return;
        }
        if (ritScenes == TTAdConstant.RitScenes.CUSTOMIZE_SCENES) {
            this.f27704i = str;
        } else {
            this.f27704i = ritScenes.getScenesName();
        }
        showFullScreenVideoAd(activity);
    }
}
