package com.baidu.tieba;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payservice.impl.H5PayConstant;
import tv.athena.revenue.api.pay.params.PayFlowType;
import tv.athena.revenue.payui.activity.PayCommonWebActivity;
import tv.athena.revenue.payui.model.PayUIKitConfig;
/* loaded from: classes6.dex */
public class sdb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(PayFlowType payFlowType, int i, int i2, PayUIKitConfig payUIKitConfig, Activity activity, String str, String str2) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{payFlowType, Integer.valueOf(i), Integer.valueOf(i2), payUIKitConfig, activity, str, str2}) == null) {
            boolean z = false;
            if (payUIKitConfig != null && payUIKitConfig.revenueConfig != null) {
                if (TextUtils.isEmpty(str)) {
                    RLog.error("PayWebActivityUtils", "startPayWebActivity error url null", new Object[0]);
                    return;
                }
                if (str2 != null && !str2.isEmpty()) {
                    str3 = str2;
                } else {
                    str3 = "";
                }
                Intent intent = new Intent(activity, PayCommonWebActivity.class);
                intent.putExtra(H5PayConstant.EXTRA_TITLE, str3);
                intent.putExtra(H5PayConstant.EXTRA_URL, str);
                intent.putExtra(H5PayConstant.EXTRA_APP_ID, i);
                intent.putExtra(H5PayConstant.EXTRA_USER_CHANNEL, i2);
                if (str.equals(fdb.e(payUIKitConfig))) {
                    intent.putExtra(H5PayConstant.EXTRA_LOCAL_PAGE_TYPE, 1);
                    z = true;
                }
                RLog.info("PayWebActivityUtils", "startPayWebActivity payFlowType:" + payFlowType + " isWalletActivity:" + z);
                if (TextUtils.isEmpty(str2)) {
                    str2 = geb.a(str);
                }
                PayCommonWebActivity.z(activity, payFlowType, intent, i, i2, str2);
                return;
            }
            RLog.error("PayWebActivityUtils", "startPayWebActivity error mPayUIKitConfig null", new Object[0]);
        }
    }
}
