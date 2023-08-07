package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import androidx.media2.session.SessionCommand;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.android.exoplayer2.extractor.ogg.DefaultOggSeeker;
/* loaded from: classes7.dex */
public class sb4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65536, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        zb4 zb4Var = new zb4();
        zb4Var.a = str;
        pb4.c().a(new ob4(50000, zb4Var));
    }

    public static void b(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        zb4 zb4Var = new zb4();
        zb4Var.a = str;
        pb4.c().a(new ob4(90000, zb4Var));
    }

    public static void e(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        zb4 zb4Var = new zb4();
        zb4Var.a = str;
        pb4.c().a(new ob4(60000, zb4Var));
    }

    public static void g(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65542, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        zb4 zb4Var = new zb4();
        zb4Var.a = str;
        pb4.c().a(new ob4(SessionCommand.COMMAND_CODE_SESSION_FAST_FORWARD, zb4Var));
    }

    public static void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, str2) == null) {
            xb4 xb4Var = new xb4();
            xb4Var.b = str;
            xb4Var.a = str2;
            pb4.c().a(new ob4(30000, xb4Var));
        }
    }

    public static void c(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            wb4 wb4Var = new wb4();
            wb4Var.b = str;
            wb4Var.c = i;
            wb4Var.d = z ? 1 : 0;
            wb4Var.a = str2;
            pb4.c().a(new ob4(DefaultOggSeeker.MATCH_BYTE_RANGE, wb4Var));
        }
    }

    public static void h(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            wb4 wb4Var = new wb4();
            wb4Var.b = str;
            wb4Var.c = i;
            wb4Var.d = z ? 1 : 0;
            wb4Var.a = str2;
            pb4.c().a(new ob4(70000, wb4Var));
        }
    }

    public static void k(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            wb4 wb4Var = new wb4();
            wb4Var.b = str;
            wb4Var.c = i;
            wb4Var.d = z ? 1 : 0;
            wb4Var.a = str2;
            pb4.c().a(new ob4(110000, wb4Var));
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            zb4 zb4Var = new zb4();
            zb4Var.a = str;
            pb4.c().a(new ob4(20000, zb4Var));
        }
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            zb4 zb4Var = new zb4();
            zb4Var.a = str;
            pb4.c().a(new ob4(10000, zb4Var));
        }
    }

    public static void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, str) == null) {
            zb4 zb4Var = new zb4();
            zb4Var.a = str;
            pb4.c().a(new ob4(120000, zb4Var));
        }
    }

    public static void j(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65545, null, str, i, str2) == null) {
            yb4 yb4Var = new yb4();
            yb4Var.b = str;
            yb4Var.c = i;
            yb4Var.a = str2;
            pb4.c().a(new ob4(80000, yb4Var));
        }
    }
}
