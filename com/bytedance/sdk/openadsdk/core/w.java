package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.utils.ah;
import com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class w implements TTAdNative {

    /* renamed from: a  reason: collision with root package name */
    private final q f4579a = p.f();
    private final Context b;

    public w(Context context) {
        this.b = context;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadFeedAd(AdSlot adSlot, @NonNull TTAdNative.FeedAdListener feedAdListener) {
        if (!a(feedAdListener)) {
            c(adSlot);
            try {
                Method a2 = ah.a("com.bytedance.sdk.openadsdk.TTC5Proxy", "loadFeed", Context.class, AdSlot.class, TTAdNative.FeedAdListener.class);
                if (a2 != null) {
                    a2.invoke(null, this.b, adSlot, feedAdListener);
                }
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.utils.u.b("TTAdNativeImpl", "feed component maybe not exist, pls check1", th);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadStream(AdSlot adSlot, @NonNull TTAdNative.FeedAdListener feedAdListener) {
        if (!a(feedAdListener)) {
            c(adSlot);
            try {
                Method a2 = ah.a("com.bytedance.sdk.openadsdk.TTC5Proxy", "loadStream", Context.class, AdSlot.class, TTAdNative.FeedAdListener.class);
                if (a2 != null) {
                    a2.invoke(null, this.b, adSlot, feedAdListener);
                }
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.utils.u.b("TTAdNativeImpl", "feed component maybe not exist, pls check1", th);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadDrawFeedAd(AdSlot adSlot, @NonNull TTAdNative.DrawFeedAdListener drawFeedAdListener) {
        if (!a(drawFeedAdListener)) {
            a(adSlot);
            try {
                Method a2 = ah.a("com.bytedance.sdk.openadsdk.TTC5Proxy", "loadDraw", Context.class, AdSlot.class, TTAdNative.DrawFeedAdListener.class);
                if (a2 != null) {
                    a2.invoke(null, this.b, adSlot, drawFeedAdListener);
                }
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.utils.u.b("TTAdNativeImpl", "feed component maybe not exist, pls check2", th);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadNativeAd(final AdSlot adSlot, @NonNull final TTAdNative.NativeAdListener nativeAdListener) {
        if (!a(nativeAdListener)) {
            b(adSlot);
            this.f4579a.a(adSlot, null, adSlot.getNativeAdType(), new q.b() { // from class: com.bytedance.sdk.openadsdk.core.w.1
                @Override // com.bytedance.sdk.openadsdk.core.q.b
                public void a(int i, String str) {
                    nativeAdListener.onError(i, str);
                }

                @Override // com.bytedance.sdk.openadsdk.core.q.b
                public void a(com.bytedance.sdk.openadsdk.core.d.a aVar) {
                    if (aVar.c() != null && !aVar.c().isEmpty()) {
                        List<com.bytedance.sdk.openadsdk.core.d.l> c = aVar.c();
                        ArrayList arrayList = new ArrayList(c.size());
                        for (com.bytedance.sdk.openadsdk.core.d.l lVar : c) {
                            if (lVar.aA()) {
                                arrayList.add(new com.bytedance.sdk.openadsdk.core.e.a(w.this.b, lVar, adSlot.getNativeAdType(), adSlot) { // from class: com.bytedance.sdk.openadsdk.core.w.1.1
                                });
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            nativeAdListener.onNativeAdLoad(arrayList);
                            return;
                        } else {
                            nativeAdListener.onError(-4, h.a(-4));
                            return;
                        }
                    }
                    nativeAdListener.onError(-3, h.a(-3));
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadBannerAd(AdSlot adSlot, @NonNull TTAdNative.BannerAdListener bannerAdListener) {
        if (!a(bannerAdListener)) {
            c(adSlot);
            try {
                Method a2 = ah.a("com.bytedance.sdk.openadsdk.TTC1Proxy", TrackLoadSettingsAtom.TYPE, Context.class, AdSlot.class, TTAdNative.BannerAdListener.class);
                if (a2 != null) {
                    a2.invoke(null, this.b, adSlot, bannerAdListener);
                }
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.utils.u.b("TTAdNativeImpl", "banner component maybe not exist, pls check", th);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadInteractionAd(AdSlot adSlot, @NonNull TTAdNative.InteractionAdListener interactionAdListener) {
        if (!a(interactionAdListener)) {
            c(adSlot);
            try {
                Method a2 = ah.a("com.bytedance.sdk.openadsdk.TTC4Proxy", TrackLoadSettingsAtom.TYPE, Context.class, AdSlot.class, TTAdNative.InteractionAdListener.class);
                if (a2 != null) {
                    a2.invoke(null, this.b, adSlot, interactionAdListener);
                }
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.utils.u.b("TTAdNativeImpl", "interaction component maybe not exist, pls check", th);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadSplashAd(AdSlot adSlot, @NonNull TTAdNative.SplashAdListener splashAdListener, int i) {
        if (!a(splashAdListener)) {
            c(adSlot);
            try {
                Method a2 = ah.a("com.bytedance.sdk.openadsdk.TTC2Proxy", TrackLoadSettingsAtom.TYPE, Context.class, AdSlot.class, TTAdNative.SplashAdListener.class, Integer.TYPE);
                if (a2 != null) {
                    a2.invoke(null, this.b, adSlot, splashAdListener, Integer.valueOf(i));
                }
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.utils.u.b("TTAdNativeImpl", "splash component maybe not exist, pls check1", th);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadSplashAd(AdSlot adSlot, @NonNull TTAdNative.SplashAdListener splashAdListener) {
        if (!a(splashAdListener)) {
            c(adSlot);
            if (!a(adSlot, true)) {
                splashAdListener.onError(110, h.a(110));
            } else {
                loadSplashAd(adSlot, splashAdListener, -1);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadRewardVideoAd(AdSlot adSlot, @NonNull TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
        if (!a(rewardVideoAdListener)) {
            try {
                Method a2 = ah.a("com.bytedance.sdk.openadsdk.TTC3Proxy", "loadReward", Context.class, AdSlot.class, TTAdNative.RewardVideoAdListener.class);
                if (a2 != null) {
                    a2.invoke(null, this.b, adSlot, rewardVideoAdListener);
                }
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.utils.u.b("TTAdNativeImpl", "reward component maybe not exist, pls check1", th);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadFullScreenVideoAd(AdSlot adSlot, @NonNull TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
        if (!a(fullScreenVideoAdListener)) {
            try {
                Method a2 = ah.a("com.bytedance.sdk.openadsdk.TTC3Proxy", "loadFull", Context.class, AdSlot.class, TTAdNative.FullScreenVideoAdListener.class);
                if (a2 != null) {
                    a2.invoke(null, this.b, adSlot, fullScreenVideoAdListener);
                }
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.utils.u.b("TTAdNativeImpl", "reward component maybe not exist, pls check2", th);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadNativeExpressAd(AdSlot adSlot, @NonNull TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
        if (!a(nativeExpressAdListener)) {
            if (!a(adSlot, false)) {
                nativeExpressAdListener.onError(110, h.a(110));
            } else {
                com.bytedance.sdk.openadsdk.core.nativeexpress.b.a(this.b).a(adSlot, 5, nativeExpressAdListener, 5000);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadExpressDrawFeedAd(AdSlot adSlot, @NonNull TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
        if (!a(nativeExpressAdListener)) {
            if (!a(adSlot, false)) {
                nativeExpressAdListener.onError(110, h.a(110));
            } else {
                com.bytedance.sdk.openadsdk.core.nativeexpress.b.a(this.b).a(adSlot, 9, nativeExpressAdListener, 5000);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadBannerExpressAd(AdSlot adSlot, @NonNull TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
        if (!a(nativeExpressAdListener)) {
            if (!a(adSlot, false)) {
                nativeExpressAdListener.onError(110, h.a(110));
                return;
            }
            adSlot.setNativeAdType(1);
            com.bytedance.sdk.openadsdk.core.nativeexpress.b.a(this.b).a(adSlot, 1, nativeExpressAdListener, 5000);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadInteractionExpressAd(AdSlot adSlot, @NonNull TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
        if (!a(nativeExpressAdListener)) {
            if (!a(adSlot, false)) {
                nativeExpressAdListener.onError(110, h.a(110));
                return;
            }
            adSlot.setNativeAdType(2);
            com.bytedance.sdk.openadsdk.core.nativeexpress.b.a(this.b).a(adSlot, 2, nativeExpressAdListener, 5000);
        }
    }

    private void a(AdSlot adSlot) {
        com.bytedance.sdk.openadsdk.utils.z.a(adSlot.getImgAcceptedWidth() > 0, "必须设置图片素材尺寸");
        com.bytedance.sdk.openadsdk.utils.z.a(adSlot.getImgAcceptedHeight() > 0, "必须设置图片素材尺寸");
    }

    private void b(AdSlot adSlot) {
        a(adSlot);
        com.bytedance.sdk.openadsdk.utils.z.a(adSlot.getNativeAdType() > 0, "必须设置请求原生广告的类型，目前支持TYPE_BANNER和TYPE_INTERACTION_AD");
    }

    private void c(AdSlot adSlot) {
        a(adSlot);
        com.bytedance.sdk.openadsdk.utils.z.a(adSlot.getNativeAdType() == 0, "请求非原生广告的类型，请勿调用setNativeAdType()方法");
    }

    private boolean a(com.bytedance.sdk.openadsdk.a.b bVar) {
        if (com.bytedance.sdk.openadsdk.core.h.g.a()) {
            return false;
        }
        if (bVar != null) {
            bVar.onError(1000, "广告请求开关已关闭,请联系穿山甲管理员");
        }
        return true;
    }

    private boolean a(AdSlot adSlot, boolean z) {
        if (adSlot == null) {
            return false;
        }
        return (z && !p.h().i(adSlot.getCodeId())) || adSlot.getExpressViewAcceptedWidth() > 0.0f;
    }
}
