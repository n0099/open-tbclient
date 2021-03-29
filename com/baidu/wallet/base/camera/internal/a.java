package com.baidu.wallet.base.camera.internal;

import android.hardware.Camera;
import android.os.Handler;
import com.baidu.wallet.core.utils.LogUtil;
/* loaded from: classes5.dex */
public final class a implements Camera.AutoFocusCallback {

    /* renamed from: c  reason: collision with root package name */
    public static final String f23561c = a.class.getSimpleName();

    /* renamed from: d  reason: collision with root package name */
    public volatile Handler f23564d;

    /* renamed from: f  reason: collision with root package name */
    public int f23566f;

    /* renamed from: a  reason: collision with root package name */
    public long f23562a = 500;

    /* renamed from: b  reason: collision with root package name */
    public long f23563b = 500;

    /* renamed from: e  reason: collision with root package name */
    public boolean f23565e = false;

    public void a(long j) {
        this.f23562a = j;
    }

    public void b(long j) {
        this.f23563b = j;
    }

    @Override // android.hardware.Camera.AutoFocusCallback
    public synchronized void onAutoFocus(boolean z, Camera camera) {
        if (this.f23564d != null) {
            this.f23564d.sendMessageDelayed(this.f23564d.obtainMessage(this.f23566f, Boolean.valueOf(z)), this.f23565e ? this.f23562a : this.f23563b);
            this.f23565e = true;
            this.f23564d = null;
        } else {
            LogUtil.w(f23561c, "Got auto-focus callback, but no handler for it");
        }
    }

    public synchronized void a(Handler handler, int i) {
        this.f23564d = handler;
        this.f23566f = i;
    }
}
