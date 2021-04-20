package com.baidu.tieba.square.forumlist;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.GetForumsFromForumClass.GetForumsFromForumClassResIdl;
/* loaded from: classes4.dex */
public class SquareForumListResHttpMsg extends TbHttpResponsedMessage {
    public GetForumsFromForumClassResIdl mResponseData;

    public SquareForumListResHttpMsg(int i) {
        super(CmdConfigHttp.CMD_SQUARE_FORUM_LIST);
    }

    public GetForumsFromForumClassResIdl getResponseData() {
        return this.mResponseData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        super.decodeInBackGround(i, bArr);
        GetForumsFromForumClassResIdl getForumsFromForumClassResIdl = (GetForumsFromForumClassResIdl) new Wire(new Class[0]).parseFrom(bArr, GetForumsFromForumClassResIdl.class);
        this.mResponseData = getForumsFromForumClassResIdl;
        Error error = getForumsFromForumClassResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(this.mResponseData.error.errmsg);
        }
    }
}
