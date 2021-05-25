package com.bytedance.sdk.openadsdk.core;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
/* loaded from: classes6.dex */
public class u {

    /* renamed from: a  reason: collision with root package name */
    public static u f28372a;

    /* renamed from: b  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.video.nativevideo.c f28373b;

    /* renamed from: d  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.d.l f28375d;

    /* renamed from: e  reason: collision with root package name */
    public TTRewardVideoAd.RewardAdInteractionListener f28376e;

    /* renamed from: f  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.downloadnew.core.a f28377f;

    /* renamed from: g  reason: collision with root package name */
    public TTFullScreenVideoAd.FullScreenVideoAdInteractionListener f28378g;

    /* renamed from: c  reason: collision with root package name */
    public boolean f28374c = true;

    /* renamed from: h  reason: collision with root package name */
    public boolean f28379h = false;

    @MainThread
    public static u a() {
        if (f28372a == null) {
            f28372a = new u();
        }
        return f28372a;
    }

    public boolean b() {
        return this.f28374c;
    }

    @NonNull
    public com.bytedance.sdk.openadsdk.core.d.l c() {
        return this.f28375d;
    }

    public TTRewardVideoAd.RewardAdInteractionListener d() {
        return this.f28376e;
    }

    public TTFullScreenVideoAd.FullScreenVideoAdInteractionListener e() {
        return this.f28378g;
    }

    public com.bytedance.sdk.openadsdk.downloadnew.core.a f() {
        return this.f28377f;
    }

    public void g() {
        this.f28373b = null;
        this.f28375d = null;
        this.f28376e = null;
        this.f28378g = null;
        this.f28377f = null;
        this.f28379h = false;
        this.f28374c = true;
    }

    public void b(boolean z) {
        this.f28379h = z;
    }

    public void a(boolean z) {
        this.f28374c = z;
    }

    public void a(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        this.f28375d = lVar;
    }

    public void a(TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        this.f28378g = fullScreenVideoAdInteractionListener;
    }

    public void a(TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        this.f28376e = rewardAdInteractionListener;
    }

    public void a(com.bytedance.sdk.openadsdk.downloadnew.core.a aVar) {
        this.f28377f = aVar;
    }
}
