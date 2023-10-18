package com.baidu.tieba;

import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import android.view.MotionEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class jy1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int b(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIII = interceptable.invokeIII(65537, null, i, i2, i3)) == null) ? i > i3 ? i3 : i < i2 ? i2 : i : invokeIII.intValue;
    }

    /* loaded from: classes6.dex */
    public static class a implements Camera.AutoFocusCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z, Camera camera) {
            Camera.Parameters parameters;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeZL(1048576, this, z, camera) != null) || camera == null || (parameters = camera.getParameters()) == null) {
                return;
            }
            parameters.setFocusMode(this.a);
            camera.setParameters(parameters);
        }
    }

    public static Rect a(float f, float f2, float f3, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            int i3 = (int) (((f / i) * 2000.0f) - 1000.0f);
            int i4 = (int) (((f2 / i2) * 2000.0f) - 1000.0f);
            int intValue = Float.valueOf(f3 * 300.0f).intValue() / 2;
            RectF rectF = new RectF(b(i3 - intValue, -1000, 1000), b(i4 - intValue, -1000, 1000), b(i3 + intValue, -1000, 1000), b(i4 + intValue, -1000, 1000));
            return new Rect(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
        }
        return (Rect) invokeCommon.objValue;
    }

    public static String c(Camera.Parameters parameters) {
        InterceptResult invokeL;
        List<String> supportedFocusModes;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, parameters)) == null) {
            if (parameters != null && (supportedFocusModes = parameters.getSupportedFocusModes()) != null) {
                if (supportedFocusModes.contains("macro")) {
                    return "macro";
                }
                if (supportedFocusModes.contains("continuous-picture")) {
                    return "continuous-picture";
                }
            }
            return "auto";
        }
        return (String) invokeL.objValue;
    }

    public static void d(MotionEvent motionEvent, Camera camera, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLII(65539, null, motionEvent, camera, i, i2) == null) && motionEvent != null && camera != null) {
            Rect a2 = a(motionEvent.getX(), motionEvent.getY(), 1.0f, i, i2);
            camera.cancelAutoFocus();
            Camera.Parameters parameters = camera.getParameters();
            if (parameters == null) {
                return;
            }
            if (parameters.getMaxNumFocusAreas() > 0) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Camera.Area(a2, 800));
                parameters.setFocusAreas(arrayList);
            }
            String focusMode = parameters.getFocusMode();
            parameters.setFocusMode(c(parameters));
            camera.setParameters(parameters);
            camera.autoFocus(new a(focusMode));
        }
    }
}
