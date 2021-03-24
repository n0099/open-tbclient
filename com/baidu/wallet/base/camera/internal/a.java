package com.baidu.wallet.base.camera.internal;

import android.hardware.Camera;
import android.os.Handler;
import com.baidu.wallet.core.utils.LogUtil;
/* loaded from: classes5.dex */
public final class a implements Camera.AutoFocusCallback {

    /* renamed from: c  reason: collision with root package name */
    public static final String f23560c = a.class.getSimpleName();

    /* renamed from: d  reason: collision with root package name */
    public volatile Handler f23563d;

    /* renamed from: f  reason: collision with root package name */
    public int f23565f;

    /* renamed from: a  reason: collision with root package name */
    public long f23561a = 500;

    /* renamed from: b  reason: collision with root package name */
    public long f23562b = 500;

    /* renamed from: e  reason: collision with root package name */
    public boolean f23564e = false;

    public void a(long j) {
        this.f23561a = j;
    }

    public void b(long j) {
        this.f23562b = j;
    }

    @Override // android.hardware.Camera.AutoFocusCallback
    public synchronized void onAutoFocus(boolean z, Camera camera) {
        if (this.f23563d != null) {
            this.f23563d.sendMessageDelayed(this.f23563d.obtainMessage(this.f23565f, Boolean.valueOf(z)), this.f23564e ? this.f23561a : this.f23562b);
            this.f23564e = true;
            this.f23563d = null;
        } else {
            LogUtil.w(f23560c, "Got auto-focus callback, but no handler for it");
        }
    }

    public synchronized void a(Handler handler, int i) {
        this.f23563d = handler;
        this.f23565f = i;
    }
}
