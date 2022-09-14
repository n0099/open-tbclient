package com.baidu.tieba;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.location.BDLocation;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.baidu.swan.apps.impl.nalib.encrypt.EncryptConstant;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tieba.g93;
import com.baidu.tieba.nl3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class pl3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948065842, "Lcom/baidu/tieba/pl3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948065842, "Lcom/baidu/tieba/pl3;");
                return;
            }
        }
        a = ij1.a;
    }

    @Nullable
    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            try {
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                cipher.init(1, new SecretKeySpec((EncryptConstant.getPartRecommendAesKey() + "rtad@mic").getBytes(), "AES"), new IvParameterSpec((EncryptConstant.getPartRecommendAesIv() + "21248000").getBytes()));
                return Base64.encodeToString(cipher.doFinal(str.getBytes(IMAudioTransRequest.CHARSET)), 2);
            } catch (Exception e) {
                e.printStackTrace();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("info", "encrypt request param fail with exception : " + e.getMessage());
                } catch (JSONException e2) {
                    if (a) {
                        e2.printStackTrace();
                    }
                }
                f(jSONObject.toString());
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static void b(nl3 nl3Var, ol3 ol3Var) {
        char c;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, nl3Var, ol3Var) == null) || nl3Var == null || ol3Var == null) {
            return;
        }
        String str = TextUtils.isEmpty(ol3Var.a) ? "unknown" : ol3Var.a;
        switch (str.hashCode()) {
            case -1395470197:
                if (str.equals("bd09ll")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 3017163:
                if (str.equals(BDLocation.BDLOCATION_GCJ02_TO_BD09)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 98175376:
                if (str.equals("gcj02")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 113079775:
                if (str.equals(CoordinateType.WGS84)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        int i = c != 0 ? c != 1 ? c != 2 ? c != 3 ? -1 : 3 : 2 : 1 : 0;
        nl3.c cVar = nl3Var.c;
        cVar.a = i;
        cVar.b = ol3Var.b;
        cVar.c = ol3Var.c;
    }

    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            String e = SwanAppNetworkUtils.e();
            if ("wifi".equals(e)) {
                return 1;
            }
            if ("2g".equals(e)) {
                return 2;
            }
            if ("3g".equals(e)) {
                return 3;
            }
            if ("4g".equals(e)) {
                return 4;
            }
            return "5g".equals(e) ? 5 : 0;
        }
        return invokeV.intValue;
    }

    public static int d(Context context) {
        InterceptResult invokeL;
        TelephonyManager telephonyManager;
        String simOperator;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (context == null || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null || (simOperator = telephonyManager.getSimOperator()) == null) {
                return 0;
            }
            if ("46000".equals(simOperator) || "46002".equals(simOperator) || "46007".equals(simOperator)) {
                return 1;
            }
            if ("46001".equals(simOperator)) {
                return 3;
            }
            return "46003".equals(simOperator) ? 2 : 0;
        }
        return invokeL.intValue;
    }

    public static boolean e(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) ? (context.getResources().getConfiguration().screenLayout & 15) >= 3 : invokeL.booleanValue;
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (a) {
            Log.d("recommend", "reportInfoWhenResponseIsNull: " + str);
        }
        g93.b bVar = new g93.b(10003);
        bVar.i(str);
        bVar.h(y23.g0());
        bVar.m();
    }
}
