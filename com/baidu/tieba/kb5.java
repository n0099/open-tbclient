package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class kb5 {
    public static /* synthetic */ Interceptable $ic;
    public static final kb5 a;
    public static final HashMap<String, ib5> b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947907339, "Lcom/baidu/tieba/kb5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947907339, "Lcom/baidu/tieba/kb5;");
                return;
            }
        }
        a = new kb5();
        HashMap<String, ib5> hashMap = new HashMap<>();
        b = hashMap;
        hashMap.put("SCENE_HOT_EVENT", a.b());
        b.put("SCENE_TOP_NOTIFY", a.c());
    }

    public final ib5 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ib5 ib5Var = new ib5();
            ib5Var.j(true);
            ib5Var.g(2);
            ib5Var.i(R.dimen.tbds63);
            ib5Var.f(R.color.CAM_X0304);
            ib5Var.h(UtilHelper.getDimenPixelSize(R.dimen.M_W_X006));
            return ib5Var;
        }
        return (ib5) invokeV.objValue;
    }

    public kb5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final ib5 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ib5 ib5Var = new ib5();
            ib5Var.j(false);
            ib5Var.g(1);
            ib5Var.f(R.color.CAM_X0301);
            return ib5Var;
        }
        return (ib5) invokeV.objValue;
    }

    @JvmStatic
    public static final ib5 a(String key) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, key)) == null) {
            Intrinsics.checkNotNullParameter(key, "key");
            if (b.containsKey(key)) {
                return b.get(key);
            }
            return b.get("SCENE_HOT_EVENT");
        }
        return (ib5) invokeL.objValue;
    }
}
