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
/* loaded from: classes5.dex */
public class je0 {
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

    public je0() {
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

    public static je0 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            je0 je0Var = new je0();
            je0Var.d = "source";
            je0Var.a = "5.1_v2";
            je0Var.f = "resource_capture";
            String a = je0Var.a("resource_capture");
            je0Var.b = a;
            je0Var.c = me0.b(a);
            je0Var.g = je0Var.k();
            je0Var.h = je0Var.d();
            return je0Var;
        }
        return (je0) invokeV.objValue;
    }

    public static je0 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            je0 je0Var = new je0();
            je0Var.d = "source";
            je0Var.a = "5.1_v2";
            je0Var.f = "resource_live";
            String a = je0Var.a("resource_live");
            je0Var.b = a;
            je0Var.c = me0.b(a);
            je0Var.g = je0Var.k();
            je0Var.h = je0Var.d();
            return je0Var;
        }
        return (je0) invokeV.objValue;
    }

    public static je0 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            je0 je0Var = new je0();
            je0Var.d = "so";
            je0Var.e = "so1";
            je0Var.a = "5.1_v2";
            String j = je0Var.j("so1");
            je0Var.b = j;
            je0Var.c = me0.b(j);
            je0Var.g = je0Var.k();
            if (zd0.m()) {
                cf0.a("DuAr_", "so1 local file path = " + je0Var.g.getAbsolutePath());
            }
            je0Var.h = je0Var.d();
            return je0Var;
        }
        return (je0) invokeV.objValue;
    }

    public static je0 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            je0 je0Var = new je0();
            je0Var.d = "so";
            je0Var.e = "so2";
            je0Var.a = "5.1_v2";
            String j = je0Var.j("so2");
            je0Var.b = j;
            je0Var.c = me0.b(j);
            je0Var.g = je0Var.k();
            if (zd0.m()) {
                cf0.a("DuAr_", "So2 local file path = " + je0Var.g.getAbsolutePath());
            }
            je0Var.h = je0Var.d();
            return je0Var;
        }
        return (je0) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            boolean a = df0.a(zd0.getContext());
            if (TextUtils.equals(this.d, "so")) {
                if (TextUtils.equals(this.e, "so2")) {
                    return ke0.f().getAbsolutePath();
                }
                return ke0.b(a).getAbsolutePath();
            }
            return ke0.d().g().getAbsolutePath();
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
                if (df0.a(zd0.getContext())) {
                    str2 = "https://pic.rmb.bdstatic.com/baidu-ar-so-64bit-";
                }
            }
            return str2 + "5.1_v2.zip";
        }
        return (String) invokeL.objValue;
    }
}
