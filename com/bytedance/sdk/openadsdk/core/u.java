package com.bytedance.sdk.openadsdk.core;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
/* loaded from: classes6.dex */
public class u {

    /* renamed from: a  reason: collision with root package name */
    public static u f28636a;

    /* renamed from: b  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.video.nativevideo.c f28637b;

    /* renamed from: d  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.d.l f28639d;

    /* renamed from: e  reason: collision with root package name */
    public TTRewardVideoAd.RewardAdInteractionListener f28640e;

    /* renamed from: f  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.downloadnew.core.a f28641f;

    /* renamed from: g  reason: collision with root package name */
    public TTFullScreenVideoAd.FullScreenVideoAdInteractionListener f28642g;

    /* renamed from: c  reason: collision with root package name */
    public boolean f28638c = true;

    /* renamed from: h  reason: collision with root package name */
    public boolean f28643h = false;

    @MainThread
    public static u a() {
        if (f28636a == null) {
            f28636a = new u();
        }
        return f28636a;
    }

    public boolean b() {
        return this.f28638c;
    }

    @NonNull
    public com.bytedance.sdk.openadsdk.core.d.l c() {
        return this.f28639d;
    }

    public TTRewardVideoAd.RewardAdInteractionListener d() {
        return this.f28640e;
    }

    public TTFullScreenVideoAd.FullScreenVideoAdInteractionListener e() {
        return this.f28642g;
    }

    public com.bytedance.sdk.openadsdk.downloadnew.core.a f() {
        return this.f28641f;
    }

    public void g() {
        this.f28637b = null;
        this.f28639d = null;
        this.f28640e = null;
        this.f28642g = null;
        this.f28641f = null;
        this.f28643h = false;
        this.f28638c = true;
    }

    public void b(boolean z) {
        this.f28643h = z;
    }

    public void a(boolean z) {
        this.f28638c = z;
    }

    public void a(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        this.f28639d = lVar;
    }

    public void a(TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        this.f28642g = fullScreenVideoAdInteractionListener;
    }

    public void a(TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        this.f28640e = rewardAdInteractionListener;
    }

    public void a(com.bytedance.sdk.openadsdk.downloadnew.core.a aVar) {
        this.f28641f = aVar;
    }
}
