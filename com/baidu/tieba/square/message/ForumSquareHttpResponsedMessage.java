package com.baidu.tieba.square.message;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import d.b.i0.z2.f.d;
import tbclient.Error;
import tbclient.GetForumSquare.GetForumSquareResIdl;
/* loaded from: classes5.dex */
public class ForumSquareHttpResponsedMessage extends TbHttpResponsedMessage {
    public d mForumSquareRespData;

    public ForumSquareHttpResponsedMessage() {
        super(CmdConfigHttp.CMD_FORUM_SQUARE);
    }

    public d getData() {
        return this.mForumSquareRespData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        String str;
        Integer num;
        GetForumSquareResIdl getForumSquareResIdl = (GetForumSquareResIdl) new Wire(new Class[0]).parseFrom(bArr, GetForumSquareResIdl.class);
        Error error = getForumSquareResIdl.error;
        if (error != null && (num = error.errorno) != null) {
            setError(num.intValue());
        }
        Error error2 = getForumSquareResIdl.error;
        if (error2 != null && (str = error2.usermsg) != null && str.length() > 0) {
            setErrorString(getForumSquareResIdl.error.usermsg);
        }
        if (getError() == 0 && getForumSquareResIdl.data != null) {
            d dVar = new d();
            this.mForumSquareRespData = dVar;
            dVar.a(getForumSquareResIdl.data);
        }
    }
}
