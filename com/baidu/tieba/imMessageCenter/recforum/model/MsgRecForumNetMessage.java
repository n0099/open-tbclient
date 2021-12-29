package com.baidu.tieba.imMessageCenter.recforum.model;

import c.a.s0.e1.b0;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.CommonReq;
import tbclient.GetMsgRecForumlist.DataReq;
import tbclient.GetMsgRecForumlist.GetMsgRecForumlistReqIdl;
/* loaded from: classes12.dex */
public class MsgRecForumNetMessage extends NetMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: common  reason: collision with root package name */
    public CommonReq f47074common;
    public Integer mPn;
    public Integer mRn;
    public Long userId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgRecForumNetMessage() {
        super(CmdConfigHttp.CMD_HTTP_GET_MSG_REC_FORUM_LIST, 309712);
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
            builder.f65169common = this.f47074common;
            builder.pn = this.mPn;
            builder.rn = this.mRn;
            builder.user_id = this.userId;
            if (z) {
                b0.a(builder, true);
            }
            GetMsgRecForumlistReqIdl.Builder builder2 = new GetMsgRecForumlistReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        }
        return invokeZ.objValue;
    }
}
