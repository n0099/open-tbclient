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
/* loaded from: classes5.dex */
public final class op1 extends po2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public interface a {
        public static final String a = po2.r("SwanApkFetcher.Params", "title");
        public static final String b = po2.r("SwanApkFetcher.Params", EmotionResourceInfo.JSON_KEY_PKG_NAME);
        public static final String c = po2.r("SwanApkFetcher.Params", "description");
        public static final String d = po2.r("SwanApkFetcher.Params", "should_auto_install");
        public static final String e = po2.r("SwanApkFetcher.Params", "current_swan_app");
        public static final String f = po2.r("SwanApkFetcher.Params", "content_disposition");
        public static final String g = po2.r("SwanApkFetcher.Params", "mime_type");
        public static final String h = po2.r("SwanApkFetcher.Params", HttpRequest.USER_AGENT);
        public static final String i = po2.r("SwanApkFetcher.Params", BreakpointSQLiteKey.CONTENT_LENGTH);
        public static final String j = po2.r("SwanApkFetcher.Params", "ext_info");
    }

    public op1 M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this : (op1) invokeV.objValue;
    }

    public op1() {
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

    @Override // com.baidu.tieba.ii3
    public /* bridge */ /* synthetic */ ii3 a() {
        M();
        return this;
    }

    public op1 E(Boolean bool) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bool)) == null) {
            return (op1) t(a.d, bool.booleanValue());
        }
        return (op1) invokeL.objValue;
    }

    public op1 F(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            return (op1) z(a.f, str);
        }
        return (op1) invokeL.objValue;
    }

    public op1 G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            return (op1) z(a.i, str);
        }
        return (op1) invokeL.objValue;
    }

    public op1 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            return (op1) z(a.e, str);
        }
        return (op1) invokeL.objValue;
    }

    public op1 I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            return (op1) z(a.c, str);
        }
        return (op1) invokeL.objValue;
    }

    public op1 J(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            return (op1) z(a.j, str);
        }
        return (op1) invokeL.objValue;
    }

    public op1 K(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            return (op1) z(a.g, str);
        }
        return (op1) invokeL.objValue;
    }

    public op1 L(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            return (op1) z(a.b, str);
        }
        return (op1) invokeL.objValue;
    }

    public op1 N(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            return (op1) z(a.a, str);
        }
        return (op1) invokeL.objValue;
    }

    public op1 O(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            return (op1) z(a.h, str);
        }
        return (op1) invokeL.objValue;
    }
}
