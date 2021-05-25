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
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.bytedance.sdk.openadsdk.activity.base.TTRewardExpressVideoActivity;
import com.bytedance.sdk.openadsdk.activity.base.TTRewardVideoActivity;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.b;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class k implements TTRewardVideoAd {

    /* renamed from: a  reason: collision with root package name */
    public final Context f27523a;

    /* renamed from: b  reason: collision with root package name */
    public final l f27524b;

    /* renamed from: c  reason: collision with root package name */
    public final AdSlot f27525c;

    /* renamed from: d  reason: collision with root package name */
    public TTRewardVideoAd.RewardAdInteractionListener f27526d;

    /* renamed from: e  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.downloadnew.core.a f27527e;

    /* renamed from: g  reason: collision with root package name */
    public boolean f27529g;

    /* renamed from: h  reason: collision with root package name */
    public String f27530h;

    /* renamed from: i  reason: collision with root package name */
    public String f27531i;
    public String k;

    /* renamed from: f  reason: collision with root package name */
    public boolean f27528f = true;
    public AtomicBoolean j = new AtomicBoolean(false);

    public k(Context context, l lVar, AdSlot adSlot) {
        this.f27523a = context;
        this.f27524b = lVar;
        this.f27525c = adSlot;
        if (getInteractionType() == 4) {
            this.f27527e = com.bytedance.sdk.openadsdk.downloadnew.a.a(this.f27523a, this.f27524b, "rewarded_video");
        }
        this.f27529g = false;
        this.k = com.bytedance.sdk.openadsdk.utils.j.a(this.f27524b.hashCode() + this.f27524b.aL().toString());
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public int getInteractionType() {
        l lVar = this.f27524b;
        if (lVar == null) {
            return -1;
        }
        return lVar.Z();
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public Map<String, Object> getMediaExtraInfo() {
        l lVar = this.f27524b;
        if (lVar != null) {
            return lVar.ay();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public int getRewardVideoAdType() {
        l lVar = this.f27524b;
        if (lVar == null) {
            return -1;
        }
        if (lVar.C() && this.f27524b.i() == 1) {
            return 2;
        }
        return (this.f27524b.C() && this.f27524b.i() == 0) ? 1 : 0;
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = this.f27527e;
        if (aVar != null) {
            aVar.a(tTAppDownloadListener);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void setRewardAdInteractionListener(TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        this.f27526d = rewardAdInteractionListener;
        a(0);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void setShowDownLoadBar(boolean z) {
        this.f27528f = z;
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void showRewardVideoAd(Activity activity) {
        Intent intent;
        if (activity != null && activity.isFinishing()) {
            u.f("TTRewardVideoAdImpl", "showRewardVideoAd error1: activity is finishing");
            activity = null;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            if (this.j.get()) {
                return;
            }
            this.j.set(true);
            l lVar = this.f27524b;
            if (lVar == null || lVar.X() == null) {
                return;
            }
            Context context = activity == null ? this.f27523a : activity;
            if (context == null) {
                context = p.a();
            }
            if (this.f27524b.d() == 2) {
                intent = new Intent(context, TTRewardExpressVideoActivity.class);
            } else {
                intent = new Intent(context, TTRewardVideoActivity.class);
            }
            if (activity == null) {
                intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            }
            intent.putExtra("reward_name", this.f27524b.b());
            intent.putExtra("reward_amount", this.f27524b.c());
            intent.putExtra("media_extra", this.f27525c.getMediaExtra());
            intent.putExtra("user_id", this.f27525c.getUserID());
            intent.putExtra("show_download_bar", this.f27528f);
            intent.putExtra("orientation", this.f27525c.getOrientation());
            if (!TextUtils.isEmpty(this.f27531i)) {
                intent.putExtra("rit_scene", this.f27531i);
            }
            if (this.f27529g) {
                intent.putExtra("video_cache_url", this.f27530h);
            }
            com.bytedance.sdk.openadsdk.utils.k.e(this.f27524b.aL().toString());
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                intent.putExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA, this.f27524b.aL().toString());
                intent.putExtra("multi_process_meta_md5", this.k);
            } else {
                com.bytedance.sdk.openadsdk.core.u.a().g();
                com.bytedance.sdk.openadsdk.core.u.a().a(this.f27524b);
                com.bytedance.sdk.openadsdk.core.u.a().a(this.f27526d);
                com.bytedance.sdk.openadsdk.core.u.a().a(this.f27527e);
                this.f27526d = null;
            }
            com.bytedance.sdk.openadsdk.utils.b.a(context, intent, new b.a() { // from class: com.bytedance.sdk.openadsdk.component.reward.k.1
                @Override // com.bytedance.sdk.openadsdk.utils.b.a
                public void a() {
                }

                @Override // com.bytedance.sdk.openadsdk.utils.b.a
                public void a(Throwable th) {
                    u.c("TTRewardVideoAdImpl", "show reward video error: ", th);
                }
            });
            if (TextUtils.isEmpty(this.f27524b.ap())) {
                return;
            }
            try {
                String optString = new JSONObject(this.f27524b.ap()).optString("rit", null);
                AdSlot b2 = h.a(this.f27523a).b(optString);
                h.a(this.f27523a).a(optString);
                if (b2 != null) {
                    if (this.f27529g && !TextUtils.isEmpty(this.f27530h)) {
                        h.a(this.f27523a).b(b2);
                    } else {
                        h.a(this.f27523a).a(b2);
                    }
                }
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        u.f("TTRewardVideoAdImpl", "showRewardVideoAd error2: not main looper");
        throw new IllegalStateException("不能在子线程调用 TTRewardVideoAd.showRewardVideoAd");
    }

    public void a(String str) {
        if (this.j.get()) {
            return;
        }
        this.f27529g = true;
        this.f27530h = str;
    }

    private void a(final int i2) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.l.e.b(new com.bytedance.sdk.openadsdk.l.g("registerMultiProcessListener") { // from class: com.bytedance.sdk.openadsdk.component.reward.k.2
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.multipro.aidl.a a2 = com.bytedance.sdk.openadsdk.multipro.aidl.a.a(k.this.f27523a);
                    if (i2 == 0 && k.this.f27526d != null) {
                        u.b("MultiProcess", "start registerRewardVideoListener ! ");
                        com.bytedance.sdk.openadsdk.multipro.aidl.b.d dVar = new com.bytedance.sdk.openadsdk.multipro.aidl.b.d(k.this.f27526d);
                        IListenerManager asInterface = IListenerManager.Stub.asInterface(a2.a(0));
                        if (asInterface != null) {
                            try {
                                asInterface.registerRewardVideoListener(k.this.k, dVar);
                                u.b("MultiProcess", "end registerRewardVideoListener ! ");
                            } catch (RemoteException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                }
            }, 5);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void showRewardVideoAd(Activity activity, TTAdConstant.RitScenes ritScenes, String str) {
        if (ritScenes == null) {
            u.f("TTRewardVideoAdImpl", "The param ritScenes can not be null!");
            return;
        }
        if (ritScenes == TTAdConstant.RitScenes.CUSTOMIZE_SCENES) {
            this.f27531i = str;
        } else {
            this.f27531i = ritScenes.getScenesName();
        }
        showRewardVideoAd(activity);
    }
}
