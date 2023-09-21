package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import tv.athena.revenue.api.pay.params.PayFlowType;
import tv.athena.revenue.payui.YYPayUIKit;
import tv.athena.revenue.payui.model.PayFlowModel;
/* loaded from: classes7.dex */
public class rkc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(int i, int i2, PayFlowType payFlowType, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), payFlowType, Integer.valueOf(i3)}) == null) {
            b(i, i2, payFlowType, i3, null);
        }
    }

    public static void b(int i, int i2, PayFlowType payFlowType, int i3, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), payFlowType, Integer.valueOf(i3), map}) == null) {
            YYPayUIKit uIKit = YYPayUIKit.getUIKit(i, i2);
            if (uIKit == null) {
                RLog.error("PayBdLiveStatisticManager", "onPayInfo null yyPayUIKit", new Object[0]);
                return;
            }
            PayFlowModel payFlowModel = uIKit.getPayFlowModel(payFlowType);
            if (payFlowModel != null && payFlowModel.viewEventListener != null) {
                String str = "{}";
                if (map != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        for (Map.Entry<String, String> entry : map.entrySet()) {
                            jSONObject.put(entry.getKey(), entry.getValue());
                        }
                        str = jSONObject.toString();
                    } catch (JSONException e) {
                        RLog.error("PayBdLiveStatisticManager", "onPayInfo JSONException" + e.getLocalizedMessage(), new Object[0]);
                    }
                }
                RLog.info("PayBdLiveStatisticManager", "onPayInfo type:" + i3 + " json:" + str + " listener:" + payFlowModel.viewEventListener + " content:" + map);
                payFlowModel.viewEventListener.onPayInfo(i3, str);
                return;
            }
            RLog.error("PayBdLiveStatisticManager", "onPayInfo error h5PayFlowModel null", new Object[0]);
        }
    }
}
