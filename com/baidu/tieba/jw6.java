package com.baidu.tieba;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class jw6 extends hb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jw6() {
        super(0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.lb
    public /* bridge */ /* synthetic */ ResponsedMessage a(ResponsedMessage responsedMessage) {
        HttpResponsedMessage httpResponsedMessage = (HttpResponsedMessage) responsedMessage;
        c(httpResponsedMessage);
        return httpResponsedMessage;
    }

    public HttpResponsedMessage c(HttpResponsedMessage httpResponsedMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, httpResponsedMessage)) == null) {
            if (httpResponsedMessage == null) {
                return httpResponsedMessage;
            }
            if (httpResponsedMessage.getError() == 1990055 && !iw6.c(httpResponsedMessage.getCmd())) {
                iw6.d();
            }
            return httpResponsedMessage;
        }
        return (HttpResponsedMessage) invokeL.objValue;
    }
}
