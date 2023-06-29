package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import androidx.media2.session.SessionCommand;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.android.exoplayer2.extractor.ogg.DefaultOggSeeker;
/* loaded from: classes8.dex */
public class wc4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65536, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        dd4 dd4Var = new dd4();
        dd4Var.a = str;
        tc4.c().a(new sc4(50000, dd4Var));
    }

    public static void b(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        dd4 dd4Var = new dd4();
        dd4Var.a = str;
        tc4.c().a(new sc4(90000, dd4Var));
    }

    public static void e(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        dd4 dd4Var = new dd4();
        dd4Var.a = str;
        tc4.c().a(new sc4(60000, dd4Var));
    }

    public static void g(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65542, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        dd4 dd4Var = new dd4();
        dd4Var.a = str;
        tc4.c().a(new sc4(SessionCommand.COMMAND_CODE_SESSION_FAST_FORWARD, dd4Var));
    }

    public static void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, str2) == null) {
            bd4 bd4Var = new bd4();
            bd4Var.b = str;
            bd4Var.a = str2;
            tc4.c().a(new sc4(30000, bd4Var));
        }
    }

    public static void c(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            ad4 ad4Var = new ad4();
            ad4Var.b = str;
            ad4Var.c = i;
            ad4Var.d = z ? 1 : 0;
            ad4Var.a = str2;
            tc4.c().a(new sc4(DefaultOggSeeker.MATCH_BYTE_RANGE, ad4Var));
        }
    }

    public static void h(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            ad4 ad4Var = new ad4();
            ad4Var.b = str;
            ad4Var.c = i;
            ad4Var.d = z ? 1 : 0;
            ad4Var.a = str2;
            tc4.c().a(new sc4(70000, ad4Var));
        }
    }

    public static void k(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            ad4 ad4Var = new ad4();
            ad4Var.b = str;
            ad4Var.c = i;
            ad4Var.d = z ? 1 : 0;
            ad4Var.a = str2;
            tc4.c().a(new sc4(110000, ad4Var));
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            dd4 dd4Var = new dd4();
            dd4Var.a = str;
            tc4.c().a(new sc4(20000, dd4Var));
        }
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            dd4 dd4Var = new dd4();
            dd4Var.a = str;
            tc4.c().a(new sc4(10000, dd4Var));
        }
    }

    public static void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, str) == null) {
            dd4 dd4Var = new dd4();
            dd4Var.a = str;
            tc4.c().a(new sc4(120000, dd4Var));
        }
    }

    public static void j(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65545, null, str, i, str2) == null) {
            cd4 cd4Var = new cd4();
            cd4Var.b = str;
            cd4Var.c = i;
            cd4Var.a = str2;
            tc4.c().a(new sc4(80000, cd4Var));
        }
    }
}
