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
/* loaded from: classes5.dex */
public class j implements TTFullScreenVideoAd {

    /* renamed from: a  reason: collision with root package name */
    public final Context f28337a;

    /* renamed from: b  reason: collision with root package name */
    public final l f28338b;

    /* renamed from: c  reason: collision with root package name */
    public final AdSlot f28339c;

    /* renamed from: d  reason: collision with root package name */
    public TTFullScreenVideoAd.FullScreenVideoAdInteractionListener f28340d;

    /* renamed from: e  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.downloadnew.core.a f28341e;

    /* renamed from: g  reason: collision with root package name */
    public boolean f28343g;

    /* renamed from: h  reason: collision with root package name */
    public String f28344h;

    /* renamed from: i  reason: collision with root package name */
    public String f28345i;
    public String l;

    /* renamed from: f  reason: collision with root package name */
    public boolean f28342f = true;
    public AtomicBoolean j = new AtomicBoolean(false);
    public boolean k = false;

    public j(Context context, l lVar, AdSlot adSlot) {
        this.f28337a = context;
        this.f28338b = lVar;
        this.f28339c = adSlot;
        if (getInteractionType() == 4) {
            this.f28341e = com.bytedance.sdk.openadsdk.downloadnew.a.a(this.f28337a, this.f28338b, "fullscreen_interstitial_ad");
        }
        this.f28343g = false;
        this.l = com.bytedance.sdk.openadsdk.utils.j.a(this.f28338b.hashCode() + this.f28338b.aL().toString());
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public int getFullVideoAdType() {
        l lVar = this.f28338b;
        if (lVar == null) {
            return -1;
        }
        if (lVar.C() && this.f28338b.i() == 1) {
            return 2;
        }
        return (this.f28338b.C() && this.f28338b.i() == 0) ? 1 : 0;
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public int getInteractionType() {
        l lVar = this.f28338b;
        if (lVar == null) {
            return -1;
        }
        return lVar.Z();
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public Map<String, Object> getMediaExtraInfo() {
        l lVar = this.f28338b;
        if (lVar != null) {
            return lVar.ay();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = this.f28341e;
        if (aVar != null) {
            aVar.a(tTAppDownloadListener);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void setFullScreenVideoAdInteractionListener(TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        this.f28340d = fullScreenVideoAdInteractionListener;
        a(1);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void setShowDownLoadBar(boolean z) {
        this.f28342f = z;
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
            l lVar = this.f28338b;
            if (lVar == null || lVar.X() == null) {
                return;
            }
            Context context = activity == null ? this.f28337a : activity;
            if (context == null) {
                context = p.a();
            }
            if (this.f28338b.d() == 2) {
                intent = new Intent(context, TTFullScreenExpressVideoActivity.class);
            } else {
                intent = new Intent(context, TTFullScreenVideoActivity.class);
            }
            if (activity == null) {
                intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            }
            intent.putExtra("show_download_bar", this.f28342f);
            intent.putExtra("orientation", this.f28339c.getOrientation());
            intent.putExtra("is_verity_playable", this.k);
            if (!TextUtils.isEmpty(this.f28345i)) {
                intent.putExtra("rit_scene", this.f28345i);
            }
            if (this.f28343g) {
                intent.putExtra("video_cache_url", this.f28344h);
            }
            com.bytedance.sdk.openadsdk.utils.k.e(this.f28338b.aL().toString());
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                intent.putExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA, this.f28338b.aL().toString());
                intent.putExtra("multi_process_meta_md5", this.l);
            } else {
                com.bytedance.sdk.openadsdk.core.u.a().g();
                com.bytedance.sdk.openadsdk.core.u.a().a(this.f28338b);
                com.bytedance.sdk.openadsdk.core.u.a().a(this.f28340d);
                com.bytedance.sdk.openadsdk.core.u.a().a(this.f28341e);
                this.f28340d = null;
            }
            com.bytedance.sdk.openadsdk.utils.b.a(context, intent, new b.a() { // from class: com.bytedance.sdk.openadsdk.component.reward.j.1
                @Override // com.bytedance.sdk.openadsdk.utils.b.a
                public void a() {
                    if (j.this.k) {
                        try {
                            com.bytedance.sdk.openadsdk.h.a.a().a(j.this.f28338b.X().j());
                        } catch (Throwable unused) {
                        }
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.utils.b.a
                public void a(Throwable th) {
                    u.c("TTFullScreenVideoAdImpl", "show full screen video error: ", th);
                    if (j.this.k) {
                        try {
                            com.bytedance.sdk.openadsdk.h.a.a().a(j.this.f28338b.X().j(), -1, th != null ? th.getMessage() : "playable tool error open");
                        } catch (Throwable unused) {
                        }
                    }
                }
            });
            if (TextUtils.isEmpty(this.f28338b.ap())) {
                return;
            }
            try {
                String optString = new JSONObject(this.f28338b.ap()).optString("rit", null);
                AdSlot b2 = c.a(this.f28337a).b(optString);
                c.a(this.f28337a).a(optString);
                if (b2 != null) {
                    if (this.f28343g && !TextUtils.isEmpty(this.f28344h)) {
                        c.a(this.f28337a).b(b2);
                    } else {
                        c.a(this.f28337a).a(b2);
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
        this.f28343g = true;
        this.f28344h = str;
    }

    private void a(final int i2) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.l.e.b(new com.bytedance.sdk.openadsdk.l.g("registerMultiProcessListener") { // from class: com.bytedance.sdk.openadsdk.component.reward.j.2
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.multipro.aidl.a a2 = com.bytedance.sdk.openadsdk.multipro.aidl.a.a(j.this.f28337a);
                    if (i2 == 1 && j.this.f28340d != null) {
                        u.b("MultiProcess", "start registerFullScreenVideoListener ! ");
                        com.bytedance.sdk.openadsdk.multipro.aidl.b.c cVar = new com.bytedance.sdk.openadsdk.multipro.aidl.b.c(j.this.f28340d);
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
            this.f28345i = str;
        } else {
            this.f28345i = ritScenes.getScenesName();
        }
        showFullScreenVideoAd(activity);
    }
}
