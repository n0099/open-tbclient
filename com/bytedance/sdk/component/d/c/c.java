package com.bytedance.sdk.component.d.c;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.sdk.component.d.h;
/* loaded from: classes5.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static h f28795a;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, hVar) == null) {
            f28795a = hVar;
        }
    }

    public static void b(String str) {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, str) == null) || (hVar = f28795a) == null) {
            return;
        }
        hVar.b(str);
    }

    public static void a(String str) {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, str) == null) || (hVar = f28795a) == null) {
            return;
        }
        hVar.a(str);
    }

    public static void b(String str, String str2) {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2) == null) || (hVar = f28795a) == null) {
            return;
        }
        hVar.b(str, str2);
    }

    public static void a(String str, String str2) {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, str, str2) == null) || (hVar = f28795a) == null) {
            return;
        }
        hVar.a(str, str2);
    }
}
