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
import kotlinx.coroutines.DebugKt;
/* loaded from: classes5.dex */
public class SurfaceViewForScan extends SurfaceView implements SurfaceHolder.Callback {
    public static final int CAMERA_BACK = 1;
    public static final int CAMERA_FRONT = 0;
    public static final int MODE_NORMAL = 0;
    public static final int MODE_TRACKER = 1;
    public static final String TAG = SurfaceViewForScan.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public static int f23437a = PeerConnectionClient.HD_VIDEO_HEIGHT;

    /* renamed from: b  reason: collision with root package name */
    public static int f23438b = TbConfig.HEAD_IMG_SIZE;

    /* renamed from: c  reason: collision with root package name */
    public Camera f23439c;

    /* renamed from: d  reason: collision with root package name */
    public Camera.Parameters f23440d;

    /* renamed from: e  reason: collision with root package name */
    public int f23441e;

    /* renamed from: f  reason: collision with root package name */
    public SurfaceHolder f23442f;

    /* renamed from: g  reason: collision with root package name */
    public byte[][] f23443g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f23444h;

    /* renamed from: i  reason: collision with root package name */
    public a f23445i;
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
        void a(byte[] bArr, int i2, int i3, int i4);
    }

    /* loaded from: classes5.dex */
    public class b extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public Handler f23449a;

        public b() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Looper.prepare();
            this.f23449a = new c(SurfaceViewForScan.this);
            Looper.loop();
        }
    }

    /* loaded from: classes5.dex */
    public static class c extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<SurfaceViewForScan> f23451a;

        /* renamed from: b  reason: collision with root package name */
        public long f23452b = System.currentTimeMillis();

        public c(SurfaceViewForScan surfaceViewForScan) {
            this.f23451a = new WeakReference<>(surfaceViewForScan);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2;
            int i3;
            SurfaceViewForScan surfaceViewForScan = this.f23451a.get();
            if (surfaceViewForScan == null) {
                return;
            }
            byte[] bArr = (byte[]) message.obj;
            if (System.currentTimeMillis() - this.f23452b > 200) {
                this.f23452b = System.currentTimeMillis();
                int i4 = surfaceViewForScan.n;
                if (surfaceViewForScan.o == 1) {
                    i4 += 180;
                }
                int i5 = 360 - i4;
                if (i5 == 0) {
                    System.arraycopy(bArr, 0, surfaceViewForScan.f23444h, 0, bArr.length);
                    i2 = surfaceViewForScan.j;
                    i3 = surfaceViewForScan.k;
                } else if (i5 == 90) {
                    surfaceViewForScan.a(bArr, surfaceViewForScan.f23444h, surfaceViewForScan.j, surfaceViewForScan.k);
                    i2 = surfaceViewForScan.k;
                    i3 = surfaceViewForScan.j;
                } else if (i5 == 180) {
                    surfaceViewForScan.b(bArr, surfaceViewForScan.f23444h, surfaceViewForScan.j, surfaceViewForScan.k);
                    i2 = surfaceViewForScan.j;
                    i3 = surfaceViewForScan.k;
                } else if (i5 == 270) {
                    surfaceViewForScan.c(bArr, surfaceViewForScan.f23444h, surfaceViewForScan.j, surfaceViewForScan.k);
                    i2 = surfaceViewForScan.k;
                    i3 = surfaceViewForScan.j;
                } else {
                    System.arraycopy(bArr, 0, surfaceViewForScan.f23444h, 0, bArr.length);
                    i2 = surfaceViewForScan.j;
                    i3 = surfaceViewForScan.k;
                }
                if (surfaceViewForScan.f23445i != null) {
                    surfaceViewForScan.f23445i.a(surfaceViewForScan.f23444h, i2, i3, surfaceViewForScan.l);
                }
            }
            if (Build.VERSION.SDK_INT < 8 || surfaceViewForScan.f23439c == null || bArr == null) {
                return;
            }
            surfaceViewForScan.f23439c.addCallbackBuffer(bArr);
        }
    }

    public SurfaceViewForScan(Context context) {
        this(context, null, 0);
    }

    private int a(int i2, int i3, int i4) {
        return i2 > i4 ? i4 : i2 < i3 ? i3 : i2;
    }

    public void autoFocus() {
        Camera.Parameters parameters;
        try {
            if (this.f23439c != null && (parameters = this.f23439c.getParameters()) != null && parameters.getSupportedFocusModes() != null && parameters.getFocusMode() != null && parameters.getSupportedFocusModes().contains(DebugKt.DEBUG_PROPERTY_VALUE_AUTO) && parameters.getFocusMode().equals(DebugKt.DEBUG_PROPERTY_VALUE_AUTO)) {
                this.f23439c.autoFocus(null);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public IdCardActivity getAttachedActivity() {
        return this.u;
    }

    public Camera getCamera() {
        return this.f23439c;
    }

    public int getCameraID() {
        return this.f23441e;
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
            if (this.f23439c != null && (parameters = this.f23439c.getParameters()) != null && parameters.getSupportedFocusModes() != null && parameters.getFocusMode() != null && parameters.getSupportedFocusModes().contains(DebugKt.DEBUG_PROPERTY_VALUE_AUTO) && parameters.getFocusMode().equals(DebugKt.DEBUG_PROPERTY_VALUE_AUTO)) {
                ArrayList arrayList = new ArrayList();
                int a2 = a((int) (((f2 / getWidth()) * 2000.0f) - 1000.0f), -1000, getWidth() - this.s);
                int a3 = a((int) (((f3 / getHeight()) * 2000.0f) - 1000.0f), -1000, getHeight() - this.s);
                String str = TAG;
                LogUtil.d(str, "getWidth()" + getWidth() + "getHeight()" + getHeight());
                String str2 = TAG;
                LogUtil.d(str2, CustomDialogData.POS_LEFT + a2 + "top" + a3);
                arrayList.add(new Camera.Area(new Rect(a2, a3, this.s + a2, this.s + a3), 1000));
                this.f23439c.cancelAutoFocus();
                parameters.setFocusMode(DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
                parameters.setFocusAreas(arrayList);
                this.f23439c.setParameters(parameters);
                this.f23439c.autoFocus(this.v);
            }
        } catch (Exception unused) {
            autoFocus();
        }
    }

    public void releaseSource() {
        try {
            if (this.f23439c != null) {
                this.f23439c.setPreviewCallbackWithBuffer(null);
                this.f23439c.setPreviewCallback(null);
                this.f23439c.stopPreview();
                this.f23439c.release();
                this.f23439c = null;
            }
            if (this.m == null || this.m.f23449a == null) {
                return;
            }
            this.m.f23449a.getLooper().quit();
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
        this.f23445i = aVar;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        if (surfaceHolder.getSurface() == null) {
            return;
        }
        try {
            if (this.f23439c != null) {
                this.f23439c.stopPreview();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            b();
            if (this.f23439c != null) {
                this.f23439c.setPreviewDisplay(surfaceHolder);
                this.f23439c.startPreview();
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
        Camera camera = this.f23439c;
        if (camera != null) {
            camera.release();
        }
        b bVar = this.m;
        if (bVar == null || (handler = bVar.f23449a) == null) {
            return;
        }
        handler.getLooper().quit();
    }

    public void switchCamera() {
        SurfaceHolder surfaceHolder = this.f23442f;
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
            this.f23439c.setPreviewDisplay(this.f23442f);
            this.f23439c.startPreview();
            autoFocus();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void takePicture() {
        Camera camera;
        Camera.PictureCallback pictureCallback;
        if (this.p != 0 || (camera = this.f23439c) == null || (pictureCallback = this.q) == null) {
            return;
        }
        camera.takePicture(null, null, pictureCallback);
    }

    public SurfaceViewForScan(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SurfaceViewForScan(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f23443g = new byte[4];
        this.o = 0;
        this.p = 1;
        this.q = null;
        this.r = null;
        this.s = 100;
        a(context, attributeSet, i2);
    }

    private void a(Context context, AttributeSet attributeSet, int i2) {
        this.r = context;
        this.o = 1;
        this.p = 1;
        try {
            com.baidu.wallet.base.iddetect.a a2 = com.baidu.wallet.base.iddetect.utils.b.a(context, 1, false);
            this.t = a2;
            if (a2 != null) {
                f23438b = a2.f23413a;
                f23437a = a2.f23414b;
            } else {
                IdCardActivity idCardActivity = this.u;
                if (idCardActivity != null) {
                    idCardActivity.dialogPermission();
                    return;
                }
            }
            SurfaceHolder holder = getHolder();
            this.f23442f = holder;
            holder.addCallback(this);
            this.f23442f.setType(3);
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
        if (this.f23439c == null) {
            return;
        }
        b bVar = new b();
        this.m = bVar;
        bVar.start();
        String str = TAG;
        LogUtil.i(str, "FRAME_WIDTH = " + f23438b + ";FRAME_HEIGHT=" + f23437a);
        int i2 = Build.VERSION.SDK_INT;
        int i3 = 270;
        int i4 = 0;
        if (i2 >= 9) {
            Camera.Parameters parameters = this.f23439c.getParameters();
            this.f23440d = parameters;
            parameters.setPreviewFormat(17);
            this.f23440d.setPreviewSize(f23438b, f23437a);
            this.f23439c.setParameters(this.f23440d);
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(this.f23441e, cameraInfo);
            int rotation = ((Activity) getContext()).getWindowManager().getDefaultDisplay().getRotation();
            if (rotation != 0) {
                if (rotation == 1) {
                    i3 = 90;
                } else if (rotation == 2) {
                    i3 = 180;
                }
                if (cameraInfo.facing != 1) {
                    int i5 = (cameraInfo.orientation + i3) % 360;
                    this.n = i5;
                    this.n = (360 - i5) % 360;
                } else {
                    this.n = ((cameraInfo.orientation - i3) + 360) % 360;
                }
                this.f23439c.setDisplayOrientation(this.n);
                this.k = this.f23440d.getPreviewSize().height;
                this.j = this.f23440d.getPreviewSize().width;
                this.l = this.f23440d.getPreviewFormat();
                int bitsPerPixel = (int) ((((this.k * 1) * this.j) * ImageFormat.getBitsPerPixel(this.f23439c.getParameters().getPreviewFormat())) / 8);
                this.f23444h = new byte[bitsPerPixel];
                while (i4 < 4) {
                    byte[][] bArr = this.f23443g;
                    bArr[i4] = new byte[bitsPerPixel];
                    this.f23439c.addCallbackBuffer(bArr[i4]);
                    i4++;
                }
                if (this.p != 1) {
                    this.f23439c.setPreviewCallbackWithBuffer(new Camera.PreviewCallback() { // from class: com.baidu.wallet.base.iddetect.view.SurfaceViewForScan.1
                        @Override // android.hardware.Camera.PreviewCallback
                        public void onPreviewFrame(byte[] bArr2, Camera camera) {
                            Message message = new Message();
                            message.obj = bArr2;
                            SurfaceViewForScan.this.m.f23449a.sendMessage(message);
                        }
                    });
                    return;
                } else {
                    this.f23439c.setPreviewCallbackWithBuffer(null);
                    return;
                }
            }
            i3 = 0;
            if (cameraInfo.facing != 1) {
            }
            this.f23439c.setDisplayOrientation(this.n);
            this.k = this.f23440d.getPreviewSize().height;
            this.j = this.f23440d.getPreviewSize().width;
            this.l = this.f23440d.getPreviewFormat();
            int bitsPerPixel2 = (int) ((((this.k * 1) * this.j) * ImageFormat.getBitsPerPixel(this.f23439c.getParameters().getPreviewFormat())) / 8);
            this.f23444h = new byte[bitsPerPixel2];
            while (i4 < 4) {
            }
            if (this.p != 1) {
            }
        } else if (i2 == 8) {
            Camera.Parameters parameters2 = this.f23439c.getParameters();
            this.f23440d = parameters2;
            parameters2.setPreviewFormat(17);
            this.f23440d.setPreviewSize(f23438b, f23437a);
            this.f23439c.setParameters(this.f23440d);
            int orientation = ((Activity) getContext()).getWindowManager().getDefaultDisplay().getOrientation();
            if (orientation != 0) {
                if (orientation == 1) {
                    i3 = 90;
                } else if (orientation == 2) {
                    i3 = 180;
                }
                int i6 = ((90 - i3) + 360) % 360;
                this.n = i6;
                this.f23439c.setDisplayOrientation(i6);
                this.k = this.f23440d.getPreviewSize().height;
                this.j = this.f23440d.getPreviewSize().width;
                this.l = this.f23440d.getPreviewFormat();
                int bitsPerPixel3 = (int) (((this.k * this.j) * ImageFormat.getBitsPerPixel(this.f23439c.getParameters().getPreviewFormat())) / 8);
                this.f23444h = new byte[bitsPerPixel3];
                while (i4 < 4) {
                    byte[][] bArr2 = this.f23443g;
                    bArr2[i4] = new byte[bitsPerPixel3];
                    this.f23439c.addCallbackBuffer(bArr2[i4]);
                    i4++;
                }
                if (this.p != 1) {
                    this.f23439c.setPreviewCallbackWithBuffer(new Camera.PreviewCallback() { // from class: com.baidu.wallet.base.iddetect.view.SurfaceViewForScan.2
                        @Override // android.hardware.Camera.PreviewCallback
                        public void onPreviewFrame(byte[] bArr3, Camera camera) {
                            Message message = new Message();
                            message.obj = bArr3;
                            SurfaceViewForScan.this.m.f23449a.sendMessage(message);
                        }
                    });
                    return;
                } else {
                    this.f23439c.setPreviewCallbackWithBuffer(null);
                    return;
                }
            }
            i3 = 0;
            int i62 = ((90 - i3) + 360) % 360;
            this.n = i62;
            this.f23439c.setDisplayOrientation(i62);
            this.k = this.f23440d.getPreviewSize().height;
            this.j = this.f23440d.getPreviewSize().width;
            this.l = this.f23440d.getPreviewFormat();
            int bitsPerPixel32 = (int) (((this.k * this.j) * ImageFormat.getBitsPerPixel(this.f23439c.getParameters().getPreviewFormat())) / 8);
            this.f23444h = new byte[bitsPerPixel32];
            while (i4 < 4) {
            }
            if (this.p != 1) {
            }
        } else {
            Camera.Parameters parameters3 = this.f23439c.getParameters();
            this.f23440d = parameters3;
            parameters3.setPreviewFormat(17);
            this.f23440d.setPreviewSize(f23438b, f23437a);
            this.f23439c.setParameters(this.f23440d);
            int orientation2 = ((Activity) getContext()).getWindowManager().getDefaultDisplay().getOrientation();
            if (orientation2 != 0) {
                if (orientation2 == 1) {
                    i3 = 90;
                } else if (orientation2 == 2) {
                    i3 = 180;
                }
                this.n = ((90 - i3) + 360) % 360;
                method = this.f23439c.getClass().getMethod("setDisplayOrientation", Integer.TYPE);
                if (method != null) {
                    method.invoke(this.f23439c, Integer.valueOf(this.n));
                }
                this.k = this.f23440d.getPreviewSize().height;
                this.j = this.f23440d.getPreviewSize().width;
                this.l = this.f23440d.getPreviewFormat();
                this.f23444h = new byte[(int) (((this.k * this.j) * 12) / 8)];
                if (this.p != 1) {
                    this.f23439c.setPreviewCallback(new Camera.PreviewCallback() { // from class: com.baidu.wallet.base.iddetect.view.SurfaceViewForScan.3
                        @Override // android.hardware.Camera.PreviewCallback
                        public void onPreviewFrame(byte[] bArr3, Camera camera) {
                            Message message = new Message();
                            message.obj = bArr3;
                            SurfaceViewForScan.this.m.f23449a.sendMessage(message);
                        }
                    });
                    return;
                } else {
                    this.f23439c.setPreviewCallback(null);
                    return;
                }
            }
            i3 = 0;
            this.n = ((90 - i3) + 360) % 360;
            method = this.f23439c.getClass().getMethod("setDisplayOrientation", Integer.TYPE);
            if (method != null) {
            }
            this.k = this.f23440d.getPreviewSize().height;
            this.j = this.f23440d.getPreviewSize().width;
            this.l = this.f23440d.getPreviewFormat();
            this.f23444h = new byte[(int) (((this.k * this.j) * 12) / 8)];
            if (this.p != 1) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(byte[] bArr, byte[] bArr2, int i2, int i3) {
        int i4 = i2 - 1;
        int i5 = 0;
        for (int i6 = i4; i6 >= 0; i6--) {
            for (int i7 = 0; i7 < i3; i7++) {
                bArr2[i5] = bArr[(i7 * i2) + i6];
                i5++;
            }
        }
        int i8 = i2 * i3;
        int i9 = i8;
        while (i4 > 0) {
            for (int i10 = 0; i10 < i3 / 2; i10++) {
                int i11 = (i10 * i2) + i8;
                bArr2[i9] = bArr[(i4 - 1) + i11];
                int i12 = i9 + 1;
                bArr2[i12] = bArr[i11 + i4];
                i9 = i12 + 1;
            }
            i4 -= 2;
        }
        return true;
    }

    private void a() {
        IdCardActivity idCardActivity;
        if (Build.VERSION.SDK_INT >= 9) {
            try {
                try {
                    if (this.o == 1) {
                        this.f23439c = Camera.open(0);
                        this.f23441e = 0;
                    } else {
                        this.f23439c = Camera.open(1);
                        this.f23441e = 1;
                    }
                } catch (Exception unused) {
                    this.f23439c = Camera.open();
                    this.f23441e = 0;
                }
            } catch (Exception unused2) {
                this.f23439c = null;
                this.f23441e = -1;
            }
        } else {
            try {
                this.f23439c = Camera.open();
            } catch (Exception unused3) {
                this.f23439c = null;
                this.f23441e = -1;
            }
        }
        if (this.f23439c != null || (idCardActivity = this.u) == null) {
            return;
        }
        idCardActivity.dialogPermission();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(byte[] bArr, byte[] bArr2, int i2, int i3) {
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            for (int i6 = i3 - 1; i6 >= 0; i6--) {
                bArr2[i4] = bArr[(i6 * i2) + i5];
                i4++;
            }
        }
        int i7 = i2 * i3;
        int i8 = ((i7 * 3) / 2) - 1;
        for (int i9 = i2 - 1; i9 > 0; i9 -= 2) {
            for (int i10 = 0; i10 < i3 / 2; i10++) {
                int i11 = (i10 * i2) + i7;
                bArr2[i8] = bArr[i11 + i9];
                int i12 = i8 - 1;
                bArr2[i12] = bArr[i11 + (i9 - 1)];
                i8 = i12 - 1;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(byte[] bArr, byte[] bArr2, int i2, int i3) {
        int i4 = i2 * i3;
        int i5 = 0;
        for (int i6 = i4 - 1; i6 >= 0; i6--) {
            bArr2[i5] = bArr[i6];
            i5++;
        }
        for (int i7 = ((i4 * 3) / 2) - 1; i7 >= i4; i7 -= 2) {
            int i8 = i5 + 1;
            bArr2[i5] = bArr[i7 - 1];
            i5 = i8 + 1;
            bArr2[i8] = bArr[i7];
        }
        return true;
    }
}
