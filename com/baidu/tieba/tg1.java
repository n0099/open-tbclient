package com.baidu.tieba;

import android.content.Context;
import android.os.Build;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.cmic.sso.sdk.auth.AuthnHelper;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class tg1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            try {
                if (ze1.f(context).d()) {
                    if (Build.VERSION.SDK_INT < 24) {
                        return -1001;
                    }
                    if (lg1.n(context)) {
                        return SubscriptionManager.getDefaultDataSubscriptionId();
                    }
                    return -1002;
                }
                return -1000;
            } catch (Throwable th) {
                lg1.d(th);
                return -1001;
            }
        }
        return invokeL.intValue;
    }

    public static String b(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(65537, null, str, z)) == null) ? z ? str : "" : (String) invokeLZ.objValue;
    }

    public static Pair<Integer, Integer> c(Context context) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            int i2 = -1;
            Pair<Integer, Integer> pair = new Pair<>(-1, -1);
            try {
                JSONObject networkType = AuthnHelper.getInstance(context).getNetworkType(context);
                if (networkType == null) {
                    return pair;
                }
                if (networkType.has("networktype")) {
                    i2 = Integer.parseInt(networkType.optString("networktype", "-1"));
                    i = Integer.parseInt(networkType.optString("operatortype", "-1"));
                } else if (networkType.has("networkType")) {
                    i2 = Integer.parseInt(networkType.optString("networkType", "-1"));
                    i = Integer.parseInt(networkType.optString("operatorType", "-1"));
                } else {
                    i = -1;
                }
                return Pair.create(Integer.valueOf(i2), Integer.valueOf(i));
            } catch (Throwable th) {
                lg1.d(th);
                return pair;
            }
        }
        return (Pair) invokeL.objValue;
    }

    public static Pair<Integer, String[]> d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            try {
                if (!ze1.f(context).d()) {
                    return new Pair<>(-1, new String[]{String.valueOf(-1000), String.valueOf(-1000), String.valueOf(-1000), String.valueOf(-1000)});
                }
                if (Build.VERSION.SDK_INT < 22) {
                    return new Pair<>(-2, new String[]{String.valueOf(-1001), String.valueOf(-1001), String.valueOf(-1001), String.valueOf(-1001)});
                }
                if (!qg1.a(context, com.kuaishou.weapon.p0.h.c)) {
                    return new Pair<>(-1, new String[]{String.valueOf(-1001), String.valueOf(-1001), String.valueOf(-1001), String.valueOf(-1001)});
                }
                if (!lg1.n(context)) {
                    return new Pair<>(-1, new String[]{String.valueOf(-1002), String.valueOf(-1002), String.valueOf(-1002), String.valueOf(-1002)});
                }
                List<SubscriptionInfo> activeSubscriptionInfoList = ((SubscriptionManager) context.getSystemService("telephony_subscription_service")).getActiveSubscriptionInfoList();
                if (activeSubscriptionInfoList == null) {
                    return new Pair<>(0, new String[]{String.valueOf(-1003), String.valueOf(-1003), String.valueOf(-1003), String.valueOf(-1003)});
                }
                String[] strArr = new String[4];
                int i = 0;
                for (SubscriptionInfo subscriptionInfo : activeSubscriptionInfoList) {
                    int i2 = i * 2;
                    int simSlotIndex = subscriptionInfo.getSimSlotIndex();
                    int subscriptionId = subscriptionInfo.getSubscriptionId();
                    String iccId = subscriptionInfo.getIccId();
                    if (TextUtils.isEmpty(iccId)) {
                        iccId = String.valueOf(-1003);
                    }
                    strArr[i2] = simSlotIndex + "_" + subscriptionId + "_" + iccId;
                    CharSequence carrierName = subscriptionInfo.getCarrierName();
                    if (carrierName != null) {
                        strArr[i2 + 1] = carrierName.toString();
                    } else {
                        strArr[i2 + 1] = String.valueOf(-1003);
                    }
                    i++;
                    if (i >= 2) {
                        break;
                    }
                }
                for (int i3 = 0; i3 < 4; i3++) {
                    if (TextUtils.isEmpty(strArr[i3])) {
                        strArr[i3] = String.valueOf(-1003);
                    }
                }
                return new Pair<>(Integer.valueOf(i), strArr);
            } catch (Throwable th) {
                lg1.d(th);
                return new Pair<>(-1, new String[]{String.valueOf(-1001), String.valueOf(-1001), String.valueOf(-1001), String.valueOf(-1001)});
            }
        }
        return (Pair) invokeL.objValue;
    }
}
