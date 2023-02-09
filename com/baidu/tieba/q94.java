package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import androidx.media2.session.SessionCommand;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class q94 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65536, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        x94 x94Var = new x94();
        x94Var.a = str;
        n94.c().a(new m94(50000, x94Var));
    }

    public static void b(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        x94 x94Var = new x94();
        x94Var.a = str;
        n94.c().a(new m94(90000, x94Var));
    }

    public static void e(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        x94 x94Var = new x94();
        x94Var.a = str;
        n94.c().a(new m94(60000, x94Var));
    }

    public static void g(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65542, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        x94 x94Var = new x94();
        x94Var.a = str;
        n94.c().a(new m94(SessionCommand.COMMAND_CODE_SESSION_FAST_FORWARD, x94Var));
    }

    public static void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, str2) == null) {
            v94 v94Var = new v94();
            v94Var.b = str;
            v94Var.a = str2;
            n94.c().a(new m94(30000, v94Var));
        }
    }

    public static void c(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            u94 u94Var = new u94();
            u94Var.b = str;
            u94Var.c = i;
            u94Var.d = z ? 1 : 0;
            u94Var.a = str2;
            n94.c().a(new m94(100000, u94Var));
        }
    }

    public static void h(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            u94 u94Var = new u94();
            u94Var.b = str;
            u94Var.c = i;
            u94Var.d = z ? 1 : 0;
            u94Var.a = str2;
            n94.c().a(new m94(70000, u94Var));
        }
    }

    public static void k(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            u94 u94Var = new u94();
            u94Var.b = str;
            u94Var.c = i;
            u94Var.d = z ? 1 : 0;
            u94Var.a = str2;
            n94.c().a(new m94(110000, u94Var));
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            x94 x94Var = new x94();
            x94Var.a = str;
            n94.c().a(new m94(20000, x94Var));
        }
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            x94 x94Var = new x94();
            x94Var.a = str;
            n94.c().a(new m94(10000, x94Var));
        }
    }

    public static void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, str) == null) {
            x94 x94Var = new x94();
            x94Var.a = str;
            n94.c().a(new m94(120000, x94Var));
        }
    }

    public static void j(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65545, null, str, i, str2) == null) {
            w94 w94Var = new w94();
            w94Var.b = str;
            w94Var.c = i;
            w94Var.a = str2;
            n94.c().a(new m94(80000, w94Var));
        }
    }
}
