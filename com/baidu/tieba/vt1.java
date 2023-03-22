package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteKey;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class vt1 extends ws2<vt1> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public interface a {
        public static final String a = ws2.r("SwanApkFetcher.Params", "title");
        public static final String b = ws2.r("SwanApkFetcher.Params", EmotionResourceInfo.JSON_KEY_PKG_NAME);
        public static final String c = ws2.r("SwanApkFetcher.Params", "description");
        public static final String d = ws2.r("SwanApkFetcher.Params", "should_auto_install");
        public static final String e = ws2.r("SwanApkFetcher.Params", "current_swan_app");
        public static final String f = ws2.r("SwanApkFetcher.Params", "content_disposition");
        public static final String g = ws2.r("SwanApkFetcher.Params", "mime_type");
        public static final String h = ws2.r("SwanApkFetcher.Params", HttpRequest.USER_AGENT);
        public static final String i = ws2.r("SwanApkFetcher.Params", BreakpointSQLiteKey.CONTENT_LENGTH);
        public static final String j = ws2.r("SwanApkFetcher.Params", "ext_info");
    }

    public vt1 M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this : (vt1) invokeV.objValue;
    }

    public vt1() {
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

    @Override // com.baidu.tieba.pm3
    public /* bridge */ /* synthetic */ pm3 d() {
        M();
        return this;
    }

    public vt1 E(Boolean bool) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bool)) == null) {
            return t(a.d, bool.booleanValue());
        }
        return (vt1) invokeL.objValue;
    }

    public vt1 F(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            return z(a.f, str);
        }
        return (vt1) invokeL.objValue;
    }

    public vt1 G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            return z(a.i, str);
        }
        return (vt1) invokeL.objValue;
    }

    public vt1 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            return z(a.e, str);
        }
        return (vt1) invokeL.objValue;
    }

    public vt1 I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            return z(a.c, str);
        }
        return (vt1) invokeL.objValue;
    }

    public vt1 J(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            return z(a.j, str);
        }
        return (vt1) invokeL.objValue;
    }

    public vt1 K(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            return z(a.g, str);
        }
        return (vt1) invokeL.objValue;
    }

    public vt1 L(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            return z(a.b, str);
        }
        return (vt1) invokeL.objValue;
    }

    public vt1 N(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            return z(a.a, str);
        }
        return (vt1) invokeL.objValue;
    }

    public vt1 O(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            return z(a.h, str);
        }
        return (vt1) invokeL.objValue;
    }
}
