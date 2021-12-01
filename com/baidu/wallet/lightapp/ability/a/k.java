package com.baidu.wallet.lightapp.ability.a;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.ILightappInvokerCallback;
import com.baidu.wallet.lightapp.base.LightappConstants;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.router.RouterRequest;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class k extends com.baidu.wallet.lightapp.ability.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public k() {
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

    @Override // com.baidu.wallet.lightapp.ability.a
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "preOrderPay" : (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.lightapp.ability.a
    public void a(Activity activity, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, str, iLightappInvokerCallback, str2) == null) || iLightappInvokerCallback == null) {
            return;
        }
        LocalRouter.getInstance(DxmApplicationContextImpl.getApplicationContext(activity)).route(activity, new RouterRequest().provider("dxmPay").action("enterPreOrderPay").data("options", str), new RouterCallback(this, iLightappInvokerCallback, str2) { // from class: com.baidu.wallet.lightapp.ability.a.k.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ILightappInvokerCallback a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f52798b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ k f52799c;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, iLightappInvokerCallback, str2};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f52799c = this;
                this.a = iLightappInvokerCallback;
                this.f52798b = str2;
            }

            @Override // com.baidu.wallet.router.RouterCallback
            public void onResult(int i2, HashMap hashMap) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, hashMap) == null) {
                    if (i2 == 0) {
                        if (hashMap == null || hashMap.size() <= 0) {
                            return;
                        }
                        String str3 = (String) hashMap.get("result");
                        if (TextUtils.isEmpty(str3)) {
                            return;
                        }
                        try {
                            if (((Integer) new JSONObject(str3).get("result")).intValue() == 0) {
                                this.a.onResult(0, str3);
                            } else {
                                this.a.onResult(1, str3);
                            }
                            return;
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    String str4 = (String) hashMap.get("errorMsg");
                    k kVar = this.f52799c;
                    ILightappInvokerCallback iLightappInvokerCallback2 = this.a;
                    String str5 = this.f52798b;
                    String num = Integer.toString(i2);
                    if (!TextUtils.isEmpty(str4)) {
                        str4 = LightappConstants.ROUTER_INVOKE_FAIL;
                    }
                    kVar.a(iLightappInvokerCallback2, str5, num, str4, "##preOrderPayFail");
                }
            }
        });
    }
}
