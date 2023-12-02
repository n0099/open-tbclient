package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteKey;
import com.baidu.searchbox.download.util.MigrateStatisticUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class ns1 extends nr2<ns1> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public interface a {
        public static final String a = nr2.r("SwanApkFetcher.Params", "title");
        public static final String b = nr2.r("SwanApkFetcher.Params", "pkg_name");
        public static final String c = nr2.r("SwanApkFetcher.Params", "description");
        public static final String d = nr2.r("SwanApkFetcher.Params", "should_auto_install");
        public static final String e = nr2.r("SwanApkFetcher.Params", "current_swan_app");
        public static final String f = nr2.r("SwanApkFetcher.Params", "content_disposition");
        public static final String g = nr2.r("SwanApkFetcher.Params", "mime_type");
        public static final String h = nr2.r("SwanApkFetcher.Params", "user_agent");
        public static final String i = nr2.r("SwanApkFetcher.Params", BreakpointSQLiteKey.CONTENT_LENGTH);
        public static final String j = nr2.r("SwanApkFetcher.Params", MigrateStatisticUtils.EXT_INFO);
    }

    public ns1 N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this : (ns1) invokeV.objValue;
    }

    public ns1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.gl3
    public /* bridge */ /* synthetic */ gl3 n() {
        N();
        return this;
    }

    public ns1 F(Boolean bool) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bool)) == null) {
            return t(a.d, bool.booleanValue());
        }
        return (ns1) invokeL.objValue;
    }

    public ns1 G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            return z(a.f, str);
        }
        return (ns1) invokeL.objValue;
    }

    public ns1 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            return z(a.i, str);
        }
        return (ns1) invokeL.objValue;
    }

    public ns1 I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            return z(a.e, str);
        }
        return (ns1) invokeL.objValue;
    }

    public ns1 J(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            return z(a.c, str);
        }
        return (ns1) invokeL.objValue;
    }

    public ns1 K(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            return z(a.j, str);
        }
        return (ns1) invokeL.objValue;
    }

    public ns1 L(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            return z(a.g, str);
        }
        return (ns1) invokeL.objValue;
    }

    public ns1 M(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            return z(a.b, str);
        }
        return (ns1) invokeL.objValue;
    }

    public ns1 O(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            return z(a.a, str);
        }
        return (ns1) invokeL.objValue;
    }

    public ns1 P(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            return z(a.h, str);
        }
        return (ns1) invokeL.objValue;
    }
}
