package com.baidu.tieba.personExtra;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes6.dex */
public class ResponsePersonBarByUidLocalMessage extends CustomResponsedMessage<String> {
    private b mData;

    public ResponsePersonBarByUidLocalMessage() {
        super(2001183);
    }

    public ResponsePersonBarByUidLocalMessage(int i) {
        super(i);
    }

    public void setPersonBarData(b bVar) {
        this.mData = bVar;
    }

    public b getPersonBarData() {
        return this.mData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.CustomResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, String str) throws Exception {
        this.mData = new b();
        this.mData.parserJson(str);
    }
}
