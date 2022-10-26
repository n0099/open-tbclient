package com.baidu.turbonet.net;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect;
/* loaded from: classes6.dex */
public class RegistrationPolicyAlwaysRegister extends NetworkChangeNotifierAutoDetect.RegistrationPolicy {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.RegistrationPolicy
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    public RegistrationPolicyAlwaysRegister() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.RegistrationPolicy
    public void b(NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, networkChangeNotifierAutoDetect) == null) {
            super.b(networkChangeNotifierAutoDetect);
            c();
        }
    }
}
