package com.baidu.tieba.imMessageCenter;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import protobuf.CommitInviteMsg.CommitInviteMsgReqIdl;
import protobuf.CommitInviteMsg.DataReq;
/* loaded from: classes4.dex */
public class RequestCommitInviteMessage extends TbSocketMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DataReq mReqData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RequestCommitInviteMessage() {
        super(205002);
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

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.mReqData != null) {
                CommitInviteMsgReqIdl.Builder builder = new CommitInviteMsgReqIdl.Builder();
                builder.data = this.mReqData;
                return builder.build(false);
            }
            return null;
        }
        return invokeV.objValue;
    }

    public void setReqData(DataReq dataReq) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataReq) == null) {
            this.mReqData = dataReq;
        }
    }
}
