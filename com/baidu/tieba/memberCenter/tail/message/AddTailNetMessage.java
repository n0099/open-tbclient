package com.baidu.tieba.memberCenter.tail.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.switchs.SocketAddCommonParamSwitch;
import com.baidu.tieba.bx5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.AddTail.AddTailReqIdl;
import tbclient.AddTail.ReqData;
/* loaded from: classes6.dex */
public class AddTailNetMessage extends NetMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ReqData.Builder data;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddTailNetMessage(String str, String str2, String str3) {
        super(CmdConfigHttp.CMD_TAIL_ADD, 305101);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        ReqData.Builder builder = new ReqData.Builder();
        this.data = builder;
        builder.tailContent = str;
        builder.fontColor = str2;
        builder.fontKeyName = str3;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            AddTailReqIdl.Builder builder = new AddTailReqIdl.Builder();
            if (z || SocketAddCommonParamSwitch.getIsOn()) {
                bx5.a(this.data, true);
            }
            builder.data = this.data.build(false);
            return builder.build(false);
        }
        return invokeZ.objValue;
    }
}
