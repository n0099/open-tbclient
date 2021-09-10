package com.baidu.tieba.memberCenter.tail.message;

import c.a.q0.d1.x;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.SetTail.ReqData;
import tbclient.SetTail.SetTailReqIdl;
/* loaded from: classes7.dex */
public class SetTailNetMessage extends NetMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ReqData.Builder data;
    public SetTailReqIdl.Builder idl;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SetTailNetMessage(int i2, int i3) {
        super(CmdConfigHttp.CMD_TAIL_SET, 305104);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.data = new ReqData.Builder();
        this.idl = new SetTailReqIdl.Builder();
        this.data.tailId = Integer.valueOf(i2);
        this.data.type = Integer.valueOf(i3);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            if (z) {
                x.a(this.data, true);
            }
            this.idl.data = this.data.build(false);
            return this.idl.build(false);
        }
        return invokeZ.objValue;
    }
}
