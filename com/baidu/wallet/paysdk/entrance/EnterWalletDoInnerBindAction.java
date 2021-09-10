package com.baidu.wallet.paysdk.entrance;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pay.BindBack;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.router.RouterAction;
import com.baidu.wallet.router.RouterCallback;
import com.qq.e.comm.constants.Constants;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class EnterWalletDoInnerBindAction implements RouterAction {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public EnterWalletDoInnerBindAction() {
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

    private void a(Context context, boolean z, String str, RouterCallback routerCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, this, new Object[]{context, Boolean.valueOf(z), str, routerCallback}) == null) {
            BaiduPayDelegate.getInstance().doInnerBind(context, new BindBack(this, routerCallback, z) { // from class: com.baidu.wallet.paysdk.entrance.EnterWalletDoInnerBindAction.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ RouterCallback f62488a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ boolean f62489b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ EnterWalletDoInnerBindAction f62490c;

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
                    this.f62490c = this;
                    this.f62488a = routerCallback;
                    this.f62489b = z;
                }

                @Override // com.baidu.android.pay.BindBack
                public boolean isHideLoadingDialog() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.f62489b : invokeV.booleanValue;
                }

                @Override // com.baidu.android.pay.BindBack
                public void onBindResult(int i2, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str2) == null) || this.f62488a == null) {
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put(Constants.KEYS.RET, Integer.valueOf(i2));
                    hashMap.put("msg", str2);
                    String assembleResult = BaiduPayDelegate.getInstance().assembleResult(hashMap, true);
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("statusCode", Integer.valueOf(i2));
                    hashMap2.put("params", assembleResult);
                    this.f62488a.onResult(0, hashMap2);
                }
            }, new HashMap(), str);
        }
    }

    @Override // com.baidu.wallet.router.RouterAction
    public void invoke(Context context, HashMap hashMap, RouterCallback routerCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, context, hashMap, routerCallback) == null) {
            if (context != null && hashMap != null && hashMap.containsKey("showDialog") && (hashMap.get("showDialog") instanceof Boolean) && hashMap.containsKey("orderInfo") && (hashMap.get("orderInfo") instanceof String)) {
                a(context, ((Boolean) hashMap.get("showDialog")).booleanValue(), (String) hashMap.get("orderInfo"), routerCallback);
            } else if (routerCallback != null) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("errorMsg", "params-error");
                routerCallback.onResult(3, hashMap2);
            }
        }
    }
}
