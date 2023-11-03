package com.baidu.tieba;

import android.view.MotionEvent;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public interface qm7 {

    /* loaded from: classes7.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static Boolean a(qm7 qm7Var, MotionEvent e) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, qm7Var, e)) == null) {
                Intrinsics.checkNotNullParameter(e, "e");
                return null;
            }
            return (Boolean) invokeLL.objValue;
        }

        public static Boolean b(qm7 qm7Var, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(65537, null, qm7Var, i, i2)) == null) {
                return null;
            }
            return (Boolean) invokeLII.objValue;
        }

        public static Boolean d(qm7 qm7Var, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(65539, null, qm7Var, i, i2)) == null) {
                return null;
            }
            return (Boolean) invokeLII.objValue;
        }

        public static Boolean e(qm7 qm7Var, MotionEvent e) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, qm7Var, e)) == null) {
                Intrinsics.checkNotNullParameter(e, "e");
                return null;
            }
            return (Boolean) invokeLL.objValue;
        }

        public static Boolean c(qm7 qm7Var, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(65538, null, qm7Var, i, i2)) == null) {
                return Boolean.FALSE;
            }
            return (Boolean) invokeLII.objValue;
        }
    }
}
