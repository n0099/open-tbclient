package com.baidu.wallet.base.camera.internal;

import android.app.Activity;
import android.hardware.Camera;
import android.view.Display;
import android.view.SurfaceHolder;
import com.baidu.wallet.core.utils.LogUtil;
/* loaded from: classes5.dex */
public class d implements Camera.PreviewCallback {

    /* renamed from: a  reason: collision with root package name */
    public static final String f23266a = d.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public static d f23267b = null;

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f23268c = new byte[0];

    /* renamed from: d  reason: collision with root package name */
    public static final CameraCtrl f23269d = CameraCtrl.getInstance();

    /* renamed from: e  reason: collision with root package name */
    public volatile c f23270e;

    /* renamed from: f  reason: collision with root package name */
    public final int f23271f;

    /* renamed from: g  reason: collision with root package name */
    public final int f23272g;

    /* renamed from: h  reason: collision with root package name */
    public int f23273h;
    public int i;
    public final int j;
    public final int k;
    public final int l;
    public final long m;
    public final int n;
    public long o = 0;

    public d(int i, int i2, int i3, int i4, int i5, int i6, c cVar) {
        this.f23270e = null;
        i6 = i6 == 0 ? 15 : i6;
        this.l = i;
        this.f23271f = i2;
        this.f23272g = i3;
        this.j = i5;
        this.k = i6;
        this.m = 1000 / i6;
        this.f23270e = cVar;
        if (i4 % 90 == 0) {
            this.n = (i4 + 360) % 360;
        } else {
            this.n = 0;
        }
    }

    public static d a(int i, int i2, int i3, int i4, int i5, int i6, c cVar) {
        synchronized (f23268c) {
            d dVar = new d(i, i2, i3, i4, i5, i6, cVar);
            if (f23267b != null) {
                if (dVar.equals(f23267b)) {
                    LogUtil.i(f23266a, "a TPreviewCallback object is already created");
                    return f23267b;
                }
                f23269d.destroy();
                f23267b.f23270e.destroyCamera();
            }
            try {
                if (!f23269d.init(i, i2, i3, dVar.n, i5, i6)) {
                    LogUtil.errord(f23266a, "can not initialize camera");
                    f23267b = null;
                    return null;
                }
                dVar.f23273h = f23269d.getPreviewWidht();
                dVar.i = f23269d.getPreviewHeight();
                f23267b = dVar;
                dVar.a(cVar);
                return f23267b;
            } catch (Exception e2) {
                e2.printStackTrace();
                f23267b = null;
                return null;
            }
        }
    }

    public synchronized int b() {
        return this.f23273h;
    }

    public void c() {
        f23269d.pause();
    }

    public b d() {
        return f23269d.camera();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            c cVar = dVar.f23270e;
            return (cVar == null || this.f23270e != null) && dVar.l == this.l && dVar.f23272g == this.f23272g && dVar.f23271f == this.f23271f && dVar.n == this.n && dVar.j == this.j && dVar.k == this.k && cVar.equals(this.f23270e);
        }
        return false;
    }

    public int hashCode() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.l);
        sb.append(this.f23272g);
        sb.append(this.f23271f);
        sb.append(this.n);
        sb.append(this.j);
        sb.append(this.k);
        sb.append(this.f23270e.hashCode());
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
            if (this.f23270e != null) {
                try {
                    this.f23270e.processImage(bArr);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        camera.addCallbackBuffer(bArr);
    }

    public void b(SurfaceHolder surfaceHolder) {
        f23269d.setPreviewDisplay(surfaceHolder);
    }

    public synchronized int a() {
        return this.i;
    }

    public void a(c cVar) {
        synchronized (f23268c) {
            if (cVar != null) {
                if (this.f23270e != null && cVar != this.f23270e) {
                    LogUtil.w(f23266a, "VideoRequestor new ImageHandler is to add.");
                    this.f23270e.destroyCamera();
                }
                cVar.initCamera(this.f23273h, this.i, this.j, this.k);
                this.f23270e = cVar;
            } else {
                if (this.f23270e != null) {
                    this.f23270e.destroyCamera();
                }
                this.f23270e = null;
            }
        }
    }

    public boolean a(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null) {
            LogUtil.errord(f23266a, "The camera preview surface is null");
            return false;
        }
        f23269d.start(this, surfaceHolder);
        return true;
    }

    public void a(boolean z) {
        synchronized (f23268c) {
            f23269d.destroy();
            if (!z && this.f23270e != null) {
                this.f23270e.destroyCamera();
            }
            this.f23270e = null;
            f23267b = null;
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
