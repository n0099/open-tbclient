package com.baidu.tieba;

import android.hardware.Camera;
import android.view.MotionEvent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class jc9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public float b;
    public int c;
    public Camera d;
    public pc9 e;

    public jc9(Camera camera) {
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

    public void c(pc9 pc9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pc9Var) == null) {
            this.e = pc9Var;
        }
    }

    public final void d(int i) {
        Camera camera;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048579, this, i) != null) || (camera = this.d) == null) {
            return;
        }
        Camera.Parameters parameters = camera.getParameters();
        if (!parameters.isZoomSupported()) {
            return;
        }
        parameters.setZoom(i);
        this.d.setParameters(parameters);
        this.c = i;
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
            if (!parameters.isZoomSupported()) {
                return -1;
            }
            if (parameters.getMaxZoom() > 40) {
                return 40;
            }
            return parameters.getMaxZoom();
        }
        return invokeV.intValue;
    }

    public boolean b(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
            pc9 pc9Var = this.e;
            if (pc9Var != null && pc9Var.j()) {
                return true;
            }
            int action = motionEvent.getAction() & 255;
            int i = 0;
            if (action != 0) {
                if (action != 2) {
                    if (action == 5) {
                        this.a = 1;
                        this.b = e(motionEvent);
                    }
                } else if (this.a != 1 || motionEvent.getPointerCount() < 2) {
                    return true;
                } else {
                    float e = e(motionEvent);
                    int i2 = (int) ((e - this.b) / 10.0f);
                    if (i2 >= 1 || i2 <= -1) {
                        int i3 = this.c + i2;
                        if (i3 > a()) {
                            i3 = a();
                        }
                        if (i3 >= 0) {
                            i = i3;
                        }
                        d(i);
                        this.b = e;
                    }
                }
            } else {
                this.a = 0;
            }
            return true;
        }
        return invokeL.booleanValue;
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
