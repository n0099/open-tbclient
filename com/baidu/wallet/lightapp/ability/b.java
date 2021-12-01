package com.baidu.wallet.lightapp.ability;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.PhoneUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.ILightappInvokerCallback;
import com.baidu.wallet.core.utils.LogUtil;
import com.dxmpay.wallet.core.beans.BeanConstants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public abstract class b implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public String a(int i2, JSONObject jSONObject) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, jSONObject)) == null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("result", i2);
                jSONObject2.put(BeanConstants.DXM_OCR_KEY_CNT, jSONObject);
            } catch (JSONException e2) {
                LogUtil.e("NativeAbilityBase", "error", e2);
            }
            return jSONObject2.toString();
        }
        return (String) invokeIL.objValue;
    }

    public String a(Map<String, Object> map, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, map, z)) == null) {
            if (map == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("result", z ? 0 : 1);
                jSONObject.put(BeanConstants.DXM_OCR_KEY_CNT, new JSONObject(map));
            } catch (JSONException e2) {
                LogUtil.e("NativeAbilityBase", "error", e2);
            }
            return jSONObject.toString();
        }
        return (String) invokeLZ.objValue;
    }

    public int a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    return Integer.parseInt(new JSONObject(str).getString(str2));
                } catch (JSONException e2) {
                    com.baidu.apollon.utils.LogUtil.d("NativeAbilityBase", e2.getMessage());
                } catch (Throwable th) {
                    com.baidu.apollon.utils.LogUtil.d("NativeAbilityBase", th.getMessage());
                }
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public void a(ILightappInvokerCallback iLightappInvokerCallback, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(1048580, this, iLightappInvokerCallback, str, str2, str3, str4) == null) || iLightappInvokerCallback == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("errCode", str2);
        hashMap.put("des", str3);
        iLightappInvokerCallback.onResult(1, a((Map<String, Object>) hashMap, false));
    }

    public String a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, str)) == null) {
            return PhoneUtils.getApplicationName(context) + "没有" + str;
        }
        return (String) invokeLL.objValue;
    }
}
