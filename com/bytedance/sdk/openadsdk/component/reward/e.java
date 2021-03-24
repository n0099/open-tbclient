package com.bytedance.sdk.openadsdk.component.reward;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
/* loaded from: classes6.dex */
public class e implements TTAdNative.FullScreenVideoAdListener, TTAdNative.RewardVideoAdListener {

    /* renamed from: a  reason: collision with root package name */
    public final TTAdNative.RewardVideoAdListener f27760a;

    /* renamed from: b  reason: collision with root package name */
    public final TTAdNative.FullScreenVideoAdListener f27761b;

    public e(TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
        this.f27760a = rewardVideoAdListener;
        this.f27761b = null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener, com.bytedance.sdk.openadsdk.a.b
    public void onError(final int i, final String str) {
        if (this.f27760a != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.e.1
                @Override // java.lang.Runnable
                public void run() {
                    TTAdNative.RewardVideoAdListener rewardVideoAdListener = e.this.f27760a;
                    if (rewardVideoAdListener != null) {
                        rewardVideoAdListener.onError(i, str);
                    }
                }
            });
        }
        if (this.f27761b != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.e.2
                @Override // java.lang.Runnable
                public void run() {
                    TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener = e.this.f27761b;
                    if (fullScreenVideoAdListener != null) {
                        fullScreenVideoAdListener.onError(i, str);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
    public void onFullScreenVideoAdLoad(final TTFullScreenVideoAd tTFullScreenVideoAd) {
        if (this.f27761b != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.e.3
                @Override // java.lang.Runnable
                public void run() {
                    TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener = e.this.f27761b;
                    if (fullScreenVideoAdListener != null) {
                        fullScreenVideoAdListener.onFullScreenVideoAdLoad(tTFullScreenVideoAd);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
    public void onFullScreenVideoCached() {
        if (this.f27761b != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.e.4
                @Override // java.lang.Runnable
                public void run() {
                    TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener = e.this.f27761b;
                    if (fullScreenVideoAdListener != null) {
                        fullScreenVideoAdListener.onFullScreenVideoCached();
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
    public void onRewardVideoAdLoad(final TTRewardVideoAd tTRewardVideoAd) {
        if (this.f27760a != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.e.5
                @Override // java.lang.Runnable
                public void run() {
                    TTAdNative.RewardVideoAdListener rewardVideoAdListener = e.this.f27760a;
                    if (rewardVideoAdListener != null) {
                        rewardVideoAdListener.onRewardVideoAdLoad(tTRewardVideoAd);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
    public void onRewardVideoCached() {
        if (this.f27760a != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.e.6
                @Override // java.lang.Runnable
                public void run() {
                    TTAdNative.RewardVideoAdListener rewardVideoAdListener = e.this.f27760a;
                    if (rewardVideoAdListener != null) {
                        rewardVideoAdListener.onRewardVideoCached();
                    }
                }
            });
        }
    }

    public e(TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
        this.f27760a = null;
        this.f27761b = fullScreenVideoAdListener;
    }
}
