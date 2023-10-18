package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import androidx.media2.session.SessionCommand;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.android.exoplayer2.extractor.ogg.DefaultOggSeeker;
/* loaded from: classes6.dex */
public class j64 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65536, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        q64 q64Var = new q64();
        q64Var.a = str;
        g64.c().a(new f64(50000, q64Var));
    }

    public static void b(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        q64 q64Var = new q64();
        q64Var.a = str;
        g64.c().a(new f64(90000, q64Var));
    }

    public static void e(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        q64 q64Var = new q64();
        q64Var.a = str;
        g64.c().a(new f64(60000, q64Var));
    }

    public static void g(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65542, null, callbackHandler, str) != null) || !UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            return;
        }
        q64 q64Var = new q64();
        q64Var.a = str;
        g64.c().a(new f64(SessionCommand.COMMAND_CODE_SESSION_FAST_FORWARD, q64Var));
    }

    public static void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, str2) == null) {
            o64 o64Var = new o64();
            o64Var.b = str;
            o64Var.a = str2;
            g64.c().a(new f64(30000, o64Var));
        }
    }

    public static void c(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            n64 n64Var = new n64();
            n64Var.b = str;
            n64Var.c = i;
            n64Var.d = z ? 1 : 0;
            n64Var.a = str2;
            g64.c().a(new f64(DefaultOggSeeker.MATCH_BYTE_RANGE, n64Var));
        }
    }

    public static void h(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            n64 n64Var = new n64();
            n64Var.b = str;
            n64Var.c = i;
            n64Var.d = z ? 1 : 0;
            n64Var.a = str2;
            g64.c().a(new f64(70000, n64Var));
        }
    }

    public static void k(String str, int i, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
            n64 n64Var = new n64();
            n64Var.b = str;
            n64Var.c = i;
            n64Var.d = z ? 1 : 0;
            n64Var.a = str2;
            g64.c().a(new f64(110000, n64Var));
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            q64 q64Var = new q64();
            q64Var.a = str;
            g64.c().a(new f64(20000, q64Var));
        }
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            q64 q64Var = new q64();
            q64Var.a = str;
            g64.c().a(new f64(10000, q64Var));
        }
    }

    public static void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, str) == null) {
            q64 q64Var = new q64();
            q64Var.a = str;
            g64.c().a(new f64(120000, q64Var));
        }
    }

    public static void j(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65545, null, str, i, str2) == null) {
            p64 p64Var = new p64();
            p64Var.b = str;
            p64Var.c = i;
            p64Var.a = str2;
            g64.c().a(new f64(80000, p64Var));
        }
    }
}
