package com.baidu.tieba.qrcode.lib.core;

import android.content.Context;
import android.hardware.Camera;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.baidu.tieba.R;
import d.a.j0.p2.b.a.c;
/* loaded from: classes3.dex */
public abstract class QRCodeView extends RelativeLayout implements Camera.PreviewCallback, c.a {

    /* renamed from: e  reason: collision with root package name */
    public Camera f20898e;

    /* renamed from: f  reason: collision with root package name */
    public CameraPreview f20899f;

    /* renamed from: g  reason: collision with root package name */
    public ScanBoxView f20900g;

    /* renamed from: h  reason: collision with root package name */
    public c f20901h;

    /* renamed from: i  reason: collision with root package name */
    public Handler f20902i;
    public boolean j;
    public d.a.j0.p2.b.a.c k;
    public int l;
    public Runnable m;

    /* loaded from: classes3.dex */
    public class a extends d.a.j0.p2.b.a.c {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Camera f20903e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Camera camera, byte[] bArr, c.a aVar, int i2, Camera camera2) {
            super(camera, bArr, aVar, i2);
            this.f20903e = camera2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: d */
        public void onPostExecute(String str) {
            QRCodeView qRCodeView = QRCodeView.this;
            if (qRCodeView.j) {
                try {
                    if (qRCodeView.f20901h != null && !TextUtils.isEmpty(str)) {
                        QRCodeView.this.f20901h.b(str);
                    } else {
                        this.f20903e.setOneShotPreviewCallback(QRCodeView.this);
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            QRCodeView qRCodeView = QRCodeView.this;
            Camera camera = qRCodeView.f20898e;
            if (camera == null || !qRCodeView.j) {
                return;
            }
            try {
                camera.setOneShotPreviewCallback(qRCodeView);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a();

        void b(String str);
    }

    public QRCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void b() {
        d.a.j0.p2.b.a.c cVar = this.k;
        if (cVar != null) {
            cVar.a();
            this.k = null;
        }
    }

    public void c() {
        ScanBoxView scanBoxView = this.f20900g;
        if (scanBoxView != null) {
            scanBoxView.setVisibility(8);
        }
    }

    public final void d(Context context, AttributeSet attributeSet) {
        this.f20899f = new CameraPreview(getContext());
        ScanBoxView scanBoxView = new ScanBoxView(getContext());
        this.f20900g = scanBoxView;
        scanBoxView.k(context, attributeSet);
        this.f20899f.setId(R.id.bgaqrcode_camera_preview);
        addView(this.f20899f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context, attributeSet);
        layoutParams.addRule(6, this.f20899f.getId());
        layoutParams.addRule(8, this.f20899f.getId());
        addView(this.f20900g, layoutParams);
        this.l = d.a.j0.p2.b.a.a.c(context);
    }

    public void e() {
        l();
        this.f20902i = null;
        this.f20901h = null;
        this.m = null;
    }

    public void f() {
        ScanBoxView scanBoxView = this.f20900g;
        if (scanBoxView != null) {
            scanBoxView.setVisibility(0);
        }
    }

    public void g() {
        h(0);
    }

    public boolean getIsScanBarcodeStyle() {
        return this.f20900g.getIsBarcode();
    }

    public ScanBoxView getScanBoxView() {
        return this.f20900g;
    }

    public void h(int i2) {
        if (this.f20898e != null) {
            return;
        }
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        for (int i3 = 0; i3 < Camera.getNumberOfCameras(); i3++) {
            Camera.getCameraInfo(i3, cameraInfo);
            if (cameraInfo.facing == i2) {
                i(i3);
                return;
            }
        }
    }

    public final void i(int i2) {
        try {
            Camera open = Camera.open(i2);
            this.f20898e = open;
            this.f20899f.setCamera(open);
        } catch (Exception unused) {
            c cVar = this.f20901h;
            if (cVar != null) {
                cVar.a();
            }
        }
    }

    public void j() {
        k(1000);
    }

    public void k(int i2) {
        this.j = true;
        this.f20902i.removeCallbacks(this.m);
        this.f20902i.postDelayed(this.m, i2);
    }

    public void l() {
        try {
            n();
            if (this.f20898e != null) {
                this.f20899f.g();
                this.f20899f.setCamera(null);
                this.f20898e.release();
                this.f20898e = null;
            }
        } catch (Exception unused) {
        }
    }

    public void m() {
        b();
        this.j = false;
        Camera camera = this.f20898e;
        if (camera != null) {
            try {
                camera.setOneShotPreviewCallback(null);
            } catch (Exception unused) {
            }
        }
        Handler handler = this.f20902i;
        if (handler != null) {
            handler.removeCallbacks(this.m);
        }
    }

    public void n() {
        m();
        c();
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        if (this.j) {
            b();
            a aVar = new a(camera, bArr, this, this.l, camera);
            aVar.c();
            this.k = aVar;
        }
    }

    public void setDelegate(c cVar) {
        this.f20901h = cVar;
    }

    public QRCodeView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.j = false;
        this.m = new b();
        this.f20902i = new Handler();
        d(context, attributeSet);
    }
}
