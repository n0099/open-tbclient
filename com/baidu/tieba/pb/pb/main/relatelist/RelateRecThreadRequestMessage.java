package com.baidu.tieba.pb.pb.main.relatelist;

import c.a.q0.d1.z;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.RelateRecThread.DataReq;
import tbclient.RelateRecThread.RelateRecThreadReqIdl;
/* loaded from: classes7.dex */
public class RelateRecThreadRequestMessage extends NetMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long forumId;
    public int sourceFrom;
    public int sourceType;
    public long threadId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RelateRecThreadRequestMessage() {
        super(CmdConfigHttp.CMD_RELATE_REC_THREAD, 309701);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                super(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            DataReq.Builder builder = new DataReq.Builder();
            builder.forum_id = Long.valueOf(this.forumId);
            builder.thread_id = Long.valueOf(this.threadId);
            builder.source_type = Integer.valueOf(this.sourceType);
            builder.source_from = Integer.valueOf(this.sourceFrom);
            if (z) {
                z.a(builder, true);
            }
            RelateRecThreadReqIdl.Builder builder2 = new RelateRecThreadReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        }
        return invokeZ.objValue;
    }
}
