package com.baidu.tieba.setting.im.more;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.switchs.SocketAddCommonParamSwitch;
import com.baidu.tbadk.util.NetMessageHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.GetPrivateInfo.GetPrivateInfoReqIdl;
import tbclient.GetPrivateInfo.ReqData;
/* loaded from: classes7.dex */
public class PrivateInfoNetMessage extends NetMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrivateInfoNetMessage() {
        super(CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            ReqData.Builder builder = new ReqData.Builder();
            builder.user_id = Long.valueOf(JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
            if (z || SocketAddCommonParamSwitch.getIsOn()) {
                NetMessageHelper.bindCommonParamsToProtobufData(builder, true);
            }
            GetPrivateInfoReqIdl.Builder builder2 = new GetPrivateInfoReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        }
        return invokeZ.objValue;
    }
}
