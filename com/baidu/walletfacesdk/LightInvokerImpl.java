package com.baidu.walletfacesdk;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.sapi2.openbduss.PASSMethodCallTransfer;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.walletfacesdk.LivenessManager;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class LightInvokerImpl {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CALL_NATIVE_VOICE = "callNativeVoice";
    public static String KEY_PASS_APIKEY = "itokhjnkuc58d3bzfh0il2uo89pdppyy";
    public static String KEY_PASS_TPL = "baiduwalletapp";
    public static final String LIVENESSSERVICE_ID = "livenessServiceId";
    public static final String LIVENESS_SERVIVETYPE = "serviceType";
    public static final String LIVENESS_SHOW_GUIDE_PAGE = "showGuidePage";
    public static final String METHOD_NAME = "method_name";
    public static final String RANDOM_ACTION = "randomAction";
    public static final String RECORD_VIDEO = "recordVideo";
    public static final String SP_PARAMS = "spParams";
    public static final String START_IDENTIFY = "startIdentify";
    public static final String STOKEN_KEY = "stoken";
    public static final String SWITCH_VIDEO = "switchVideo";
    public static final String TAG = "LightInvokerImpl";
    public static final String VOICE_ACTIONTYPE = "actionType";
    public static final String VOICE_BARSTYLE = "barStyle";
    public static final String VOICE_PRODUCTID = "productId";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public interface IResultListener {
        void onResult(int i2, JSONObject jSONObject);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(391866334, "Lcom/baidu/walletfacesdk/LightInvokerImpl;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(391866334, "Lcom/baidu/walletfacesdk/LightInvokerImpl;");
        }
    }

    public LightInvokerImpl() {
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

    public static String assembleResult(int i2, JSONObject jSONObject) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65539, null, i2, jSONObject)) == null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("result", i2);
                jSONObject2.put("cnt", jSONObject);
            } catch (JSONException unused) {
            }
            return jSONObject2.toString();
        }
        return (String) invokeIL.objValue;
    }

    public static void callNativeVoice(Context context, String str, boolean z, IResultListener iResultListener) {
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, str, Boolean.valueOf(z), iResultListener}) == null) {
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = null;
            try {
                jSONObject = new JSONObject(str);
            } catch (Exception e2) {
                e2.getMessage();
                jSONObject = null;
            }
            if (!jSONObject.has(START_IDENTIFY)) {
                try {
                    jSONObject2.put("errCode", 103);
                    jSONObject2.put("des", PASSMethodCallTransfer.DynamicCallbak.ERROR_MSG_PARAMS_ERROR);
                    iResultListener.onResult(1, jSONObject2);
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
            try {
                jSONObject3 = new JSONObject(jSONObject.optString(START_IDENTIFY));
            } catch (Exception e3) {
                e3.getMessage();
            }
            if (jSONObject3.has(VOICE_ACTIONTYPE)) {
                if (!(!TextUtils.isEmpty(jSONObject3.optString(VOICE_ACTIONTYPE)) ? jSONObject3.optString(VOICE_ACTIONTYPE) : "").equals("2")) {
                    try {
                        jSONObject2.put("errCode", 103);
                        jSONObject2.put("des", PASSMethodCallTransfer.DynamicCallbak.ERROR_MSG_PARAMS_ERROR);
                        iResultListener.onResult(1, jSONObject2);
                        return;
                    } catch (Exception unused2) {
                        return;
                    }
                }
            }
            HashMap hashMap = new HashMap();
            hashMap.put("stoken", jSONObject.optString("stoken"));
            String optString = !TextUtils.isEmpty(jSONObject3.optString("productId")) ? jSONObject3.optString("productId") : "default";
            hashMap.put(LIVENESS_SERVIVETYPE, !TextUtils.isEmpty(jSONObject3.optString(LIVENESS_SERVIVETYPE)) ? jSONObject3.optString(LIVENESS_SERVIVETYPE) : "1008");
            if (!jSONObject3.has(LIVENESS_SHOW_GUIDE_PAGE) || TextUtils.isEmpty(jSONObject3.optString(LIVENESS_SHOW_GUIDE_PAGE))) {
                hashMap.put(LIVENESS_SHOW_GUIDE_PAGE, (!TextUtils.isEmpty(jSONObject3.optString(VOICE_BARSTYLE)) ? jSONObject3.optString(VOICE_BARSTYLE) : "0").equals("1") ^ true ? "1" : "0");
            } else {
                hashMap.put(LIVENESS_SHOW_GUIDE_PAGE, jSONObject3.optString(LIVENESS_SHOW_GUIDE_PAGE));
            }
            String optString2 = jSONObject3.optString(LIVENESSSERVICE_ID);
            String optString3 = jSONObject3.optString(SP_PARAMS);
            if (!TextUtils.isEmpty(optString2)) {
                hashMap.put(LIVENESSSERVICE_ID, optString2);
            }
            if (!TextUtils.isEmpty(optString3)) {
                hashMap.put(SP_PARAMS, optString3);
            }
            if (!TextUtils.isEmpty(jSONObject3.optString(RANDOM_ACTION))) {
                hashMap.put(RANDOM_ACTION, jSONObject3.optString(RANDOM_ACTION));
            }
            if (!TextUtils.isEmpty(jSONObject3.optString(SWITCH_VIDEO))) {
                hashMap.put(SWITCH_VIDEO, jSONObject3.optString(SWITCH_VIDEO));
            }
            if (!TextUtils.isEmpty(jSONObject3.optString(RECORD_VIDEO))) {
                hashMap.put(RECORD_VIDEO, jSONObject3.optString(RECORD_VIDEO));
            }
            new LivenessManager(context, z, optString).livenessRecognize(hashMap, new LivenessManager.IvoiceListener(jSONObject2, iResultListener) { // from class: com.baidu.walletfacesdk.LightInvokerImpl.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ JSONObject a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ IResultListener f51366b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {jSONObject2, iResultListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = jSONObject2;
                    this.f51366b = iResultListener;
                }

                @Override // com.baidu.walletfacesdk.LivenessManager.IvoiceListener
                public void onResult(int i2, int i3, String str2, Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str2, obj}) == null) {
                        if (obj != null) {
                            try {
                                this.a.put("data", obj);
                            } catch (Exception unused3) {
                                return;
                            }
                        }
                        this.a.put("errCode", i3);
                        this.a.put("des", str2);
                        this.f51366b.onResult(i2, this.a);
                    }
                }
            });
        }
    }

    public static void invokeBdWalletNative(Context context, String str, boolean z, LightInvokerCallback lightInvokerCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{context, str, Boolean.valueOf(z), lightInvokerCallback}) == null) || context == null || str == null || lightInvokerCallback == null) {
            return;
        }
        try {
            if (new JSONObject(str).optString("method_name").equalsIgnoreCase("callNativeVoice")) {
                callNativeVoice(context, str, z, new IResultListener(lightInvokerCallback) { // from class: com.baidu.walletfacesdk.LightInvokerImpl.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LightInvokerCallback a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {lightInvokerCallback};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = lightInvokerCallback;
                    }

                    @Override // com.baidu.walletfacesdk.LightInvokerImpl.IResultListener
                    public void onResult(int i2, JSONObject jSONObject) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, jSONObject) == null) || jSONObject == null) {
                            return;
                        }
                        this.a.onResult(i2, LightInvokerImpl.assembleResult(i2, jSONObject));
                    }
                });
            }
        } catch (Exception e2) {
            e2.getMessage();
        }
    }

    public static void setProduct(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, str, str2) == null) {
            KEY_PASS_TPL = str;
            KEY_PASS_APIKEY = str2;
        }
    }
}
