package com.bytedance.sdk.openadsdk.core;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
/* loaded from: classes4.dex */
public class u {

    /* renamed from: a  reason: collision with root package name */
    private static u f6982a;

    /* renamed from: b  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.video.nativevideo.c f6983b;
    private com.bytedance.sdk.openadsdk.core.d.l d;
    private TTRewardVideoAd.RewardAdInteractionListener e;
    private com.bytedance.sdk.openadsdk.downloadnew.core.a f;
    private TTFullScreenVideoAd.FullScreenVideoAdInteractionListener g;
    private boolean c = true;
    private boolean h = false;

    private u() {
    }

    @MainThread
    public static u a() {
        if (f6982a == null) {
            f6982a = new u();
        }
        return f6982a;
    }

    public void a(boolean z) {
        this.c = z;
    }

    public boolean b() {
        return this.c;
    }

    @NonNull
    public com.bytedance.sdk.openadsdk.core.d.l c() {
        return this.d;
    }

    public void a(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        this.d = lVar;
    }

    public TTRewardVideoAd.RewardAdInteractionListener d() {
        return this.e;
    }

    public TTFullScreenVideoAd.FullScreenVideoAdInteractionListener e() {
        return this.g;
    }

    public void a(TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        this.g = fullScreenVideoAdInteractionListener;
    }

    public void a(TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        this.e = rewardAdInteractionListener;
    }

    public com.bytedance.sdk.openadsdk.downloadnew.core.a f() {
        return this.f;
    }

    public void a(com.bytedance.sdk.openadsdk.downloadnew.core.a aVar) {
        this.f = aVar;
    }

    public void b(boolean z) {
        this.h = z;
    }

    public void g() {
        this.f6983b = null;
        this.d = null;
        this.e = null;
        this.g = null;
        this.f = null;
        this.h = false;
        this.c = true;
    }
}
