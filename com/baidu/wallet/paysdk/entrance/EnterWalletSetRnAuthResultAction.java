package com.baidu.wallet.paysdk.entrance;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.rnauth.RNAuthCallBack;
import com.baidu.wallet.router.RouterAction;
import com.baidu.wallet.router.RouterCallback;
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import java.util.HashMap;
/* loaded from: classes12.dex */
public class EnterWalletSetRnAuthResultAction implements RouterAction {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public EnterWalletSetRnAuthResultAction() {
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

    private void a(int i2, String str) {
        RNAuthCallBack rNAuthBack;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(65537, this, i2, str) == null) || (rNAuthBack = BaiduPay.getInstance().getRNAuthBack()) == null) {
            return;
        }
        rNAuthBack.onRNAuthResult(i2, str);
        BaiduPay.getInstance().clearRNAuthBack();
    }

    @Override // com.baidu.wallet.router.RouterAction
    public void invoke(Context context, HashMap hashMap, RouterCallback routerCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, context, hashMap, routerCallback) == null) {
            HashMap hashMap2 = new HashMap();
            if (hashMap == null || !hashMap.containsKey(EnterDxmPayServiceAction.SERVICE_STATUS_CODE) || !(hashMap.get(EnterDxmPayServiceAction.SERVICE_STATUS_CODE) instanceof Integer) || !hashMap.containsKey("desc")) {
                if (routerCallback != null) {
                    hashMap2.put("errorMsg", "params-error");
                    routerCallback.onResult(3, hashMap2);
                    return;
                }
                return;
            }
            a(((Integer) hashMap.get(EnterDxmPayServiceAction.SERVICE_STATUS_CODE)).intValue(), (String) hashMap.get("desc"));
            if (routerCallback != null) {
                hashMap2.put("desc", "success");
                routerCallback.onResult(0, hashMap2);
            }
        }
    }
}
