package com.baidu.tieba.memberCenter.tail.message;

import c.a.s0.e1.b0;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.DeleteTail.DeleteTailReqIdl;
import tbclient.DeleteTail.ReqData;
/* loaded from: classes12.dex */
public class DeleteTailNetMessage extends NetMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ReqData.Builder data;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeleteTailNetMessage(int i2) {
        super(CmdConfigHttp.CMD_TAIL_DELETE, 305103);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        ReqData.Builder builder = new ReqData.Builder();
        this.data = builder;
        builder.tailId = Integer.valueOf(i2);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            DeleteTailReqIdl.Builder builder = new DeleteTailReqIdl.Builder();
            if (z) {
                b0.a(this.data, true);
            }
            builder.data = this.data.build(false);
            return builder.build(false);
        }
        return invokeZ.objValue;
    }
}
