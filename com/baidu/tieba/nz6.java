package com.baidu.tieba;

import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.PvThread;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.log.TbLog;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.JvmStatic;
/* loaded from: classes7.dex */
public final class nz6 {
    public static /* synthetic */ Interceptable $ic;
    public static final nz6 a;
    public static long b;
    public static int c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948019807, "Lcom/baidu/tieba/nz6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948019807, "Lcom/baidu/tieba/nz6;");
                return;
            }
        }
        a = new nz6();
    }

    public nz6() {
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
    public static final void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, null) == null) && b > 0) {
            SharedPrefHelper.getInstance().putLong("key_last_page_pause_time", ((System.nanoTime() - b) / 1000000) / 1000);
        }
    }

    public final boolean a() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (c == 0) {
                if (UbsABTestHelper.isExistSid("12.48_client_time_page_count_a")) {
                    i = 1;
                } else {
                    i = 2;
                }
                c = i;
            }
            if (c == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return SharedPrefHelper.getInstance().getBoolean("key_is_last_client_uploaded", true);
        }
        return invokeV.booleanValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            long j = b;
            if (j > 0) {
                c(j);
                b = 0L;
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            h();
            if (b == 0) {
                b = System.nanoTime();
                g(false);
                DefaultLog.getInstance().i("ClientDurationHelper", "processUseDuration setIsUploaded false");
            }
        }
    }

    @JvmStatic
    public static final void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65539, null, z) == null) {
            SharedPrefHelper.getInstance().putBoolean("key_is_last_client_uploaded", z);
        }
    }

    public final void c(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            long nanoTime = ((System.nanoTime() - j) / 1000000) / 1000;
            if (PermissionUtil.isAgreePrivacyPolicy()) {
                i(nanoTime);
                g(true);
                DefaultLog.getInstance().i("ClientDurationHelper", "processUseDuration setIsUploaded true");
            }
        }
    }

    public final void i(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048582, this, j) == null) && j >= TbadkCoreApplication.getInst().getUseTimeInterval()) {
            new PvThread("use", String.valueOf(j)).start();
            TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), "use", null, 1, "st_param", String.valueOf(j));
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && !b() && PermissionUtil.isAgreePrivacyPolicy()) {
            long j = SharedPrefHelper.getInstance().getLong("key_last_page_pause_time", 0L);
            i(j);
            TbLog defaultLog = DefaultLog.getInstance();
            defaultLog.i("ClientDurationHelper", "trySupplementClientTime pauseTime=" + j);
        }
    }
}
