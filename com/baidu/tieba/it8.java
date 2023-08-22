package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.util.DialogUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.JvmStatic;
/* loaded from: classes6.dex */
public final class it8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947865148, "Lcom/baidu/tieba/it8;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947865148, "Lcom/baidu/tieba/it8;");
        }
    }

    @JvmStatic
    public static final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (TbSingleton.getInstance().getPushStrategyConfig().d()) {
                return DialogUtil.showPushPermissionDialog(TbadkCoreApplication.getInst(), 4);
            }
            return zz9.d.a().b("agree_message_bar");
        }
        return invokeV.booleanValue;
    }

    @JvmStatic
    public static final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (TbSingleton.getInstance().getPushStrategyConfig().d()) {
                return DialogUtil.showPushPermissionDialog(TbadkCoreApplication.getInst(), 3);
            }
            return zz9.d.a().b("at_message_bar");
        }
        return invokeV.booleanValue;
    }

    @JvmStatic
    public static final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (TbSingleton.getInstance().getPushStrategyConfig().d()) {
                return DialogUtil.showPushPermissionDialog(TbadkCoreApplication.getInst(), 5);
            }
            return zz9.d.a().b("fan_message_bar");
        }
        return invokeV.booleanValue;
    }

    @JvmStatic
    public static final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (TbSingleton.getInstance().getPushStrategyConfig().d()) {
                return DialogUtil.showPushPermissionDialog(TbadkCoreApplication.getInst(), 0);
            }
            return zz9.d.a().b("im");
        }
        return invokeV.booleanValue;
    }

    @JvmStatic
    public static final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (TbSingleton.getInstance().getPushStrategyConfig().d()) {
                return DialogUtil.showPushPermissionDialog(TbadkCoreApplication.getInst(), 6);
            }
            return zz9.d.a().b("reply_message_bar");
        }
        return invokeV.booleanValue;
    }
}
