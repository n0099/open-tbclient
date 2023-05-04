package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import androidx.media2.session.SessionCommand;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.android.exoplayer2.extractor.ogg.DefaultOggSeeker;
/* loaded from: classes6.dex */
public class r84 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65536, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        y84 y84Var = new y84();
        y84Var.a = str;
        o84.c().a(new n84(50000, y84Var));
    }

    public static void b(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        y84 y84Var = new y84();
        y84Var.a = str;
        o84.c().a(new n84(90000, y84Var));
    }

    public static void e(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        y84 y84Var = new y84();
        y84Var.a = str;
        o84.c().a(new n84(60000, y84Var));
    }

    public static void g(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65542, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        y84 y84Var = new y84();
        y84Var.a = str;
        o84.c().a(new n84(SessionCommand.COMMAND_CODE_SESSION_FAST_FORWARD, y84Var));
    }

    public static void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, str2) == null) {
            w84 w84Var = new w84();
            w84Var.b = str;
            w84Var.a = str2;
            o84.c().a(new n84(30000, w84Var));
        }
    }

    public static void c(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            v84 v84Var = new v84();
            v84Var.b = str;
            v84Var.c = i;
            v84Var.d = z ? 1 : 0;
            v84Var.a = str2;
            o84.c().a(new n84(DefaultOggSeeker.MATCH_BYTE_RANGE, v84Var));
        }
    }

    public static void h(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            v84 v84Var = new v84();
            v84Var.b = str;
            v84Var.c = i;
            v84Var.d = z ? 1 : 0;
            v84Var.a = str2;
            o84.c().a(new n84(70000, v84Var));
        }
    }

    public static void k(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            v84 v84Var = new v84();
            v84Var.b = str;
            v84Var.c = i;
            v84Var.d = z ? 1 : 0;
            v84Var.a = str2;
            o84.c().a(new n84(110000, v84Var));
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            y84 y84Var = new y84();
            y84Var.a = str;
            o84.c().a(new n84(20000, y84Var));
        }
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            y84 y84Var = new y84();
            y84Var.a = str;
            o84.c().a(new n84(10000, y84Var));
        }
    }

    public static void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, str) == null) {
            y84 y84Var = new y84();
            y84Var.a = str;
            o84.c().a(new n84(120000, y84Var));
        }
    }

    public static void j(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65545, null, str, i, str2) == null) {
            x84 x84Var = new x84();
            x84Var.b = str;
            x84Var.c = i;
            x84Var.a = str2;
            o84.c().a(new n84(80000, x84Var));
        }
    }
}
