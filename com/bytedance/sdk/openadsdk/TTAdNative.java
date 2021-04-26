package com.bytedance.sdk.openadsdk;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.a.b;
import java.util.List;
/* loaded from: classes5.dex */
public interface TTAdNative {

    /* loaded from: classes5.dex */
    public interface BannerAdListener extends b {
        @MainThread
        void onBannerAdLoad(TTBannerAd tTBannerAd);

        @Override // com.bytedance.sdk.openadsdk.a.b
        @MainThread
        void onError(int i2, String str);
    }

    /* loaded from: classes5.dex */
    public interface DrawFeedAdListener extends b {
        @MainThread
        void onDrawFeedAdLoad(List<TTDrawFeedAd> list);

        @Override // com.bytedance.sdk.openadsdk.a.b
        @MainThread
        void onError(int i2, String str);
    }

    /* loaded from: classes5.dex */
    public interface FeedAdListener extends b {
        @Override // com.bytedance.sdk.openadsdk.a.b
        @MainThread
        void onError(int i2, String str);

        @MainThread
        void onFeedAdLoad(List<TTFeedAd> list);
    }

    /* loaded from: classes5.dex */
    public interface FullScreenVideoAdListener extends b {
        @Override // com.bytedance.sdk.openadsdk.a.b
        @MainThread
        void onError(int i2, String str);

        @MainThread
        void onFullScreenVideoAdLoad(TTFullScreenVideoAd tTFullScreenVideoAd);

        void onFullScreenVideoCached();
    }

    /* loaded from: classes5.dex */
    public interface InteractionAdListener extends b {
        @Override // com.bytedance.sdk.openadsdk.a.b
        @MainThread
        void onError(int i2, String str);

        @MainThread
        void onInteractionAdLoad(TTInteractionAd tTInteractionAd);
    }

    /* loaded from: classes5.dex */
    public interface NativeAdListener extends b {
        @Override // com.bytedance.sdk.openadsdk.a.b
        @MainThread
        void onError(int i2, String str);

        @MainThread
        void onNativeAdLoad(List<TTNativeAd> list);
    }

    /* loaded from: classes5.dex */
    public interface NativeExpressAdListener extends b {
        @Override // com.bytedance.sdk.openadsdk.a.b
        @MainThread
        void onError(int i2, String str);

        @MainThread
        void onNativeExpressAdLoad(List<TTNativeExpressAd> list);
    }

    /* loaded from: classes5.dex */
    public interface RewardVideoAdListener extends b {
        @Override // com.bytedance.sdk.openadsdk.a.b
        @MainThread
        void onError(int i2, String str);

        @MainThread
        void onRewardVideoAdLoad(TTRewardVideoAd tTRewardVideoAd);

        void onRewardVideoCached();
    }

    /* loaded from: classes5.dex */
    public interface SplashAdListener extends b {
        @Override // com.bytedance.sdk.openadsdk.a.b
        @MainThread
        void onError(int i2, String str);

        @MainThread
        void onSplashAdLoad(TTSplashAd tTSplashAd);

        void onTimeout();
    }

    void loadBannerAd(AdSlot adSlot, @NonNull BannerAdListener bannerAdListener);

    void loadBannerExpressAd(AdSlot adSlot, @NonNull NativeExpressAdListener nativeExpressAdListener);

    void loadDrawFeedAd(AdSlot adSlot, @NonNull DrawFeedAdListener drawFeedAdListener);

    void loadExpressDrawFeedAd(AdSlot adSlot, @NonNull NativeExpressAdListener nativeExpressAdListener);

    void loadFeedAd(AdSlot adSlot, @NonNull FeedAdListener feedAdListener);

    void loadFullScreenVideoAd(AdSlot adSlot, @NonNull FullScreenVideoAdListener fullScreenVideoAdListener);

    void loadInteractionAd(AdSlot adSlot, @NonNull InteractionAdListener interactionAdListener);

    void loadInteractionExpressAd(AdSlot adSlot, @NonNull NativeExpressAdListener nativeExpressAdListener);

    void loadNativeAd(AdSlot adSlot, @NonNull NativeAdListener nativeAdListener);

    void loadNativeExpressAd(AdSlot adSlot, @NonNull NativeExpressAdListener nativeExpressAdListener);

    void loadRewardVideoAd(AdSlot adSlot, @NonNull RewardVideoAdListener rewardVideoAdListener);

    void loadSplashAd(AdSlot adSlot, @NonNull SplashAdListener splashAdListener);

    void loadSplashAd(AdSlot adSlot, @NonNull SplashAdListener splashAdListener, int i2);

    void loadStream(AdSlot adSlot, @NonNull FeedAdListener feedAdListener);
}
