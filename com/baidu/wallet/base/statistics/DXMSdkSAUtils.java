package com.baidu.wallet.base.statistics;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.restnet.a;
import com.baidu.apollon.restnet.b;
import com.baidu.apollon.restnet.http.b;
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
import java.util.Arrays;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class DXMSdkSAUtils implements a.b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f60146a = "DXMSdkSAUtils";

    /* renamed from: b  reason: collision with root package name */
    public static final String f60147b = "https://bi-sensors.duxiaoman.com/sa?project=production";

    /* renamed from: c  reason: collision with root package name */
    public static final DxmSdkSensorsDataAPI.DebugMode f60148c;

    /* renamed from: d  reason: collision with root package name */
    public static final String f60149d = "DXMSDK";
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
        f60148c = DxmSdkSensorsDataAPI.DebugMode.DEBUG_OFF;
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
            LogUtil.d(f60146a, "commonParams = " + jSONObject.toString());
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void initSensorStat(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, context) == null) {
            LogUtil.d(f60146a, "initSensorStat");
            DxmSdkSensorsDataAPI.J(context, f60147b, f60148c);
            onChangeProperties(a(context));
        }
    }

    public static void onChangeProperties(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject) == null) {
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
            LogUtil.d(f60146a, "onEventEnd. id = " + str + " , retCode = " + i2);
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
            DxmSdkSensorsDataAPI.H().O(f60149d, jSONObject);
        }
    }

    public static void onEventEndWithValues(String str, int i2, Collection<String> collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65543, null, str, i2, collection) == null) {
            LogUtil.d(f60146a, "onEventEndWithValues. id = " + str + " , retCode = " + i2 + " , values = " + collection);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("event_key", str);
                jSONObject.put("value0", String.valueOf(i2));
                JSONArray jSONArray = new JSONArray((Collection) collection);
                if (jSONArray.length() > 0) {
                    jSONObject.put("value1", jSONArray.get(0));
                }
                if (jSONArray.length() > 1) {
                    jSONObject.put("value2", jSONArray.get(1));
                }
                if (jSONArray.length() > 2) {
                    jSONObject.put("value3", jSONArray.get(2));
                }
                if (jSONArray.length() > 3) {
                    jSONObject.put("value4", jSONArray.get(3));
                }
                if (jSONArray.length() > 4) {
                    jSONObject.put("value5", jSONArray.get(4));
                }
                if (jSONArray.length() > 5) {
                    jSONObject.put("value6", jSONArray.get(5));
                }
                if (jSONArray.length() > 6) {
                    jSONObject.put("value7", jSONArray.get(6));
                }
                if (jSONArray.length() > 7) {
                    jSONObject.put("value8", jSONArray.get(7));
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            refreshUnionIDProperty();
            DxmSdkSensorsDataAPI.H().O(f60149d, jSONObject);
        }
    }

    public static void onEventStart(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, str) == null) {
            LogUtil.d(f60146a, "onEventStart. id = " + str);
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
            LogUtil.d(f60146a, "onEventWithValues. id = " + str + ", values = " + collection);
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
                DxmSdkSensorsDataAPI.H().M(f60149d, jSONObject);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void refreshUnionIDProperty() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            String unionId = WalletLoginHelper.getInstance().getUnionId();
            LogUtil.d(f60146a, "refreshUnionIDProperty union_id = " + unionId);
            if (!TextUtils.isEmpty(unionId)) {
                DxmSdkSensorsDataAPI.H().C(unionId);
            } else {
                DxmSdkSensorsDataAPI.H().D();
            }
        }
    }

    @Override // com.baidu.apollon.restnet.a.b
    public void send(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("event_key", "network_stat");
                jSONObject.put("host", bVar.a());
                jSONObject.put("$url_path", bVar.b());
                jSONObject.put("totalTime", bVar.c());
                String str = "1";
                jSONObject.put("value0", bVar.d() ? "1" : "0");
                jSONObject.put("value1", bVar.e() ? "1" : "0");
                jSONObject.put("value2", bVar.g());
                jSONObject.put("value3", bVar.h());
                jSONObject.put("value4", bVar.f() ? "1" : "0");
                if (!bVar.i()) {
                    str = "0";
                }
                jSONObject.put("value5", str);
                jSONObject.put("value6", String.valueOf(bVar.j()));
                LogUtil.d("okhttp", "network_stat: " + jSONObject.toString());
                refreshUnionIDProperty();
                DxmSdkSensorsDataAPI.H().M(f60149d, jSONObject);
            } catch (JSONException unused) {
            }
        }
    }

    @Override // com.baidu.apollon.restnet.a.b
    public void send(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("event_key", "network_metrics").put("host", jSONObject.optString("host")).put("$url_path", jSONObject.optString("path")).put("value0", jSONObject.optString("proxy")).put("value1", jSONObject.optString(b.InterfaceC1615b.l)).put("value2", jSONObject.optString("protocol")).put("value3", jSONObject.optString("location")).put("value4", jSONObject.optString(b.InterfaceC1615b.k)).put("value5", jSONObject.optString(b.InterfaceC1615b.m)).put(b.InterfaceC1615b.f37958a, jSONObject.optLong(b.InterfaceC1615b.f37958a)).put(b.InterfaceC1615b.f37959b, jSONObject.optLong(b.InterfaceC1615b.f37959b)).put(b.InterfaceC1615b.f37960c, jSONObject.optLong(b.InterfaceC1615b.f37960c)).put(b.InterfaceC1615b.f37961d, jSONObject.optLong(b.InterfaceC1615b.f37961d)).put(b.InterfaceC1615b.f37962e, jSONObject.optLong(b.InterfaceC1615b.f37962e));
                LogUtil.d("okhttp", "network_metrics: " + jSONObject2.toString());
                refreshUnionIDProperty();
                DxmSdkSensorsDataAPI.H().M(f60149d, jSONObject2);
            } catch (JSONException unused) {
            }
        }
    }
}
