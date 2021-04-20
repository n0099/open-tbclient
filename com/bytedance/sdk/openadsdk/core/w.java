package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.utils.ai;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class w implements TTAdNative {

    /* renamed from: a  reason: collision with root package name */
    public final q f28454a = p.f();

    /* renamed from: b  reason: collision with root package name */
    public final Context f28455b;

    public w(Context context) {
        this.f28455b = context;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadBannerAd(final AdSlot adSlot, @NonNull final TTAdNative.BannerAdListener bannerAdListener) {
        a(new com.bytedance.sdk.openadsdk.l.g("loadBannerAd") { // from class: com.bytedance.sdk.openadsdk.core.w.10
            @Override // java.lang.Runnable
            public void run() {
                if (w.this.a(bannerAdListener)) {
                    return;
                }
                w.this.c(adSlot);
                try {
                    Method a2 = ai.a("com.bytedance.sdk.openadsdk.TTC1Proxy", TrackLoadSettingsAtom.TYPE, Context.class, AdSlot.class, TTAdNative.BannerAdListener.class);
                    if (a2 != null) {
                        a2.invoke(null, w.this.f28455b, adSlot, bannerAdListener);
                    }
                } catch (Throwable th) {
                    com.bytedance.sdk.openadsdk.utils.u.b("TTAdNativeImpl", "banner component maybe not exist, pls check", th);
                }
            }
        }, bannerAdListener);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadBannerExpressAd(final AdSlot adSlot, @NonNull final TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
        a(new com.bytedance.sdk.openadsdk.l.g("loadBannerExpressAd") { // from class: com.bytedance.sdk.openadsdk.core.w.5
            @Override // java.lang.Runnable
            public void run() {
                if (w.this.a(nativeExpressAdListener)) {
                    return;
                }
                if (!w.this.a(adSlot, false)) {
                    nativeExpressAdListener.onError(110, h.a(110));
                    return;
                }
                adSlot.setNativeAdType(1);
                adSlot.setDurationSlotType(1);
                com.bytedance.sdk.openadsdk.core.nativeexpress.b.a(w.this.f28455b).a(adSlot, 1, nativeExpressAdListener, 5000);
            }
        }, nativeExpressAdListener);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadDrawFeedAd(final AdSlot adSlot, @NonNull final TTAdNative.DrawFeedAdListener drawFeedAdListener) {
        a(new com.bytedance.sdk.openadsdk.l.g("loadDrawFeedAd") { // from class: com.bytedance.sdk.openadsdk.core.w.8
            @Override // java.lang.Runnable
            public void run() {
                if (w.this.a(drawFeedAdListener)) {
                    return;
                }
                w.this.a(adSlot);
                try {
                    Method a2 = ai.a("com.bytedance.sdk.openadsdk.TTC5Proxy", "loadDraw", Context.class, AdSlot.class, TTAdNative.DrawFeedAdListener.class);
                    if (a2 != null) {
                        a2.invoke(null, w.this.f28455b, adSlot, drawFeedAdListener);
                    }
                } catch (Throwable th) {
                    com.bytedance.sdk.openadsdk.utils.u.b("TTAdNativeImpl", "feed component maybe not exist, pls check2", th);
                }
            }
        }, drawFeedAdListener);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadExpressDrawFeedAd(final AdSlot adSlot, @NonNull final TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
        a(new com.bytedance.sdk.openadsdk.l.g("loadExpressDrawFeedAd") { // from class: com.bytedance.sdk.openadsdk.core.w.4
            @Override // java.lang.Runnable
            public void run() {
                if (w.this.a(nativeExpressAdListener)) {
                    return;
                }
                if (!w.this.a(adSlot, false)) {
                    nativeExpressAdListener.onError(110, h.a(110));
                    return;
                }
                adSlot.setDurationSlotType(9);
                com.bytedance.sdk.openadsdk.core.nativeexpress.b.a(w.this.f28455b).a(adSlot, 9, nativeExpressAdListener, 5000);
            }
        }, nativeExpressAdListener);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadFeedAd(final AdSlot adSlot, @NonNull final TTAdNative.FeedAdListener feedAdListener) {
        a(new com.bytedance.sdk.openadsdk.l.g("loadFeedAd") { // from class: com.bytedance.sdk.openadsdk.core.w.1
            @Override // java.lang.Runnable
            public void run() {
                if (w.this.a(feedAdListener)) {
                    return;
                }
                w.this.c(adSlot);
                try {
                    Method a2 = ai.a("com.bytedance.sdk.openadsdk.TTC5Proxy", "loadFeed", Context.class, AdSlot.class, TTAdNative.FeedAdListener.class);
                    if (a2 != null) {
                        a2.invoke(null, w.this.f28455b, adSlot, feedAdListener);
                    }
                } catch (Throwable th) {
                    com.bytedance.sdk.openadsdk.utils.u.b("TTAdNativeImpl", "feed component maybe not exist, pls check1", th);
                }
            }
        }, feedAdListener);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadFullScreenVideoAd(final AdSlot adSlot, @NonNull final TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
        a(new com.bytedance.sdk.openadsdk.l.g("loadFullScreenVideoAd") { // from class: com.bytedance.sdk.openadsdk.core.w.2
            @Override // java.lang.Runnable
            public void run() {
                if (w.this.a(fullScreenVideoAdListener)) {
                    return;
                }
                try {
                    Method a2 = ai.a("com.bytedance.sdk.openadsdk.TTC3Proxy", "loadFull", Context.class, AdSlot.class, TTAdNative.FullScreenVideoAdListener.class);
                    if (a2 != null) {
                        a2.invoke(null, w.this.f28455b, adSlot, fullScreenVideoAdListener);
                    }
                } catch (Throwable th) {
                    com.bytedance.sdk.openadsdk.utils.u.b("TTAdNativeImpl", "reward component maybe not exist, pls check2", th);
                }
            }
        }, fullScreenVideoAdListener);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadInteractionAd(final AdSlot adSlot, @NonNull final TTAdNative.InteractionAdListener interactionAdListener) {
        a(new com.bytedance.sdk.openadsdk.l.g("loadInteractionAd") { // from class: com.bytedance.sdk.openadsdk.core.w.11
            @Override // java.lang.Runnable
            public void run() {
                if (w.this.a(interactionAdListener)) {
                    return;
                }
                w.this.c(adSlot);
                try {
                    Method a2 = ai.a("com.bytedance.sdk.openadsdk.TTC4Proxy", TrackLoadSettingsAtom.TYPE, Context.class, AdSlot.class, TTAdNative.InteractionAdListener.class);
                    if (a2 != null) {
                        a2.invoke(null, w.this.f28455b, adSlot, interactionAdListener);
                    }
                } catch (Throwable th) {
                    com.bytedance.sdk.openadsdk.utils.u.b("TTAdNativeImpl", "interaction component maybe not exist, pls check", th);
                }
            }
        }, interactionAdListener);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadInteractionExpressAd(final AdSlot adSlot, @NonNull final TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
        a(new com.bytedance.sdk.openadsdk.l.g("loadInteractionExpressAd") { // from class: com.bytedance.sdk.openadsdk.core.w.6
            @Override // java.lang.Runnable
            public void run() {
                if (w.this.a(nativeExpressAdListener)) {
                    return;
                }
                if (!w.this.a(adSlot, false)) {
                    nativeExpressAdListener.onError(110, h.a(110));
                    return;
                }
                adSlot.setNativeAdType(2);
                adSlot.setDurationSlotType(2);
                com.bytedance.sdk.openadsdk.core.nativeexpress.b.a(w.this.f28455b).a(adSlot, 2, nativeExpressAdListener, 5000);
            }
        }, nativeExpressAdListener);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadNativeAd(final AdSlot adSlot, @NonNull final TTAdNative.NativeAdListener nativeAdListener) {
        final long currentTimeMillis = System.currentTimeMillis();
        adSlot.setDurationSlotType(adSlot.getNativeAdType());
        a(new com.bytedance.sdk.openadsdk.l.g("loadNativeAd") { // from class: com.bytedance.sdk.openadsdk.core.w.9
            @Override // java.lang.Runnable
            public void run() {
                if (w.this.a(nativeAdListener)) {
                    return;
                }
                w.this.b(adSlot);
                w.this.f28454a.a(adSlot, new com.bytedance.sdk.openadsdk.core.d.m(), adSlot.getNativeAdType(), new q.b() { // from class: com.bytedance.sdk.openadsdk.core.w.9.1
                    @Override // com.bytedance.sdk.openadsdk.core.q.b
                    public void a(int i, String str) {
                        nativeAdListener.onError(i, str);
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.q.b
                    public void a(com.bytedance.sdk.openadsdk.core.d.a aVar) {
                        if (aVar.c() != null && !aVar.c().isEmpty()) {
                            List<com.bytedance.sdk.openadsdk.core.d.l> c2 = aVar.c();
                            ArrayList arrayList = new ArrayList(c2.size());
                            for (com.bytedance.sdk.openadsdk.core.d.l lVar : c2) {
                                if (lVar.aH()) {
                                    arrayList.add(new com.bytedance.sdk.openadsdk.core.e.a(w.this.f28455b, lVar, adSlot.getNativeAdType(), adSlot) { // from class: com.bytedance.sdk.openadsdk.core.w.9.1.1
                                    });
                                }
                            }
                            if (!arrayList.isEmpty()) {
                                com.bytedance.sdk.openadsdk.c.d.a(w.this.f28455b, c2.get(0), ak.b(adSlot.getDurationSlotType()), currentTimeMillis);
                                nativeAdListener.onNativeAdLoad(arrayList);
                                return;
                            }
                            nativeAdListener.onError(-4, h.a(-4));
                            return;
                        }
                        nativeAdListener.onError(-3, h.a(-3));
                    }
                });
            }
        }, nativeAdListener);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadNativeExpressAd(final AdSlot adSlot, @NonNull final TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
        a(new com.bytedance.sdk.openadsdk.l.g("loadNativeExpressAd") { // from class: com.bytedance.sdk.openadsdk.core.w.3
            @Override // java.lang.Runnable
            public void run() {
                if (w.this.a(nativeExpressAdListener)) {
                    return;
                }
                if (w.this.a(adSlot, false)) {
                    com.bytedance.sdk.openadsdk.core.nativeexpress.b.a(w.this.f28455b).a(adSlot, 5, nativeExpressAdListener, 5000);
                } else {
                    nativeExpressAdListener.onError(110, h.a(110));
                }
            }
        }, nativeExpressAdListener);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadRewardVideoAd(final AdSlot adSlot, @NonNull final TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
        a(new com.bytedance.sdk.openadsdk.l.g("loadRewardVideoAd") { // from class: com.bytedance.sdk.openadsdk.core.w.14
            @Override // java.lang.Runnable
            public void run() {
                if (w.this.a(rewardVideoAdListener)) {
                    return;
                }
                try {
                    Method a2 = ai.a("com.bytedance.sdk.openadsdk.TTC3Proxy", "loadReward", Context.class, AdSlot.class, TTAdNative.RewardVideoAdListener.class);
                    if (a2 != null) {
                        a2.invoke(null, w.this.f28455b, adSlot, rewardVideoAdListener);
                    }
                } catch (Throwable th) {
                    com.bytedance.sdk.openadsdk.utils.u.b("TTAdNativeImpl", "reward component maybe not exist, pls check1", th);
                }
            }
        }, rewardVideoAdListener);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadSplashAd(final AdSlot adSlot, @NonNull final TTAdNative.SplashAdListener splashAdListener, final int i) {
        a(new com.bytedance.sdk.openadsdk.l.g("loadSplashAd b") { // from class: com.bytedance.sdk.openadsdk.core.w.12
            @Override // java.lang.Runnable
            public void run() {
                if (w.this.a(splashAdListener)) {
                    return;
                }
                w.this.c(adSlot);
                try {
                    Method a2 = ai.a("com.bytedance.sdk.openadsdk.TTC2Proxy", TrackLoadSettingsAtom.TYPE, Context.class, AdSlot.class, TTAdNative.SplashAdListener.class, Integer.TYPE);
                    if (a2 != null) {
                        a2.invoke(null, w.this.f28455b, adSlot, splashAdListener, Integer.valueOf(i));
                    }
                } catch (Throwable th) {
                    com.bytedance.sdk.openadsdk.utils.u.b("TTAdNativeImpl", "splash component maybe not exist, pls check1", th);
                }
            }
        }, splashAdListener);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadStream(final AdSlot adSlot, @NonNull final TTAdNative.FeedAdListener feedAdListener) {
        a(new com.bytedance.sdk.openadsdk.l.g("loadStream") { // from class: com.bytedance.sdk.openadsdk.core.w.7
            @Override // java.lang.Runnable
            public void run() {
                if (w.this.a(feedAdListener)) {
                    return;
                }
                w.this.c(adSlot);
                try {
                    Method a2 = ai.a("com.bytedance.sdk.openadsdk.TTC5Proxy", "loadStream", Context.class, AdSlot.class, TTAdNative.FeedAdListener.class);
                    if (a2 != null) {
                        a2.invoke(null, w.this.f28455b, adSlot, feedAdListener);
                    }
                } catch (Throwable th) {
                    com.bytedance.sdk.openadsdk.utils.u.b("TTAdNativeImpl", "feed component maybe not exist, pls check1", th);
                }
            }
        }, feedAdListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(AdSlot adSlot) {
        a(adSlot);
        com.bytedance.sdk.openadsdk.utils.z.a(adSlot.getNativeAdType() == 0, "请求非原生广告的类型，请勿调用setNativeAdType()方法");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AdSlot adSlot) {
        a(adSlot);
        com.bytedance.sdk.openadsdk.utils.z.a(adSlot.getNativeAdType() > 0, "必须设置请求原生广告的类型， ");
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadSplashAd(final AdSlot adSlot, final TTAdNative.SplashAdListener splashAdListener) {
        a(new com.bytedance.sdk.openadsdk.l.g("loadSplashAd a") { // from class: com.bytedance.sdk.openadsdk.core.w.13
            @Override // java.lang.Runnable
            public void run() {
                if (w.this.a(splashAdListener)) {
                    return;
                }
                w.this.c(adSlot);
                if (!w.this.a(adSlot, true)) {
                    splashAdListener.onError(110, h.a(110));
                    return;
                }
                try {
                    Method a2 = ai.a("com.bytedance.sdk.openadsdk.TTC2Proxy", TrackLoadSettingsAtom.TYPE, Context.class, AdSlot.class, TTAdNative.SplashAdListener.class, Integer.TYPE);
                    if (a2 != null) {
                        a2.invoke(null, w.this.f28455b, adSlot, splashAdListener, -1);
                    }
                } catch (Throwable th) {
                    com.bytedance.sdk.openadsdk.utils.u.b("TTAdNativeImpl", "splash component maybe not exist, pls check1", th);
                }
            }
        }, splashAdListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdSlot adSlot) {
        com.bytedance.sdk.openadsdk.utils.z.a(adSlot.getImgAcceptedWidth() > 0, "必须设置图片素材尺寸");
        com.bytedance.sdk.openadsdk.utils.z.a(adSlot.getImgAcceptedHeight() > 0, "必须设置图片素材尺寸");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.bytedance.sdk.openadsdk.a.b bVar) {
        if (com.bytedance.sdk.openadsdk.core.h.g.a()) {
            return false;
        }
        if (bVar != null) {
            bVar.onError(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(AdSlot adSlot, boolean z) {
        if (adSlot == null) {
            return false;
        }
        return (z && !p.h().i(adSlot.getCodeId())) || adSlot.getExpressViewAcceptedWidth() > 0.0f;
    }

    private void a(com.bytedance.sdk.openadsdk.l.g gVar, com.bytedance.sdk.openadsdk.a.b bVar) {
        if (!m.f28146c) {
            com.bytedance.sdk.openadsdk.utils.u.f("TTAdNativeImpl", "please exec TTAdSdk.init before load ad");
            if (bVar != null) {
                bVar.onError(10000, "Please exec TTAdSdk.init before load ad");
                return;
            }
            return;
        }
        m.b().post(gVar);
    }
}
