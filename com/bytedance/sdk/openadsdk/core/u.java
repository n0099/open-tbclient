package com.bytedance.sdk.openadsdk.core;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
/* loaded from: classes5.dex */
public class u {

    /* renamed from: a  reason: collision with root package name */
    public static u f29198a;

    /* renamed from: b  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.video.nativevideo.c f29199b;

    /* renamed from: d  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.d.l f29201d;

    /* renamed from: e  reason: collision with root package name */
    public TTRewardVideoAd.RewardAdInteractionListener f29202e;

    /* renamed from: f  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.downloadnew.core.a f29203f;

    /* renamed from: g  reason: collision with root package name */
    public TTFullScreenVideoAd.FullScreenVideoAdInteractionListener f29204g;

    /* renamed from: c  reason: collision with root package name */
    public boolean f29200c = true;

    /* renamed from: h  reason: collision with root package name */
    public boolean f29205h = false;

    @MainThread
    public static u a() {
        if (f29198a == null) {
            f29198a = new u();
        }
        return f29198a;
    }

    public boolean b() {
        return this.f29200c;
    }

    @NonNull
    public com.bytedance.sdk.openadsdk.core.d.l c() {
        return this.f29201d;
    }

    public TTRewardVideoAd.RewardAdInteractionListener d() {
        return this.f29202e;
    }

    public TTFullScreenVideoAd.FullScreenVideoAdInteractionListener e() {
        return this.f29204g;
    }

    public com.bytedance.sdk.openadsdk.downloadnew.core.a f() {
        return this.f29203f;
    }

    public void g() {
        this.f29199b = null;
        this.f29201d = null;
        this.f29202e = null;
        this.f29204g = null;
        this.f29203f = null;
        this.f29205h = false;
        this.f29200c = true;
    }

    public void b(boolean z) {
        this.f29205h = z;
    }

    public void a(boolean z) {
        this.f29200c = z;
    }

    public void a(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        this.f29201d = lVar;
    }

    public void a(TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        this.f29204g = fullScreenVideoAdInteractionListener;
    }

    public void a(TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        this.f29202e = rewardAdInteractionListener;
    }

    public void a(com.bytedance.sdk.openadsdk.downloadnew.core.a aVar) {
        this.f29203f = aVar;
    }
}
