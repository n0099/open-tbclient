package com.baidu.wallet.paysdk.entrance;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.rnauth.RNAuthCallBack;
import com.baidu.wallet.router.RouterAction;
import com.baidu.wallet.router.RouterCallback;
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class EnterWalletDoRnAuthAction implements RouterAction {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public EnterWalletDoRnAuthAction() {
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

    private void a(Context context, HashMap<String, String> hashMap, RouterCallback routerCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, this, context, hashMap, routerCallback) == null) {
            BaiduPayDelegate.getInstance().doRNAuth(context, hashMap, new RNAuthCallBack(this, routerCallback) { // from class: com.baidu.wallet.paysdk.entrance.EnterWalletDoRnAuthAction.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ RouterCallback f59678a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ EnterWalletDoRnAuthAction f59679b;

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
                    this.f59679b = this;
                    this.f59678a = routerCallback;
                }

                @Override // com.baidu.wallet.rnauth.RNAuthCallBack
                public void onRNAuthResult(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) || this.f59678a == null) {
                        return;
                    }
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put(EnterDxmPayServiceAction.SERVICE_STATUS_CODE, Integer.valueOf(i2));
                    hashMap2.put("authDesc", str);
                    this.f59678a.onResult(0, hashMap2);
                }
            });
        }
    }

    @Override // com.baidu.wallet.router.RouterAction
    public void invoke(Context context, HashMap hashMap, RouterCallback routerCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, context, hashMap, routerCallback) == null) {
            if (context != null && hashMap != null) {
                a(context, hashMap, routerCallback);
            } else if (routerCallback != null) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("errorMsg", "params-error");
                routerCallback.onResult(3, hashMap2);
            }
        }
    }
}
