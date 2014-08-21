package com.baidu.tieba.person;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class ResponsePersonBarByUidLocalMessage extends CustomResponsedMessage<String> {
    private t mData;

    public ResponsePersonBarByUidLocalMessage() {
        super(2001187);
    }

    public ResponsePersonBarByUidLocalMessage(int i) {
        super(i);
    }

    public void setPersonBarData(t tVar) {
        this.mData = tVar;
    }

    public t getPersonBarData() {
        return this.mData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.CustomResponsedMessage, com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, String str) {
        this.mData = new t();
        this.mData.a(str);
    }
}
