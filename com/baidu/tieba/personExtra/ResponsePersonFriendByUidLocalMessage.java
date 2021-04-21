package com.baidu.tieba.personExtra;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import d.b.i0.r.q.f1;
/* loaded from: classes3.dex */
public class ResponsePersonFriendByUidLocalMessage extends CustomResponsedMessage<String> {
    public f1 mData;

    public ResponsePersonFriendByUidLocalMessage() {
        super(2001182);
    }

    public f1 getPersonFriendData() {
        return this.mData;
    }

    public void setPersonFriendData(f1 f1Var) {
        this.mData = f1Var;
    }

    public ResponsePersonFriendByUidLocalMessage(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.CustomResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, String str) throws Exception {
        if (str != null) {
            f1 f1Var = new f1();
            this.mData = f1Var;
            f1Var.f(str);
        }
    }
}
