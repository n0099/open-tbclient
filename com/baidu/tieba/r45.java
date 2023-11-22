package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.debugtool.annotation.ModifyClass;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.JvmStatic;
@ModifyClass
/* loaded from: classes8.dex */
public final class r45 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final r45 a;
    public static volatile int b = -1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948071670, "Lcom/baidu/tieba/r45;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948071670, "Lcom/baidu/tieba/r45;");
                return;
            }
        }
        a = new r45();
    }

    public r45() {
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

    @JvmStatic
    public static final synchronized boolean a() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (r45.class) {
                z = false;
                if (b != 1 && b != 0) {
                    b = TbadkCoreApplication.getInst().getSharedPreferences("shared_pref_downgrade", 0).getInt("shared_pref_downgrade_key", 0);
                }
                if (b == 1) {
                    z = true;
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    @JvmStatic
    public static final synchronized void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, null, i) == null) {
            synchronized (r45.class) {
                TbadkCoreApplication.getInst().getSharedPreferences("shared_pref_downgrade", 0).edit().putInt("shared_pref_downgrade_key", i).apply();
            }
        }
    }
}
