package com.baidu.wallet.base.camera.internal;

import android.app.Activity;
import android.hardware.Camera;
import android.view.Display;
import android.view.SurfaceHolder;
import com.baidu.wallet.core.utils.LogUtil;
/* loaded from: classes5.dex */
public class d implements Camera.PreviewCallback {

    /* renamed from: a  reason: collision with root package name */
    public static final String f23341a = d.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public static d f23342b = null;

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f23343c = new byte[0];

    /* renamed from: d  reason: collision with root package name */
    public static final CameraCtrl f23344d = CameraCtrl.getInstance();

    /* renamed from: e  reason: collision with root package name */
    public volatile c f23345e;

    /* renamed from: f  reason: collision with root package name */
    public final int f23346f;

    /* renamed from: g  reason: collision with root package name */
    public final int f23347g;

    /* renamed from: h  reason: collision with root package name */
    public int f23348h;

    /* renamed from: i  reason: collision with root package name */
    public int f23349i;
    public final int j;
    public final int k;
    public final int l;
    public final long m;
    public final int n;
    public long o = 0;

    public d(int i2, int i3, int i4, int i5, int i6, int i7, c cVar) {
        this.f23345e = null;
        i7 = i7 == 0 ? 15 : i7;
        this.l = i2;
        this.f23346f = i3;
        this.f23347g = i4;
        this.j = i6;
        this.k = i7;
        this.m = 1000 / i7;
        this.f23345e = cVar;
        if (i5 % 90 == 0) {
            this.n = (i5 + 360) % 360;
        } else {
            this.n = 0;
        }
    }

    public static d a(int i2, int i3, int i4, int i5, int i6, int i7, c cVar) {
        synchronized (f23343c) {
            d dVar = new d(i2, i3, i4, i5, i6, i7, cVar);
            if (f23342b != null) {
                if (dVar.equals(f23342b)) {
                    LogUtil.i(f23341a, "a TPreviewCallback object is already created");
                    return f23342b;
                }
                f23344d.destroy();
                f23342b.f23345e.destroyCamera();
            }
            try {
                if (!f23344d.init(i2, i3, i4, dVar.n, i6, i7)) {
                    LogUtil.errord(f23341a, "can not initialize camera");
                    f23342b = null;
                    return null;
                }
                dVar.f23348h = f23344d.getPreviewWidht();
                dVar.f23349i = f23344d.getPreviewHeight();
                f23342b = dVar;
                dVar.a(cVar);
                return f23342b;
            } catch (Exception e2) {
                e2.printStackTrace();
                f23342b = null;
                return null;
            }
        }
    }

    public synchronized int b() {
        return this.f23348h;
    }

    public void c() {
        f23344d.pause();
    }

    public b d() {
        return f23344d.camera();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            c cVar = dVar.f23345e;
            return (cVar == null || this.f23345e != null) && dVar.l == this.l && dVar.f23347g == this.f23347g && dVar.f23346f == this.f23346f && dVar.n == this.n && dVar.j == this.j && dVar.k == this.k && cVar.equals(this.f23345e);
        }
        return false;
    }

    public int hashCode() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.l);
        sb.append(this.f23347g);
        sb.append(this.f23346f);
        sb.append(this.n);
        sb.append(this.j);
        sb.append(this.k);
        sb.append(this.f23345e.hashCode());
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
            if (this.f23345e != null) {
                try {
                    this.f23345e.processImage(bArr);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        camera.addCallbackBuffer(bArr);
    }

    public void b(SurfaceHolder surfaceHolder) {
        f23344d.setPreviewDisplay(surfaceHolder);
    }

    public synchronized int a() {
        return this.f23349i;
    }

    public void a(c cVar) {
        synchronized (f23343c) {
            if (cVar != null) {
                if (this.f23345e != null && cVar != this.f23345e) {
                    LogUtil.w(f23341a, "VideoRequestor new ImageHandler is to add.");
                    this.f23345e.destroyCamera();
                }
                cVar.initCamera(this.f23348h, this.f23349i, this.j, this.k);
                this.f23345e = cVar;
            } else {
                if (this.f23345e != null) {
                    this.f23345e.destroyCamera();
                }
                this.f23345e = null;
            }
        }
    }

    public boolean a(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null) {
            LogUtil.errord(f23341a, "The camera preview surface is null");
            return false;
        }
        f23344d.start(this, surfaceHolder);
        return true;
    }

    public void a(boolean z) {
        synchronized (f23343c) {
            f23344d.destroy();
            if (!z && this.f23345e != null) {
                this.f23345e.destroyCamera();
            }
            this.f23345e = null;
            f23342b = null;
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
