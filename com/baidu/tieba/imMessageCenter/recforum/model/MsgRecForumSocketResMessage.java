package com.baidu.tieba.imMessageCenter.recforum.model;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.List;
import tbclient.Error;
import tbclient.GetMsgRecForumlist.DataRes;
import tbclient.GetMsgRecForumlist.GetMsgRecForumlistResIdl;
import tbclient.Page;
import tbclient.RecommendForumInfo;
/* loaded from: classes3.dex */
public class MsgRecForumSocketResMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<RecommendForumInfo> forumList;
    public Page pageInfo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgRecForumSocketResMessage() {
        super(309712);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            GetMsgRecForumlistResIdl getMsgRecForumlistResIdl = (GetMsgRecForumlistResIdl) new Wire(new Class[0]).parseFrom(bArr, GetMsgRecForumlistResIdl.class);
            if (getMsgRecForumlistResIdl == null) {
                return null;
            }
            Error error = getMsgRecForumlistResIdl.error;
            if (error != null) {
                setError(error.errorno.intValue());
                setErrorString(getMsgRecForumlistResIdl.error.usermsg);
            }
            DataRes dataRes = getMsgRecForumlistResIdl.data;
            if (dataRes != null) {
                this.forumList = dataRes.forum_list;
                this.pageInfo = dataRes.page_info;
            }
            return getMsgRecForumlistResIdl;
        }
        return invokeIL.objValue;
    }
}
