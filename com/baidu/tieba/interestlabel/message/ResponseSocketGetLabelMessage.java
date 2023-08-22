package com.baidu.tieba.interestlabel.message;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.q09;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.GetTagList.GetTagListResIdl;
/* loaded from: classes6.dex */
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

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        RequestGetLabelMessage requestGetLabelMessage;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            GetTagListResIdl getTagListResIdl = (GetTagListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetTagListResIdl.class);
            q09 q09Var = null;
            if (getTagListResIdl == null) {
                return null;
            }
            setError(getTagListResIdl.error.errorno.intValue());
            setErrorString(getTagListResIdl.error.usermsg);
            if (getError() != 0) {
                return getTagListResIdl;
            }
            if (getOrginalMessage().getExtra() instanceof RequestGetLabelMessage) {
                requestGetLabelMessage = (RequestGetLabelMessage) getOrginalMessage().getExtra();
            } else {
                requestGetLabelMessage = null;
            }
            if (requestGetLabelMessage != null) {
                q09Var = requestGetLabelMessage.getLabelDataSet();
            }
            if (q09Var != null) {
                q09Var.c(getTagListResIdl.data);
            }
            return getTagListResIdl;
        }
        return invokeIL.objValue;
    }
}
