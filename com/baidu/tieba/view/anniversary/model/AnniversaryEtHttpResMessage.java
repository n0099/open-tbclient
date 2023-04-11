package com.baidu.tieba.view.anniversary.model;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.py9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.VideoTemplate.VideoTemplateResIdl;
/* loaded from: classes6.dex */
public class AnniversaryEtHttpResMessage extends HttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public py9 resultData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnniversaryEtHttpResMessage() {
        super(CmdConfigHttp.CMD_HTTP_ET_VIDEO);
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public py9 getResultData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.resultData;
        }
        return (py9) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        VideoTemplateResIdl videoTemplateResIdl;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) && (videoTemplateResIdl = (VideoTemplateResIdl) new Wire(new Class[0]).parseFrom(bArr, VideoTemplateResIdl.class)) != null) {
            Error error = videoTemplateResIdl.error;
            if (error != null) {
                setError(error.errorno.intValue());
                setErrorString(videoTemplateResIdl.error.usermsg);
            }
            if (videoTemplateResIdl.data != null) {
                py9 py9Var = new py9();
                this.resultData = py9Var;
                py9Var.g(videoTemplateResIdl.data);
            }
        }
    }
}
