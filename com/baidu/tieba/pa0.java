package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes7.dex */
public class pa0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public File g;
    public File h;

    public pa0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = "5.1_v2";
        this.g = null;
    }

    public File c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return k();
        }
        return (File) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a + "-" + this.c;
        }
        return (String) invokeV.objValue;
    }

    public File k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.g == null && !TextUtils.isEmpty(this.a)) {
                this.g = new File(b(), e());
            }
            return this.g;
        }
        return (File) invokeV.objValue;
    }

    public static pa0 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            pa0 pa0Var = new pa0();
            pa0Var.d = "source";
            pa0Var.a = "5.1_v2";
            pa0Var.f = "resource_capture";
            String a = pa0Var.a("resource_capture");
            pa0Var.b = a;
            pa0Var.c = sa0.b(a);
            pa0Var.g = pa0Var.k();
            pa0Var.h = pa0Var.d();
            return pa0Var;
        }
        return (pa0) invokeV.objValue;
    }

    public static pa0 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            pa0 pa0Var = new pa0();
            pa0Var.d = "source";
            pa0Var.a = "5.1_v2";
            pa0Var.f = "resource_live";
            String a = pa0Var.a("resource_live");
            pa0Var.b = a;
            pa0Var.c = sa0.b(a);
            pa0Var.g = pa0Var.k();
            pa0Var.h = pa0Var.d();
            return pa0Var;
        }
        return (pa0) invokeV.objValue;
    }

    public static pa0 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            pa0 pa0Var = new pa0();
            pa0Var.d = "so";
            pa0Var.e = "so1";
            pa0Var.a = "5.1_v2";
            String j = pa0Var.j("so1");
            pa0Var.b = j;
            pa0Var.c = sa0.b(j);
            pa0Var.g = pa0Var.k();
            if (fa0.n()) {
                ib0.a("DuAr_", "so1 local file path = " + pa0Var.g.getAbsolutePath());
            }
            pa0Var.h = pa0Var.d();
            return pa0Var;
        }
        return (pa0) invokeV.objValue;
    }

    public static pa0 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            pa0 pa0Var = new pa0();
            pa0Var.d = "so";
            pa0Var.e = "so2";
            pa0Var.a = "5.1_v2";
            String j = pa0Var.j("so2");
            pa0Var.b = j;
            pa0Var.c = sa0.b(j);
            pa0Var.g = pa0Var.k();
            if (fa0.n()) {
                ib0.a("DuAr_", "So2 local file path = " + pa0Var.g.getAbsolutePath());
            }
            pa0Var.h = pa0Var.d();
            return pa0Var;
        }
        return (pa0) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            boolean a = jb0.a(fa0.c());
            if (TextUtils.equals(this.d, "so")) {
                if (TextUtils.equals(this.e, "so2")) {
                    return qa0.f().getAbsolutePath();
                }
                return qa0.b(a).getAbsolutePath();
            }
            return qa0.d().g().getAbsolutePath();
        }
        return (String) invokeV.objValue;
    }

    public File d() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.h == null) {
                File c = c();
                if (c != null) {
                    str = c.getAbsolutePath();
                } else {
                    str = null;
                }
                if (str == null) {
                    return null;
                }
                if (!str.endsWith(".zip")) {
                    str = str + ".zip";
                }
                if (!str.endsWith(".loading")) {
                    str = str + ".loading";
                }
                this.h = new File(str);
            }
            return this.h;
        }
        return (File) invokeV.objValue;
    }

    public final String a(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.equals("resource_live", str)) {
                str2 = "https://pic.rmb.bdstatic.com/baidu-ar-source-live-";
            } else {
                str2 = "https://pic.rmb.bdstatic.com/baidu-ar-source-";
            }
            return str2 + "5.1_v2.zip";
        }
        return (String) invokeL.objValue;
    }

    public final String j(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (TextUtils.equals("so2", str)) {
                str2 = "https://pic.rmb.bdstatic.com/baidu-ar-so-live-";
            } else {
                str2 = "https://pic.rmb.bdstatic.com/baidu-ar-so-";
                if (jb0.a(fa0.c())) {
                    str2 = "https://pic.rmb.bdstatic.com/baidu-ar-so-64bit-";
                }
            }
            return str2 + "5.1_v2.zip";
        }
        return (String) invokeL.objValue;
    }
}
