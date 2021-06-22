package com.bytedance.sdk.openadsdk.core;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
/* loaded from: classes6.dex */
public class u {

    /* renamed from: a  reason: collision with root package name */
    public static u f28557a;

    /* renamed from: b  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.video.nativevideo.c f28558b;

    /* renamed from: d  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.d.l f28560d;

    /* renamed from: e  reason: collision with root package name */
    public TTRewardVideoAd.RewardAdInteractionListener f28561e;

    /* renamed from: f  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.downloadnew.core.a f28562f;

    /* renamed from: g  reason: collision with root package name */
    public TTFullScreenVideoAd.FullScreenVideoAdInteractionListener f28563g;

    /* renamed from: c  reason: collision with root package name */
    public boolean f28559c = true;

    /* renamed from: h  reason: collision with root package name */
    public boolean f28564h = false;

    @MainThread
    public static u a() {
        if (f28557a == null) {
            f28557a = new u();
        }
        return f28557a;
    }

    public boolean b() {
        return this.f28559c;
    }

    @NonNull
    public com.bytedance.sdk.openadsdk.core.d.l c() {
        return this.f28560d;
    }

    public TTRewardVideoAd.RewardAdInteractionListener d() {
        return this.f28561e;
    }

    public TTFullScreenVideoAd.FullScreenVideoAdInteractionListener e() {
        return this.f28563g;
    }

    public com.bytedance.sdk.openadsdk.downloadnew.core.a f() {
        return this.f28562f;
    }

    public void g() {
        this.f28558b = null;
        this.f28560d = null;
        this.f28561e = null;
        this.f28563g = null;
        this.f28562f = null;
        this.f28564h = false;
        this.f28559c = true;
    }

    public void b(boolean z) {
        this.f28564h = z;
    }

    public void a(boolean z) {
        this.f28559c = z;
    }

    public void a(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        this.f28560d = lVar;
    }

    public void a(TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        this.f28563g = fullScreenVideoAdInteractionListener;
    }

    public void a(TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        this.f28561e = rewardAdInteractionListener;
    }

    public void a(com.bytedance.sdk.openadsdk.downloadnew.core.a aVar) {
        this.f28562f = aVar;
    }
}
