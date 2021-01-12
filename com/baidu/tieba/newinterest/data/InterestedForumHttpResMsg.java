package com.baidu.tieba.newinterest.data;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.squareup.wire.Wire;
import tbclient.GetVerticalForumList.GetVerticalForumListResIdl;
/* loaded from: classes7.dex */
public class InterestedForumHttpResMsg extends HttpResponsedMessage {
    private c pageData;

    public InterestedForumHttpResMsg() {
        super(CmdConfigHttp.CMD_GUIDE_INTERESTED_FORUM);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetVerticalForumListResIdl getVerticalForumListResIdl = (GetVerticalForumListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetVerticalForumListResIdl.class);
        if (getVerticalForumListResIdl != null) {
            if (getVerticalForumListResIdl.error != null) {
                if (getVerticalForumListResIdl.error.errorno != null) {
                    setError(getVerticalForumListResIdl.error.errorno.intValue());
                }
                setErrorString(getVerticalForumListResIdl.error.usermsg);
            }
            this.pageData = new c();
            this.pageData.a(getVerticalForumListResIdl.data);
        }
    }

    public c getPageData() {
        return this.pageData;
    }
}
