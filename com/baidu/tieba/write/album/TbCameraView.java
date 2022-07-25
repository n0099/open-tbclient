package com.baidu.tieba.write.album;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.TextureView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.qg;
import java.io.IOException;
import java.util.List;
/* loaded from: classes4.dex */
public class TbCameraView extends TextureView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SurfaceTexture a;
    public Camera b;
    public Camera.Parameters c;
    public boolean d;
    public h e;
    public int f;
    public float g;
    public float h;
    public int i;
    public int j;
    public boolean k;
    public f l;
    public g m;
    public e n;
    public boolean o;
    public boolean p;
    public TextureView.SurfaceTextureListener q;
    public final Runnable r;
    public final Runnable s;
    public Runnable t;

    /* loaded from: classes4.dex */
    public class a implements TextureView.SurfaceTextureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbCameraView a;

        public a(TbCameraView tbCameraView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCameraView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbCameraView;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, surfaceTexture, i, i2) == null) {
                this.a.a = surfaceTexture;
                if (!this.a.p && !this.a.o) {
                    boolean z = true;
                    this.a.p = true;
                    TbCameraView tbCameraView = this.a;
                    tbCameraView.o = (tbCameraView.m == null || !this.a.m.a()) ? false : false;
                }
                if (this.a.o) {
                    new Thread(this.a.r).start();
                }
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, surfaceTexture)) == null) {
                new Thread(this.a.s).start();
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, surfaceTexture, i, i2) == null) {
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, surfaceTexture) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbCameraView a;

        public b(TbCameraView tbCameraView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCameraView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbCameraView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.a) {
                    this.a.m(this.a.k);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbCameraView a;

        public c(TbCameraView tbCameraView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCameraView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbCameraView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.a) {
                    this.a.o();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbCameraView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.e == null) {
                return;
            }
            this.a.e.a();
        }
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a();
    }

    /* loaded from: classes4.dex */
    public interface f {
        void a(int i, int i2);
    }

    /* loaded from: classes4.dex */
    public interface g {
        boolean a();
    }

    /* loaded from: classes4.dex */
    public interface h {
        void a();
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = false;
        this.f = 0;
        this.k = false;
        this.o = false;
        this.p = false;
        this.q = new a(this);
        this.r = new b(this);
        this.s = new c(this);
        this.t = new d(this);
        setSurfaceTextureListener(this.q);
        this.i = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702d1);
        this.j = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701d5);
    }

    public final float k(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            if (motionEvent == null) {
                return 0.0f;
            }
            float x = motionEvent.getX(1) - motionEvent.getX(0);
            float y = motionEvent.getY(1) - motionEvent.getY(0);
            return (float) Math.sqrt((x * x) + (y * y));
        }
        return invokeL.floatValue;
    }

    public Camera.Size l(List<Camera.Size> list, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, i, i2)) == null) {
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
        return (Camera.Size) invokeLII.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m(boolean z) {
        e eVar;
        Camera.CameraInfo cameraInfo;
        int numberOfCameras;
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || this.a == null) {
            return;
        }
        try {
            o();
            cameraInfo = new Camera.CameraInfo();
            numberOfCameras = Camera.getNumberOfCameras();
            i = 0;
        } catch (Throwable th) {
            th.printStackTrace();
            o();
            eVar = this.n;
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
                    this.b = Camera.open(i);
                    this.k = true;
                    break;
                }
                i++;
            } else if (cameraInfo.facing == 0) {
                this.b = Camera.open(i);
                this.k = false;
                break;
            } else {
                i++;
            }
            th.printStackTrace();
            o();
            eVar = this.n;
            if (eVar == null) {
                eVar.a();
                return;
            }
            return;
        }
        n(this.a);
    }

    public final void n(SurfaceTexture surfaceTexture) {
        Camera camera;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, surfaceTexture) == null) || (camera = this.b) == null) {
            return;
        }
        Camera.Parameters parameters = camera.getParameters();
        this.c = parameters;
        parameters.setPictureFormat(256);
        Camera.Size l = l(this.c.getSupportedPictureSizes(), 1440, 1080);
        this.c.setPictureSize(l.width, l.height);
        Camera.Size l2 = l(this.c.getSupportedPreviewSizes(), 1440, 1080);
        this.c.setPreviewSize(l2.width, l2.height);
        f fVar = this.l;
        if (fVar != null) {
            fVar.a(l2.width, l2.height);
        }
        this.b.setDisplayOrientation(90);
        if (this.c.getSupportedFocusModes().contains("continuous-video")) {
            this.c.setFocusMode("continuous-video");
        }
        this.b.setParameters(this.c);
        try {
            this.b.setPreviewTexture(surfaceTexture);
            this.b.startPreview();
            this.d = true;
        } catch (IOException e2) {
            e2.printStackTrace();
            o();
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Camera camera = this.b;
            if (camera != null) {
                try {
                    camera.setPreviewCallback(null);
                    this.b.stopPreview();
                    this.b.release();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            this.d = false;
            this.b = null;
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDetachedFromWindow();
            qg.a().removeCallbacks(this.t);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) {
            if (this.d) {
                int action = motionEvent.getAction() & 255;
                if (action != 0) {
                    if (action == 1) {
                        this.f = 0;
                    } else if (action == 2) {
                        Camera.Parameters parameters = this.c;
                        if (parameters != null && parameters.isZoomSupported() && this.f == 2) {
                            float k = k(motionEvent);
                            this.g = k;
                            if (k > this.i) {
                                float f2 = k - this.h;
                                int maxZoom = this.c.getMaxZoom();
                                int zoom = this.b.getParameters().getZoom();
                                if (f2 > this.j) {
                                    int i2 = zoom + 1;
                                    if (i2 <= maxZoom) {
                                        maxZoom = i2;
                                    }
                                    p(maxZoom);
                                    this.h = this.g;
                                } else if (f2 < (-i)) {
                                    int i3 = zoom - 1;
                                    p(i3 >= 0 ? i3 : 0);
                                    this.h = this.g;
                                }
                            }
                        }
                    } else if (action == 5) {
                        float k2 = k(motionEvent);
                        this.h = k2;
                        if (k2 > this.i) {
                            this.f = 2;
                        }
                    } else if (action == 6) {
                        this.f = 0;
                    }
                } else {
                    this.f = 1;
                }
                return true;
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void p(int i) {
        Camera camera;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i) == null) || (camera = this.b) == null) {
            return;
        }
        Camera.Parameters parameters = camera.getParameters();
        this.c = parameters;
        if (parameters != null) {
            parameters.setZoom(i);
            this.b.setParameters(this.c);
        }
    }

    public void setOnGotPictureListener(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hVar) == null) {
            this.e = hVar;
        }
    }

    public void setOnOpenCameraFailedListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, eVar) == null) {
            this.n = eVar;
        }
    }

    public void setOnPreviewSizeChangedListener(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, fVar) == null) {
            this.l = fVar;
        }
    }

    public void setOnRequestPermissionListener(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, gVar) == null) {
            this.m = gVar;
        }
    }

    public void setStorePath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
        }
    }
}
