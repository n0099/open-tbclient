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
import java.io.IOException;
import java.util.List;
/* loaded from: classes4.dex */
public class TbCameraView extends TextureView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public SurfaceTexture f22564e;

    /* renamed from: f  reason: collision with root package name */
    public Camera f22565f;

    /* renamed from: g  reason: collision with root package name */
    public Camera.Parameters f22566g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f22567h;

    /* renamed from: i  reason: collision with root package name */
    public h f22568i;
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
    public boolean t;
    public TextureView.SurfaceTextureListener u;
    public final Runnable v;
    public final Runnable w;
    public Runnable x;

    /* loaded from: classes4.dex */
    public class a implements TextureView.SurfaceTextureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbCameraView f22569e;

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
            this.f22569e = tbCameraView;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, surfaceTexture, i2, i3) == null) {
                this.f22569e.f22564e = surfaceTexture;
                if (!this.f22569e.t && !this.f22569e.s) {
                    boolean z = true;
                    this.f22569e.t = true;
                    TbCameraView tbCameraView = this.f22569e;
                    tbCameraView.s = (tbCameraView.q == null || !this.f22569e.q.a()) ? false : false;
                }
                if (this.f22569e.s) {
                    new Thread(this.f22569e.v).start();
                }
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, surfaceTexture)) == null) {
                new Thread(this.f22569e.w).start();
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

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbCameraView f22570e;

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
            this.f22570e = tbCameraView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f22570e) {
                    this.f22570e.m(this.f22570e.o);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbCameraView f22571e;

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
            this.f22571e = tbCameraView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f22571e) {
                    this.f22571e.o();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbCameraView f22572e;

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
            this.f22572e = tbCameraView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f22572e.f22568i == null) {
                return;
            }
            this.f22572e.f22568i.a();
        }
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a();
    }

    /* loaded from: classes4.dex */
    public interface f {
        void a(int i2, int i3);
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
        this.f22567h = false;
        this.j = 0;
        this.o = false;
        this.s = false;
        this.t = false;
        this.u = new a(this);
        this.v = new b(this);
        this.w = new c(this);
        this.x = new d(this);
        setSurfaceTextureListener(this.u);
        this.m = getResources().getDimensionPixelSize(R.dimen.ds5);
        this.n = getResources().getDimensionPixelSize(R.dimen.ds20);
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

    public Camera.Size l(List<Camera.Size> list, int i2, int i3) {
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

    /* JADX WARN: Removed duplicated region for block: B:23:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m(boolean z) {
        e eVar;
        Camera.CameraInfo cameraInfo;
        int numberOfCameras;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || this.f22564e == null) {
            return;
        }
        try {
            o();
            cameraInfo = new Camera.CameraInfo();
            numberOfCameras = Camera.getNumberOfCameras();
            i2 = 0;
        } catch (Throwable th) {
            th.printStackTrace();
            o();
            eVar = this.r;
            if (eVar == null) {
            }
        }
        while (true) {
            if (i2 >= numberOfCameras) {
                break;
            }
            Camera.getCameraInfo(i2, cameraInfo);
            if (z) {
                if (cameraInfo.facing == 1) {
                    this.f22565f = Camera.open(i2);
                    this.o = true;
                    break;
                }
                i2++;
            } else if (cameraInfo.facing == 0) {
                this.f22565f = Camera.open(i2);
                this.o = false;
                break;
            } else {
                i2++;
            }
            th.printStackTrace();
            o();
            eVar = this.r;
            if (eVar == null) {
                eVar.a();
                return;
            }
            return;
        }
        n(this.f22564e);
    }

    public final void n(SurfaceTexture surfaceTexture) {
        Camera camera;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, surfaceTexture) == null) || (camera = this.f22565f) == null) {
            return;
        }
        Camera.Parameters parameters = camera.getParameters();
        this.f22566g = parameters;
        parameters.setPictureFormat(256);
        Camera.Size l = l(this.f22566g.getSupportedPictureSizes(), 1440, 1080);
        this.f22566g.setPictureSize(l.width, l.height);
        Camera.Size l2 = l(this.f22566g.getSupportedPreviewSizes(), 1440, 1080);
        this.f22566g.setPreviewSize(l2.width, l2.height);
        f fVar = this.p;
        if (fVar != null) {
            fVar.a(l2.width, l2.height);
        }
        this.f22565f.setDisplayOrientation(90);
        if (this.f22566g.getSupportedFocusModes().contains("continuous-video")) {
            this.f22566g.setFocusMode("continuous-video");
        }
        this.f22565f.setParameters(this.f22566g);
        try {
            this.f22565f.setPreviewTexture(surfaceTexture);
            this.f22565f.startPreview();
            this.f22567h = true;
        } catch (IOException e2) {
            e2.printStackTrace();
            o();
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Camera camera = this.f22565f;
            if (camera != null) {
                try {
                    camera.setPreviewCallback(null);
                    this.f22565f.stopPreview();
                    this.f22565f.release();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            this.f22567h = false;
            this.f22565f = null;
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDetachedFromWindow();
            d.a.c.e.m.e.a().removeCallbacks(this.x);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) {
            if (this.f22567h) {
                int action = motionEvent.getAction() & 255;
                if (action != 0) {
                    if (action == 1) {
                        this.j = 0;
                    } else if (action == 2) {
                        Camera.Parameters parameters = this.f22566g;
                        if (parameters != null && parameters.isZoomSupported() && this.j == 2) {
                            float k = k(motionEvent);
                            this.k = k;
                            if (k > this.m) {
                                float f2 = k - this.l;
                                int maxZoom = this.f22566g.getMaxZoom();
                                int zoom = this.f22565f.getParameters().getZoom();
                                if (f2 > this.n) {
                                    int i3 = zoom + 1;
                                    if (i3 <= maxZoom) {
                                        maxZoom = i3;
                                    }
                                    p(maxZoom);
                                    this.l = this.k;
                                } else if (f2 < (-i2)) {
                                    int i4 = zoom - 1;
                                    p(i4 >= 0 ? i4 : 0);
                                    this.l = this.k;
                                }
                            }
                        }
                    } else if (action == 5) {
                        float k2 = k(motionEvent);
                        this.l = k2;
                        if (k2 > this.m) {
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
        return invokeL.booleanValue;
    }

    public void p(int i2) {
        Camera camera;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || (camera = this.f22565f) == null) {
            return;
        }
        Camera.Parameters parameters = camera.getParameters();
        this.f22566g = parameters;
        if (parameters != null) {
            parameters.setZoom(i2);
            this.f22565f.setParameters(this.f22566g);
        }
    }

    public void setOnGotPictureListener(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hVar) == null) {
            this.f22568i = hVar;
        }
    }

    public void setOnOpenCameraFailedListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, eVar) == null) {
            this.r = eVar;
        }
    }

    public void setOnPreviewSizeChangedListener(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, fVar) == null) {
            this.p = fVar;
        }
    }

    public void setOnRequestPermissionListener(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, gVar) == null) {
            this.q = gVar;
        }
    }

    public void setStorePath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
        }
    }
}
