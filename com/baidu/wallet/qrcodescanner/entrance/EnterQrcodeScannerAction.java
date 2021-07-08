package com.baidu.wallet.qrcodescanner.entrance;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.alibaba.fastjson.asm.Label;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.core.utils.BaiduWalletUtils;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.qrcodescanner.QRScanCodeActivity;
import com.baidu.wallet.router.RouterAction;
import com.baidu.wallet.router.RouterCallback;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class EnterQrcodeScannerAction implements RouterAction {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BEAN_TAG = "enterQrcodeScannerAction";
    public transient /* synthetic */ FieldHolder $fh;

    public EnterQrcodeScannerAction() {
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

    private void a(Context context, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, this, new Object[]{context, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            Intent intent = new Intent();
            boolean z3 = context instanceof Activity;
            if (z3) {
                LogUtil.d(BEAN_TAG, "context is activity!");
            } else {
                intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            }
            intent.setClass(context, QRScanCodeActivity.class);
            intent.putExtra("with_anim", z);
            if (z2) {
                intent.putExtra("showQrCodeBtns", true);
            }
            WalletLoginHelper.getInstance().verifyPassLogin(false, null);
            context.startActivity(intent);
            if (z3) {
                if (z) {
                    BaiduWalletUtils.startActivityAnim(context);
                } else {
                    BaiduWalletUtils.overridePendingTransitionNoAnim((Activity) context);
                }
            }
        }
    }

    @Override // com.baidu.wallet.router.RouterAction
    public void invoke(Context context, HashMap hashMap, RouterCallback routerCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048576, this, context, hashMap, routerCallback) == null) || a(context, hashMap, routerCallback)) {
            return;
        }
        a(context, Boolean.parseBoolean((String) hashMap.get("withAnim")), hashMap.containsKey("showQrCodeBtns") ? ((Boolean) hashMap.get("showQrCodeBtns")).booleanValue() : false);
        if (routerCallback != null) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("desc", "success");
            routerCallback.onResult(0, hashMap2);
        }
    }

    private boolean a(Context context, HashMap hashMap, RouterCallback routerCallback) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, this, context, hashMap, routerCallback)) == null) {
            if (context == null || hashMap == null || !hashMap.containsKey("withAnim")) {
                if (routerCallback != null) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("errorMsg", "params-error");
                    routerCallback.onResult(3, hashMap2);
                    return true;
                }
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }
}
