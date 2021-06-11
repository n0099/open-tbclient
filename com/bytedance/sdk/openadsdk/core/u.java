package com.bytedance.sdk.openadsdk.core;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
/* loaded from: classes6.dex */
public class u {

    /* renamed from: a  reason: collision with root package name */
    public static u f28475a;

    /* renamed from: b  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.video.nativevideo.c f28476b;

    /* renamed from: d  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.d.l f28478d;

    /* renamed from: e  reason: collision with root package name */
    public TTRewardVideoAd.RewardAdInteractionListener f28479e;

    /* renamed from: f  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.downloadnew.core.a f28480f;

    /* renamed from: g  reason: collision with root package name */
    public TTFullScreenVideoAd.FullScreenVideoAdInteractionListener f28481g;

    /* renamed from: c  reason: collision with root package name */
    public boolean f28477c = true;

    /* renamed from: h  reason: collision with root package name */
    public boolean f28482h = false;

    @MainThread
    public static u a() {
        if (f28475a == null) {
            f28475a = new u();
        }
        return f28475a;
    }

    public boolean b() {
        return this.f28477c;
    }

    @NonNull
    public com.bytedance.sdk.openadsdk.core.d.l c() {
        return this.f28478d;
    }

    public TTRewardVideoAd.RewardAdInteractionListener d() {
        return this.f28479e;
    }

    public TTFullScreenVideoAd.FullScreenVideoAdInteractionListener e() {
        return this.f28481g;
    }

    public com.bytedance.sdk.openadsdk.downloadnew.core.a f() {
        return this.f28480f;
    }

    public void g() {
        this.f28476b = null;
        this.f28478d = null;
        this.f28479e = null;
        this.f28481g = null;
        this.f28480f = null;
        this.f28482h = false;
        this.f28477c = true;
    }

    public void b(boolean z) {
        this.f28482h = z;
    }

    public void a(boolean z) {
        this.f28477c = z;
    }

    public void a(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        this.f28478d = lVar;
    }

    public void a(TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        this.f28481g = fullScreenVideoAdInteractionListener;
    }

    public void a(TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        this.f28479e = rewardAdInteractionListener;
    }

    public void a(com.bytedance.sdk.openadsdk.downloadnew.core.a aVar) {
        this.f28480f = aVar;
    }
}
