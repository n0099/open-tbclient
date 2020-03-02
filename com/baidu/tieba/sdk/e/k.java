package com.baidu.tieba.sdk.e;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.extraparams.ResultCallback;
import com.baidu.live.tbadk.scheme.ILiveScheme;
import com.baidu.live.tbadk.scheme.SchemeCallback;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class k implements ILiveScheme {
    @Override // com.baidu.live.tbadk.scheme.ILiveScheme
    public void excute(Context context, Map<String, String> map, final SchemeCallback schemeCallback) {
        try {
            final String str = map.get(BuyTBeanActivityConfig.CALLBACK);
            String str2 = map.get("is_translucent");
            String str3 = map.get("from");
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put(BuyTBeanActivityConfig.CALLBACK, str);
            }
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("isTranslucent", TextUtils.equals(str2, "1"));
            }
            if (!TextUtils.isEmpty(str3)) {
                jSONObject.put("from", str3);
            }
            if (schemeCallback != null) {
                ExtraParamsManager.addEnterBuyTBeanCallback(new ResultCallback() { // from class: com.baidu.tieba.sdk.e.k.1
                    @Override // com.baidu.live.tbadk.extraparams.ResultCallback
                    public void onCallback(JSONObject jSONObject2) {
                        try {
                            int optInt = jSONObject2.optInt("status", 0);
                            String optString = jSONObject2.optString("message");
                            String optString2 = jSONObject2.optString("productId");
                            String optString3 = jSONObject2.optString("total");
                            String optString4 = jSONObject2.optString("transitionId");
                            JSONObject jSONObject3 = new JSONObject();
                            if (!TextUtils.isEmpty(optString2)) {
                                jSONObject3.put("productId", optString2);
                            }
                            if (!TextUtils.isEmpty(optString3)) {
                                jSONObject3.put("total", optString3);
                            }
                            if (!TextUtils.isEmpty(optString4)) {
                                jSONObject3.put("transitionId", optString4);
                            }
                            schemeCallback.doJsCallback(optInt, optString, jSONObject3, str);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
            com.baidu.tieba.sdk.a.cEi().Im(jSONObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
