package com.baidu.tieba.square.message;

import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.baidu.tieba.square.data.d;
import com.squareup.wire.Wire;
import tbclient.GetForumSquare.GetForumSquareResIdl;
/* loaded from: classes21.dex */
public class ForumSquareSocketResponsedMessage extends TbSocketReponsedMessage {
    private d mForumSquareRespData;

    public ForumSquareSocketResponsedMessage() {
        super(309653);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetForumSquareResIdl getForumSquareResIdl = (GetForumSquareResIdl) new Wire(new Class[0]).parseFrom(bArr, GetForumSquareResIdl.class);
        if (getForumSquareResIdl.error != null && getForumSquareResIdl.error.errorno != null) {
            setError(getForumSquareResIdl.error.errorno.intValue());
        }
        if (getForumSquareResIdl.error != null && getForumSquareResIdl.error.usermsg != null && getForumSquareResIdl.error.usermsg.length() > 0) {
            setErrorString(getForumSquareResIdl.error.usermsg);
        }
        if (getError() == 0 && getForumSquareResIdl.data != null) {
            this.mForumSquareRespData = new d();
            this.mForumSquareRespData.a(getForumSquareResIdl.data);
        }
    }

    public d getData() {
        return this.mForumSquareRespData;
    }
}
