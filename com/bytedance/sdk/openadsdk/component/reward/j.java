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
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.bytedance.sdk.openadsdk.activity.base.TTRewardExpressVideoActivity;
import com.bytedance.sdk.openadsdk.activity.base.TTRewardVideoActivity;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.b;
import com.bytedance.sdk.openadsdk.utils.k;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes6.dex */
class j implements TTRewardVideoAd {

    /* renamed from: a  reason: collision with root package name */
    private final Context f4293a;
    private final l b;
    private final AdSlot c;
    private TTRewardVideoAd.RewardAdInteractionListener d;
    private com.bytedance.sdk.openadsdk.downloadnew.core.a e;
    private boolean g;
    private String h;
    private String i;
    private String k;
    private boolean f = true;
    private AtomicBoolean j = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Context context, l lVar, AdSlot adSlot) {
        this.f4293a = context;
        this.b = lVar;
        this.c = adSlot;
        if (getInteractionType() == 4) {
            this.e = com.bytedance.sdk.openadsdk.downloadnew.a.a(this.f4293a, this.b, "rewarded_video");
        }
        this.g = false;
        this.k = com.bytedance.sdk.openadsdk.utils.j.a(this.b.hashCode() + this.b.aE().toString());
    }

    public void a(String str) {
        if (!this.j.get()) {
            this.g = true;
            this.h = str;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void setRewardAdInteractionListener(TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        this.d = rewardAdInteractionListener;
        a(0);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        if (this.e != null) {
            this.e.a(tTAppDownloadListener);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public int getInteractionType() {
        if (this.b == null) {
            return -1;
        }
        return this.b.T();
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void setShowDownLoadBar(boolean z) {
        this.f = z;
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public int getRewardVideoAdType() {
        if (this.b == null) {
            return -1;
        }
        if (this.b.C() && this.b.i() == 1) {
            return 2;
        }
        return (this.b.C() && this.b.i() == 0) ? 1 : 0;
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void showRewardVideoAd(Activity activity) {
        Intent intent;
        if (activity != null && activity.isFinishing()) {
            u.f("TTRewardVideoAdImpl", "showRewardVideoAd error1: activity is finishing");
        } else if (Looper.getMainLooper() != Looper.myLooper()) {
            u.f("TTRewardVideoAdImpl", "showRewardVideoAd error2: not main looper");
            throw new IllegalStateException("不能在子线程调用 TTRewardVideoAd.showRewardVideoAd");
        } else if (!this.j.get()) {
            this.j.set(true);
            if (this.b != null && this.b.R() != null) {
                Context context = activity == null ? this.f4293a : activity;
                if (context == null) {
                    context = p.a();
                }
                if (this.b.d() == 2) {
                    intent = new Intent(context, TTRewardExpressVideoActivity.class);
                } else {
                    intent = new Intent(context, TTRewardVideoActivity.class);
                }
                if (activity == null) {
                    intent.addFlags(268435456);
                }
                intent.putExtra("reward_name", this.b.b());
                intent.putExtra("reward_amount", this.b.c());
                intent.putExtra("media_extra", this.c.getMediaExtra());
                intent.putExtra("user_id", this.c.getUserID());
                intent.putExtra("show_download_bar", this.f);
                intent.putExtra("orientation", this.c.getOrientation());
                if (!TextUtils.isEmpty(this.i)) {
                    intent.putExtra("rit_scene", this.i);
                }
                if (this.g) {
                    intent.putExtra("video_cache_url", this.h);
                }
                k.e(this.b.aE().toString());
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    intent.putExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA, this.b.aE().toString());
                    intent.putExtra("multi_process_meta_md5", this.k);
                } else {
                    com.bytedance.sdk.openadsdk.core.u.a().g();
                    com.bytedance.sdk.openadsdk.core.u.a().a(this.b);
                    com.bytedance.sdk.openadsdk.core.u.a().a(this.d);
                    com.bytedance.sdk.openadsdk.core.u.a().a(this.e);
                    this.d = null;
                }
                com.bytedance.sdk.openadsdk.utils.b.a(context, intent, new b.a() { // from class: com.bytedance.sdk.openadsdk.component.reward.j.1
                    @Override // com.bytedance.sdk.openadsdk.utils.b.a
                    public void a() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.utils.b.a
                    public void a(Throwable th) {
                        u.c("TTRewardVideoAdImpl", "show reward video error: ", th);
                    }
                });
                if (!TextUtils.isEmpty(this.b.aj())) {
                    try {
                        String optString = new JSONObject(this.b.aj()).optString("rit", null);
                        AdSlot b = g.a(this.f4293a).b(optString);
                        g.a(this.f4293a).a(optString);
                        if (b != null) {
                            if (this.g && !TextUtils.isEmpty(this.h)) {
                                g.a(this.f4293a).b(b);
                            } else {
                                g.a(this.f4293a).a(b);
                            }
                        }
                    } catch (Throwable th) {
                    }
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public Map<String, Object> getMediaExtraInfo() {
        if (this.b != null) {
            return this.b.ar();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void showRewardVideoAd(Activity activity, TTAdConstant.RitScenes ritScenes, String str) {
        if (ritScenes == null) {
            u.f("TTRewardVideoAdImpl", "The param ritScenes can not be null!");
            return;
        }
        if (ritScenes == TTAdConstant.RitScenes.CUSTOMIZE_SCENES) {
            this.i = str;
        } else {
            this.i = ritScenes.getScenesName();
        }
        showRewardVideoAd(activity);
    }

    private void a(final int i) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.j.e.b(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.j.2
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.multipro.aidl.a a2 = com.bytedance.sdk.openadsdk.multipro.aidl.a.a(j.this.f4293a);
                    switch (i) {
                        case 0:
                            if (j.this.d != null) {
                                u.b("MultiProcess", "start registerRewardVideoListener ! ");
                                com.bytedance.sdk.openadsdk.multipro.aidl.b.d dVar = new com.bytedance.sdk.openadsdk.multipro.aidl.b.d(j.this.d);
                                IListenerManager asInterface = com.bytedance.sdk.openadsdk.multipro.aidl.a.f.asInterface(a2.a(0));
                                if (asInterface != null) {
                                    try {
                                        asInterface.registerRewardVideoListener(j.this.k, dVar);
                                        u.b("MultiProcess", "end registerRewardVideoListener ! ");
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
