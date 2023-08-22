package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import androidx.media2.session.SessionCommand;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.android.exoplayer2.extractor.ogg.DefaultOggSeeker;
/* loaded from: classes8.dex */
public class xb4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65536, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        ec4 ec4Var = new ec4();
        ec4Var.a = str;
        ub4.c().a(new tb4(50000, ec4Var));
    }

    public static void b(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        ec4 ec4Var = new ec4();
        ec4Var.a = str;
        ub4.c().a(new tb4(90000, ec4Var));
    }

    public static void e(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        ec4 ec4Var = new ec4();
        ec4Var.a = str;
        ub4.c().a(new tb4(60000, ec4Var));
    }

    public static void g(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65542, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        ec4 ec4Var = new ec4();
        ec4Var.a = str;
        ub4.c().a(new tb4(SessionCommand.COMMAND_CODE_SESSION_FAST_FORWARD, ec4Var));
    }

    public static void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, str2) == null) {
            cc4 cc4Var = new cc4();
            cc4Var.b = str;
            cc4Var.a = str2;
            ub4.c().a(new tb4(30000, cc4Var));
        }
    }

    public static void c(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            bc4 bc4Var = new bc4();
            bc4Var.b = str;
            bc4Var.c = i;
            bc4Var.d = z ? 1 : 0;
            bc4Var.a = str2;
            ub4.c().a(new tb4(DefaultOggSeeker.MATCH_BYTE_RANGE, bc4Var));
        }
    }

    public static void h(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            bc4 bc4Var = new bc4();
            bc4Var.b = str;
            bc4Var.c = i;
            bc4Var.d = z ? 1 : 0;
            bc4Var.a = str2;
            ub4.c().a(new tb4(70000, bc4Var));
        }
    }

    public static void k(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            bc4 bc4Var = new bc4();
            bc4Var.b = str;
            bc4Var.c = i;
            bc4Var.d = z ? 1 : 0;
            bc4Var.a = str2;
            ub4.c().a(new tb4(110000, bc4Var));
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            ec4 ec4Var = new ec4();
            ec4Var.a = str;
            ub4.c().a(new tb4(20000, ec4Var));
        }
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            ec4 ec4Var = new ec4();
            ec4Var.a = str;
            ub4.c().a(new tb4(10000, ec4Var));
        }
    }

    public static void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, str) == null) {
            ec4 ec4Var = new ec4();
            ec4Var.a = str;
            ub4.c().a(new tb4(120000, ec4Var));
        }
    }

    public static void j(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65545, null, str, i, str2) == null) {
            dc4 dc4Var = new dc4();
            dc4Var.b = str;
            dc4Var.c = i;
            dc4Var.a = str2;
            ub4.c().a(new tb4(80000, dc4Var));
        }
    }
}
