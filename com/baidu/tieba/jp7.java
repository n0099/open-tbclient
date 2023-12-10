package com.baidu.tieba;

import android.view.MotionEvent;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public interface jp7 {

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static Boolean a(jp7 jp7Var, MotionEvent e) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, jp7Var, e)) == null) {
                Intrinsics.checkNotNullParameter(e, "e");
                return null;
            }
            return (Boolean) invokeLL.objValue;
        }

        public static Boolean b(jp7 jp7Var, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(65537, null, jp7Var, i, i2)) == null) {
                return null;
            }
            return (Boolean) invokeLII.objValue;
        }

        public static Boolean d(jp7 jp7Var, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(65539, null, jp7Var, i, i2)) == null) {
                return null;
            }
            return (Boolean) invokeLII.objValue;
        }

        public static Boolean e(jp7 jp7Var, MotionEvent e) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, jp7Var, e)) == null) {
                Intrinsics.checkNotNullParameter(e, "e");
                return null;
            }
            return (Boolean) invokeLL.objValue;
        }

        public static Boolean c(jp7 jp7Var, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(65538, null, jp7Var, i, i2)) == null) {
                return Boolean.FALSE;
            }
            return (Boolean) invokeLII.objValue;
        }
    }
}
