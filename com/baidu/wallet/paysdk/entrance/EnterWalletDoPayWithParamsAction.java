package com.baidu.wallet.paysdk.entrance;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pay.PayCallBack;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.router.RouterAction;
import com.baidu.wallet.router.RouterCallback;
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class EnterWalletDoPayWithParamsAction implements RouterAction {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public EnterWalletDoPayWithParamsAction() {
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

    private void a(Context context, HashMap<String, String> hashMap, boolean z, String str, RouterCallback routerCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, this, new Object[]{context, hashMap, Boolean.valueOf(z), str, routerCallback}) == null) {
            BaiduPayDelegate.getInstance().doPay(context, str, new PayCallBack(this, routerCallback, z) { // from class: com.baidu.wallet.paysdk.entrance.EnterWalletDoPayWithParamsAction.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ RouterCallback f60594a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ boolean f60595b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ EnterWalletDoPayWithParamsAction f60596c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, routerCallback, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f60596c = this;
                    this.f60594a = routerCallback;
                    this.f60595b = z;
                }

                @Override // com.baidu.android.pay.PayCallBack
                public boolean isHideLoadingDialog() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.f60595b : invokeV.booleanValue;
                }

                @Override // com.baidu.android.pay.PayCallBack
                public void onPayResult(int i2, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str2) == null) || this.f60594a == null) {
                        return;
                    }
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put(EnterDxmPayServiceAction.SERVICE_STATUS_CODE, Integer.valueOf(i2));
                    hashMap2.put("payDesc", str2);
                    this.f60594a.onResult(0, hashMap2);
                }
            }, hashMap);
        }
    }

    @Override // com.baidu.wallet.router.RouterAction
    public void invoke(Context context, HashMap hashMap, RouterCallback routerCallback) {
        HashMap<String, String> hashMap2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, context, hashMap, routerCallback) == null) {
            if (context == null || hashMap == null || !hashMap.containsKey("showDialog") || !(hashMap.get("showDialog") instanceof Boolean) || !hashMap.containsKey("orderInfo") || !(hashMap.get("orderInfo") instanceof String)) {
                if (routerCallback != null) {
                    HashMap hashMap3 = new HashMap();
                    hashMap3.put("errorMsg", "params-error");
                    routerCallback.onResult(3, hashMap3);
                    return;
                }
                return;
            }
            boolean booleanValue = ((Boolean) hashMap.get("showDialog")).booleanValue();
            String str = (String) hashMap.get("orderInfo");
            if (hashMap.containsKey("params") && (hashMap.get("params") instanceof HashMap)) {
                hashMap2 = (HashMap) hashMap.get("params");
            } else {
                hashMap2 = new HashMap<>();
            }
            a(context, hashMap2, booleanValue, str, routerCallback);
        }
    }
}
