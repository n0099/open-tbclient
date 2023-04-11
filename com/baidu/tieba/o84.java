package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import androidx.media2.session.SessionCommand;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.android.exoplayer2.extractor.ogg.DefaultOggSeeker;
/* loaded from: classes5.dex */
public class o84 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65536, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        v84 v84Var = new v84();
        v84Var.a = str;
        l84.c().a(new k84(50000, v84Var));
    }

    public static void b(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        v84 v84Var = new v84();
        v84Var.a = str;
        l84.c().a(new k84(90000, v84Var));
    }

    public static void e(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        v84 v84Var = new v84();
        v84Var.a = str;
        l84.c().a(new k84(60000, v84Var));
    }

    public static void g(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65542, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        v84 v84Var = new v84();
        v84Var.a = str;
        l84.c().a(new k84(SessionCommand.COMMAND_CODE_SESSION_FAST_FORWARD, v84Var));
    }

    public static void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, str2) == null) {
            t84 t84Var = new t84();
            t84Var.b = str;
            t84Var.a = str2;
            l84.c().a(new k84(30000, t84Var));
        }
    }

    public static void c(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            s84 s84Var = new s84();
            s84Var.b = str;
            s84Var.c = i;
            s84Var.d = z ? 1 : 0;
            s84Var.a = str2;
            l84.c().a(new k84(DefaultOggSeeker.MATCH_BYTE_RANGE, s84Var));
        }
    }

    public static void h(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            s84 s84Var = new s84();
            s84Var.b = str;
            s84Var.c = i;
            s84Var.d = z ? 1 : 0;
            s84Var.a = str2;
            l84.c().a(new k84(70000, s84Var));
        }
    }

    public static void k(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            s84 s84Var = new s84();
            s84Var.b = str;
            s84Var.c = i;
            s84Var.d = z ? 1 : 0;
            s84Var.a = str2;
            l84.c().a(new k84(110000, s84Var));
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            v84 v84Var = new v84();
            v84Var.a = str;
            l84.c().a(new k84(20000, v84Var));
        }
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            v84 v84Var = new v84();
            v84Var.a = str;
            l84.c().a(new k84(10000, v84Var));
        }
    }

    public static void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, str) == null) {
            v84 v84Var = new v84();
            v84Var.a = str;
            l84.c().a(new k84(120000, v84Var));
        }
    }

    public static void j(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65545, null, str, i, str2) == null) {
            u84 u84Var = new u84();
            u84Var.b = str;
            u84Var.c = i;
            u84Var.a = str2;
            l84.c().a(new k84(80000, u84Var));
        }
    }
}
