package com.baidu.tieba.interestlabel.message;

import b.a.r0.o1.b.b;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.GetTagList.GetTagListResIdl;
/* loaded from: classes9.dex */
public class ResponseSocketGetLabelMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponseSocketGetLabelMessage() {
        super(309467);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        GetTagListResIdl getTagListResIdl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) || (getTagListResIdl = (GetTagListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetTagListResIdl.class)) == null) {
            return;
        }
        setError(getTagListResIdl.error.errorno.intValue());
        setErrorString(getTagListResIdl.error.usermsg);
        if (getError() != 0) {
            return;
        }
        RequestGetLabelMessage requestGetLabelMessage = getOrginalMessage().getExtra() instanceof RequestGetLabelMessage ? (RequestGetLabelMessage) getOrginalMessage().getExtra() : null;
        b labelDataSet = requestGetLabelMessage != null ? requestGetLabelMessage.getLabelDataSet() : null;
        if (labelDataSet != null) {
            labelDataSet.d(getTagListResIdl.data);
        }
    }
}
