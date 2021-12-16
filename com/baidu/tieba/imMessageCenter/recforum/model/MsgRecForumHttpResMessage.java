package com.baidu.tieba.imMessageCenter.recforum.model;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.List;
import tbclient.Error;
import tbclient.GetMsgRecForumlist.DataRes;
import tbclient.GetMsgRecForumlist.GetMsgRecForumlistResIdl;
import tbclient.Page;
import tbclient.RecommendForumInfo;
/* loaded from: classes12.dex */
public class MsgRecForumHttpResMessage extends TbHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<RecommendForumInfo> forumList;
    public Page pageInfo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgRecForumHttpResMessage() {
        super(CmdConfigHttp.CMD_HTTP_GET_MSG_REC_FORUM_LIST);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        GetMsgRecForumlistResIdl getMsgRecForumlistResIdl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) || (getMsgRecForumlistResIdl = (GetMsgRecForumlistResIdl) new Wire(new Class[0]).parseFrom(bArr, GetMsgRecForumlistResIdl.class)) == null) {
            return;
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
    }
}
