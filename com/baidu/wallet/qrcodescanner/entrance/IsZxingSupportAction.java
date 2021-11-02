package com.baidu.wallet.qrcodescanner.entrance;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.qrcodescanner.ScanCodeController;
import com.baidu.wallet.router.RouterAction;
import com.baidu.wallet.router.RouterCallback;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class IsZxingSupportAction implements RouterAction {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public IsZxingSupportAction() {
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

    @Override // com.baidu.wallet.router.RouterAction
    public void invoke(Context context, HashMap hashMap, RouterCallback routerCallback) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, context, hashMap, routerCallback) == null) {
            if (hashMap.containsKey("type")) {
                i2 = ((Integer) hashMap.get("type")).intValue();
                if (!ScanCodeController.a(i2)) {
                    LogUtil.d("zxing", "not support type = " + i2);
                    if (routerCallback != null) {
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("errorMsg", "notSupport");
                        routerCallback.onResult(5, hashMap2);
                        return;
                    }
                }
            } else {
                i2 = 1;
            }
            LogUtil.d("zxing", "support type = " + i2);
            if (routerCallback != null) {
                routerCallback.onResult(0, null);
            }
        }
    }
}
