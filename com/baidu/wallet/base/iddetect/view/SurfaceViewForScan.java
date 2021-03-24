package com.baidu.wallet.base.iddetect.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.baidu.rtc.PeerConnectionClient;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.wallet.base.iddetect.IdCardActivity;
import com.baidu.wallet.core.utils.LogUtil;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class SurfaceViewForScan extends SurfaceView implements SurfaceHolder.Callback {
    public static final int CAMERA_BACK = 1;
    public static final int CAMERA_FRONT = 0;
    public static final int MODE_NORMAL = 0;
    public static final int MODE_TRACKER = 1;
    public static final String TAG = SurfaceViewForScan.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public static int f23663a = PeerConnectionClient.HD_VIDEO_HEIGHT;

    /* renamed from: b  reason: collision with root package name */
    public static int f23664b = TbConfig.HEAD_IMG_SIZE;

    /* renamed from: c  reason: collision with root package name */
    public Camera f23665c;

    /* renamed from: d  reason: collision with root package name */
    public Camera.Parameters f23666d;

    /* renamed from: e  reason: collision with root package name */
    public int f23667e;

    /* renamed from: f  reason: collision with root package name */
    public SurfaceHolder f23668f;

    /* renamed from: g  reason: collision with root package name */
    public byte[][] f23669g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f23670h;
    public a i;
    public int j;
    public int k;
    public int l;
    public b m;
    public int n;
    public int o;
    public int p;
    public Camera.PictureCallback q;
    public Context r;
    public int s;
    public com.baidu.wallet.base.iddetect.a t;
    public IdCardActivity u;
    public Camera.AutoFocusCallback v;

    /* loaded from: classes5.dex */
    public interface a {
        void a(byte[] bArr, int i, int i2, int i3);
    }

    /* loaded from: classes5.dex */
    public class b extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public Handler f23674a;

        public b() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Looper.prepare();
            this.f23674a = new c(SurfaceViewForScan.this);
            Looper.loop();
        }
    }

    /* loaded from: classes5.dex */
    public static class c extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<SurfaceViewForScan> f23676a;

        /* renamed from: b  reason: collision with root package name */
        public long f23677b = System.currentTimeMillis();

        public c(SurfaceViewForScan surfaceViewForScan) {
            this.f23676a = new WeakReference<>(surfaceViewForScan);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i;
            int i2;
            SurfaceViewForScan surfaceViewForScan = this.f23676a.get();
            if (surfaceViewForScan == null) {
                return;
            }
            byte[] bArr = (byte[]) message.obj;
            if (System.currentTimeMillis() - this.f23677b > 200) {
                this.f23677b = System.currentTimeMillis();
                int i3 = surfaceViewForScan.n;
                if (surfaceViewForScan.o == 1) {
                    i3 += 180;
                }
                int i4 = 360 - i3;
                if (i4 == 0) {
                    System.arraycopy(bArr, 0, surfaceViewForScan.f23670h, 0, bArr.length);
                    i = surfaceViewForScan.j;
                    i2 = surfaceViewForScan.k;
                } else if (i4 == 90) {
                    surfaceViewForScan.a(bArr, surfaceViewForScan.f23670h, surfaceViewForScan.j, surfaceViewForScan.k);
                    i = surfaceViewForScan.k;
                    i2 = surfaceViewForScan.j;
                } else if (i4 == 180) {
                    surfaceViewForScan.b(bArr, surfaceViewForScan.f23670h, surfaceViewForScan.j, surfaceViewForScan.k);
                    i = surfaceViewForScan.j;
                    i2 = surfaceViewForScan.k;
                } else if (i4 == 270) {
                    surfaceViewForScan.c(bArr, surfaceViewForScan.f23670h, surfaceViewForScan.j, surfaceViewForScan.k);
                    i = surfaceViewForScan.k;
                    i2 = surfaceViewForScan.j;
                } else {
                    System.arraycopy(bArr, 0, surfaceViewForScan.f23670h, 0, bArr.length);
                    i = surfaceViewForScan.j;
                    i2 = surfaceViewForScan.k;
                }
                if (surfaceViewForScan.i != null) {
                    surfaceViewForScan.i.a(surfaceViewForScan.f23670h, i, i2, surfaceViewForScan.l);
                }
            }
            if (Build.VERSION.SDK_INT < 8 || surfaceViewForScan.f23665c == null || bArr == null) {
                return;
            }
            surfaceViewForScan.f23665c.addCallbackBuffer(bArr);
        }
    }

    public SurfaceViewForScan(Context context) {
        this(context, null, 0);
    }

    private int a(int i, int i2, int i3) {
        return i > i3 ? i3 : i < i2 ? i2 : i;
    }

    public void autoFocus() {
        Camera.Parameters parameters;
        try {
            if (this.f23665c != null && (parameters = this.f23665c.getParameters()) != null && parameters.getSupportedFocusModes() != null && parameters.getFocusMode() != null && parameters.getSupportedFocusModes().contains("auto") && parameters.getFocusMode().equals("auto")) {
                this.f23665c.autoFocus(null);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public IdCardActivity getAttachedActivity() {
        return this.u;
    }

    public Camera getCamera() {
        return this.f23665c;
    }

    public int getCameraID() {
        return this.f23667e;
    }

    public Camera.PictureCallback getPictureCallback() {
        return this.q;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        pointFocus(motionEvent.getX(), motionEvent.getY());
        return super.onTouchEvent(motionEvent);
    }

    public void pointFocus(float f2, float f3) {
        Camera.Parameters parameters;
        try {
            if (this.f23665c != null && (parameters = this.f23665c.getParameters()) != null && parameters.getSupportedFocusModes() != null && parameters.getFocusMode() != null && parameters.getSupportedFocusModes().contains("auto") && parameters.getFocusMode().equals("auto")) {
                ArrayList arrayList = new ArrayList();
                int a2 = a((int) (((f2 / getWidth()) * 2000.0f) - 1000.0f), -1000, getWidth() - this.s);
                int a3 = a((int) (((f3 / getHeight()) * 2000.0f) - 1000.0f), -1000, getHeight() - this.s);
                String str = TAG;
                LogUtil.d(str, "getWidth()" + getWidth() + "getHeight()" + getHeight());
                String str2 = TAG;
                LogUtil.d(str2, CustomDialogData.POS_LEFT + a2 + "top" + a3);
                arrayList.add(new Camera.Area(new Rect(a2, a3, this.s + a2, this.s + a3), 1000));
                this.f23665c.cancelAutoFocus();
                parameters.setFocusMode("auto");
                parameters.setFocusAreas(arrayList);
                this.f23665c.setParameters(parameters);
                this.f23665c.autoFocus(this.v);
            }
        } catch (Exception unused) {
            autoFocus();
        }
    }

    public void releaseSource() {
        try {
            if (this.f23665c != null) {
                this.f23665c.setPreviewCallbackWithBuffer(null);
                this.f23665c.setPreviewCallback(null);
                this.f23665c.stopPreview();
                this.f23665c.release();
                this.f23665c = null;
            }
            if (this.m == null || this.m.f23674a == null) {
                return;
            }
            this.m.f23674a.getLooper().quit();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void setAttachedActivity(IdCardActivity idCardActivity) {
        this.u = idCardActivity;
    }

    public void setAutoFocusCallback(Camera.AutoFocusCallback autoFocusCallback) {
        this.v = autoFocusCallback;
    }

    public void setPictureCallback(Camera.PictureCallback pictureCallback) {
        this.q = pictureCallback;
    }

    public void setPreviewCallback(a aVar) {
        this.i = aVar;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (surfaceHolder.getSurface() == null) {
            return;
        }
        try {
            if (this.f23665c != null) {
                this.f23665c.stopPreview();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            b();
            if (this.f23665c != null) {
                this.f23665c.setPreviewDisplay(surfaceHolder);
                this.f23665c.startPreview();
                autoFocus();
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        a();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Handler handler;
        Camera camera = this.f23665c;
        if (camera != null) {
            camera.release();
        }
        b bVar = this.m;
        if (bVar == null || (handler = bVar.f23674a) == null) {
            return;
        }
        handler.getLooper().quit();
    }

    public void switchCamera() {
        SurfaceHolder surfaceHolder = this.f23668f;
        if (surfaceHolder == null || surfaceHolder.getSurface() == null) {
            return;
        }
        if (this.o == 1) {
            this.o = 0;
        } else {
            this.o = 1;
        }
        try {
            releaseSource();
            a();
            b();
            this.f23665c.setPreviewDisplay(this.f23668f);
            this.f23665c.startPreview();
            autoFocus();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void takePicture() {
        Camera camera;
        Camera.PictureCallback pictureCallback;
        if (this.p != 0 || (camera = this.f23665c) == null || (pictureCallback = this.q) == null) {
            return;
        }
        camera.takePicture(null, null, pictureCallback);
    }

    public SurfaceViewForScan(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SurfaceViewForScan(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f23669g = new byte[4];
        this.o = 0;
        this.p = 1;
        this.q = null;
        this.r = null;
        this.s = 100;
        a(context, attributeSet, i);
    }

    private void a(Context context, AttributeSet attributeSet, int i) {
        this.r = context;
        this.o = 1;
        this.p = 1;
        try {
            com.baidu.wallet.base.iddetect.a a2 = com.baidu.wallet.base.iddetect.utils.b.a(context, 1, false);
            this.t = a2;
            if (a2 != null) {
                f23664b = a2.f23640a;
                f23663a = a2.f23641b;
            } else {
                IdCardActivity idCardActivity = this.u;
                if (idCardActivity != null) {
                    idCardActivity.dialogPermission();
                    return;
                }
            }
            SurfaceHolder holder = getHolder();
            this.f23668f = holder;
            holder.addCallback(this);
            this.f23668f.setType(3);
        } catch (Exception e2) {
            String simpleName = SurfaceViewForScan.class.getSimpleName();
            LogUtil.errord(simpleName, "init fail exception = " + e2.getMessage());
            throw e2;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:48|(7:(1:(0)(1:67))(1:68)|53|54|55|(1:57)|59|(2:61|62)(2:63|64))|69|53|54|55|(0)|59|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0083, code lost:
        if (r1 != 3) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x014d, code lost:
        if (r0 != 3) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x01f9, code lost:
        if (r0 != 3) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x022d, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x022e, code lost:
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00ef A[LOOP:0: B:19:0x00ed->B:20:0x00ef, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x019f A[LOOP:1: B:36:0x019d->B:37:0x019f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x021d A[Catch: Exception -> 0x022d, TRY_LEAVE, TryCatch #0 {Exception -> 0x022d, blocks: (B:51:0x0209, B:53:0x021d), top: B:62:0x0209 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x026e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b() {
        Method method;
        if (this.f23665c == null) {
            return;
        }
        b bVar = new b();
        this.m = bVar;
        bVar.start();
        String str = TAG;
        LogUtil.i(str, "FRAME_WIDTH = " + f23664b + ";FRAME_HEIGHT=" + f23663a);
        int i = Build.VERSION.SDK_INT;
        int i2 = 270;
        int i3 = 0;
        if (i >= 9) {
            Camera.Parameters parameters = this.f23665c.getParameters();
            this.f23666d = parameters;
            parameters.setPreviewFormat(17);
            this.f23666d.setPreviewSize(f23664b, f23663a);
            this.f23665c.setParameters(this.f23666d);
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(this.f23667e, cameraInfo);
            int rotation = ((Activity) getContext()).getWindowManager().getDefaultDisplay().getRotation();
            if (rotation != 0) {
                if (rotation == 1) {
                    i2 = 90;
                } else if (rotation == 2) {
                    i2 = 180;
                }
                if (cameraInfo.facing != 1) {
                    int i4 = (cameraInfo.orientation + i2) % 360;
                    this.n = i4;
                    this.n = (360 - i4) % 360;
                } else {
                    this.n = ((cameraInfo.orientation - i2) + 360) % 360;
                }
                this.f23665c.setDisplayOrientation(this.n);
                this.k = this.f23666d.getPreviewSize().height;
                this.j = this.f23666d.getPreviewSize().width;
                this.l = this.f23666d.getPreviewFormat();
                int bitsPerPixel = (int) ((((this.k * 1) * this.j) * ImageFormat.getBitsPerPixel(this.f23665c.getParameters().getPreviewFormat())) / 8);
                this.f23670h = new byte[bitsPerPixel];
                while (i3 < 4) {
                    byte[][] bArr = this.f23669g;
                    bArr[i3] = new byte[bitsPerPixel];
                    this.f23665c.addCallbackBuffer(bArr[i3]);
                    i3++;
                }
                if (this.p != 1) {
                    this.f23665c.setPreviewCallbackWithBuffer(new Camera.PreviewCallback() { // from class: com.baidu.wallet.base.iddetect.view.SurfaceViewForScan.1
                        @Override // android.hardware.Camera.PreviewCallback
                        public void onPreviewFrame(byte[] bArr2, Camera camera) {
                            Message message = new Message();
                            message.obj = bArr2;
                            SurfaceViewForScan.this.m.f23674a.sendMessage(message);
                        }
                    });
                    return;
                } else {
                    this.f23665c.setPreviewCallbackWithBuffer(null);
                    return;
                }
            }
            i2 = 0;
            if (cameraInfo.facing != 1) {
            }
            this.f23665c.setDisplayOrientation(this.n);
            this.k = this.f23666d.getPreviewSize().height;
            this.j = this.f23666d.getPreviewSize().width;
            this.l = this.f23666d.getPreviewFormat();
            int bitsPerPixel2 = (int) ((((this.k * 1) * this.j) * ImageFormat.getBitsPerPixel(this.f23665c.getParameters().getPreviewFormat())) / 8);
            this.f23670h = new byte[bitsPerPixel2];
            while (i3 < 4) {
            }
            if (this.p != 1) {
            }
        } else if (i == 8) {
            Camera.Parameters parameters2 = this.f23665c.getParameters();
            this.f23666d = parameters2;
            parameters2.setPreviewFormat(17);
            this.f23666d.setPreviewSize(f23664b, f23663a);
            this.f23665c.setParameters(this.f23666d);
            int orientation = ((Activity) getContext()).getWindowManager().getDefaultDisplay().getOrientation();
            if (orientation != 0) {
                if (orientation == 1) {
                    i2 = 90;
                } else if (orientation == 2) {
                    i2 = 180;
                }
                int i5 = ((90 - i2) + 360) % 360;
                this.n = i5;
                this.f23665c.setDisplayOrientation(i5);
                this.k = this.f23666d.getPreviewSize().height;
                this.j = this.f23666d.getPreviewSize().width;
                this.l = this.f23666d.getPreviewFormat();
                int bitsPerPixel3 = (int) (((this.k * this.j) * ImageFormat.getBitsPerPixel(this.f23665c.getParameters().getPreviewFormat())) / 8);
                this.f23670h = new byte[bitsPerPixel3];
                while (i3 < 4) {
                    byte[][] bArr2 = this.f23669g;
                    bArr2[i3] = new byte[bitsPerPixel3];
                    this.f23665c.addCallbackBuffer(bArr2[i3]);
                    i3++;
                }
                if (this.p != 1) {
                    this.f23665c.setPreviewCallbackWithBuffer(new Camera.PreviewCallback() { // from class: com.baidu.wallet.base.iddetect.view.SurfaceViewForScan.2
                        @Override // android.hardware.Camera.PreviewCallback
                        public void onPreviewFrame(byte[] bArr3, Camera camera) {
                            Message message = new Message();
                            message.obj = bArr3;
                            SurfaceViewForScan.this.m.f23674a.sendMessage(message);
                        }
                    });
                    return;
                } else {
                    this.f23665c.setPreviewCallbackWithBuffer(null);
                    return;
                }
            }
            i2 = 0;
            int i52 = ((90 - i2) + 360) % 360;
            this.n = i52;
            this.f23665c.setDisplayOrientation(i52);
            this.k = this.f23666d.getPreviewSize().height;
            this.j = this.f23666d.getPreviewSize().width;
            this.l = this.f23666d.getPreviewFormat();
            int bitsPerPixel32 = (int) (((this.k * this.j) * ImageFormat.getBitsPerPixel(this.f23665c.getParameters().getPreviewFormat())) / 8);
            this.f23670h = new byte[bitsPerPixel32];
            while (i3 < 4) {
            }
            if (this.p != 1) {
            }
        } else {
            Camera.Parameters parameters3 = this.f23665c.getParameters();
            this.f23666d = parameters3;
            parameters3.setPreviewFormat(17);
            this.f23666d.setPreviewSize(f23664b, f23663a);
            this.f23665c.setParameters(this.f23666d);
            int orientation2 = ((Activity) getContext()).getWindowManager().getDefaultDisplay().getOrientation();
            if (orientation2 != 0) {
                if (orientation2 == 1) {
                    i2 = 90;
                } else if (orientation2 == 2) {
                    i2 = 180;
                }
                this.n = ((90 - i2) + 360) % 360;
                method = this.f23665c.getClass().getMethod("setDisplayOrientation", Integer.TYPE);
                if (method != null) {
                    method.invoke(this.f23665c, Integer.valueOf(this.n));
                }
                this.k = this.f23666d.getPreviewSize().height;
                this.j = this.f23666d.getPreviewSize().width;
                this.l = this.f23666d.getPreviewFormat();
                this.f23670h = new byte[(int) (((this.k * this.j) * 12) / 8)];
                if (this.p != 1) {
                    this.f23665c.setPreviewCallback(new Camera.PreviewCallback() { // from class: com.baidu.wallet.base.iddetect.view.SurfaceViewForScan.3
                        @Override // android.hardware.Camera.PreviewCallback
                        public void onPreviewFrame(byte[] bArr3, Camera camera) {
                            Message message = new Message();
                            message.obj = bArr3;
                            SurfaceViewForScan.this.m.f23674a.sendMessage(message);
                        }
                    });
                    return;
                } else {
                    this.f23665c.setPreviewCallback(null);
                    return;
                }
            }
            i2 = 0;
            this.n = ((90 - i2) + 360) % 360;
            method = this.f23665c.getClass().getMethod("setDisplayOrientation", Integer.TYPE);
            if (method != null) {
            }
            this.k = this.f23666d.getPreviewSize().height;
            this.j = this.f23666d.getPreviewSize().width;
            this.l = this.f23666d.getPreviewFormat();
            this.f23670h = new byte[(int) (((this.k * this.j) * 12) / 8)];
            if (this.p != 1) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(byte[] bArr, byte[] bArr2, int i, int i2) {
        int i3 = i - 1;
        int i4 = 0;
        for (int i5 = i3; i5 >= 0; i5--) {
            for (int i6 = 0; i6 < i2; i6++) {
                bArr2[i4] = bArr[(i6 * i) + i5];
                i4++;
            }
        }
        int i7 = i * i2;
        int i8 = i7;
        while (i3 > 0) {
            for (int i9 = 0; i9 < i2 / 2; i9++) {
                int i10 = (i9 * i) + i7;
                bArr2[i8] = bArr[(i3 - 1) + i10];
                int i11 = i8 + 1;
                bArr2[i11] = bArr[i10 + i3];
                i8 = i11 + 1;
            }
            i3 -= 2;
        }
        return true;
    }

    private void a() {
        IdCardActivity idCardActivity;
        if (Build.VERSION.SDK_INT >= 9) {
            try {
                try {
                    if (this.o == 1) {
                        this.f23665c = Camera.open(0);
                        this.f23667e = 0;
                    } else {
                        this.f23665c = Camera.open(1);
                        this.f23667e = 1;
                    }
                } catch (Exception unused) {
                    this.f23665c = Camera.open();
                    this.f23667e = 0;
                }
            } catch (Exception unused2) {
                this.f23665c = null;
                this.f23667e = -1;
            }
        } else {
            try {
                this.f23665c = Camera.open();
            } catch (Exception unused3) {
                this.f23665c = null;
                this.f23667e = -1;
            }
        }
        if (this.f23665c != null || (idCardActivity = this.u) == null) {
            return;
        }
        idCardActivity.dialogPermission();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(byte[] bArr, byte[] bArr2, int i, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            for (int i5 = i2 - 1; i5 >= 0; i5--) {
                bArr2[i3] = bArr[(i5 * i) + i4];
                i3++;
            }
        }
        int i6 = i * i2;
        int i7 = ((i6 * 3) / 2) - 1;
        for (int i8 = i - 1; i8 > 0; i8 -= 2) {
            for (int i9 = 0; i9 < i2 / 2; i9++) {
                int i10 = (i9 * i) + i6;
                bArr2[i7] = bArr[i10 + i8];
                int i11 = i7 - 1;
                bArr2[i11] = bArr[i10 + (i8 - 1)];
                i7 = i11 - 1;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(byte[] bArr, byte[] bArr2, int i, int i2) {
        int i3 = i * i2;
        int i4 = 0;
        for (int i5 = i3 - 1; i5 >= 0; i5--) {
            bArr2[i4] = bArr[i5];
            i4++;
        }
        for (int i6 = ((i3 * 3) / 2) - 1; i6 >= i3; i6 -= 2) {
            int i7 = i4 + 1;
            bArr2[i4] = bArr[i6 - 1];
            i4 = i7 + 1;
            bArr2[i7] = bArr[i6];
        }
        return true;
    }
}
