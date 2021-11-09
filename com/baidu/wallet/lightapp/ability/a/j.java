package com.baidu.wallet.lightapp.ability.a;

import android.app.Activity;
import android.util.Base64;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.BussinessUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.ILightappInvokerCallback;
import com.baidu.wallet.lightapp.ability.datamodle.NativeAbilityUserAgentModel;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
/* loaded from: classes10.dex */
public class j extends com.baidu.wallet.lightapp.ability.b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static int f58644a = 1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(324256256, "Lcom/baidu/wallet/lightapp/ability/a/j;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(324256256, "Lcom/baidu/wallet/lightapp/ability/a/j;");
        }
    }

    public j() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.baidu.wallet.lightapp.ability.a
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? LightappBusinessClient.METHOD_GET_USER_AGENT : (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.lightapp.ability.a
    public void a(Activity activity, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, str, iLightappInvokerCallback, str2) == null) {
            String ua = BussinessUtils.getUA(activity);
            if (a(str, "base64") == f58644a) {
                ua = Base64.encodeToString(ua.getBytes(), 2);
            }
            NativeAbilityUserAgentModel nativeAbilityUserAgentModel = new NativeAbilityUserAgentModel(0);
            nativeAbilityUserAgentModel.cnt.data = ua;
            iLightappInvokerCallback.onResult(0, nativeAbilityUserAgentModel.toJson());
        }
    }
}
