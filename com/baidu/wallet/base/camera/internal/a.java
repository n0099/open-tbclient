package com.baidu.wallet.base.camera.internal;

import android.hardware.Camera;
import android.os.Handler;
import com.baidu.wallet.core.utils.LogUtil;
/* loaded from: classes5.dex */
public final class a implements Camera.AutoFocusCallback {

    /* renamed from: c  reason: collision with root package name */
    public static final String f23144c = a.class.getSimpleName();

    /* renamed from: d  reason: collision with root package name */
    public volatile Handler f23147d;

    /* renamed from: f  reason: collision with root package name */
    public int f23149f;

    /* renamed from: a  reason: collision with root package name */
    public long f23145a = 500;

    /* renamed from: b  reason: collision with root package name */
    public long f23146b = 500;

    /* renamed from: e  reason: collision with root package name */
    public boolean f23148e = false;

    public void a(long j) {
        this.f23145a = j;
    }

    public void b(long j) {
        this.f23146b = j;
    }

    @Override // android.hardware.Camera.AutoFocusCallback
    public synchronized void onAutoFocus(boolean z, Camera camera) {
        if (this.f23147d != null) {
            this.f23147d.sendMessageDelayed(this.f23147d.obtainMessage(this.f23149f, Boolean.valueOf(z)), this.f23148e ? this.f23145a : this.f23146b);
            this.f23148e = true;
            this.f23147d = null;
        } else {
            LogUtil.w(f23144c, "Got auto-focus callback, but no handler for it");
        }
    }

    public synchronized void a(Handler handler, int i2) {
        this.f23147d = handler;
        this.f23149f = i2;
    }
}
