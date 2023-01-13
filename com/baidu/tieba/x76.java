package com.baidu.tieba;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public class x76 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, view2) == null) {
            try {
                ViewParent parent = view2.getRootView().getParent();
                Method declaredMethod = parent.getClass().getDeclaredMethod("handleDispatchDoneAnimating", new Class[0]);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(parent, new Object[0]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void b(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, view2) == null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
    }

    public static void c(View view2) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, view2) == null) && (i = Build.VERSION.SDK_INT) <= 23 && i >= 17) {
            if (i < 17) {
                a(view2);
                return;
            }
            try {
                ViewParent parent = view2.getRootView().getParent();
                Method declaredMethod = parent.getClass().getDeclaredMethod("setDrawDuringWindowsAnimating", Boolean.TYPE);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(parent, Boolean.TRUE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void d(@NonNull View view2, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65539, null, view2, i) == null) && view2.getVisibility() != i) {
            view2.setVisibility(i);
        }
    }
}
