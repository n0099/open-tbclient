package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coremedia.iso.boxes.FreeSpaceBox;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ug1 {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = 120;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948209930, "Lcom/baidu/tieba/ug1;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948209930, "Lcom/baidu/tieba/ug1;");
        }
    }

    public ug1() {
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final JSONObject a(String str, boolean z) {
        InterceptResult invokeLZ;
        char c;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, str, z)) == null) {
            switch (str.hashCode()) {
                case -1472943047:
                    if (str.equals("click_float_lottie")) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case -1340273551:
                    if (str.equals("wifi_tip")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case -1152479161:
                    if (str.equals("ad_logo")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -264975480:
                    if (str.equals("bd_logo")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 3327403:
                    if (str.equals("logo")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 3532159:
                    if (str.equals(FreeSpaceBox.TYPE)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 31392744:
                    if (str.equals("download_desc")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 102727412:
                    if (str.equals("label")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    if (z) {
                        str2 = "{\"l_gravity\": 10,\"margin\": \"0_0_0_0\"}";
                        break;
                    } else {
                        str2 = "{\"l_gravity\": 10,\"margin\": \"0_0_0_" + a + "\"}";
                        break;
                    }
                case 1:
                    if (z) {
                        str2 = "{\"l_gravity\": 10,\"margin\": \"0_0_25_0\"}";
                        break;
                    } else {
                        str2 = "{\"l_gravity\": 10,\"margin\": \"0_0_25_" + a + "\"}";
                        break;
                    }
                case 2:
                    str2 = "{\"l_gravity\": 9,\"margin\": \"0_20_15_0\"}";
                    break;
                case 3:
                    str2 = "{\"l_gravity\": 5,\"margin\": \"15_20_0_0\"}";
                    break;
                case 4:
                    if (z) {
                        str2 = "{\"l_gravity\": 18,\"margin\": \"0_0_0_15\"}";
                        break;
                    } else {
                        str2 = "{\"l_gravity\": 18,\"margin\": \"0_0_0_" + (a + 15) + "\"}";
                        break;
                    }
                case 5:
                    str2 = "{\"l_gravity\": 5,\"margin\": \"14_14_0_0\"}";
                    break;
                case 6:
                    if (z) {
                        str2 = "{\"l_gravity\": 6,\"margin\": \"0_0_0_65\"}";
                        break;
                    } else {
                        str2 = "{\"l_gravity\": 6,\"margin\": \"0_0_0_" + a + "\"}";
                        break;
                    }
                case 7:
                    if (z) {
                        str2 = "{\"l_gravity\": 18,\"margin\": \"0_0_0_37\"}";
                        break;
                    } else {
                        str2 = "{\"is_equal_bottom_logo\":0,\"l_gravity\": 18,\"margin\": \"0_0_0_" + (a + 39) + "\"}";
                        break;
                    }
                default:
                    str2 = "";
                    break;
            }
            try {
                return new JSONObject(str2);
            } catch (Throwable unused) {
                return null;
            }
        }
        return (JSONObject) invokeLZ.objValue;
    }

    public JSONObject b(JSONObject jSONObject, String str, boolean z) {
        InterceptResult invokeLLZ;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, str, z)) == null) {
            JSONObject jSONObject2 = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (jSONObject != null) {
                if (z) {
                    str2 = str + "_f";
                } else {
                    str2 = str;
                }
                jSONObject2 = jSONObject.optJSONObject(str2);
            }
            if (jSONObject2 != null && !jSONObject2.isNull("l_gravity")) {
                return jSONObject2;
            }
            return a(str, z);
        }
        return (JSONObject) invokeLLZ.objValue;
    }
}
