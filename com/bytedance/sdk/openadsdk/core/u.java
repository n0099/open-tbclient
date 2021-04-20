package com.bytedance.sdk.openadsdk.core;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
/* loaded from: classes5.dex */
public class u {

    /* renamed from: a  reason: collision with root package name */
    public static u f28321a;

    /* renamed from: b  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.video.nativevideo.c f28322b;

    /* renamed from: d  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.d.l f28324d;

    /* renamed from: e  reason: collision with root package name */
    public TTRewardVideoAd.RewardAdInteractionListener f28325e;

    /* renamed from: f  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.downloadnew.core.a f28326f;

    /* renamed from: g  reason: collision with root package name */
    public TTFullScreenVideoAd.FullScreenVideoAdInteractionListener f28327g;

    /* renamed from: c  reason: collision with root package name */
    public boolean f28323c = true;

    /* renamed from: h  reason: collision with root package name */
    public boolean f28328h = false;

    @MainThread
    public static u a() {
        if (f28321a == null) {
            f28321a = new u();
        }
        return f28321a;
    }

    public boolean b() {
        return this.f28323c;
    }

    @NonNull
    public com.bytedance.sdk.openadsdk.core.d.l c() {
        return this.f28324d;
    }

    public TTRewardVideoAd.RewardAdInteractionListener d() {
        return this.f28325e;
    }

    public TTFullScreenVideoAd.FullScreenVideoAdInteractionListener e() {
        return this.f28327g;
    }

    public com.bytedance.sdk.openadsdk.downloadnew.core.a f() {
        return this.f28326f;
    }

    public void g() {
        this.f28322b = null;
        this.f28324d = null;
        this.f28325e = null;
        this.f28327g = null;
        this.f28326f = null;
        this.f28328h = false;
        this.f28323c = true;
    }

    public void b(boolean z) {
        this.f28328h = z;
    }

    public void a(boolean z) {
        this.f28323c = z;
    }

    public void a(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        this.f28324d = lVar;
    }

    public void a(TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        this.f28327g = fullScreenVideoAdInteractionListener;
    }

    public void a(TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        this.f28325e = rewardAdInteractionListener;
    }

    public void a(com.bytedance.sdk.openadsdk.downloadnew.core.a aVar) {
        this.f28326f = aVar;
    }
}
