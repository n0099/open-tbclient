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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.iddetect.IdCardActivity;
import com.baidu.wallet.core.utils.LogUtil;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import kotlinx.coroutines.DebugKt;
/* loaded from: classes5.dex */
public class SurfaceViewForScan extends SurfaceView implements SurfaceHolder.Callback {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CAMERA_BACK = 1;
    public static final int CAMERA_FRONT = 0;
    public static final int MODE_NORMAL = 0;
    public static final int MODE_TRACKER = 1;
    public static final String TAG;

    /* renamed from: a  reason: collision with root package name */
    public static int f24090a;

    /* renamed from: b  reason: collision with root package name */
    public static int f24091b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public Camera f24092c;

    /* renamed from: d  reason: collision with root package name */
    public Camera.Parameters f24093d;

    /* renamed from: e  reason: collision with root package name */
    public int f24094e;

    /* renamed from: f  reason: collision with root package name */
    public SurfaceHolder f24095f;

    /* renamed from: g  reason: collision with root package name */
    public byte[][] f24096g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f24097h;

    /* renamed from: i  reason: collision with root package name */
    public a f24098i;
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
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Handler f24102a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SurfaceViewForScan f24103b;

        public b(SurfaceViewForScan surfaceViewForScan) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {surfaceViewForScan};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24103b = surfaceViewForScan;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Looper.prepare();
                this.f24102a = new c(this.f24103b);
                Looper.loop();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<SurfaceViewForScan> f24104a;

        /* renamed from: b  reason: collision with root package name */
        public long f24105b;

