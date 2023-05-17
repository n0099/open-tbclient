package com.baidu.tieba.pb.pb.main.relatelist;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.RelateRecThread.DataRes;
import tbclient.RelateRecThread.RelateRecThreadResIdl;
/* loaded from: classes7.dex */
public class RelateRecThreadHttpResponseMessage extends TbHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DataRes mData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RelateRecThreadHttpResponseMessage() {
        super(CmdConfigHttp.CMD_RELATE_REC_THREAD);
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

    public DataRes getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mData;
        }
        return (DataRes) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) {
            try {
                RelateRecThreadResIdl relateRecThreadResIdl = (RelateRecThreadResIdl) new Wire(new Class[0]).parseFrom(bArr, RelateRecThreadResIdl.class);
                if (relateRecThreadResIdl != null && relateRecThreadResIdl.error != null) {
                    setError(relateRecThreadResIdl.error.errorno.intValue());
                    setErrorString(relateRecThreadResIdl.error.usermsg);
                }
                if (relateRecThreadResIdl != null) {
                    this.mData = relateRecThreadResIdl.data;
                }
            } catch (Exception e) {
                e.printStackTrace();
                setError(-2);
            }
        }
    }
}
