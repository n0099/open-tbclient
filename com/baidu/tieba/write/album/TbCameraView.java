package com.baidu.tieba.write.album;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.TextureView;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.d1.k0;
import c.a.r0.d1.n0;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
/* loaded from: classes12.dex */
public class TbCameraView extends TextureView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable A;

    /* renamed from: e  reason: collision with root package name */
    public SurfaceTexture f51331e;

    /* renamed from: f  reason: collision with root package name */
    public Camera f51332f;

    /* renamed from: g  reason: collision with root package name */
    public Camera.Parameters f51333g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f51334h;

    /* renamed from: i  reason: collision with root package name */
    public String f51335i;

    /* renamed from: j  reason: collision with root package name */
    public j f51336j;

    /* renamed from: k  reason: collision with root package name */
    public int f51337k;
    public float l;
    public float m;
    public int n;
    public int o;
    public boolean p;
    public Bitmap q;
    public h r;
    public i s;
    public g t;
    public boolean u;
    public boolean v;
    public TextureView.SurfaceTextureListener w;
    public final Runnable x;
    public final Runnable y;
    public Camera.PictureCallback z;

    /* loaded from: classes12.dex */
    public class a implements TextureView.SurfaceTextureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbCameraView f51338e;

        public a(TbCameraView tbCameraView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCameraView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51338e = tbCameraView;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, surfaceTexture, i2, i3) == null) {
                this.f51338e.f51331e = surfaceTexture;
                if (!this.f51338e.v && !this.f51338e.u) {
                    boolean z = true;
                    this.f51338e.v = true;
                    TbCameraView tbCameraView = this.f51338e;
                    tbCameraView.u = (tbCameraView.s == null || !this.f51338e.s.a()) ? false : false;
                }
                if (this.f51338e.u) {
                    new Thread(this.f51338e.x).start();
                }
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, surfaceTexture)) == null) {
                new Thread(this.f51338e.y).start();
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, surfaceTexture, i2, i3) == null) {
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, surfaceTexture) == null) {
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbCameraView f51339e;

        public b(TbCameraView tbCameraView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCameraView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51339e = tbCameraView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f51339e) {
                    this.f51339e.openCamera(this.f51339e.p);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbCameraView f51340e;

        public c(TbCameraView tbCameraView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCameraView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51340e = tbCameraView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f51340e) {
                    this.f51340e.stopCamera();
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d implements Camera.PictureCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbCameraView a;

        public d(TbCameraView tbCameraView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCameraView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbCameraView;
        }

        @Override // android.hardware.Camera.PictureCallback
        public void onPictureTaken(byte[] bArr, Camera camera) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, bArr, camera) == null) || bArr == null) {
                return;
            }
            this.a.q = BitmapHelper.Bytes2Bitmap(bArr);
            if (this.a.f51332f != null) {
                this.a.f51332f.stopPreview();
            }
            this.a.f51334h = false;
            if (this.a.f51336j != null) {
                this.a.f51336j.b();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class e extends k0<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbCameraView a;

        public e(TbCameraView tbCameraView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCameraView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbCameraView;
        }

        @Override // c.a.r0.d1.k0
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a.q == null || StringUtils.isNull(this.a.f51335i)) {
                    return null;
                }
                try {
                    Bitmap rotateBitmap = this.a.getRotateBitmap(this.a.q, this.a.p ? -90 : 90);
                    if (rotateBitmap != null) {
                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(this.a.f51335i));
                        rotateBitmap.compress(Bitmap.CompressFormat.JPEG, 100, bufferedOutputStream);
                        bufferedOutputStream.flush();
                        bufferedOutputStream.close();
                        rotateBitmap.recycle();
                        c.a.d.f.m.e.a().post(this.a.A);
                        return null;
                    }
                    return null;
                } catch (Throwable th) {
                    th.printStackTrace();
                    return null;
                }
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes12.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbCameraView f51341e;

        public f(TbCameraView tbCameraView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCameraView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51341e = tbCameraView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f51341e.f51336j == null) {
                return;
            }
            this.f51341e.f51336j.a();
        }
    }

    /* loaded from: classes12.dex */
    public interface g {
        void a();
    }

    /* loaded from: classes12.dex */
    public interface h {
        void a(int i2, int i3);
    }

    /* loaded from: classes12.dex */
    public interface i {
        boolean a();
    }

    /* loaded from: classes12.dex */
    public interface j {
        void a();

        void b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f51334h = false;
        this.f51335i = null;
        this.f51337k = 0;
        this.p = false;
        this.u = false;
        this.v = false;
        this.w = new a(this);
        this.x = new b(this);
        this.y = new c(this);
        this.z = new d(this);
        this.A = new f(this);
        setSurfaceTextureListener(this.w);
        this.n = getResources().getDimensionPixelSize(c.a.s0.n4.e.ds5);
        this.o = getResources().getDimensionPixelSize(c.a.s0.n4.e.ds20);
    }

    public void cancelPicture() {
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bitmap = this.q) == null) {
            return;
        }
        bitmap.recycle();
        this.q = null;
    }

    public Camera.Size getPropSize(List<Camera.Size> list, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, i2, i3)) == null) {
            if (ListUtils.getCount(list) == 0) {
                return null;
            }
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                Camera.Size size = list.get(i6);
                if (size != null) {
                    int abs = Math.abs(size.width - i2) + Math.abs(size.height - i3);
                    if (i6 == 0) {
                        i5 = abs;
                        i4 = 0;
                    } else if (abs < i5) {
                        i4 = i6;
                        i5 = abs;
                    }
                }
            }
            return list.get(i4);
        }
        return (Camera.Size) invokeLII.objValue;
    }

    public Bitmap getRotateBitmap(Bitmap bitmap, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(Constants.METHOD_SEND_USER_MSG, this, bitmap, f2)) == null) {
            Matrix matrix = new Matrix();
            matrix.postRotate(f2);
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
        }
        return (Bitmap) invokeLF.objValue;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDetachedFromWindow();
            c.a.d.f.m.e.a().removeCallbacks(this.A);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) {
            if (this.f51334h) {
                int action = motionEvent.getAction() & 255;
                if (action != 0) {
                    if (action == 1) {
                        this.f51337k = 0;
                    } else if (action == 2) {
                        Camera.Parameters parameters = this.f51333g;
                        if (parameters != null && parameters.isZoomSupported() && this.f51337k == 2) {
                            float q = q(motionEvent);
                            this.l = q;
                            if (q > this.n) {
                                float f2 = q - this.m;
                                int maxZoom = this.f51333g.getMaxZoom();
                                int zoom = this.f51332f.getParameters().getZoom();
                                if (f2 > this.o) {
                                    int i3 = zoom + 1;
                                    if (i3 <= maxZoom) {
                                        maxZoom = i3;
                                    }
                                    zoom(maxZoom);
                                    this.m = this.l;
                                } else if (f2 < (-i2)) {
                                    int i4 = zoom - 1;
                                    zoom(i4 >= 0 ? i4 : 0);
                                    this.m = this.l;
                                }
                            }
                        }
                    } else if (action == 5) {
                        float q2 = q(motionEvent);
                        this.m = q2;
                        if (q2 > this.n) {
                            this.f51337k = 2;
                        }
                    } else if (action == 6) {
                        this.f51337k = 0;
                    }
                } else {
                    this.f51337k = 1;
                }
                return true;
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void openCamera(boolean z) {
        g gVar;
        Camera.CameraInfo cameraInfo;
        int numberOfCameras;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || this.f51331e == null) {
            return;
        }
        try {
            stopCamera();
            cameraInfo = new Camera.CameraInfo();
            numberOfCameras = Camera.getNumberOfCameras();
            i2 = 0;
        } catch (Throwable th) {
            th.printStackTrace();
            stopCamera();
            gVar = this.t;
            if (gVar == null) {
            }
        }
        while (true) {
            if (i2 >= numberOfCameras) {
                break;
            }
            Camera.getCameraInfo(i2, cameraInfo);
            if (z) {
                if (cameraInfo.facing == 1) {
                    this.f51332f = Camera.open(i2);
                    this.p = true;
                    break;
                }
                i2++;
            } else if (cameraInfo.facing == 0) {
                this.f51332f = Camera.open(i2);
                this.p = false;
                break;
            } else {
                i2++;
            }
            th.printStackTrace();
            stopCamera();
            gVar = this.t;
            if (gVar == null) {
                gVar.a();
                return;
            }
            return;
        }
        r(this.f51331e);
    }

    public final float q(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) {
            if (motionEvent == null) {
                return 0.0f;
            }
            float x = motionEvent.getX(1) - motionEvent.getX(0);
            float y = motionEvent.getY(1) - motionEvent.getY(0);
            return (float) Math.sqrt((x * x) + (y * y));
        }
        return invokeL.floatValue;
    }

    public final void r(SurfaceTexture surfaceTexture) {
        Camera camera;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, surfaceTexture) == null) || (camera = this.f51332f) == null) {
            return;
        }
        Camera.Parameters parameters = camera.getParameters();
        this.f51333g = parameters;
        parameters.setPictureFormat(256);
        Camera.Size propSize = getPropSize(this.f51333g.getSupportedPictureSizes(), 1440, 1080);
        this.f51333g.setPictureSize(propSize.width, propSize.height);
        Camera.Size propSize2 = getPropSize(this.f51333g.getSupportedPreviewSizes(), 1440, 1080);
        this.f51333g.setPreviewSize(propSize2.width, propSize2.height);
        h hVar = this.r;
        if (hVar != null) {
            hVar.a(propSize2.width, propSize2.height);
        }
        this.f51332f.setDisplayOrientation(90);
        if (this.f51333g.getSupportedFocusModes().contains("continuous-video")) {
            this.f51333g.setFocusMode("continuous-video");
        }
        this.f51332f.setParameters(this.f51333g);
        try {
            this.f51332f.setPreviewTexture(surfaceTexture);
            this.f51332f.startPreview();
            this.f51334h = true;
        } catch (IOException e2) {
            e2.printStackTrace();
            stopCamera();
        }
    }

    public void savePicture() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            n0.b(new e(this), null);
        }
    }

    public void setOnGotPictureListener(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, jVar) == null) {
            this.f51336j = jVar;
        }
    }

    public void setOnOpenCameraFailedListener(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, gVar) == null) {
            this.t = gVar;
        }
    }

    public void setOnPreviewSizeChangedListener(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, hVar) == null) {
            this.r = hVar;
        }
    }

    public void setOnRequestPermissionListener(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, iVar) == null) {
            this.s = iVar;
        }
    }

    public void setStorePath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.f51335i = str;
        }
    }

    public void stopCamera() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            Camera camera = this.f51332f;
            if (camera != null) {
                try {
                    camera.setPreviewCallback(null);
                    this.f51332f.stopPreview();
                    this.f51332f.release();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            this.f51334h = false;
            this.f51332f = null;
        }
    }

    public void switchFrontBack() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            stopCamera();
            openCamera(!this.p);
        }
    }

    public void takePicture() {
        Camera camera;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && this.f51334h && (camera = this.f51332f) != null) {
            camera.takePicture(null, null, this.z);
        }
    }

    public void zoom(int i2) {
        Camera camera;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048593, this, i2) == null) || (camera = this.f51332f) == null) {
            return;
        }
        Camera.Parameters parameters = camera.getParameters();
        this.f51333g = parameters;
        if (parameters != null) {
            parameters.setZoom(i2);
            this.f51332f.setParameters(this.f51333g);
        }
    }
}
