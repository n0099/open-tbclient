package com.baidu.tieba.immessagecenter.mention;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.mvc.data.INetRequestData;
import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetAutoModel;
import com.baidu.tieba.rt8;
import com.baidu.tieba.st8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ReplyMeNetModel extends NetAutoModel<rt8, st8, ReplyMessageFragment> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tbadk.mvc.model.NetModel
    public int Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? CmdConfigHttp.REPLYME_HTTP_CMD : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    public String c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "c/u/feed/replyme" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    public int d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 303007;
        }
        return invokeV.intValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReplyMeNetModel(TbPageContext tbPageContext, rt8 rt8Var) {
        super(tbPageContext, rt8Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, rt8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (INetRequestData) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    public Class<? extends MvcProtobufHttpResponsedMessage> b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return ReplyMeHttpResponseMessage.class;
        }
        return (Class) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    public Class<? extends MvcSocketResponsedMessage> e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return ReplyMeSocketResponseMessage.class;
        }
        return (Class) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    public Class<st8> getResponseDataClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return st8.class;
        }
        return (Class) invokeV.objValue;
    }
}
