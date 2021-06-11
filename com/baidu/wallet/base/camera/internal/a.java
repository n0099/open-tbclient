package com.baidu.wallet.base.camera.internal;

import android.hardware.Camera;
import android.os.Handler;
import com.baidu.wallet.core.utils.LogUtil;
/* loaded from: classes5.dex */
public final class a implements Camera.AutoFocusCallback {

    /* renamed from: c  reason: collision with root package name */
    public static final String f23247c = a.class.getSimpleName();

    /* renamed from: d  reason: collision with root package name */
    public volatile Handler f23250d;

    /* renamed from: f  reason: collision with root package name */
    public int f23252f;

    /* renamed from: a  reason: collision with root package name */
    public long f23248a = 500;

    /* renamed from: b  reason: collision with root package name */
    public long f23249b = 500;

    /* renamed from: e  reason: collision with root package name */
    public boolean f23251e = false;

    public void a(long j) {
        this.f23248a = j;
    }

    public void b(long j) {
        this.f23249b = j;
    }

    @Override // android.hardware.Camera.AutoFocusCallback
    public synchronized void onAutoFocus(boolean z, Camera camera) {
        if (this.f23250d != null) {
            this.f23250d.sendMessageDelayed(this.f23250d.obtainMessage(this.f23252f, Boolean.valueOf(z)), this.f23251e ? this.f23248a : this.f23249b);
            this.f23251e = true;
            this.f23250d = null;
        } else {
            LogUtil.w(f23247c, "Got auto-focus callback, but no handler for it");
        }
    }

    public synchronized void a(Handler handler, int i2) {
        this.f23250d = handler;
        this.f23252f = i2;
    }
}
