package com.baidu.wallet.base.camera.internal;

import android.app.Activity;
import android.hardware.Camera;
import android.view.Display;
import android.view.SurfaceHolder;
import com.baidu.wallet.core.utils.LogUtil;
/* loaded from: classes5.dex */
public class d implements Camera.PreviewCallback {

    /* renamed from: a  reason: collision with root package name */
    public static final String f23259a = d.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public static d f23260b = null;

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f23261c = new byte[0];

    /* renamed from: d  reason: collision with root package name */
    public static final CameraCtrl f23262d = CameraCtrl.getInstance();

    /* renamed from: e  reason: collision with root package name */
    public volatile c f23263e;

    /* renamed from: f  reason: collision with root package name */
    public final int f23264f;

    /* renamed from: g  reason: collision with root package name */
    public final int f23265g;

    /* renamed from: h  reason: collision with root package name */
    public int f23266h;

    /* renamed from: i  reason: collision with root package name */
    public int f23267i;
    public final int j;
    public final int k;
    public final int l;
    public final long m;
    public final int n;
    public long o = 0;

    public d(int i2, int i3, int i4, int i5, int i6, int i7, c cVar) {
        this.f23263e = null;
        i7 = i7 == 0 ? 15 : i7;
        this.l = i2;
        this.f23264f = i3;
        this.f23265g = i4;
        this.j = i6;
        this.k = i7;
        this.m = 1000 / i7;
        this.f23263e = cVar;
        if (i5 % 90 == 0) {
            this.n = (i5 + 360) % 360;
        } else {
            this.n = 0;
        }
    }

    public static d a(int i2, int i3, int i4, int i5, int i6, int i7, c cVar) {
        synchronized (f23261c) {
            d dVar = new d(i2, i3, i4, i5, i6, i7, cVar);
            if (f23260b != null) {
                if (dVar.equals(f23260b)) {
                    LogUtil.i(f23259a, "a TPreviewCallback object is already created");
                    return f23260b;
                }
                f23262d.destroy();
                f23260b.f23263e.destroyCamera();
            }
            try {
                if (!f23262d.init(i2, i3, i4, dVar.n, i6, i7)) {
                    LogUtil.errord(f23259a, "can not initialize camera");
                    f23260b = null;
                    return null;
                }
                dVar.f23266h = f23262d.getPreviewWidht();
                dVar.f23267i = f23262d.getPreviewHeight();
                f23260b = dVar;
                dVar.a(cVar);
                return f23260b;
            } catch (Exception e2) {
                e2.printStackTrace();
                f23260b = null;
                return null;
            }
        }
    }

    public synchronized int b() {
        return this.f23266h;
    }

    public void c() {
        f23262d.pause();
    }

    public b d() {
        return f23262d.camera();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            c cVar = dVar.f23263e;
            return (cVar == null || this.f23263e != null) && dVar.l == this.l && dVar.f23265g == this.f23265g && dVar.f23264f == this.f23264f && dVar.n == this.n && dVar.j == this.j && dVar.k == this.k && cVar.equals(this.f23263e);
        }
        return false;
    }

    public int hashCode() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.l);
        sb.append(this.f23265g);
        sb.append(this.f23264f);
        sb.append(this.n);
        sb.append(this.j);
        sb.append(this.k);
        sb.append(this.f23263e.hashCode());
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
            if (this.f23263e != null) {
                try {
                    this.f23263e.processImage(bArr);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        camera.addCallbackBuffer(bArr);
    }

    public void b(SurfaceHolder surfaceHolder) {
        f23262d.setPreviewDisplay(surfaceHolder);
    }

    public synchronized int a() {
        return this.f23267i;
    }

    public void a(c cVar) {
        synchronized (f23261c) {
            if (cVar != null) {
                if (this.f23263e != null && cVar != this.f23263e) {
                    LogUtil.w(f23259a, "VideoRequestor new ImageHandler is to add.");
                    this.f23263e.destroyCamera();
                }
                cVar.initCamera(this.f23266h, this.f23267i, this.j, this.k);
                this.f23263e = cVar;
            } else {
                if (this.f23263e != null) {
                    this.f23263e.destroyCamera();
                }
                this.f23263e = null;
            }
        }
    }

    public boolean a(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null) {
            LogUtil.errord(f23259a, "The camera preview surface is null");
            return false;
        }
        f23262d.start(this, surfaceHolder);
        return true;
    }

    public void a(boolean z) {
        synchronized (f23261c) {
            f23262d.destroy();
            if (!z && this.f23263e != null) {
                this.f23263e.destroyCamera();
            }
            this.f23263e = null;
            f23260b = null;
        }
    }

    public static int a(Activity activity, int i2) {
        try {
            Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i2, cameraInfo);
            if (i2 == 1) {
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
