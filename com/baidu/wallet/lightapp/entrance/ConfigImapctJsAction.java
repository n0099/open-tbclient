package com.baidu.wallet.lightapp.entrance;

import android.content.Context;
import androidx.lifecycle.SavedStateHandle;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.lightapp.business.a;
import com.baidu.wallet.paysdk.datamodel.SdkInitResponse;
import com.baidu.wallet.router.RouterAction;
import com.baidu.wallet.router.RouterCallback;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class ConfigImapctJsAction implements RouterAction {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ConfigImapctJsAction() {
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
        if (!(interceptable == null || interceptable.invokeLLL(1048576, this, context, hashMap, routerCallback) == null) || routerCallback == null) {
            return;
        }
        HashMap hashMap2 = new HashMap();
        if (hashMap != null && hashMap.size() != 0) {
            String[] strArr = (String[]) hashMap.get("configs");
            String[] strArr2 = (String[]) hashMap.get(SavedStateHandle.KEYS);
            if (strArr != null && strArr.length != 0 && strArr2 != null && strArr2.length != 0) {
                a.a(context, SdkInitResponse.getInstance().getJsHookURl(context), strArr, strArr2);
                routerCallback.onResult(0, hashMap2);
                return;
            }
            hashMap2.put("errorMsg", "reqValueInvalid");
            routerCallback.onResult(1, hashMap2);
            return;
        }
        hashMap2.put("errorMsg", "reqValueInvalid");
        routerCallback.onResult(1, hashMap2);
    }
}
