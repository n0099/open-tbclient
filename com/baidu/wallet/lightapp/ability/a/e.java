package com.baidu.wallet.lightapp.ability.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.Base64Utils;
import com.baidu.apollon.utils.BussinessUtils;
import com.baidu.apollon.utils.NetworkUtils;
import com.baidu.apollon.utils.PhoneUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.ILightappInvokerCallback;
import com.baidu.wallet.core.utils.SecurityUtils;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import com.baidu.wallet.utils.NetUtils;
import com.dxmpay.wallet.core.beans.BeanConstants;
import com.yy.hiidostatis.inner.BaseStatisContent;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class e extends com.baidu.wallet.lightapp.ability.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public e() {
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

    @Override // com.baidu.wallet.lightapp.ability.a
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? LightappBusinessClient.MTD_CALLPHONEINFO : (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.lightapp.ability.a
    public void a(Activity activity, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        int i2;
        Activity activity2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, str, iLightappInvokerCallback, str2) == null) || iLightappInvokerCallback == null) {
            return;
        }
        String str3 = null;
        JSONObject jSONObject = new JSONObject();
        boolean z = false;
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            if (jSONObject2.has("all") && "true".equals(jSONObject2.getString("all"))) {
                String[] strArr = {"screenWidth", "screenHeight", "walletUserAgent", "cuid", "BAIDUCUID", "location", "imei", BaseStatisContent.IMSI, "simSerialNum", "localIp", "wifi", LightappBusinessClient.WCP, LightappBusinessClient.ROOT};
                JSONObject jSONObject3 = new JSONObject();
                for (int i3 = 0; i3 < 13; i3++) {
                    jSONObject3.put(strArr[i3], "1");
                }
                activity2 = activity;
                jSONObject2 = jSONObject3;
            } else {
                activity2 = activity;
            }
            str3 = a(activity2, jSONObject2);
            i2 = 0;
        } catch (Exception e2) {
            try {
                jSONObject.put("data", Base64Utils.encodeToString(new JSONObject().toString().getBytes()));
                jSONObject.put("errCode", 1);
                jSONObject.put(BeanConstants.DXM_OCR_KEY_ERROR_DES, "exception." + e2.getMessage());
                str3 = a(1, jSONObject);
                i2 = 1;
            } catch (Exception unused) {
                i2 = 1;
                z = true;
            }
        }
        if (z) {
            str3 = a(1, jSONObject);
        }
        iLightappInvokerCallback.onResult(i2, str3);
    }

    private String a(Context context, JSONObject jSONObject) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, context, jSONObject)) == null) {
            if (context == null || jSONObject == null) {
                return null;
            }
            JSONObject jSONObject2 = new JSONObject();
            if (jSONObject.has("screenWidth")) {
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                jSONObject2.put("screenWidth", displayMetrics.widthPixels + "");
            }
            if (jSONObject.has("screenHeight")) {
                DisplayMetrics displayMetrics2 = context.getResources().getDisplayMetrics();
                jSONObject2.put("screenHeight", displayMetrics2.heightPixels + "");
            }
            if (jSONObject.has("walletUserAgent")) {
                jSONObject2.put("walletUserAgent", BussinessUtils.getUA(context) + "");
            }
            if (jSONObject.has("cuid")) {
                jSONObject2.put("cuid", PhoneUtils.getCUID(context) + "");
            }
            if (jSONObject.has("BAIDUCUID")) {
                jSONObject2.put("BAIDUCUID", DeviceId.getCUID(context));
            }
            if (jSONObject.has("location")) {
                String gPSLocation = PhoneUtils.getGPSLocation(context);
                if (TextUtils.isEmpty(gPSLocation)) {
                    jSONObject2.put("location", "");
                } else {
                    String[] split = gPSLocation.split(":");
                    if (split != null && 2 == split.length) {
                        jSONObject2.put("location", "{\"longitude\":" + split[0] + ",\"latitude\":" + split[1] + "}");
                    } else {
                        jSONObject2.put("location", "");
                    }
                }
            }
            if (jSONObject.has("localIp")) {
                jSONObject2.put("localIp", PhoneUtils.getIpInfo() + "");
            }
            if (jSONObject.has("wifi")) {
                jSONObject2.put("wifi", NetUtils.getWifiSig(context, PhoneUtils.getCUID(context)));
            }
            if (jSONObject.has(LightappBusinessClient.WCP)) {
                try {
                    if (!jSONObject2.has("wime")) {
                        jSONObject2.put("wime", "");
                    }
                    if (!jSONObject2.has("cuid_1")) {
                        jSONObject2.put("cuid_1", PhoneUtils.getCUID(context));
                    }
                    if (!jSONObject2.has("cuid_2")) {
                        jSONObject2.put("cuid_2", PhoneUtils.getCUID2(context));
                    }
                    if (!jSONObject2.has("nettype")) {
                        jSONObject2.put("nettype", NetworkUtils.getNetworkType(context));
                    }
                    if (!jSONObject2.has("wloc")) {
                        jSONObject2.put("wloc", PhoneUtils.getGPSLocation(context));
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            if (jSONObject.has(LightappBusinessClient.ROOT)) {
                try {
                    if (!jSONObject2.has(LightappBusinessClient.ROOT)) {
                        jSONObject2.put(LightappBusinessClient.ROOT, SecurityUtils.isRoot());
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            Bundle a2 = com.baidu.wallet.lightapp.ability.b.a.a().a(context, Base64Utils.encodeToString(jSONObject2.toString().getBytes()));
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("data", (Object) null);
            jSONObject3.put("aesdata", a2.getString("aesContent"));
            jSONObject3.put("aeskey", a2.getString("aesKey"));
            jSONObject3.put("errCode", 0);
            jSONObject3.put(BeanConstants.DXM_OCR_KEY_ERROR_DES, "ok");
            return a(0, jSONObject3);
        }
        return (String) invokeLL.objValue;
    }
}
