package com.baidu.wallet.base.camera.internal;

import android.app.Activity;
import android.hardware.Camera;
import android.view.Display;
import android.view.SurfaceHolder;
import com.baidu.wallet.core.utils.LogUtil;
/* loaded from: classes5.dex */
public class d implements Camera.PreviewCallback {

    /* renamed from: a  reason: collision with root package name */
    public static final String f23258a = d.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public static d f23259b = null;

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f23260c = new byte[0];

    /* renamed from: d  reason: collision with root package name */
    public static final CameraCtrl f23261d = CameraCtrl.getInstance();

    /* renamed from: e  reason: collision with root package name */
    public volatile c f23262e;

    /* renamed from: f  reason: collision with root package name */
    public final int f23263f;

    /* renamed from: g  reason: collision with root package name */
    public final int f23264g;

    /* renamed from: h  reason: collision with root package name */
    public int f23265h;
    public int i;
    public final int j;
    public final int k;
    public final int l;
    public final long m;
    public final int n;
    public long o = 0;

    public d(int i, int i2, int i3, int i4, int i5, int i6, c cVar) {
        this.f23262e = null;
        i6 = i6 == 0 ? 15 : i6;
        this.l = i;
        this.f23263f = i2;
        this.f23264g = i3;
        this.j = i5;
        this.k = i6;
        this.m = 1000 / i6;
        this.f23262e = cVar;
        if (i4 % 90 == 0) {
            this.n = (i4 + 360) % 360;
        } else {
            this.n = 0;
        }
    }

    public static d a(int i, int i2, int i3, int i4, int i5, int i6, c cVar) {
        synchronized (f23260c) {
            d dVar = new d(i, i2, i3, i4, i5, i6, cVar);
            if (f23259b != null) {
                if (dVar.equals(f23259b)) {
                    LogUtil.i(f23258a, "a TPreviewCallback object is already created");
                    return f23259b;
                }
                f23261d.destroy();
                f23259b.f23262e.destroyCamera();
            }
            try {
                if (!f23261d.init(i, i2, i3, dVar.n, i5, i6)) {
                    LogUtil.errord(f23258a, "can not initialize camera");
                    f23259b = null;
                    return null;
                }
                dVar.f23265h = f23261d.getPreviewWidht();
                dVar.i = f23261d.getPreviewHeight();
                f23259b = dVar;
                dVar.a(cVar);
                return f23259b;
            } catch (Exception e2) {
                e2.printStackTrace();
                f23259b = null;
                return null;
            }
        }
    }

    public synchronized int b() {
        return this.f23265h;
    }

    public void c() {
        f23261d.pause();
    }

    public b d() {
        return f23261d.camera();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            c cVar = dVar.f23262e;
            return (cVar == null || this.f23262e != null) && dVar.l == this.l && dVar.f23264g == this.f23264g && dVar.f23263f == this.f23263f && dVar.n == this.n && dVar.j == this.j && dVar.k == this.k && cVar.equals(this.f23262e);
        }
        return false;
    }

    public int hashCode() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.l);
        sb.append(this.f23264g);
        sb.append(this.f23263f);
        sb.append(this.n);
        sb.append(this.j);
        sb.append(this.k);
        sb.append(this.f23262e.hashCode());
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
            if (this.f23262e != null) {
                try {
                    this.f23262e.processImage(bArr);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        camera.addCallbackBuffer(bArr);
    }

    public void b(SurfaceHolder surfaceHolder) {
        f23261d.setPreviewDisplay(surfaceHolder);
    }

    public synchronized int a() {
        return this.i;
    }

    public void a(c cVar) {
        synchronized (f23260c) {
            if (cVar != null) {
                if (this.f23262e != null && cVar != this.f23262e) {
                    LogUtil.w(f23258a, "VideoRequestor new ImageHandler is to add.");
                    this.f23262e.destroyCamera();
                }
                cVar.initCamera(this.f23265h, this.i, this.j, this.k);
                this.f23262e = cVar;
            } else {
                if (this.f23262e != null) {
                    this.f23262e.destroyCamera();
                }
                this.f23262e = null;
            }
        }
    }

    public boolean a(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null) {
            LogUtil.errord(f23258a, "The camera preview surface is null");
            return false;
        }
        f23261d.start(this, surfaceHolder);
        return true;
    }

    public void a(boolean z) {
        synchronized (f23260c) {
            f23261d.destroy();
            if (!z && this.f23262e != null) {
                this.f23262e.destroyCamera();
            }
            this.f23262e = null;
            f23259b = null;
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
