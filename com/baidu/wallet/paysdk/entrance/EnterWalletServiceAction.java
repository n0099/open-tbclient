package com.baidu.wallet.paysdk.entrance;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.BaiduPayServiceController;
import com.baidu.wallet.lightapp.base.LightappConstants;
import com.baidu.wallet.router.RouterAction;
import com.baidu.wallet.router.RouterCallback;
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import com.dxmpay.wallet.utils.BdWalletUtils;
import java.util.HashMap;
/* loaded from: classes13.dex */
public class EnterWalletServiceAction implements RouterAction {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public EnterWalletServiceAction() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        BdWalletUtils.putFunctionNameList(EnterDxmPayServiceAction.DXM_BANK_CARD, EnterDxmPayServiceAction.DXM_TRANS_RECORDS, EnterDxmPayServiceAction.DXM_SECURITY_CENTER, EnterDxmPayServiceAction.DXM_PAY_SET, EnterDxmPayServiceAction.DXM_PWD_SET, EnterDxmPayServiceAction.DXM_CHECK_PWD, EnterDxmPayServiceAction.DXM_DO_SCAN_CODE, EnterDxmPayServiceAction.DXM_BALANCE);
    }

    private void a(Context context, String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, this, new Object[]{context, str, str2, Boolean.valueOf(z)}) == null) {
            BaiduPayServiceController.getInstance().gotoWalletService(context, str, str2, z);
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
            a(context, (String) hashMap.get(LightappConstants.ACCESS_WALLET_SERVICE_PARAM_SERVICE), (String) hashMap.get("extra"), Boolean.parseBoolean((String) hashMap.get("withAnim")));
            if (routerCallback != null) {
                HashMap hashMap3 = new HashMap();
                hashMap3.put("desc", "success");
                routerCallback.onResult(0, hashMap3);
            }
        }
    }
}
