package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import androidx.media2.session.SessionCommand;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class y44 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65536, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        f54 f54Var = new f54();
        f54Var.a = str;
        v44.c().a(new u44(50000, f54Var));
    }

    public static void b(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        f54 f54Var = new f54();
        f54Var.a = str;
        v44.c().a(new u44(90000, f54Var));
    }

    public static void e(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        f54 f54Var = new f54();
        f54Var.a = str;
        v44.c().a(new u44(60000, f54Var));
    }

    public static void g(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65542, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        f54 f54Var = new f54();
        f54Var.a = str;
        v44.c().a(new u44(SessionCommand.COMMAND_CODE_SESSION_FAST_FORWARD, f54Var));
    }

    public static void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, str2) == null) {
            d54 d54Var = new d54();
            d54Var.b = str;
            d54Var.a = str2;
            v44.c().a(new u44(30000, d54Var));
        }
    }

    public static void c(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            c54 c54Var = new c54();
            c54Var.b = str;
            c54Var.c = i;
            c54Var.d = z ? 1 : 0;
            c54Var.a = str2;
            v44.c().a(new u44(100000, c54Var));
        }
    }

    public static void h(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            c54 c54Var = new c54();
            c54Var.b = str;
            c54Var.c = i;
            c54Var.d = z ? 1 : 0;
            c54Var.a = str2;
            v44.c().a(new u44(70000, c54Var));
        }
    }

    public static void k(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            c54 c54Var = new c54();
            c54Var.b = str;
            c54Var.c = i;
            c54Var.d = z ? 1 : 0;
            c54Var.a = str2;
            v44.c().a(new u44(110000, c54Var));
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            f54 f54Var = new f54();
            f54Var.a = str;
            v44.c().a(new u44(20000, f54Var));
        }
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            f54 f54Var = new f54();
            f54Var.a = str;
            v44.c().a(new u44(10000, f54Var));
        }
    }

    public static void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, str) == null) {
            f54 f54Var = new f54();
            f54Var.a = str;
            v44.c().a(new u44(120000, f54Var));
        }
    }

    public static void j(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65545, null, str, i, str2) == null) {
            e54 e54Var = new e54();
            e54Var.b = str;
            e54Var.c = i;
            e54Var.a = str2;
            v44.c().a(new u44(80000, e54Var));
        }
    }
}
