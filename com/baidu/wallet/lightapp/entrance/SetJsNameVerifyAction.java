package com.baidu.wallet.lightapp.entrance;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.lightapp.base.LightappJsClient;
import com.baidu.wallet.router.RouterAction;
import com.baidu.wallet.router.RouterCallback;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class SetJsNameVerifyAction implements RouterAction {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public SetJsNameVerifyAction() {
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
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048576, this, context, hashMap, routerCallback) == null) || hashMap == null) {
            return;
        }
        LightappJsClient.enableJsNameVerify("1".equals((String) hashMap.get("enableJsNameVerify")));
        routerCallback.onResult(0, null);
    }
}
