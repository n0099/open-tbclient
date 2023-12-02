package com.baidu.tieba.setting.forbiddenforum;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.gna;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.GetDislikeList.GetDislikeListResIdl;
/* loaded from: classes8.dex */
public class ForbiddenForumHttpResMsg extends HttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public gna pageData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForbiddenForumHttpResMsg() {
        super(CmdConfigHttp.CMD_GET_FORBIDDEN_FORUM);
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

    public gna getPageData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.pageData;
        }
        return (gna) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetDislikeListResIdl getDislikeListResIdl;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) != null) || (getDislikeListResIdl = (GetDislikeListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetDislikeListResIdl.class)) == null) {
            return;
        }
        Error error = getDislikeListResIdl.error;
        if (error != null) {
            Integer num = error.errorno;
            if (num != null) {
                setError(num.intValue());
            }
            setErrorString(getDislikeListResIdl.error.usermsg);
        }
        gna gnaVar = new gna();
        this.pageData = gnaVar;
        gnaVar.a(getDislikeListResIdl.data);
    }
}
