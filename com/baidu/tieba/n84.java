package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import androidx.media2.session.SessionCommand;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.android.exoplayer2.extractor.ogg.DefaultOggSeeker;
/* loaded from: classes5.dex */
public class n84 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65536, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        u84 u84Var = new u84();
        u84Var.a = str;
        k84.c().a(new j84(50000, u84Var));
    }

    public static void b(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        u84 u84Var = new u84();
        u84Var.a = str;
        k84.c().a(new j84(90000, u84Var));
    }

    public static void e(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        u84 u84Var = new u84();
        u84Var.a = str;
        k84.c().a(new j84(60000, u84Var));
    }

    public static void g(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65542, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        u84 u84Var = new u84();
        u84Var.a = str;
        k84.c().a(new j84(SessionCommand.COMMAND_CODE_SESSION_FAST_FORWARD, u84Var));
    }

    public static void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, str2) == null) {
            s84 s84Var = new s84();
            s84Var.b = str;
            s84Var.a = str2;
            k84.c().a(new j84(30000, s84Var));
        }
    }

    public static void c(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            r84 r84Var = new r84();
            r84Var.b = str;
            r84Var.c = i;
            r84Var.d = z ? 1 : 0;
            r84Var.a = str2;
            k84.c().a(new j84(DefaultOggSeeker.MATCH_BYTE_RANGE, r84Var));
        }
    }

    public static void h(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            r84 r84Var = new r84();
            r84Var.b = str;
            r84Var.c = i;
            r84Var.d = z ? 1 : 0;
            r84Var.a = str2;
            k84.c().a(new j84(70000, r84Var));
        }
    }

    public static void k(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            r84 r84Var = new r84();
            r84Var.b = str;
            r84Var.c = i;
            r84Var.d = z ? 1 : 0;
            r84Var.a = str2;
            k84.c().a(new j84(110000, r84Var));
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            u84 u84Var = new u84();
            u84Var.a = str;
            k84.c().a(new j84(20000, u84Var));
        }
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            u84 u84Var = new u84();
            u84Var.a = str;
            k84.c().a(new j84(10000, u84Var));
        }
    }

    public static void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, str) == null) {
            u84 u84Var = new u84();
            u84Var.a = str;
            k84.c().a(new j84(120000, u84Var));
        }
    }

    public static void j(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65545, null, str, i, str2) == null) {
            t84 t84Var = new t84();
            t84Var.b = str;
            t84Var.c = i;
            t84Var.a = str2;
            k84.c().a(new j84(80000, t84Var));
        }
    }
}
