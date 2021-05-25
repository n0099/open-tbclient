package com.baidu.tieba.newinterest.data;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.squareup.wire.Wire;
import d.a.n0.a2.c.c;
import tbclient.Error;
import tbclient.GetVerticalForumList.GetVerticalForumListResIdl;
/* loaded from: classes4.dex */
public class InterestedForumHttpResMsg extends HttpResponsedMessage {
    public c pageData;

    public InterestedForumHttpResMsg() {
        super(CmdConfigHttp.CMD_GUIDE_INTERESTED_FORUM);
    }

    public c getPageData() {
        return this.pageData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        GetVerticalForumListResIdl getVerticalForumListResIdl = (GetVerticalForumListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetVerticalForumListResIdl.class);
        if (getVerticalForumListResIdl == null) {
            return;
        }
        Error error = getVerticalForumListResIdl.error;
        if (error != null) {
            Integer num = error.errorno;
            if (num != null) {
                setError(num.intValue());
            }
            setErrorString(getVerticalForumListResIdl.error.usermsg);
        }
        c cVar = new c();
        this.pageData = cVar;
        cVar.a(getVerticalForumListResIdl.data);
    }
}
