package com.baidu.tieba;

import android.os.Build;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class n75 {
    public static /* synthetic */ Interceptable $ic;
    public static Domain a;
    public static boolean b;
    public static o75 c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947955389, "Lcom/baidu/tieba/n75;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947955389, "Lcom/baidu/tieba/n75;");
                return;
            }
        }
        a = Domain.DOMAIN_ONLINE;
        if (vya.a(AppRuntime.getAppContext(), "USE_QA_PASS_LOGIN_ADDRESS")) {
            a = Domain.DOMAIN_QA;
        }
        b = true;
        c = null;
    }

    public static void c() {
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, null) == null) && c == null && (runTask = MessageManager.getInstance().runTask(2001268, o75.class)) != null && runTask.getData() != null) {
            c = (o75) runTask.getData();
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            if (TbConfig.USE_OLD_LOGIN) {
                b = true;
                return;
            }
            if (Build.VERSION.SDK_INT < 9) {
                if (TbadkCoreApplication.getInst().isLowVersionPassV6ShouldOpen()) {
                    b = false;
                } else {
                    b = true;
                }
            } else if (TbadkCoreApplication.getInst().isPassportV6ShouldOpen()) {
                b = false;
            } else {
                b = true;
            }
            if (Build.VERSION.SDK_INT <= 10 && !b && UtilHelper.webViewIsProbablyCorrupt(TbadkCoreApplication.getInst().getContext())) {
                TbadkCoreApplication.getInst().incPassportV6CrashCount();
                b = true;
            }
        }
    }

    public static o75 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return c;
        }
        return (o75) invokeV.objValue;
    }
}
