package com.baidu.wallet.base.camera.internal;

import android.hardware.Camera;
import android.os.Handler;
import com.baidu.wallet.core.utils.LogUtil;
/* loaded from: classes5.dex */
public final class a implements Camera.AutoFocusCallback {

    /* renamed from: c  reason: collision with root package name */
    public static final String f23970c = a.class.getSimpleName();

    /* renamed from: d  reason: collision with root package name */
    public volatile Handler f23973d;

    /* renamed from: f  reason: collision with root package name */
    public int f23975f;

    /* renamed from: a  reason: collision with root package name */
    public long f23971a = 500;

    /* renamed from: b  reason: collision with root package name */
    public long f23972b = 500;

    /* renamed from: e  reason: collision with root package name */
    public boolean f23974e = false;

    public void a(long j) {
        this.f23971a = j;
    }

    public void b(long j) {
        this.f23972b = j;
    }

    @Override // android.hardware.Camera.AutoFocusCallback
    public synchronized void onAutoFocus(boolean z, Camera camera) {
        if (this.f23973d != null) {
            this.f23973d.sendMessageDelayed(this.f23973d.obtainMessage(this.f23975f, Boolean.valueOf(z)), this.f23974e ? this.f23971a : this.f23972b);
            this.f23974e = true;
            this.f23973d = null;
        } else {
            LogUtil.w(f23970c, "Got auto-focus callback, but no handler for it");
        }
    }

    public synchronized void a(Handler handler, int i2) {
        this.f23973d = handler;
        this.f23975f = i2;
    }
}
