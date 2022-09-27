package com.baidu.tieba;

import android.hardware.Camera;
import android.view.MotionEvent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class uw8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public float b;
    public int c;
    public Camera d;
    public ax8 e;

    public uw8(Camera camera) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {camera};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.d = camera;
    }

    public final int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Camera camera = this.d;
            if (camera == null) {
                return -1;
            }
            Camera.Parameters parameters = camera.getParameters();
            if (parameters.isZoomSupported()) {
                if (parameters.getMaxZoom() > 40) {
                    return 40;
                }
                return parameters.getMaxZoom();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public boolean b(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
            ax8 ax8Var = this.e;
            if (ax8Var == null || !ax8Var.j()) {
                int action = motionEvent.getAction() & 255;
                if (action == 0) {
                    this.a = 0;
                } else if (action != 2) {
                    if (action == 5) {
                        this.a = 1;
                        this.b = e(motionEvent);
                    }
                } else if (this.a != 1 || motionEvent.getPointerCount() < 2) {
                    return true;
                } else {
                    float e = e(motionEvent);
                    int i = (int) ((e - this.b) / 10.0f);
                    if (i >= 1 || i <= -1) {
                        int i2 = this.c + i;
                        if (i2 > a()) {
                            i2 = a();
                        }
                        d(i2 >= 0 ? i2 : 0);
                        this.b = e;
                    }
                }
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void c(ax8 ax8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ax8Var) == null) {
            this.e = ax8Var;
        }
    }

    public final void d(int i) {
        Camera camera;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i) == null) || (camera = this.d) == null) {
            return;
        }
        Camera.Parameters parameters = camera.getParameters();
        if (parameters.isZoomSupported()) {
            parameters.setZoom(i);
            this.d.setParameters(parameters);
            this.c = i;
        }
    }

    public final float e(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) {
            if (motionEvent == null) {
                return 0.0f;
            }
            double x = motionEvent.getX(0) - motionEvent.getX(1);
            double y = motionEvent.getY(0) - motionEvent.getY(1);
            return (float) Math.sqrt((x * x) + (y * y));
        }
        return invokeL.floatValue;
    }
}
