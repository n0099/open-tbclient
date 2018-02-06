package com.baidu.tieba.personExtra;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes3.dex */
public class ResponsePersonBarByUidLocalMessage extends CustomResponsedMessage<String> {
    private c mData;

    public ResponsePersonBarByUidLocalMessage() {
        super(2001183);
    }

    public ResponsePersonBarByUidLocalMessage(int i) {
        super(i);
    }

    public void setPersonBarData(c cVar) {
        this.mData = cVar;
    }

    public c getPersonBarData() {
        return this.mData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.CustomResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, String str) throws Exception {
        this.mData = new c();
        this.mData.parserJson(str);
    }
}
