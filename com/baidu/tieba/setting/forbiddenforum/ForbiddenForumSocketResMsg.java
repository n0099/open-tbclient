package com.baidu.tieba.setting.forbiddenforum;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.GetDislikeList.GetDislikeListResIdl;
/* loaded from: classes8.dex */
public class ForbiddenForumSocketResMsg extends SocketResponsedMessage {
    private d pageData;

    public d getPageData() {
        return this.pageData;
    }

    public ForbiddenForumSocketResMsg() {
        super(309692);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetDislikeListResIdl getDislikeListResIdl = (GetDislikeListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetDislikeListResIdl.class);
        if (getDislikeListResIdl != null) {
            if (getDislikeListResIdl.error != null) {
                if (getDislikeListResIdl.error.errorno != null) {
                    setError(getDislikeListResIdl.error.errorno.intValue());
                }
                setErrorString(getDislikeListResIdl.error.usermsg);
            }
            this.pageData = new d();
            this.pageData.a(getDislikeListResIdl.data);
        }
    }
}
