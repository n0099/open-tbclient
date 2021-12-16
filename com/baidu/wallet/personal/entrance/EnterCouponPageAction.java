package com.baidu.wallet.personal.entrance;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.NetworkUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.BaiduWalletServiceController;
import com.baidu.wallet.personal.ui.MyCouponDetailActivity;
import com.baidu.wallet.personal.ui.MyCouponListActivity;
import com.baidu.wallet.router.RouterAction;
import com.baidu.wallet.router.RouterCallback;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes13.dex */
public class EnterCouponPageAction implements RouterAction {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public EnterCouponPageAction() {
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

    private void accessWalletCoupon(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65537, this, context, str, z) == null) {
            if (!NetworkUtils.isNetworkAvailable(context)) {
                GlobalUtils.toast(context, ResUtils.getString(context, "ebpay_no_network"));
                return;
            }
            Intent intent = new Intent();
            boolean z2 = false;
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.optInt("enterDetail", 0) == 1) {
                        intent.putExtra("cardType", jSONObject.optInt("cardType", 0));
                        intent.putExtra("couponNum", jSONObject.optString("coupon_num", ""));
                        intent.putExtra("templateNum", jSONObject.optString("template_num", ""));
                        z2 = true;
                    } else {
                        intent.putExtra("extra_data", str);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            intent.setClass(context, z2 ? MyCouponDetailActivity.class : MyCouponListActivity.class);
            BaiduWalletServiceController.loginFirst(context, intent, z);
        }
    }

    @Override // com.baidu.wallet.router.RouterAction
    public void invoke(Context context, HashMap hashMap, RouterCallback routerCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, context, hashMap, routerCallback) == null) {
            if (context == null || hashMap == null || !hashMap.containsKey("withAnim") || !(hashMap.get("withAnim") instanceof String)) {
                if (routerCallback != null) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("errorMsg", "params-error");
                    routerCallback.onResult(3, hashMap2);
                    return;
                }
                return;
            }
            accessWalletCoupon(context, !TextUtils.isEmpty((String) hashMap.get("extra")) ? (String) hashMap.get("extra") : "", Boolean.parseBoolean((String) hashMap.get("withAnim")));
            if (routerCallback != null) {
                HashMap hashMap3 = new HashMap();
                hashMap3.put("desc", "success");
                routerCallback.onResult(0, hashMap3);
            }
        }
    }
}
