package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class jc5 {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = 2;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947878509, "Lcom/baidu/tieba/jc5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947878509, "Lcom/baidu/tieba/jc5;");
        }
    }

    public jc5() {
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

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return n95.m().n("fun_ad_big_image_density", 6);
        }
        return invokeV.intValue;
    }

    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return n95.m().n("fun_ad_big_image_floor", 5);
        }
        return invokeV.intValue;
    }

    public static int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return n95.m().n("fun_ad_big_image_size", 1);
        }
        return invokeV.intValue;
    }

    public static int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if (a < 0) {
                a = 2;
            }
            return a;
        }
        return invokeV.intValue;
    }

    public static int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            int n = n95.m().n("pref_key_fun_ad_density", 6);
            if (n <= 0) {
                return 6;
            }
            return n;
        }
        return invokeV.intValue;
    }

    public static int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return n95.m().n("pref_key_fun_ad_frs_density", 5);
        }
        return invokeV.intValue;
    }

    public static int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return n95.m().n("pref_key_fun_ad_frs_first_floor", 2);
        }
        return invokeV.intValue;
    }

    public static int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return n95.m().n("key_pb_comment_bear_density", 6);
        }
        return invokeV.intValue;
    }

    public static int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            int n = n95.m().n("key_pb_comment_bear_first", 4);
            if (n <= 0) {
                return 4;
            }
            return n;
        }
        return invokeV.intValue;
    }

    public static int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            return n95.m().n("key_pb_comment_bear_maxsize", 1);
        }
        return invokeV.intValue;
    }

    public static int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            return n95.m().n("key_video_middle_density", 4);
        }
        return invokeV.intValue;
    }

    public static int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            int n = n95.m().n("key_video_middle_first", 2);
            if (n <= 0) {
                return 2;
            }
            return n;
        }
        return invokeV.intValue;
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            int n = n95.m().n("pref_key_fun_ad_first_floor_min", 2);
            int n2 = n95.m().n("pref_key_fun_ad_first_floor_max", 3);
            if (n < n2) {
                a = u48.a(n, n2);
            } else {
                a = u48.a(n2, n);
            }
            if (a < 0) {
                a = 2;
            }
            return a;
        }
        return invokeV.intValue;
    }

    public void n(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        try {
            int optInt = jSONObject.optInt("frs_bear_first_floor", 2);
            int optInt2 = jSONObject.optInt("frs_bear_density", 5);
            n95.m().z("pref_key_fun_ad_frs_first_floor", optInt);
            n95.m().z("pref_key_fun_ad_frs_density", optInt2);
            int optInt3 = jSONObject.optInt("index_bear_density", 6);
            int optInt4 = jSONObject.optInt("index_bear_first_floor_max", 3);
            int optInt5 = jSONObject.optInt("index_bear_first_floor_min", 2);
            n95.m().z("pref_key_fun_ad_density", optInt3);
            n95.m().z("pref_key_fun_ad_first_floor_max", optInt4);
            n95.m().z("pref_key_fun_ad_first_floor_min", optInt5);
            int optInt6 = jSONObject.optInt("video_bear_density", 4);
            int optInt7 = jSONObject.optInt("video_bear_first_floor", 2);
            n95.m().z("key_video_middle_density", optInt6);
            n95.m().z("key_video_middle_first", optInt7);
            int optInt8 = jSONObject.optInt("pb_comment_bear_density", 6);
            int optInt9 = jSONObject.optInt("pb_comment_bear_first_floor", 4);
            int optInt10 = jSONObject.optInt("pb_comment_bear_max_size", 1);
            n95.m().z("key_pb_comment_bear_density", optInt8);
            n95.m().z("key_pb_comment_bear_first", optInt9);
            n95.m().z("key_pb_comment_bear_maxsize", optInt10);
            int optInt11 = jSONObject.optInt("picpage_bear_first_floor", 5);
            int optInt12 = jSONObject.optInt("picpage_bear_density", 6);
            int optInt13 = jSONObject.optInt("picpage_bear_max_size", 1);
            int optInt14 = jSONObject.optInt("picpage_bear_last_frame_switch", 0);
            n95.m().z("fun_ad_big_image_floor", optInt11);
            n95.m().z("fun_ad_big_image_density", optInt12);
            n95.m().z("fun_ad_big_image_size", optInt13);
            n95.m().z("fun_ad_big_image_switch", optInt14);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
