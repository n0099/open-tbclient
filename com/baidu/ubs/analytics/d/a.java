package com.baidu.ubs.analytics.d;

import android.os.Environment;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;
    public static final String b;
    public static final String c;
    public static int d;
    public transient /* synthetic */ FieldHolder $fh;

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? "0.4.0" : (String) invokeV.objValue;
    }

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* renamed from: com.baidu.ubs.analytics.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class EnumC0510a {
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
        a = Environment.getExternalStorageDirectory().getPath();
        b = a + "/baidu/ab/crash/";
        c = a + "/baidu/ab/sdklog/";
        String str = a + "/baidu/ab/sdkupdata/" + b() + "/";
        d = EnumC0510a.aV;
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (d == EnumC0510a.aV) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            try {
                String[] split = "0.4.0".split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
                if (split.length > 2) {
                    return (Integer.parseInt(split[0]) * 100) + (Integer.parseInt(split[1]) * 10);
                }
                return 20;
            } catch (Exception e) {
                e.printStackTrace();
                return 20;
            }
        }
        return invokeV.intValue;
    }
}
