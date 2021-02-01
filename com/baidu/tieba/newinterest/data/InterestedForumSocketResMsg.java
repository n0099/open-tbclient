package com.baidu.tieba.newinterest.data;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.GetVerticalForumList.GetVerticalForumListResIdl;
/* loaded from: classes8.dex */
public class InterestedForumSocketResMsg extends SocketResponsedMessage {
    private c pageData;

    public InterestedForumSocketResMsg() {
        super(309654);
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
