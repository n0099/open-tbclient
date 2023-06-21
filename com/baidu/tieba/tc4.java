package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import androidx.media2.session.SessionCommand;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.android.exoplayer2.extractor.ogg.DefaultOggSeeker;
/* loaded from: classes7.dex */
public class tc4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65536, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        ad4 ad4Var = new ad4();
        ad4Var.a = str;
        qc4.c().a(new pc4(50000, ad4Var));
    }

    public static void b(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        ad4 ad4Var = new ad4();
        ad4Var.a = str;
        qc4.c().a(new pc4(90000, ad4Var));
    }

    public static void e(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        ad4 ad4Var = new ad4();
        ad4Var.a = str;
        qc4.c().a(new pc4(60000, ad4Var));
    }

    public static void g(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65542, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        ad4 ad4Var = new ad4();
        ad4Var.a = str;
        qc4.c().a(new pc4(SessionCommand.COMMAND_CODE_SESSION_FAST_FORWARD, ad4Var));
    }

    public static void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, str2) == null) {
            yc4 yc4Var = new yc4();
            yc4Var.b = str;
            yc4Var.a = str2;
            qc4.c().a(new pc4(30000, yc4Var));
        }
    }

    public static void c(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            xc4 xc4Var = new xc4();
            xc4Var.b = str;
            xc4Var.c = i;
            xc4Var.d = z ? 1 : 0;
            xc4Var.a = str2;
            qc4.c().a(new pc4(DefaultOggSeeker.MATCH_BYTE_RANGE, xc4Var));
        }
    }

    public static void h(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            xc4 xc4Var = new xc4();
            xc4Var.b = str;
            xc4Var.c = i;
            xc4Var.d = z ? 1 : 0;
            xc4Var.a = str2;
            qc4.c().a(new pc4(70000, xc4Var));
        }
    }

    public static void k(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            xc4 xc4Var = new xc4();
            xc4Var.b = str;
            xc4Var.c = i;
            xc4Var.d = z ? 1 : 0;
            xc4Var.a = str2;
            qc4.c().a(new pc4(110000, xc4Var));
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            ad4 ad4Var = new ad4();
            ad4Var.a = str;
            qc4.c().a(new pc4(20000, ad4Var));
        }
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            ad4 ad4Var = new ad4();
            ad4Var.a = str;
            qc4.c().a(new pc4(10000, ad4Var));
        }
    }

    public static void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, str) == null) {
            ad4 ad4Var = new ad4();
            ad4Var.a = str;
            qc4.c().a(new pc4(120000, ad4Var));
        }
    }

    public static void j(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65545, null, str, i, str2) == null) {
            zc4 zc4Var = new zc4();
            zc4Var.b = str;
            zc4Var.c = i;
            zc4Var.a = str2;
            qc4.c().a(new pc4(80000, zc4Var));
        }
    }
}
