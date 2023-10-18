package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.api.ExpressResponse;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class vkb implements ylb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ExpressResponse a;

    public vkb(ExpressResponse expressResponse) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {expressResponse};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = expressResponse;
    }

    @Override // com.baidu.tieba.ylb
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ExpressResponse expressResponse = this.a;
            return expressResponse != null ? expressResponse.getECPMLevel() : "0";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ylb
    public void a(String str) {
        ExpressResponse expressResponse;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (expressResponse = this.a) == null) {
            return;
        }
        expressResponse.biddingSuccess(str);
    }

    @Override // com.baidu.tieba.ylb
    public void a(String str, HashMap<String, Object> hashMap) {
        ExpressResponse expressResponse;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, hashMap) == null) || (expressResponse = this.a) == null) {
            return;
        }
        expressResponse.biddingFail(str, hashMap);
    }
}
