package com.baidu.tieba.qrcode.lib.core;

import android.content.Context;
import android.hardware.Camera;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.baidu.tieba.R;
import d.b.j0.p2.b.a.c;
/* loaded from: classes3.dex */
public abstract class QRCodeView extends RelativeLayout implements Camera.PreviewCallback, c.a {

    /* renamed from: e  reason: collision with root package name */
    public Camera f20360e;

    /* renamed from: f  reason: collision with root package name */
    public CameraPreview f20361f;

    /* renamed from: g  reason: collision with root package name */
    public ScanBoxView f20362g;

    /* renamed from: h  reason: collision with root package name */
    public c f20363h;
    public Handler i;
    public boolean j;
    public d.b.j0.p2.b.a.c k;
    public int l;
    public Runnable m;

    /* loaded from: classes3.dex */
    public class a extends d.b.j0.p2.b.a.c {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Camera f20364e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Camera camera, byte[] bArr, c.a aVar, int i, Camera camera2) {
            super(camera, bArr, aVar, i);
            this.f20364e = camera2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: d */
        public void onPostExecute(String str) {
            QRCodeView qRCodeView = QRCodeView.this;
            if (qRCodeView.j) {
                try {
                    if (qRCodeView.f20363h != null && !TextUtils.isEmpty(str)) {
                        QRCodeView.this.f20363h.b(str);
                    } else {
                        this.f20364e.setOneShotPreviewCallback(QRCodeView.this);
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
            Camera camera = qRCodeView.f20360e;
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
        d.b.j0.p2.b.a.c cVar = this.k;
        if (cVar != null) {
            cVar.a();
            this.k = null;
        }
    }

    public void c() {
        ScanBoxView scanBoxView = this.f20362g;
        if (scanBoxView != null) {
            scanBoxView.setVisibility(8);
        }
    }

    public final void d(Context context, AttributeSet attributeSet) {
        this.f20361f = new CameraPreview(getContext());
        ScanBoxView scanBoxView = new ScanBoxView(getContext());
        this.f20362g = scanBoxView;
        scanBoxView.k(context, attributeSet);
        this.f20361f.setId(R.id.bgaqrcode_camera_preview);
        addView(this.f20361f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context, attributeSet);
        layoutParams.addRule(6, this.f20361f.getId());
        layoutParams.addRule(8, this.f20361f.getId());
        addView(this.f20362g, layoutParams);
        this.l = d.b.j0.p2.b.a.a.c(context);
    }

    public void e() {
        l();
        this.i = null;
        this.f20363h = null;
        this.m = null;
    }

    public void f() {
        ScanBoxView scanBoxView = this.f20362g;
        if (scanBoxView != null) {
            scanBoxView.setVisibility(0);
        }
    }

    public void g() {
        h(0);
    }

    public boolean getIsScanBarcodeStyle() {
        return this.f20362g.getIsBarcode();
    }

    public ScanBoxView getScanBoxView() {
        return this.f20362g;
    }

    public void h(int i) {
        if (this.f20360e != null) {
            return;
        }
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
            Camera.getCameraInfo(i2, cameraInfo);
            if (cameraInfo.facing == i) {
                i(i2);
                return;
            }
        }
    }

    public final void i(int i) {
        try {
            Camera open = Camera.open(i);
            this.f20360e = open;
            this.f20361f.setCamera(open);
        } catch (Exception unused) {
            c cVar = this.f20363h;
            if (cVar != null) {
                cVar.a();
            }
        }
    }

    public void j() {
        k(1000);
    }

    public void k(int i) {
        this.j = true;
        this.i.removeCallbacks(this.m);
        this.i.postDelayed(this.m, i);
    }

    public void l() {
        try {
            n();
            if (this.f20360e != null) {
                this.f20361f.g();
                this.f20361f.setCamera(null);
                this.f20360e.release();
                this.f20360e = null;
            }
        } catch (Exception unused) {
        }
    }

    public void m() {
        b();
        this.j = false;
        Camera camera = this.f20360e;
        if (camera != null) {
            try {
                camera.setOneShotPreviewCallback(null);
            } catch (Exception unused) {
            }
        }
        Handler handler = this.i;
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
        this.f20363h = cVar;
    }

    public QRCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.j = false;
        this.m = new b();
        this.i = new Handler();
        d(context, attributeSet);
    }
}
