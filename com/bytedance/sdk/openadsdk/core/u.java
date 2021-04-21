package com.bytedance.sdk.openadsdk.core;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
/* loaded from: classes5.dex */
public class u {

    /* renamed from: a  reason: collision with root package name */
    public static u f28329a;

    /* renamed from: b  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.video.nativevideo.c f28330b;

    /* renamed from: d  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.d.l f28332d;

    /* renamed from: e  reason: collision with root package name */
    public TTRewardVideoAd.RewardAdInteractionListener f28333e;

    /* renamed from: f  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.downloadnew.core.a f28334f;

    /* renamed from: g  reason: collision with root package name */
    public TTFullScreenVideoAd.FullScreenVideoAdInteractionListener f28335g;

    /* renamed from: c  reason: collision with root package name */
    public boolean f28331c = true;

    /* renamed from: h  reason: collision with root package name */
    public boolean f28336h = false;

    @MainThread
    public static u a() {
        if (f28329a == null) {
            f28329a = new u();
        }
        return f28329a;
    }

    public boolean b() {
        return this.f28331c;
    }

    @NonNull
    public com.bytedance.sdk.openadsdk.core.d.l c() {
        return this.f28332d;
    }

    public TTRewardVideoAd.RewardAdInteractionListener d() {
        return this.f28333e;
    }

    public TTFullScreenVideoAd.FullScreenVideoAdInteractionListener e() {
        return this.f28335g;
    }

    public com.bytedance.sdk.openadsdk.downloadnew.core.a f() {
        return this.f28334f;
    }

    public void g() {
        this.f28330b = null;
        this.f28332d = null;
        this.f28333e = null;
        this.f28335g = null;
        this.f28334f = null;
        this.f28336h = false;
        this.f28331c = true;
    }

    public void b(boolean z) {
        this.f28336h = z;
    }

    public void a(boolean z) {
        this.f28331c = z;
    }

    public void a(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        this.f28332d = lVar;
    }

    public void a(TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        this.f28335g = fullScreenVideoAdInteractionListener;
    }

    public void a(TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        this.f28333e = rewardAdInteractionListener;
    }

    public void a(com.bytedance.sdk.openadsdk.downloadnew.core.a aVar) {
        this.f28334f = aVar;
    }
}
