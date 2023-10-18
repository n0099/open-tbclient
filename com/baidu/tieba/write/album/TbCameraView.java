package com.baidu.tieba.write.album;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.TextureView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.kp6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.List;
/* loaded from: classes8.dex */
public class TbCameraView extends TextureView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SurfaceTexture a;
    public Camera b;
    public Camera.Parameters c;
    public boolean d;
    public g e;
    public int f;
    public h g;
    public float h;
    public float i;
    public int j;
    public int k;
    public boolean l;
    public e m;
    public f n;
    public d o;
    public boolean p;
    public boolean q;
    public TextureView.SurfaceTextureListener r;
    public final Runnable s;
    public Runnable t;

    /* loaded from: classes8.dex */
    public interface d {
        void a();
    }

    /* loaded from: classes8.dex */
    public interface e {
        void a(int i, int i2);
    }

    /* loaded from: classes8.dex */
    public interface f {
        boolean a();
    }

    /* loaded from: classes8.dex */
    public interface g {
        void a();
    }

    /* loaded from: classes8.dex */
    public class a implements TextureView.SurfaceTextureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbCameraView a;

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
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, surfaceTexture)) != null) {
                return invokeL.booleanValue;
            }
            this.a.g = new h(this.a);
            this.a.g.execute(new Object[0]);
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, surfaceTexture, i, i2) == null) {
                this.a.a = surfaceTexture;
                if (!this.a.q && !this.a.p) {
                    this.a.q = true;
                    TbCameraView tbCameraView = this.a;
                    if (tbCameraView.n != null && this.a.n.a()) {
                        z = true;
                    } else {
                        z = false;
                    }
                    tbCameraView.p = z;
                }
                if (this.a.p) {
                    kp6.a(this.a.s, "mTextureAvailable", 1);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
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
                    this.a.n(this.a.l);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.e != null) {
                this.a.e.a();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class h extends BdAsyncTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<TbCameraView> a;

        public h(TbCameraView tbCameraView) {
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
            this.a = new WeakReference<>(tbCameraView);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Object doInBackground(Object[] objArr) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                TbCameraView tbCameraView = this.a.get();
                if (tbCameraView != null) {
                    synchronized (tbCameraView) {
                        tbCameraView.p();
                    }
                    return null;
                }
                return null;
            }
            return invokeL.objValue;
        }
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
        this.l = false;
        this.p = false;
        this.q = false;
        this.r = new a(this);
        this.s = new b(this);
        this.t = new c(this);
        setSurfaceTextureListener(this.r);
        this.j = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703eb);
        this.k = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701d5);
    }

    public void q(int i) {
        Camera camera;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048583, this, i) != null) || (camera = this.b) == null) {
            return;
        }
        Camera.Parameters parameters = camera.getParameters();
        this.c = parameters;
        if (parameters != null) {
            parameters.setZoom(i);
            this.b.setParameters(this.c);
        }
    }

    public void setOnOpenCameraFailedListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar) == null) {
            this.o = dVar;
        }
    }

    public void setOnRequestPermissionListener(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, fVar) == null) {
            this.n = fVar;
        }
    }

    public final float l(MotionEvent motionEvent) {
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

    public Camera.Size m(List<Camera.Size> list, int i, int i2) {
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
    public void n(boolean z) {
        d dVar;
        Camera.CameraInfo cameraInfo;
        int numberOfCameras;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) != null) || this.a == null) {
            return;
        }
        try {
            p();
            cameraInfo = new Camera.CameraInfo();
            numberOfCameras = Camera.getNumberOfCameras();
            i = 0;
        } catch (Throwable th) {
            th.printStackTrace();
            p();
            dVar = this.o;
            if (dVar == null) {
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
                    this.l = true;
                    break;
                }
                i++;
            } else if (cameraInfo.facing == 0) {
                this.b = Camera.open(i);
                this.l = false;
                break;
            } else {
                i++;
            }
            th.printStackTrace();
            p();
            dVar = this.o;
            if (dVar == null) {
                dVar.a();
                return;
            }
            return;
        }
        o(this.a);
    }

    public final void o(SurfaceTexture surfaceTexture) {
        Camera camera;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, surfaceTexture) == null) && (camera = this.b) != null) {
            Camera.Parameters parameters = camera.getParameters();
            this.c = parameters;
            parameters.setPictureFormat(256);
            Camera.Size m = m(this.c.getSupportedPictureSizes(), 1440, 1080);
            this.c.setPictureSize(m.width, m.height);
            Camera.Size m2 = m(this.c.getSupportedPreviewSizes(), 1440, 1080);
            this.c.setPreviewSize(m2.width, m2.height);
            e eVar = this.m;
            if (eVar != null) {
                eVar.a(m2.width, m2.height);
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
                p();
            }
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDetachedFromWindow();
            SafeHandler.getInst().removeCallbacks(this.t);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
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
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, motionEvent)) == null) {
            if (this.d) {
                int action = motionEvent.getAction() & 255;
                if (action != 0) {
                    int i2 = 0;
                    if (action != 1) {
                        if (action != 2) {
                            if (action != 5) {
                                if (action == 6) {
                                    this.f = 0;
                                }
                            } else {
                                float l = l(motionEvent);
                                this.i = l;
                                if (l > this.j) {
                                    this.f = 2;
                                }
                            }
                        } else {
                            Camera.Parameters parameters = this.c;
                            if (parameters != null && parameters.isZoomSupported() && this.f == 2) {
                                float l2 = l(motionEvent);
                                this.h = l2;
                                if (l2 > this.j) {
                                    float f2 = l2 - this.i;
                                    int maxZoom = this.c.getMaxZoom();
                                    int zoom = this.b.getParameters().getZoom();
                                    if (f2 > this.k) {
                                        int i3 = zoom + 1;
                                        if (i3 <= maxZoom) {
                                            maxZoom = i3;
                                        }
                                        q(maxZoom);
                                        this.i = this.h;
                                    } else if (f2 < (-i)) {
                                        int i4 = zoom - 1;
                                        if (i4 >= 0) {
                                            i2 = i4;
                                        }
                                        q(i2);
                                        this.i = this.h;
                                    }
                                }
                            }
                        }
                    } else {
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
}
