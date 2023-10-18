package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class zkb implements ylb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NativeResponse a;

    public zkb(NativeResponse nativeResponse) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nativeResponse};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = nativeResponse;
    }

    @Override // com.baidu.tieba.ylb
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            NativeResponse nativeResponse = this.a;
            return nativeResponse != null ? nativeResponse.getECPMLevel() : "0";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ylb
    public void a(String str) {
        NativeResponse nativeResponse;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (nativeResponse = this.a) == null) {
            return;
        }
        nativeResponse.biddingSuccess(str);
    }

    @Override // com.baidu.tieba.ylb
    public void a(String str, HashMap<String, Object> hashMap) {
        NativeResponse nativeResponse;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, hashMap) == null) || (nativeResponse = this.a) == null) {
            return;
        }
        nativeResponse.biddingFail(str, hashMap);
    }
}
