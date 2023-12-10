package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class k4a {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;
    public static final String b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947864497, "Lcom/baidu/tieba/k4a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947864497, "Lcom/baidu/tieba/k4a;");
                return;
            }
        }
        a = SharedPrefHelper.getSharedPrefKeyWithAccount("key_show_god_agree_tips_count");
        b = SharedPrefHelper.getSharedPrefKeyWithAccount("key_show_god_agree_tips_timestamp");
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, null) == null) && !b()) {
            SharedPrefHelper.getInstance().putLong(b, System.currentTimeMillis());
            SharedPrefHelper.getInstance().putInt(a, 0);
        }
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = SharedPrefHelper.getInstance().getLong(b, 0L);
            if (j >= 0) {
                return TimeHelper.isSameDay(currentTimeMillis, j);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean c(aw9 aw9Var) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, aw9Var)) == null) {
            if (aw9Var == null || aw9Var.R() == null || !TbadkCoreApplication.isLogin() || !aw9Var.R().isExcellentThread() || aw9Var.R().getHasAgree() == 1) {
                return false;
            }
            if (b()) {
                i = SharedPrefHelper.getInstance().getInt(a, 0);
            } else {
                i = 0;
            }
            if (i >= 2) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void d(Context context, View view2, aw9 aw9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, view2, aw9Var) != null) || cu9.c() || c(aw9Var)) {
        }
    }
}
