package com.baidu.wallet.base.camera.internal;

import android.app.Activity;
import android.hardware.Camera;
import android.view.Display;
import android.view.SurfaceHolder;
import com.baidu.wallet.core.utils.LogUtil;
/* loaded from: classes5.dex */
public class d implements Camera.PreviewCallback {

    /* renamed from: a  reason: collision with root package name */
    public static final String f23573a = d.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public static d f23574b = null;

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f23575c = new byte[0];

    /* renamed from: d  reason: collision with root package name */
    public static final CameraCtrl f23576d = CameraCtrl.getInstance();

    /* renamed from: e  reason: collision with root package name */
    public volatile c f23577e;

    /* renamed from: f  reason: collision with root package name */
    public final int f23578f;

    /* renamed from: g  reason: collision with root package name */
    public final int f23579g;

    /* renamed from: h  reason: collision with root package name */
    public int f23580h;
    public int i;
    public final int j;
    public final int k;
    public final int l;
    public final long m;
    public final int n;
    public long o = 0;

    public d(int i, int i2, int i3, int i4, int i5, int i6, c cVar) {
        this.f23577e = null;
        i6 = i6 == 0 ? 15 : i6;
        this.l = i;
        this.f23578f = i2;
        this.f23579g = i3;
        this.j = i5;
        this.k = i6;
        this.m = 1000 / i6;
        this.f23577e = cVar;
        if (i4 % 90 == 0) {
            this.n = (i4 + 360) % 360;
        } else {
            this.n = 0;
        }
    }

    public static d a(int i, int i2, int i3, int i4, int i5, int i6, c cVar) {
        synchronized (f23575c) {
            d dVar = new d(i, i2, i3, i4, i5, i6, cVar);
            if (f23574b != null) {
                if (dVar.equals(f23574b)) {
                    LogUtil.i(f23573a, "a TPreviewCallback object is already created");
                    return f23574b;
                }
                f23576d.destroy();
                f23574b.f23577e.destroyCamera();
            }
            try {
                if (!f23576d.init(i, i2, i3, dVar.n, i5, i6)) {
                    LogUtil.errord(f23573a, "can not initialize camera");
                    f23574b = null;
                    return null;
                }
                dVar.f23580h = f23576d.getPreviewWidht();
                dVar.i = f23576d.getPreviewHeight();
                f23574b = dVar;
                dVar.a(cVar);
                return f23574b;
            } catch (Exception e2) {
                e2.printStackTrace();
                f23574b = null;
                return null;
            }
        }
    }

    public synchronized int b() {
        return this.f23580h;
    }

    public void c() {
        f23576d.pause();
    }

    public b d() {
        return f23576d.camera();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            c cVar = dVar.f23577e;
            return (cVar == null || this.f23577e != null) && dVar.l == this.l && dVar.f23579g == this.f23579g && dVar.f23578f == this.f23578f && dVar.n == this.n && dVar.j == this.j && dVar.k == this.k && cVar.equals(this.f23577e);
        }
        return false;
    }

    public int hashCode() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.l);
        sb.append(this.f23579g);
        sb.append(this.f23578f);
        sb.append(this.n);
        sb.append(this.j);
        sb.append(this.k);
        sb.append(this.f23577e.hashCode());
        return sb.hashCode();
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.o;
        if (0 == j) {
            this.o = currentTimeMillis;
        } else if (currentTimeMillis - j > this.m) {
            this.o = currentTimeMillis;
            if (this.f23577e != null) {
                try {
                    this.f23577e.processImage(bArr);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        camera.addCallbackBuffer(bArr);
    }

    public void b(SurfaceHolder surfaceHolder) {
        f23576d.setPreviewDisplay(surfaceHolder);
    }

    public synchronized int a() {
        return this.i;
    }

    public void a(c cVar) {
        synchronized (f23575c) {
            if (cVar != null) {
                if (this.f23577e != null && cVar != this.f23577e) {
                    LogUtil.w(f23573a, "VideoRequestor new ImageHandler is to add.");
                    this.f23577e.destroyCamera();
                }
                cVar.initCamera(this.f23580h, this.i, this.j, this.k);
                this.f23577e = cVar;
            } else {
                if (this.f23577e != null) {
                    this.f23577e.destroyCamera();
                }
                this.f23577e = null;
            }
        }
    }

    public boolean a(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null) {
            LogUtil.errord(f23573a, "The camera preview surface is null");
            return false;
        }
        f23576d.start(this, surfaceHolder);
        return true;
    }

    public void a(boolean z) {
        synchronized (f23575c) {
            f23576d.destroy();
            if (!z && this.f23577e != null) {
                this.f23577e.destroyCamera();
            }
            this.f23577e = null;
            f23574b = null;
        }
    }

    public static int a(Activity activity, int i) {
        try {
            Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i, cameraInfo);
            if (i == 1) {
                return ((-defaultDisplay.getRotation()) * 90) - cameraInfo.orientation;
            }
            return ((-defaultDisplay.getRotation()) * 90) + cameraInfo.orientation;
        } catch (Throwable unused) {
            return a(activity);
        }
    }

    public static int a(Activity activity) {
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        if (rotation == 0) {
            rotation = 1;
        } else if (rotation == 1) {
            rotation = 0;
        } else if (rotation == 2) {
            rotation = 3;
        } else if (rotation == 3) {
            rotation = 2;
        }
        return rotation * 90;
    }
}
