package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import androidx.media2.session.SessionCommand;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class z44 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65536, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        g54 g54Var = new g54();
        g54Var.a = str;
        w44.c().a(new v44(50000, g54Var));
    }

    public static void b(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        g54 g54Var = new g54();
        g54Var.a = str;
        w44.c().a(new v44(90000, g54Var));
    }

    public static void e(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        g54 g54Var = new g54();
        g54Var.a = str;
        w44.c().a(new v44(60000, g54Var));
    }

    public static void g(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65542, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        g54 g54Var = new g54();
        g54Var.a = str;
        w44.c().a(new v44(SessionCommand.COMMAND_CODE_SESSION_FAST_FORWARD, g54Var));
    }

    public static void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, str2) == null) {
            e54 e54Var = new e54();
            e54Var.b = str;
            e54Var.a = str2;
            w44.c().a(new v44(30000, e54Var));
        }
    }

    public static void c(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            d54 d54Var = new d54();
            d54Var.b = str;
            d54Var.c = i;
            d54Var.d = z ? 1 : 0;
            d54Var.a = str2;
            w44.c().a(new v44(100000, d54Var));
        }
    }

    public static void h(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            d54 d54Var = new d54();
            d54Var.b = str;
            d54Var.c = i;
            d54Var.d = z ? 1 : 0;
            d54Var.a = str2;
            w44.c().a(new v44(70000, d54Var));
        }
    }

    public static void k(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            d54 d54Var = new d54();
            d54Var.b = str;
            d54Var.c = i;
            d54Var.d = z ? 1 : 0;
            d54Var.a = str2;
            w44.c().a(new v44(110000, d54Var));
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            g54 g54Var = new g54();
            g54Var.a = str;
            w44.c().a(new v44(20000, g54Var));
        }
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            g54 g54Var = new g54();
            g54Var.a = str;
            w44.c().a(new v44(10000, g54Var));
        }
    }

    public static void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, str) == null) {
            g54 g54Var = new g54();
            g54Var.a = str;
            w44.c().a(new v44(120000, g54Var));
        }
    }

    public static void j(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65545, null, str, i, str2) == null) {
            f54 f54Var = new f54();
            f54Var.b = str;
            f54Var.c = i;
            f54Var.a = str2;
            w44.c().a(new v44(80000, f54Var));
        }
    }
}
