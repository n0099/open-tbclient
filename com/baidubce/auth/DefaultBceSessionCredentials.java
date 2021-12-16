package com.baidubce.auth;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.util.CheckUtils;
/* loaded from: classes2.dex */
public class DefaultBceSessionCredentials extends DefaultBceCredentials implements BceSessionCredentials {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String sessionToken;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultBceSessionCredentials(String str, String str2, String str3) {
        super(str, str2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        CheckUtils.isNotNull(str3, "token should not be null.");
        CheckUtils.checkArgument(!str3.isEmpty(), "token should not be empty.");
        this.sessionToken = str3;
    }

    @Override // com.baidubce.auth.BceSessionCredentials
    public String getSessionToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.sessionToken : (String) invokeV.objValue;
    }
}
