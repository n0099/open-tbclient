package com.baidu.tieba;

import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes8.dex */
public final class zx1 extends yw2<zx1> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public interface a {
        public static final String a = yw2.r("SwanFileFetcher.Params", "file_url");
        public static final String b = yw2.r("SwanFileFetcher.Params", "file_save_path");
        public static final String c = yw2.r("SwanFileFetcher.Params", "file_head_map");
        public static final String d = yw2.r("SwanFileFetcher.Params", "image_save_gallery");
        public static final String e = yw2.r("SwanFileFetcher.Params", "file_cancel_tag");
    }

    public zx1 J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this : (zx1) invokeV.objValue;
    }

    public zx1() {
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

    @Override // com.baidu.tieba.rq3
    public /* bridge */ /* synthetic */ rq3 h() {
        J();
        return this;
    }

    public zx1 E(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            return z(a.e, str);
        }
        return (zx1) invokeL.objValue;
    }

    public zx1 G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            return z(a.b, str);
        }
        return (zx1) invokeL.objValue;
    }

    public zx1 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            return z(a.a, str);
        }
        return (zx1) invokeL.objValue;
    }

    public zx1 I(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
            return t(a.d, z);
        }
        return (zx1) invokeZ.objValue;
    }

    public zx1 F(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map)) == null) {
            Bundle bundle = new Bundle();
            if (map != null && !map.isEmpty()) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    bundle.putString(entry.getKey(), entry.getValue());
                }
            }
            return u(a.c, bundle);
        }
        return (zx1) invokeL.objValue;
    }
}
