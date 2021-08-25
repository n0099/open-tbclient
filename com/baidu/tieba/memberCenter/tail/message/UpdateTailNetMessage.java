package com.baidu.tieba.memberCenter.tail.message;

import c.a.p0.b1.w;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.UpdateTail.ReqData;
import tbclient.UpdateTail.UpdateTailReqIdl;
/* loaded from: classes7.dex */
public class UpdateTailNetMessage extends NetMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ReqData.Builder data;
    public UpdateTailReqIdl.Builder idl;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UpdateTailNetMessage(int i2, String str, String str2, String str3) {
        super(CmdConfigHttp.CMD_TAIL_UPDATE, 305102);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), str, str2, str3};
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
        this.data = new ReqData.Builder();
        this.idl = new UpdateTailReqIdl.Builder();
        this.data.tailId = Integer.valueOf(i2);
        ReqData.Builder builder = this.data;
        builder.tailContent = str;
        builder.fontColor = str2;
        builder.fontKeyName = str3;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            if (z) {
                w.a(this.data, true);
            }
            this.idl.data = this.data.build(false);
            return this.idl.build(false);
        }
        return invokeZ.objValue;
    }
}
