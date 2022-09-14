package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import androidx.media2.session.SessionCommand;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class s34 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, callbackHandler, str) == null) && UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            z34 z34Var = new z34();
            z34Var.a = str;
            p34.c().a(new o34(50000, z34Var));
        }
    }

    public static void b(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, callbackHandler, str) == null) && UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            z34 z34Var = new z34();
            z34Var.a = str;
            p34.c().a(new o34(90000, z34Var));
        }
    }

    public static void c(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            w34 w34Var = new w34();
            w34Var.b = str;
            w34Var.c = i;
            w34Var.d = z ? 1 : 0;
            w34Var.a = str2;
            p34.c().a(new o34(100000, w34Var));
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            z34 z34Var = new z34();
            z34Var.a = str;
            p34.c().a(new o34(20000, z34Var));
        }
    }

    public static void e(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, callbackHandler, str) == null) && UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            z34 z34Var = new z34();
            z34Var.a = str;
            p34.c().a(new o34(60000, z34Var));
        }
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            z34 z34Var = new z34();
            z34Var.a = str;
            p34.c().a(new o34(10000, z34Var));
        }
    }

    public static void g(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65542, null, callbackHandler, str) == null) && UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            z34 z34Var = new z34();
            z34Var.a = str;
            p34.c().a(new o34(SessionCommand.COMMAND_CODE_SESSION_FAST_FORWARD, z34Var));
        }
    }

    public static void h(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            w34 w34Var = new w34();
            w34Var.b = str;
            w34Var.c = i;
            w34Var.d = z ? 1 : 0;
            w34Var.a = str2;
            p34.c().a(new o34(70000, w34Var));
        }
    }

    public static void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, str2) == null) {
            x34 x34Var = new x34();
            x34Var.b = str;
            x34Var.a = str2;
            p34.c().a(new o34(30000, x34Var));
        }
    }

    public static void j(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65545, null, str, i, str2) == null) {
            y34 y34Var = new y34();
            y34Var.b = str;
            y34Var.c = i;
            y34Var.a = str2;
            p34.c().a(new o34(80000, y34Var));
        }
    }

    public static void k(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            w34 w34Var = new w34();
            w34Var.b = str;
            w34Var.c = i;
            w34Var.d = z ? 1 : 0;
            w34Var.a = str2;
            p34.c().a(new o34(110000, w34Var));
        }
    }

    public static void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, str) == null) {
            z34 z34Var = new z34();
            z34Var.a = str;
            p34.c().a(new o34(120000, z34Var));
        }
    }
}
