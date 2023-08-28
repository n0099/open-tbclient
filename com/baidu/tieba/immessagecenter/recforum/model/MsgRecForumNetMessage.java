package com.baidu.tieba.immessagecenter.recforum.model;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.switchs.SocketAddCommonParamSwitch;
import com.baidu.tbadk.util.NetMessageHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.CommonReq;
import tbclient.GetMsgRecForumlist.DataReq;
import tbclient.GetMsgRecForumlist.GetMsgRecForumlistReqIdl;
/* loaded from: classes6.dex */
public class MsgRecForumNetMessage extends NetMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: common  reason: collision with root package name */
    public CommonReq f1136common;
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
            builder.f1362common = this.f1136common;
            builder.pn = this.mPn;
            builder.rn = this.mRn;
            builder.user_id = this.userId;
            if (z || SocketAddCommonParamSwitch.getIsOn()) {
                NetMessageHelper.bindCommonParamsToProtobufData(builder, true);
            }
            GetMsgRecForumlistReqIdl.Builder builder2 = new GetMsgRecForumlistReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        }
        return invokeZ.objValue;
    }
}
