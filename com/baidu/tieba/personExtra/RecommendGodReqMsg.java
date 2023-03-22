package com.baidu.tieba.personExtra;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.switchs.SocketAddCommonParamSwitch;
import com.baidu.tieba.kp5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.GetRecommendGodList.DataReq;
import tbclient.GetRecommendGodList.GetRecommendGodListReqIdl;
/* loaded from: classes5.dex */
public class RecommendGodReqMsg extends NetMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int pageNum;
    public String portrait;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecommendGodReqMsg() {
        super(CmdConfigHttp.CMD_GET_RECOMMEND_GOD_LIST, 309684);
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
            DataReq.Builder builder = new DataReq.Builder();
            if (z || SocketAddCommonParamSwitch.getIsOn()) {
                kp5.a(builder, true);
            }
            builder.portrait = this.portrait;
            builder.pn = Integer.valueOf(this.pageNum);
            GetRecommendGodListReqIdl.Builder builder2 = new GetRecommendGodListReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        }
        return invokeZ.objValue;
    }
}
