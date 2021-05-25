package com.baidu.tieba.personExtra;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import d.a.n0.i2.b;
/* loaded from: classes5.dex */
public class ResponsePersonBarByUidLocalMessage extends CustomResponsedMessage<String> {
    public b mData;

    public ResponsePersonBarByUidLocalMessage() {
        super(2001183);
    }

    public b getPersonBarData() {
        return this.mData;
    }

    public void setPersonBarData(b bVar) {
        this.mData = bVar;
    }

    public ResponsePersonBarByUidLocalMessage(int i2) {
        super(i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.CustomResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, String str) throws Exception {
        b bVar = new b();
        this.mData = bVar;
        bVar.n(str);
    }
}
