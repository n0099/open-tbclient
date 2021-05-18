package com.baidu.tieba.newinterest.data;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import d.a.k0.z1.c.c;
import tbclient.Error;
import tbclient.GetVerticalForumList.GetVerticalForumListResIdl;
/* loaded from: classes4.dex */
public class InterestedForumSocketResMsg extends SocketResponsedMessage {
    public c pageData;

    public InterestedForumSocketResMsg() {
        super(309654);
    }

    public c getPageData() {
        return this.pageData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
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
