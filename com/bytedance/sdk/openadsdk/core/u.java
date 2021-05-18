package com.bytedance.sdk.openadsdk.core;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
/* loaded from: classes6.dex */
public class u {

    /* renamed from: a  reason: collision with root package name */
    public static u f28443a;

    /* renamed from: b  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.video.nativevideo.c f28444b;

    /* renamed from: d  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.d.l f28446d;

    /* renamed from: e  reason: collision with root package name */
    public TTRewardVideoAd.RewardAdInteractionListener f28447e;

    /* renamed from: f  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.downloadnew.core.a f28448f;

    /* renamed from: g  reason: collision with root package name */
    public TTFullScreenVideoAd.FullScreenVideoAdInteractionListener f28449g;

    /* renamed from: c  reason: collision with root package name */
    public boolean f28445c = true;

    /* renamed from: h  reason: collision with root package name */
    public boolean f28450h = false;

    @MainThread
    public static u a() {
        if (f28443a == null) {
            f28443a = new u();
        }
        return f28443a;
    }

    public boolean b() {
        return this.f28445c;
    }

    @NonNull
    public com.bytedance.sdk.openadsdk.core.d.l c() {
        return this.f28446d;
    }

    public TTRewardVideoAd.RewardAdInteractionListener d() {
        return this.f28447e;
    }

    public TTFullScreenVideoAd.FullScreenVideoAdInteractionListener e() {
        return this.f28449g;
    }

    public com.bytedance.sdk.openadsdk.downloadnew.core.a f() {
        return this.f28448f;
    }

    public void g() {
        this.f28444b = null;
        this.f28446d = null;
        this.f28447e = null;
        this.f28449g = null;
        this.f28448f = null;
        this.f28450h = false;
        this.f28445c = true;
    }

    public void b(boolean z) {
        this.f28450h = z;
    }

    public void a(boolean z) {
        this.f28445c = z;
    }

    public void a(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        this.f28446d = lVar;
    }

    public void a(TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        this.f28449g = fullScreenVideoAdInteractionListener;
    }

    public void a(TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        this.f28447e = rewardAdInteractionListener;
    }

    public void a(com.bytedance.sdk.openadsdk.downloadnew.core.a aVar) {
        this.f28448f = aVar;
    }
}
