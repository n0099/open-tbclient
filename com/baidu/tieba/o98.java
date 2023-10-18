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
/* loaded from: classes7.dex */
public interface o98 {

    /* loaded from: classes7.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @CallSuper
        public static void a(o98 o98Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65536, null, o98Var) == null) {
            }
        }

        @CallSuper
        public static void b(o98 o98Var, int i, int i2, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{o98Var, Integer.valueOf(i), Integer.valueOf(i2), intent}) == null) {
            }
        }

        @CallSuper
        public static void c(o98 o98Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(65538, null, o98Var, z) == null) {
            }
        }

        @CallSuper
        public static void d(o98 o98Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(65539, null, o98Var, i) == null) {
            }
        }

        @CallSuper
        public static boolean e(o98 o98Var, int i, KeyEvent event) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(InputDeviceCompat.SOURCE_TRACKBALL, null, o98Var, i, event)) == null) {
                Intrinsics.checkNotNullParameter(event, "event");
                return false;
            }
            return invokeLIL.booleanValue;
        }

        @CallSuper
        public static void f(o98 o98Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(65541, null, o98Var, z) == null) {
            }
        }

        @CallSuper
        public static void g(o98 o98Var, int i, String[] permissions, int[] grantResults) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(65542, null, o98Var, i, permissions, grantResults) == null) {
                Intrinsics.checkNotNullParameter(permissions, "permissions");
                Intrinsics.checkNotNullParameter(grantResults, "grantResults");
            }
        }

        public static void h(o98 o98Var, Bundle outState) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65543, null, o98Var, outState) == null) {
                Intrinsics.checkNotNullParameter(outState, "outState");
            }
        }

        @CallSuper
        public static void i(o98 o98Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(65544, null, o98Var, z) == null) {
            }
        }
    }
}
