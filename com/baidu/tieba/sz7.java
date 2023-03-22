package com.baidu.tieba;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.annotation.CallSuper;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public interface sz7 {

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @CallSuper
        public static void a(sz7 sz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65536, null, sz7Var) == null) {
            }
        }

        @CallSuper
        public static void b(sz7 sz7Var, int i, int i2, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{sz7Var, Integer.valueOf(i), Integer.valueOf(i2), intent}) == null) {
            }
        }

        @CallSuper
        public static void c(sz7 sz7Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(65538, null, sz7Var, z) == null) {
            }
        }

        @CallSuper
        public static void d(sz7 sz7Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(65539, null, sz7Var, i) == null) {
            }
        }

        @CallSuper
        public static boolean e(sz7 sz7Var, int i, KeyEvent event) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(InputDeviceCompat.SOURCE_TRACKBALL, null, sz7Var, i, event)) == null) {
                Intrinsics.checkNotNullParameter(event, "event");
                return false;
            }
            return invokeLIL.booleanValue;
        }

        @CallSuper
        public static void f(sz7 sz7Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(65541, null, sz7Var, z) == null) {
            }
        }

        @CallSuper
        public static void g(sz7 sz7Var, int i, String[] permissions, int[] grantResults) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(65542, null, sz7Var, i, permissions, grantResults) == null) {
                Intrinsics.checkNotNullParameter(permissions, "permissions");
                Intrinsics.checkNotNullParameter(grantResults, "grantResults");
            }
        }

        public static void h(sz7 sz7Var, Bundle outState) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65543, null, sz7Var, outState) == null) {
                Intrinsics.checkNotNullParameter(outState, "outState");
            }
        }

        @CallSuper
        public static void i(sz7 sz7Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(65544, null, sz7Var, z) == null) {
            }
        }
    }
}
