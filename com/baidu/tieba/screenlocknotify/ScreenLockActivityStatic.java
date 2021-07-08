package com.baidu.tieba.screenlocknotify;

import android.content.Intent;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ScreenLockActivityConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.y2.a;
/* loaded from: classes4.dex */
public class ScreenLockActivityStatic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2010814790, "Lcom/baidu/tieba/screenlocknotify/ScreenLockActivityStatic;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2010814790, "Lcom/baidu/tieba/screenlocknotify/ScreenLockActivityStatic;");
                return;
            }
        }
        TbadkApplication.getInst().RegisterIntent(ScreenLockActivityConfig.class, ScreenLockActivity.class);
        try {
            a.j();
            TbadkCoreApplication.getInst().getApp().startService(new Intent(TbadkCoreApplication.getInst().getApp(), ScreenLockNotifyService.class));
        } catch (Exception e2) {
            BdLog.e(e2);
            d.a.c.h.h.a b2 = d.a.c.h.h.a.b();
            b2.r("plugin_load", "screenlock_failed", null, e2.getMessage() + "---" + e2.getClass().getName());
        }
    }

    public ScreenLockActivityStatic() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }
}
