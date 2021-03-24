package com.bytedance.sdk.openadsdk.core;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
/* loaded from: classes6.dex */
public class u {

    /* renamed from: a  reason: collision with root package name */
    public static u f28635a;

    /* renamed from: b  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.video.nativevideo.c f28636b;

    /* renamed from: d  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.d.l f28638d;

    /* renamed from: e  reason: collision with root package name */
    public TTRewardVideoAd.RewardAdInteractionListener f28639e;

    /* renamed from: f  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.downloadnew.core.a f28640f;

    /* renamed from: g  reason: collision with root package name */
    public TTFullScreenVideoAd.FullScreenVideoAdInteractionListener f28641g;

    /* renamed from: c  reason: collision with root package name */
    public boolean f28637c = true;

    /* renamed from: h  reason: collision with root package name */
    public boolean f28642h = false;

    @MainThread
    public static u a() {
        if (f28635a == null) {
            f28635a = new u();
        }
        return f28635a;
    }

    public boolean b() {
        return this.f28637c;
    }

    @NonNull
    public com.bytedance.sdk.openadsdk.core.d.l c() {
        return this.f28638d;
    }

    public TTRewardVideoAd.RewardAdInteractionListener d() {
        return this.f28639e;
    }

    public TTFullScreenVideoAd.FullScreenVideoAdInteractionListener e() {
        return this.f28641g;
    }

    public com.bytedance.sdk.openadsdk.downloadnew.core.a f() {
        return this.f28640f;
    }

    public void g() {
        this.f28636b = null;
        this.f28638d = null;
        this.f28639e = null;
        this.f28641g = null;
        this.f28640f = null;
        this.f28642h = false;
        this.f28637c = true;
    }

    public void b(boolean z) {
        this.f28642h = z;
    }

    public void a(boolean z) {
        this.f28637c = z;
    }

    public void a(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        this.f28638d = lVar;
    }

    public void a(TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        this.f28641g = fullScreenVideoAdInteractionListener;
    }

    public void a(TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        this.f28639e = rewardAdInteractionListener;
    }

    public void a(com.bytedance.sdk.openadsdk.downloadnew.core.a aVar) {
        this.f28640f = aVar;
    }
}
