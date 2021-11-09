package com.baidu.ubs.analytics.d;

import android.os.Environment;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes10.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String f56623a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f56624b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f56625c;

    /* renamed from: d  reason: collision with root package name */
    public static int f56626d;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* renamed from: com.baidu.ubs.analytics.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static final class EnumC1776a {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int aV = 1;
        public static final int aW = 2;
        public static final /* synthetic */ int[] aX;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(233154568, "Lcom/baidu/ubs/analytics/d/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(233154568, "Lcom/baidu/ubs/analytics/d/a$a;");
                    return;
                }
            }
            aX = new int[]{1, 2};
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1863927717, "Lcom/baidu/ubs/analytics/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1863927717, "Lcom/baidu/ubs/analytics/d/a;");
                return;
            }
        }
        f56623a = Environment.getExternalStorageDirectory().getPath();
        f56624b = f56623a + "/baidu/ab/crash/";
        f56625c = f56623a + "/baidu/ab/sdklog/";
        String str = f56623a + "/baidu/ab/sdkupdata/" + b() + "/";
        f56626d = EnumC1776a.aV;
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? f56626d == EnumC1776a.aV : invokeV.booleanValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            try {
                String[] split = "0.4.0".split("\\.");
                if (split.length > 2) {
                    return (Integer.parseInt(split[0]) * 100) + (Integer.parseInt(split[1]) * 10);
                }
                return 20;
            } catch (Exception e2) {
                e2.printStackTrace();
                return 20;
            }
        }
        return invokeV.intValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? "0.4.0" : (String) invokeV.objValue;
    }
}
