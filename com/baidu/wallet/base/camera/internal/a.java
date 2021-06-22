package com.baidu.wallet.base.camera.internal;

import android.hardware.Camera;
import android.os.Handler;
import com.baidu.wallet.core.utils.LogUtil;
/* loaded from: classes5.dex */
public final class a implements Camera.AutoFocusCallback {

    /* renamed from: c  reason: collision with root package name */
    public static final String f23329c = a.class.getSimpleName();

    /* renamed from: d  reason: collision with root package name */
    public volatile Handler f23332d;

    /* renamed from: f  reason: collision with root package name */
    public int f23334f;

    /* renamed from: a  reason: collision with root package name */
    public long f23330a = 500;

    /* renamed from: b  reason: collision with root package name */
    public long f23331b = 500;

    /* renamed from: e  reason: collision with root package name */
    public boolean f23333e = false;

    public void a(long j) {
        this.f23330a = j;
    }

    public void b(long j) {
        this.f23331b = j;
    }

    @Override // android.hardware.Camera.AutoFocusCallback
    public synchronized void onAutoFocus(boolean z, Camera camera) {
        if (this.f23332d != null) {
            this.f23332d.sendMessageDelayed(this.f23332d.obtainMessage(this.f23334f, Boolean.valueOf(z)), this.f23333e ? this.f23330a : this.f23331b);
            this.f23333e = true;
            this.f23332d = null;
        } else {
            LogUtil.w(f23329c, "Got auto-focus callback, but no handler for it");
        }
    }

    public synchronized void a(Handler handler, int i2) {
        this.f23332d = handler;
        this.f23334f = i2;
    }
}
