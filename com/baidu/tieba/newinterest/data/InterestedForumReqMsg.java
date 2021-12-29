package com.baidu.tieba.newinterest.data;

import c.a.s0.b.d;
import c.a.s0.e1.b0;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.GetVerticalForumList.DataReq;
import tbclient.GetVerticalForumList.GetVerticalForumListReqIdl;
/* loaded from: classes12.dex */
public class InterestedForumReqMsg extends NetMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<Integer> classidList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InterestedForumReqMsg() {
        super(CmdConfigHttp.CMD_GUIDE_INTERESTED_FORUM, 309654);
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
            if (z) {
                b0.a(builder, true);
            }
            if (!d.E()) {
                builder.begin_id = 1;
                builder.pn = 0;
            }
            builder.classid_list = this.classidList;
            GetVerticalForumListReqIdl.Builder builder2 = new GetVerticalForumListReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        }
        return invokeZ.objValue;
    }
}
