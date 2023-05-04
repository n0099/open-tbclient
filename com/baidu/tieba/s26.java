package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tieba.advert.sdk.data.AdInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.io.PrintStream;
import java.util.Date;
/* loaded from: classes6.dex */
public class s26 {
    public static /* synthetic */ Interceptable $ic = null;
    public static long a = 0;
    public static String b = "5";
    public static String c = "6";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948099570, "Lcom/baidu/tieba/s26;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948099570, "Lcom/baidu/tieba/s26;");
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            int i = 0;
            if (b()) {
                i = f55.m().n("key_plg_show_count", 0);
            } else {
                f55.m().A("key_plg_show_count_reset_time", System.currentTimeMillis());
            }
            f55.m().z("key_plg_show_count", i + 1);
        }
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            long o = f55.m().o("key_plg_show_count_reset_time", 0L);
            if (o >= 0) {
                return TimeHelper.isSameDay(new Date(o), new Date(System.currentTimeMillis()));
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            File file = new File(o26.b);
            if (file.exists()) {
                FileHelper.deleteFileOrDir(file);
            }
        }
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            TbadkCoreApplication.getInst().getContext().getSharedPreferences("bc_splash_info_new", 0).edit().putString("bc_splash_info_new", "").apply();
        }
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return TbadkCoreApplication.getInst().getContext().getSharedPreferences("bc_splash_info_new", 0).getString("bc_splash_info_new", "");
        }
        return (String) invokeV.objValue;
    }

    public static boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = currentTimeMillis - a;
            if (0 < j && j < 500) {
                return true;
            }
            a = currentTimeMillis;
            return false;
        }
        return invokeV.booleanValue;
    }

    public static void d(File file) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, file) == null) {
            File file2 = new File(o26.b);
            if (!file2.exists() || (listFiles = file2.listFiles()) == null) {
                return;
            }
            for (File file3 : listFiles) {
                if (file3 != null && !file3.equals(file)) {
                    FileHelper.deleteFileOrDir(file3);
                }
            }
        }
    }

    public static void i(AdInfo adInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, adInfo) == null) {
            TbadkCoreApplication.getInst().getContext().getSharedPreferences("bc_splash_info_new", 0).edit().putString("bc_splash_info_new", z16.a(adInfo).toString()).apply();
        }
    }

    public static void j(z16 z16Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, z16Var) == null) {
            if (z16Var == null) {
                e();
            } else {
                TbadkCoreApplication.getInst().getContext().getSharedPreferences("bc_splash_info_new", 0).edit().putString("bc_splash_info_new", z16Var.toString()).apply();
            }
        }
    }

    public static boolean g() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            int n = f55.m().n("key_plg_show_count", 0);
            if ((UbsABTestHelper.isPlgRequestLimitA() && n > 20) || ((UbsABTestHelper.isPlgRequestLimitB() && n > 25) || (UbsABTestHelper.isPlgRequestLimitC() && n > 30))) {
                z = true;
            } else {
                z = false;
            }
            if (!b()) {
                return false;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public static void k(String str, String str2, String str3, String str4, int i, int i2, boolean z, long j) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{str, str2, str3, str4, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Long.valueOf(j)}) == null) {
            StatisticItem param = StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", str).param("obj_type", "a064").param("obj_locate", str2).param("resource_id", Math.max(i2, 0));
            if (z) {
                i3 = 2;
            } else {
                i3 = 1;
            }
            StatisticItem param2 = param.param("obj_param1", i3).param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param(TiebaStatic.Params.SPLASH_UNI, j);
            if (!StringUtils.isNull(str3)) {
                param2.param(TiebaStatic.Params.OBJ_PARAM2, i);
                param2.param(TiebaStatic.Params.OBJ_PARAM3, str3);
            }
            if (StringUtils.isNull(str4)) {
                param2.param(TiebaStatic.Params.OBJ_TO, str4);
            }
            TiebaStatic.log(param2);
        }
    }

    public static void l(String str, String str2, String str3, String str4, String str5, String str6, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{str, str2, str3, str4, str5, str6, Long.valueOf(j)}) == null) {
            StatisticItem param = StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_SHOW).param("obj_source", str).param("obj_type", "a064").param("obj_locate", str2).param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param(TiebaStatic.Params.SPLASH_UNI, j);
            if (!StringUtils.isNull(str4)) {
                param.param(TiebaStatic.Params.OBJ_TO, str4);
            }
            if (!StringUtils.isNull(str3)) {
                param.param("topic_id", str3);
            }
            if (!StringUtils.isNull(str5)) {
                param.param("obj_param1", str5);
                if (TbadkCoreApplication.getInst().isDebugMode() || aw4.h()) {
                    PrintStream printStream = System.out;
                    printStream.println("FunAdSdk show sid:" + str5 + " aid:" + str4 + " adAppId:" + str6);
                }
            }
            if (!StringUtils.isNull(str6)) {
                param.param(TiebaStatic.Params.OBJ_PARAM2, str6);
            }
            TiebaStatic.log(param);
        }
    }
}
