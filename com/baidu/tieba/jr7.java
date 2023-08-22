package com.baidu.tieba;

import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.util.PushOpenUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.JvmStatic;
/* loaded from: classes6.dex */
public final class jr7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947892986, "Lcom/baidu/tieba/jr7;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947892986, "Lcom/baidu/tieba/jr7;");
        }
    }

    @JvmStatic
    public static final boolean a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            if (TbSingleton.getInstance().getPushStrategyConfig().d()) {
                return PushOpenUtil.shouldShowPushOpenView(TbadkCoreApplication.getInst(), i);
            }
            return zz9.d.a().b("forum_follow");
        }
        return invokeI.booleanValue;
    }

    @JvmStatic
    public static final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (TbSingleton.getInstance().getPushStrategyConfig().d()) {
                return PushOpenUtil.shouldShowPushOpenView(TbadkCoreApplication.getInst(), 4);
            }
            return zz9.d.a().b("forum_sign");
        }
        return invokeV.booleanValue;
    }
}
