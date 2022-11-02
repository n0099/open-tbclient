package com.baidu.tieba;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.common.util.CommonParam;
import com.baidu.tieba.advert.sdk.data.AdInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.heytap.mcssdk.mode.CommandMessage;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class xs5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(Context context, AdInfo adInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, adInfo)) == null) {
            if (adInfo != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("placeId", adInfo.placeId);
                    jSONObject.put(CommandMessage.SDK_VERSION, "1.1.4");
                    jSONObject.put("adType", adInfo.adShowType.getValue());
                    if (TextUtils.isEmpty(adInfo.redirectUrl)) {
                        jSONObject.put("landingPage", adInfo.downLoadUrl);
                    } else {
                        jSONObject.put("landingPage", adInfo.redirectUrl);
                    }
                    jSONObject.put("showStamp", String.valueOf(System.currentTimeMillis()));
                    jSONObject.put("packageName", adInfo.packageName);
                    jSONObject.put("finalPrice", adInfo.finalPrice);
                    jSONObject.put("chargingMode", adInfo.chargingMode);
                    jSONObject.put("token", adInfo.token);
                    jSONObject.put("adpUserId", adInfo.adpUserId);
                    jSONObject.put("bdId", CommonParam.getCUID(context));
                    jSONObject.put("unitId", adInfo.unitId);
                    jSONObject.put("planId", adInfo.planId);
                    jSONObject.put("ideaId", adInfo.ideaId);
                    jSONObject.put("ideaType", adInfo.sourceType);
                    jSONObject.put("s", "0");
                    return jSONObject.toString();
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    return "";
                }
            }
            return "";
        }
        return (String) invokeLL.objValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }
}
