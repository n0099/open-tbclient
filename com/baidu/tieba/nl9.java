package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pyramid.annotation.Service;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
@Service
/* loaded from: classes7.dex */
public class nl9 implements ig5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public nl9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return da5.p().q("key_pb_enter_frs_tip_followed_floor", 5);
        }
        return invokeV.intValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return da5.p().q("key_pb_enter_frs_tip_followed_new_post_num", 100);
        }
        return invokeV.intValue;
    }

    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return da5.p().q("key_pb_enter_frs_tip_followed_time", 10);
        }
        return invokeV.intValue;
    }

    public static int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return da5.p().q("key_pb_enter_frs_tip_followed_visit_day", 3);
        }
        return invokeV.intValue;
    }

    public static int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return da5.p().q("key_pb_enter_frs_tip_no_followed_floor", 8);
        }
        return invokeV.intValue;
    }

    public static int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return da5.p().q("key_pb_enter_frs_tip_no_followed_time", 30);
        }
        return invokeV.intValue;
    }

    public static int e(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65541, null, z)) == null) {
            if (z) {
                return a();
            }
            return f();
        }
        return invokeZ.intValue;
    }

    public static int h(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65544, null, z)) == null) {
            if (z) {
                return c();
            }
            return g();
        }
        return invokeZ.intValue;
    }

    @Override // com.baidu.tieba.ig5
    public void parseJson(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
            i(jSONObject.optJSONObject("sprite_pb_guide"));
        }
    }

    public static void i(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65545, null, jSONObject) != null) || jSONObject == null) {
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("followed");
        if (optJSONObject != null) {
            int optInt = optJSONObject.optInt("waiting_floor");
            if (optInt > 0) {
                da5.p().F("key_pb_enter_frs_tip_followed_floor", optInt);
            }
            int optInt2 = optJSONObject.optInt("waiting_time");
            if (optInt2 > 0) {
                da5.p().F("key_pb_enter_frs_tip_followed_time", optInt2);
            }
            int optInt3 = optJSONObject.optInt("visit_day");
            if (optInt3 > 0) {
                da5.p().F("key_pb_enter_frs_tip_followed_visit_day", optInt3);
            }
            int optInt4 = optJSONObject.optInt("new_post_num");
            if (optInt4 > 0) {
                da5.p().F("key_pb_enter_frs_tip_followed_new_post_num", optInt4);
            }
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("unfollowed");
        if (optJSONObject2 != null) {
            int optInt5 = optJSONObject2.optInt("waiting_floor");
            if (optInt5 > 0) {
                da5.p().F("key_pb_enter_frs_tip_no_followed_floor", optInt5);
            }
            int optInt6 = optJSONObject2.optInt("waiting_time");
            if (optInt6 > 0) {
                da5.p().F("key_pb_enter_frs_tip_no_followed_time", optInt6);
            }
        }
    }
}
