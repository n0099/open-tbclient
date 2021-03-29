package com.baidu.tieba.write.album;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.TextureView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import java.io.IOException;
import java.util.List;
/* loaded from: classes5.dex */
public class TbCameraView extends TextureView {

    /* renamed from: e  reason: collision with root package name */
    public SurfaceTexture f22259e;

    /* renamed from: f  reason: collision with root package name */
    public Camera f22260f;

    /* renamed from: g  reason: collision with root package name */
    public Camera.Parameters f22261g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f22262h;
    public h i;
    public int j;
    public float k;
    public float l;
    public int m;
    public int n;
    public boolean o;
    public f p;
    public g q;
    public e r;
    public boolean s;
    public TextureView.SurfaceTextureListener t;
    public final Runnable u;
    public final Runnable v;
    public Runnable w;

    /* loaded from: classes5.dex */
    public class a implements TextureView.SurfaceTextureListener {
        public a() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            TbCameraView.this.f22259e = surfaceTexture;
            if (!TbCameraView.this.s) {
                TbCameraView tbCameraView = TbCameraView.this;
                tbCameraView.s = tbCameraView.q != null && TbCameraView.this.q.a();
            }
            if (TbCameraView.this.s) {
                new Thread(TbCameraView.this.u).start();
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            new Thread(TbCameraView.this.v).start();
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (TbCameraView.this) {
                TbCameraView.this.k(TbCameraView.this.o);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (TbCameraView.this) {
                TbCameraView.this.m();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TbCameraView.this.i != null) {
                TbCameraView.this.i.a();
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface e {
        void a();
    }

    /* loaded from: classes5.dex */
    public interface f {
        void a(int i, int i2);
    }

    /* loaded from: classes5.dex */
    public interface g {
        boolean a();
    }

    /* loaded from: classes5.dex */
    public interface h {
        void a();
    }

    public TbCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22262h = false;
        this.j = 0;
        this.o = false;
        this.s = false;
        this.t = new a();
        this.u = new b();
        this.v = new c();
        this.w = new d();
        setSurfaceTextureListener(this.t);
        this.m = getResources().getDimensionPixelSize(R.dimen.ds5);
        this.n = getResources().getDimensionPixelSize(R.dimen.ds20);
    }

    public final float i(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return 0.0f;
        }
        float x = motionEvent.getX(1) - motionEvent.getX(0);
        float y = motionEvent.getY(1) - motionEvent.getY(0);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    public Camera.Size j(List<Camera.Size> list, int i, int i2) {
        if (ListUtils.getCount(list) == 0) {
            return null;
        }
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            Camera.Size size = list.get(i5);
            if (size != null) {
                int abs = Math.abs(size.width - i) + Math.abs(size.height - i2);
                if (i5 == 0) {
                    i4 = abs;
                    i3 = 0;
                } else if (abs < i4) {
                    i3 = i5;
                    i4 = abs;
                }
            }
        }
        return list.get(i3);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void k(boolean z) {
        e eVar;
        Camera.CameraInfo cameraInfo;
        int numberOfCameras;
        int i;
        if (this.f22259e == null) {
            return;
        }
        try {
            m();
            cameraInfo = new Camera.CameraInfo();
            numberOfCameras = Camera.getNumberOfCameras();
            i = 0;
        } catch (Throwable th) {
            th.printStackTrace();
            m();
            eVar = this.r;
            if (eVar == null) {
            }
        }
        while (true) {
            if (i >= numberOfCameras) {
                break;
            }
            Camera.getCameraInfo(i, cameraInfo);
            if (z) {
                if (cameraInfo.facing == 1) {
                    this.f22260f = Camera.open(i);
                    this.o = true;
                    break;
                }
                i++;
            } else if (cameraInfo.facing == 0) {
                this.f22260f = Camera.open(i);
                this.o = false;
                break;
            } else {
                i++;
            }
            th.printStackTrace();
            m();
            eVar = this.r;
            if (eVar == null) {
                eVar.a();
                return;
            }
            return;
        }
        l(this.f22259e);
    }

    public final void l(SurfaceTexture surfaceTexture) {
        Camera camera = this.f22260f;
        if (camera != null) {
            Camera.Parameters parameters = camera.getParameters();
            this.f22261g = parameters;
            parameters.setPictureFormat(256);
            Camera.Size j = j(this.f22261g.getSupportedPictureSizes(), 1440, 1080);
            this.f22261g.setPictureSize(j.width, j.height);
            Camera.Size j2 = j(this.f22261g.getSupportedPreviewSizes(), 1440, 1080);
            this.f22261g.setPreviewSize(j2.width, j2.height);
            f fVar = this.p;
            if (fVar != null) {
                fVar.a(j2.width, j2.height);
            }
            this.f22260f.setDisplayOrientation(90);
            if (this.f22261g.getSupportedFocusModes().contains("continuous-video")) {
                this.f22261g.setFocusMode("continuous-video");
            }
            this.f22260f.setParameters(this.f22261g);
            try {
                this.f22260f.setPreviewTexture(surfaceTexture);
                this.f22260f.startPreview();
                this.f22262h = true;
            } catch (IOException e2) {
                e2.printStackTrace();
                m();
            }
        }
    }

    public void m() {
        Camera camera = this.f22260f;
        if (camera != null) {
            try {
                camera.setPreviewCallback(null);
                this.f22260f.stopPreview();
                this.f22260f.release();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        this.f22262h = false;
        this.f22260f = null;
    }

    public void n(int i) {
        Camera camera = this.f22260f;
        if (camera == null) {
            return;
        }
        Camera.Parameters parameters = camera.getParameters();
        this.f22261g = parameters;
        if (parameters != null) {
            parameters.setZoom(i);
            this.f22260f.setParameters(this.f22261g);
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d.b.b.e.m.e.a().removeCallbacks(this.w);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i;
        if (this.f22262h) {
            int action = motionEvent.getAction() & 255;
            if (action != 0) {
                if (action == 1) {
                    this.j = 0;
                } else if (action == 2) {
                    Camera.Parameters parameters = this.f22261g;
                    if (parameters != null && parameters.isZoomSupported() && this.j == 2) {
                        float i2 = i(motionEvent);
                        this.k = i2;
                        if (i2 > this.m) {
                            float f2 = i2 - this.l;
                            int maxZoom = this.f22261g.getMaxZoom();
                            int zoom = this.f22260f.getParameters().getZoom();
                            if (f2 > this.n) {
                                int i3 = zoom + 1;
                                if (i3 <= maxZoom) {
                                    maxZoom = i3;
                                }
                                n(maxZoom);
                                this.l = this.k;
                            } else if (f2 < (-i)) {
                                int i4 = zoom - 1;
                                n(i4 >= 0 ? i4 : 0);
                                this.l = this.k;
                            }
                        }
                    }
                } else if (action == 5) {
                    float i5 = i(motionEvent);
                    this.l = i5;
                    if (i5 > this.m) {
                        this.j = 2;
                    }
                } else if (action == 6) {
                    this.j = 0;
                }
            } else {
                this.j = 1;
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setOnGotPictureListener(h hVar) {
        this.i = hVar;
    }

    public void setOnOpenCameraFailedListener(e eVar) {
        this.r = eVar;
    }

    public void setOnPreviewSizeChangedListener(f fVar) {
        this.p = fVar;
    }

    public void setOnRequestPermissionListener(g gVar) {
        this.q = gVar;
    }

    public void setStorePath(String str) {
    }
}
