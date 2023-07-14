package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import androidx.media2.session.SessionCommand;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.android.exoplayer2.extractor.ogg.DefaultOggSeeker;
/* loaded from: classes7.dex */
public class pc4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65536, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        wc4 wc4Var = new wc4();
        wc4Var.a = str;
        mc4.c().a(new lc4(50000, wc4Var));
    }

    public static void b(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        wc4 wc4Var = new wc4();
        wc4Var.a = str;
        mc4.c().a(new lc4(90000, wc4Var));
    }

    public static void e(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        wc4 wc4Var = new wc4();
        wc4Var.a = str;
        mc4.c().a(new lc4(60000, wc4Var));
    }

    public static void g(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65542, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        wc4 wc4Var = new wc4();
        wc4Var.a = str;
        mc4.c().a(new lc4(SessionCommand.COMMAND_CODE_SESSION_FAST_FORWARD, wc4Var));
    }

    public static void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, str2) == null) {
            uc4 uc4Var = new uc4();
            uc4Var.b = str;
            uc4Var.a = str2;
            mc4.c().a(new lc4(30000, uc4Var));
        }
    }

    public static void c(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            tc4 tc4Var = new tc4();
            tc4Var.b = str;
            tc4Var.c = i;
            tc4Var.d = z ? 1 : 0;
            tc4Var.a = str2;
            mc4.c().a(new lc4(DefaultOggSeeker.MATCH_BYTE_RANGE, tc4Var));
        }
    }

    public static void h(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            tc4 tc4Var = new tc4();
            tc4Var.b = str;
            tc4Var.c = i;
            tc4Var.d = z ? 1 : 0;
            tc4Var.a = str2;
            mc4.c().a(new lc4(70000, tc4Var));
        }
    }

    public static void k(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            tc4 tc4Var = new tc4();
            tc4Var.b = str;
            tc4Var.c = i;
            tc4Var.d = z ? 1 : 0;
            tc4Var.a = str2;
            mc4.c().a(new lc4(110000, tc4Var));
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            wc4 wc4Var = new wc4();
            wc4Var.a = str;
            mc4.c().a(new lc4(20000, wc4Var));
        }
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            wc4 wc4Var = new wc4();
            wc4Var.a = str;
            mc4.c().a(new lc4(10000, wc4Var));
        }
    }

    public static void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, str) == null) {
            wc4 wc4Var = new wc4();
            wc4Var.a = str;
            mc4.c().a(new lc4(120000, wc4Var));
        }
    }

    public static void j(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65545, null, str, i, str2) == null) {
            vc4 vc4Var = new vc4();
            vc4Var.b = str;
            vc4Var.c = i;
            vc4Var.a = str2;
            mc4.c().a(new lc4(80000, vc4Var));
        }
    }
}
