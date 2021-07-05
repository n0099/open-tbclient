package com.baidu.wallet.base.statistics;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.utils.PhoneUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.core.beans.BeanConstants;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.UAFilterUtil;
import com.baidu.webkit.internal.utils.ZeusInitConfigUtils;
import dxm.sasdk.DxmSdkSensorsDataAPI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class DXMSdkSAUtils {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f24009a = "DXMSdkSAUtils";

    /* renamed from: b  reason: collision with root package name */
    public static final String f24010b = "https://bi-sensors.duxiaoman.com/sa?project=production";

    /* renamed from: c  reason: collision with root package name */
    public static final DxmSdkSensorsDataAPI.DebugMode f24011c;

    /* renamed from: d  reason: collision with root package name */
    public static final String f24012d = "DXMSDK";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1697204465, "Lcom/baidu/wallet/base/statistics/DXMSdkSAUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1697204465, "Lcom/baidu/wallet/base/statistics/DXMSdkSAUtils;");
                return;
            }
        }
        f24011c = DxmSdkSensorsDataAPI.DebugMode.DEBUG_OFF;
    }

    public DXMSdkSAUtils() {
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

    public static JSONObject a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                a a2 = a.a();
                jSONObject.put("UserAgent", UAFilterUtil.getInstance().getTrueUA(context));
                jSONObject.put("cuid", PhoneUtils.getCUID(context));
                jSONObject.put("cuid2", PhoneUtils.getCUID2(context));
                jSONObject.put("op", a2.d(context));
                jSONObject.put(ZeusInitConfigUtils.PREF_KEY_SDK_VERSION, BeanConstants.VERSION_NO);
                jSONObject.put("channel_id", BeanConstants.CHANNEL_ID);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            LogUtil.d(f24009a, "commonParams = " + jSONObject.toString());
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void initSensorStat(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, context) == null) {
            LogUtil.d(f24009a, "initSensorStat");
            DxmSdkSensorsDataAPI.J(context, f24010b, f24011c);
            onChangeProperties(a(context));
        }
    }

    public static void onChangeProperties(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65540, null, jSONObject) == null) {
            try {
                DxmSdkSensorsDataAPI.H().E(jSONObject);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void onEvent(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        onEventWithValues(str, Arrays.asList(""));
    }

    public static void onEventEnd(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(AdIconUtil.BAIDU_LOGO_ID, null, str, i2) == null) {
            LogUtil.d(f24009a, "onEventEnd. id = " + str + " , retCode = " + i2);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            refreshUnionIDProperty();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("event_key", str);
                jSONObject.put("value0", String.valueOf(i2));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            DxmSdkSensorsDataAPI.H().O(f24012d, jSONObject);
        }
    }

    public static void onEventEndWithValues(String str, int i2, Collection<String> collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65543, null, str, i2, collection) == null) {
            LogUtil.d(f24009a, "onEventEndWithValues. id = " + str + " , retCode = " + i2 + " , values = " + collection);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (collection == null) {
                collection = new ArrayList<>();
            }
            collection.add(String.valueOf(i2));
            onEventWithValues(str, collection);
        }
    }

    public static void onEventStart(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, str) == null) {
            LogUtil.d(f24009a, "onEventStart. id = " + str);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            refreshUnionIDProperty();
            DxmSdkSensorsDataAPI.H().P(str);
        }
    }

    public static void onEventWithValues(String str, Collection<String> collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, str, collection) == null) {
            LogUtil.d(f24009a, "onEventWithValues. id = " + str + ", values = " + collection);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("event_key", str);
                JSONArray jSONArray = new JSONArray((Collection) collection);
                if (jSONArray.length() > 0) {
                    jSONObject.put("value0", jSONArray.get(0));
                }
                if (jSONArray.length() > 1) {
                    jSONObject.put("value1", jSONArray.get(1));
                }
                if (jSONArray.length() > 2) {
                    jSONObject.put("value2", jSONArray.get(2));
                }
                if (jSONArray.length() > 3) {
                    jSONObject.put("value3", jSONArray.get(3));
                }
                if (jSONArray.length() > 4) {
                    jSONObject.put("value4", jSONArray.get(4));
                }
                if (jSONArray.length() > 5) {
                    jSONObject.put("value5", jSONArray.get(5));
                }
                if (jSONArray.length() > 6) {
                    jSONObject.put("value6", jSONArray.get(6));
                }
                if (jSONArray.length() > 7) {
                    jSONObject.put("value7", jSONArray.get(7));
                }
                if (jSONArray.length() > 8) {
                    jSONObject.put("value8", jSONArray.get(8));
                }
                refreshUnionIDProperty();
                DxmSdkSensorsDataAPI.H().M(f24012d, jSONObject);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void refreshUnionIDProperty() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            String unionId = WalletLoginHelper.getInstance().getUnionId();
            LogUtil.d(f24009a, "refreshUnionIDProperty union_id = " + unionId);
            if (!TextUtils.isEmpty(unionId)) {
                DxmSdkSensorsDataAPI.H().C(unionId);
            } else {
                DxmSdkSensorsDataAPI.H().D();
            }
        }
    }
}