        public c(SurfaceViewForScan surfaceViewForScan) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {surfaceViewForScan};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24105b = System.currentTimeMillis();
            this.f24104a = new WeakReference<>(surfaceViewForScan);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            SurfaceViewForScan surfaceViewForScan;
            int i2;
            int i3;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, message) == null) || (surfaceViewForScan = this.f24104a.get()) == null) {
                return;
            }
            byte[] bArr = (byte[]) message.obj;
            if (System.currentTimeMillis() - this.f24105b > 200) {
                this.f24105b = System.currentTimeMillis();
                int i4 = surfaceViewForScan.n;
                if (surfaceViewForScan.o == 1) {
                    i4 += 180;
                }
                int i5 = 360 - i4;
                if (i5 == 0) {
                    System.arraycopy(bArr, 0, surfaceViewForScan.f24097h, 0, bArr.length);
                    i2 = surfaceViewForScan.j;
                    i3 = surfaceViewForScan.k;
                } else if (i5 == 90) {
                    surfaceViewForScan.a(bArr, surfaceViewForScan.f24097h, surfaceViewForScan.j, surfaceViewForScan.k);
                    i2 = surfaceViewForScan.k;
                    i3 = surfaceViewForScan.j;
                } else if (i5 == 180) {
                    surfaceViewForScan.b(bArr, surfaceViewForScan.f24097h, surfaceViewForScan.j, surfaceViewForScan.k);
                    i2 = surfaceViewForScan.j;
                    i3 = surfaceViewForScan.k;
                } else if (i5 == 270) {
                    surfaceViewForScan.c(bArr, surfaceViewForScan.f24097h, surfaceViewForScan.j, surfaceViewForScan.k);
                    i2 = surfaceViewForScan.k;
                    i3 = surfaceViewForScan.j;
                } else {
                    System.arraycopy(bArr, 0, surfaceViewForScan.f24097h, 0, bArr.length);
                    i2 = surfaceViewForScan.j;
                    i3 = surfaceViewForScan.k;
                }
                if (surfaceViewForScan.f24098i != null) {
                    surfaceViewForScan.f24098i.a(surfaceViewForScan.f24097h, i2, i3, surfaceViewForScan.l);
                }
            }
            if (Build.VERSION.SDK_INT < 8 || surfaceViewForScan.f24092c == null || bArr == null) {
                return;
            }
            surfaceViewForScan.f24092c.addCallbackBuffer(bArr);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(409988824, "Lcom/baidu/wallet/base/iddetect/view/SurfaceViewForScan;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(409988824, "Lcom/baidu/wallet/base/iddetect/view/SurfaceViewForScan;");
                return;
            }
        }
        TAG = SurfaceViewForScan.class.getSimpleName();
        f24090a = 720;
        f24091b = 960;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SurfaceViewForScan(Context context) {
        this(context, null, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private int a(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIII = interceptable.invokeIII(InputDeviceCompat.SOURCE_TRACKBALL, this, i2, i3, i4)) == null) ? i2 > i4 ? i4 : i2 < i3 ? i3 : i2 : invokeIII.intValue;
    }

    public void autoFocus() {
        Camera.Parameters parameters;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                if (this.f24092c != null && (parameters = this.f24092c.getParameters()) != null && parameters.getSupportedFocusModes() != null && parameters.getFocusMode() != null && parameters.getSupportedFocusModes().contains(DebugKt.DEBUG_PROPERTY_VALUE_AUTO) && parameters.getFocusMode().equals(DebugKt.DEBUG_PROPERTY_VALUE_AUTO)) {
                    this.f24092c.autoFocus(null);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public IdCardActivity getAttachedActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.u : (IdCardActivity) invokeV.objValue;
    }

    public Camera getCamera() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f24092c : (Camera) invokeV.objValue;
    }

    public int getCameraID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f24094e : invokeV.intValue;
    }

    public Camera.PictureCallback getPictureCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.q : (Camera.PictureCallback) invokeV.objValue;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, motionEvent)) == null) {
            pointFocus(motionEvent.getX(), motionEvent.getY());
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void pointFocus(float f2, float f3) {
        Camera.Parameters parameters;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            try {
                if (this.f24092c != null && (parameters = this.f24092c.getParameters()) != null && parameters.getSupportedFocusModes() != null && parameters.getFocusMode() != null && parameters.getSupportedFocusModes().contains(DebugKt.DEBUG_PROPERTY_VALUE_AUTO) && parameters.getFocusMode().equals(DebugKt.DEBUG_PROPERTY_VALUE_AUTO)) {
                    ArrayList arrayList = new ArrayList();
                    int a2 = a((int) (((f2 / getWidth()) * 2000.0f) - 1000.0f), -1000, getWidth() - this.s);
                    int a3 = a((int) (((f3 / getHeight()) * 2000.0f) - 1000.0f), -1000, getHeight() - this.s);
                    String str = TAG;
                    LogUtil.d(str, "getWidth()" + getWidth() + "getHeight()" + getHeight());
                    String str2 = TAG;
                    LogUtil.d(str2, CustomDialogData.POS_LEFT + a2 + "top" + a3);
                    arrayList.add(new Camera.Area(new Rect(a2, a3, this.s + a2, this.s + a3), 1000));
                    this.f24092c.cancelAutoFocus();
                    parameters.setFocusMode(DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
                    parameters.setFocusAreas(arrayList);
                    this.f24092c.setParameters(parameters);
                    this.f24092c.autoFocus(this.v);
                }
            } catch (Exception unused) {
                autoFocus();
            }
        }
    }

    public void releaseSource() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            try {
                if (this.f24092c != null) {
                    this.f24092c.setPreviewCallbackWithBuffer(null);
                    this.f24092c.setPreviewCallback(null);
                    this.f24092c.stopPreview();
                    this.f24092c.release();
                    this.f24092c = null;
                }
                if (this.m == null || this.m.f24102a == null) {
                    return;
                }
                this.m.f24102a.getLooper().quit();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void setAttachedActivity(IdCardActivity idCardActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, idCardActivity) == null) {
            this.u = idCardActivity;
        }
    }

    public void setAutoFocusCallback(Camera.AutoFocusCallback autoFocusCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, autoFocusCallback) == null) {
            this.v = autoFocusCallback;
        }
    }

    public void setPictureCallback(Camera.PictureCallback pictureCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, pictureCallback) == null) {
            this.q = pictureCallback;
        }
    }

    public void setPreviewCallback(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) {
            this.f24098i = aVar;
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIII(1048588, this, surfaceHolder, i2, i3, i4) == null) || surfaceHolder.getSurface() == null) {
            return;
        }
        try {
            if (this.f24092c != null) {
                this.f24092c.stopPreview();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            b();
            if (this.f24092c != null) {
                this.f24092c.setPreviewDisplay(surfaceHolder);
                this.f24092c.startPreview();
                autoFocus();
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, surfaceHolder) == null) {
            a();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Handler handler;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, surfaceHolder) == null) {
            Camera camera = this.f24092c;
            if (camera != null) {
                camera.release();
            }
            b bVar = this.m;
            if (bVar == null || (handler = bVar.f24102a) == null) {
                return;
            }
            handler.getLooper().quit();
        }
    }

    public void switchCamera() {
        SurfaceHolder surfaceHolder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (surfaceHolder = this.f24095f) == null || surfaceHolder.getSurface() == null) {
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
            this.f24092c.setPreviewDisplay(this.f24095f);
            this.f24092c.startPreview();
            autoFocus();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void takePicture() {
        Camera camera;
        Camera.PictureCallback pictureCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || this.p != 0 || (camera = this.f24092c) == null || (pictureCallback = this.q) == null) {
            return;
        }
        camera.takePicture(null, null, pictureCallback);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SurfaceViewForScan(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SurfaceViewForScan(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f24096g = new byte[4];
        this.o = 0;
        this.p = 1;
        this.q = null;
        this.r = null;
        this.s = 100;
        a(context, attributeSet, i2);
    }

    private void a(Context context, AttributeSet attributeSet, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65543, this, context, attributeSet, i2) == null) {
            this.r = context;
            this.o = 1;
            this.p = 1;
            try {
                com.baidu.wallet.base.iddetect.a a2 = com.baidu.wallet.base.iddetect.utils.b.a(context, 1, false);
                this.t = a2;
                if (a2 != null) {
                    f24091b = a2.f24066a;
                    f24090a = a2.f24067b;
                } else {
                    IdCardActivity idCardActivity = this.u;
                    if (idCardActivity != null) {
                        idCardActivity.dialogPermission();
                        return;
                    }
                }
                SurfaceHolder holder = getHolder();
                this.f24095f = holder;
                holder.addCallback(this);
                this.f24095f.setType(3);
            } catch (Exception e2) {
                String simpleName = SurfaceViewForScan.class.getSimpleName();
                LogUtil.errord(simpleName, "init fail exception = " + e2.getMessage());
                throw e2;
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:50|(7:(1:(0)(1:69))(1:70)|55|56|57|(1:59)|61|(2:63|64)(2:65|66))|71|55|56|57|(0)|61|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0087, code lost:
        if (r1 != 3) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0151, code lost:
        if (r0 != 3) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x01fd, code lost:
        if (r0 != 3) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0232, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0233, code lost:
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00f3 A[LOOP:0: B:21:0x00f1->B:22:0x00f3, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01a3 A[LOOP:1: B:38:0x01a1->B:39:0x01a3, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0222 A[Catch: Exception -> 0x0232, TRY_LEAVE, TryCatch #0 {Exception -> 0x0232, blocks: (B:53:0x020d, B:55:0x0222), top: B:67:0x020d }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0273  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b() {
        Method method;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65547, this) == null) || this.f24092c == null) {
            return;
        }
        b bVar = new b(this);
        this.m = bVar;
        bVar.start();
        String str = TAG;
        LogUtil.i(str, "FRAME_WIDTH = " + f24091b + ";FRAME_HEIGHT=" + f24090a);
        int i2 = Build.VERSION.SDK_INT;
        int i3 = 270;
        int i4 = 0;
        if (i2 >= 9) {
            Camera.Parameters parameters = this.f24092c.getParameters();
            this.f24093d = parameters;
            parameters.setPreviewFormat(17);
            this.f24093d.setPreviewSize(f24091b, f24090a);
            this.f24092c.setParameters(this.f24093d);
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(this.f24094e, cameraInfo);
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
                this.f24092c.setDisplayOrientation(this.n);
                this.k = this.f24093d.getPreviewSize().height;
                this.j = this.f24093d.getPreviewSize().width;
                this.l = this.f24093d.getPreviewFormat();
                int bitsPerPixel = (int) ((((this.k * 1) * this.j) * ImageFormat.getBitsPerPixel(this.f24092c.getParameters().getPreviewFormat())) / 8);
                this.f24097h = new byte[bitsPerPixel];
                while (i4 < 4) {
                    byte[][] bArr = this.f24096g;
                    bArr[i4] = new byte[bitsPerPixel];
                    this.f24092c.addCallbackBuffer(bArr[i4]);
                    i4++;
                }
                if (this.p != 1) {
                    this.f24092c.setPreviewCallbackWithBuffer(new Camera.PreviewCallback(this) { // from class: com.baidu.wallet.base.iddetect.view.SurfaceViewForScan.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ SurfaceViewForScan f24099a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i6 = newInitContext.flag;
                                if ((i6 & 1) != 0) {
                                    int i7 = i6 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f24099a = this;
                        }

                        @Override // android.hardware.Camera.PreviewCallback
                        public void onPreviewFrame(byte[] bArr2, Camera camera) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLL(1048576, this, bArr2, camera) == null) {
                                Message message = new Message();
                                message.obj = bArr2;
                                this.f24099a.m.f24102a.sendMessage(message);
                            }
                        }
                    });
                    return;
                } else {
                    this.f24092c.setPreviewCallbackWithBuffer(null);
                    return;
                }
            }
            i3 = 0;
            if (cameraInfo.facing != 1) {
            }
            this.f24092c.setDisplayOrientation(this.n);
            this.k = this.f24093d.getPreviewSize().height;
            this.j = this.f24093d.getPreviewSize().width;
            this.l = this.f24093d.getPreviewFormat();
            int bitsPerPixel2 = (int) ((((this.k * 1) * this.j) * ImageFormat.getBitsPerPixel(this.f24092c.getParameters().getPreviewFormat())) / 8);
            this.f24097h = new byte[bitsPerPixel2];
            while (i4 < 4) {
            }
            if (this.p != 1) {
            }
        } else if (i2 == 8) {
            Camera.Parameters parameters2 = this.f24092c.getParameters();
            this.f24093d = parameters2;
            parameters2.setPreviewFormat(17);
            this.f24093d.setPreviewSize(f24091b, f24090a);
            this.f24092c.setParameters(this.f24093d);
            int orientation = ((Activity) getContext()).getWindowManager().getDefaultDisplay().getOrientation();
            if (orientation != 0) {
                if (orientation == 1) {
                    i3 = 90;
                } else if (orientation == 2) {
                    i3 = 180;
                }
                int i6 = ((90 - i3) + 360) % 360;
                this.n = i6;
                this.f24092c.setDisplayOrientation(i6);
                this.k = this.f24093d.getPreviewSize().height;
                this.j = this.f24093d.getPreviewSize().width;
                this.l = this.f24093d.getPreviewFormat();
                int bitsPerPixel3 = (int) (((this.k * this.j) * ImageFormat.getBitsPerPixel(this.f24092c.getParameters().getPreviewFormat())) / 8);
                this.f24097h = new byte[bitsPerPixel3];
                while (i4 < 4) {
                    byte[][] bArr2 = this.f24096g;
                    bArr2[i4] = new byte[bitsPerPixel3];
                    this.f24092c.addCallbackBuffer(bArr2[i4]);
                    i4++;
                }
                if (this.p != 1) {
                    this.f24092c.setPreviewCallbackWithBuffer(new Camera.PreviewCallback(this) { // from class: com.baidu.wallet.base.iddetect.view.SurfaceViewForScan.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ SurfaceViewForScan f24100a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i7 = newInitContext.flag;
                                if ((i7 & 1) != 0) {
                                    int i8 = i7 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f24100a = this;
                        }

                        @Override // android.hardware.Camera.PreviewCallback
                        public void onPreviewFrame(byte[] bArr3, Camera camera) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLL(1048576, this, bArr3, camera) == null) {
                                Message message = new Message();
                                message.obj = bArr3;
                                this.f24100a.m.f24102a.sendMessage(message);
                            }
                        }
                    });
                    return;
                } else {
                    this.f24092c.setPreviewCallbackWithBuffer(null);
                    return;
                }
            }
            i3 = 0;
            int i62 = ((90 - i3) + 360) % 360;
            this.n = i62;
            this.f24092c.setDisplayOrientation(i62);
            this.k = this.f24093d.getPreviewSize().height;
            this.j = this.f24093d.getPreviewSize().width;
            this.l = this.f24093d.getPreviewFormat();
            int bitsPerPixel32 = (int) (((this.k * this.j) * ImageFormat.getBitsPerPixel(this.f24092c.getParameters().getPreviewFormat())) / 8);
            this.f24097h = new byte[bitsPerPixel32];
            while (i4 < 4) {
            }
            if (this.p != 1) {
            }
        } else {
            Camera.Parameters parameters3 = this.f24092c.getParameters();
            this.f24093d = parameters3;
            parameters3.setPreviewFormat(17);
            this.f24093d.setPreviewSize(f24091b, f24090a);
            this.f24092c.setParameters(this.f24093d);
            int orientation2 = ((Activity) getContext()).getWindowManager().getDefaultDisplay().getOrientation();
            if (orientation2 != 0) {
                if (orientation2 == 1) {
                    i3 = 90;
                } else if (orientation2 == 2) {
                    i3 = 180;
                }
                this.n = ((90 - i3) + 360) % 360;
                method = this.f24092c.getClass().getMethod("setDisplayOrientation", Integer.TYPE);
                if (method != null) {
                    method.invoke(this.f24092c, Integer.valueOf(this.n));
                }
                this.k = this.f24093d.getPreviewSize().height;
                this.j = this.f24093d.getPreviewSize().width;
                this.l = this.f24093d.getPreviewFormat();
                this.f24097h = new byte[(int) (((this.k * this.j) * 12) / 8)];
                if (this.p != 1) {
                    this.f24092c.setPreviewCallback(new Camera.PreviewCallback(this) { // from class: com.baidu.wallet.base.iddetect.view.SurfaceViewForScan.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ SurfaceViewForScan f24101a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i7 = newInitContext.flag;
                                if ((i7 & 1) != 0) {
                                    int i8 = i7 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f24101a = this;
                        }

                        @Override // android.hardware.Camera.PreviewCallback
                        public void onPreviewFrame(byte[] bArr3, Camera camera) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLL(1048576, this, bArr3, camera) == null) {
                                Message message = new Message();
                                message.obj = bArr3;
                                this.f24101a.m.f24102a.sendMessage(message);
                            }
                        }
                    });
                    return;
                } else {
                    this.f24092c.setPreviewCallback(null);
                    return;
                }
            }
            i3 = 0;
            this.n = ((90 - i3) + 360) % 360;
            method = this.f24092c.getClass().getMethod("setDisplayOrientation", Integer.TYPE);
            if (method != null) {
            }
            this.k = this.f24093d.getPreviewSize().height;
            this.j = this.f24093d.getPreviewSize().width;
            this.l = this.f24093d.getPreviewFormat();
            this.f24097h = new byte[(int) (((this.k * this.j) * 12) / 8)];
            if (this.p != 1) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(byte[] bArr, byte[] bArr2, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65551, this, bArr, bArr2, i2, i3)) == null) {
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
        return invokeLLII.booleanValue;
    }

    private void a() {
        IdCardActivity idCardActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            if (Build.VERSION.SDK_INT >= 9) {
                try {
                    try {
                        if (this.o == 1) {
                            this.f24092c = Camera.open(0);
                            this.f24094e = 0;
                        } else {
                            this.f24092c = Camera.open(1);
                            this.f24094e = 1;
                        }
                    } catch (Exception unused) {
                        this.f24092c = null;
                        this.f24094e = -1;
                    }
                } catch (Exception unused2) {
                    this.f24092c = Camera.open();
                    this.f24094e = 0;
                }
            } else {
                try {
                    this.f24092c = Camera.open();
                } catch (Exception unused3) {
                    this.f24092c = null;
                    this.f24094e = -1;
                }
            }
            if (this.f24092c != null || (idCardActivity = this.u) == null) {
                return;
            }
            idCardActivity.dialogPermission();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(byte[] bArr, byte[] bArr2, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65545, this, bArr, bArr2, i2, i3)) == null) {
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
        return invokeLLII.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(byte[] bArr, byte[] bArr2, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65549, this, bArr, bArr2, i2, i3)) == null) {
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
        return invokeLLII.booleanValue;
    }
}
