package com.baidu.tieba.message;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import protobuf.DebugCommitMsg.DataReq;
import protobuf.DebugCommitMsg.DebugCommitMsgReqIdl;
/* loaded from: classes13.dex */
public class TbDebugOnlineMessage extends TbSocketMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean bSender;
    public String content;
    public String from;
    public String to;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbDebugOnlineMessage(boolean z, String str, String str2, String str3) {
        super(205102);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), str, str2, str3};
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
        this.bSender = true;
        this.bSender = z;
        this.from = str;
        this.to = str2;
        this.content = str3;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                DataReq.Builder builder = new DataReq.Builder();
                builder.content = this.content;
                builder.sender = Boolean.valueOf(this.bSender);
                builder.to = this.to;
                builder.cuid = this.from;
                DebugCommitMsgReqIdl.Builder builder2 = new DebugCommitMsgReqIdl.Builder();
                builder2.data = builder.build(false);
                return builder2.build(false);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                return null;
            }
        }
        return invokeV.objValue;
    }
}
