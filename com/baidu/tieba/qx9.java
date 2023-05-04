package com.baidu.tieba;

import android.os.Build;
import android.view.Window;
import android.view.WindowManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Field;
/* loaded from: classes6.dex */
public class qx9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i)) == null) {
            if (Build.VERSION.SDK_INT >= 26) {
                return 2038;
            }
            return i;
        }
        return invokeI.intValue;
    }

    public static void b(int i, WindowManager.LayoutParams layoutParams, Window window) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(65537, null, i, layoutParams, window) == null) && layoutParams != null && window != null) {
            try {
                Field declaredField = layoutParams.getClass().getDeclaredField("layoutInDisplayCutoutMode");
                if (declaredField != null) {
                    declaredField.set(layoutParams, Integer.valueOf(i));
                    window.setAttributes(layoutParams);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e2) {
                e2.printStackTrace();
            }
        }
    }
}
