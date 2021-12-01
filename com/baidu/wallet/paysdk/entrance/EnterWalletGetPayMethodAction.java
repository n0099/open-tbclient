package com.baidu.wallet.paysdk.entrance;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.api.IPrecashierCallback;
import com.baidu.wallet.router.RouterAction;
import com.baidu.wallet.router.RouterCallback;
import java.util.HashMap;
/* loaded from: classes12.dex */
public class EnterWalletGetPayMethodAction implements RouterAction {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public EnterWalletGetPayMethodAction() {
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

    private void a(Context context, String str, RouterCallback routerCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, this, context, str, routerCallback) == null) {
            BaiduPayDelegate.getInstance().getPayMethod(context, str, new IPrecashierCallback(this, routerCallback) { // from class: com.baidu.wallet.paysdk.entrance.EnterWalletGetPayMethodAction.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ RouterCallback a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ EnterWalletGetPayMethodAction f53469b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, routerCallback};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f53469b = this;
                    this.a = routerCallback;
                }

                @Override // com.baidu.wallet.api.IPrecashierCallback
                public void onResult(String str2) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, str2) == null) || this.a == null) {
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("result", str2);
                    this.a.onResult(0, hashMap);
                }
            });
        }
    }

    @Override // com.baidu.wallet.router.RouterAction
    public void invoke(Context context, HashMap hashMap, RouterCallback routerCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, context, hashMap, routerCallback) == null) {
            if (context != null && hashMap != null && hashMap.containsKey("options") && (hashMap.get("options") instanceof String)) {
                a(context, (String) hashMap.get("options"), routerCallback);
            } else if (routerCallback != null) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("errorMsg", "params-error");
                routerCallback.onResult(3, hashMap2);
            }
        }
    }
}
