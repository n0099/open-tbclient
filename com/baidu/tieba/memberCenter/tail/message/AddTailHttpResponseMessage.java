package com.baidu.tieba.memberCenter.tail.message;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.memberCenter.tail.data.b;
/* loaded from: classes9.dex */
public class AddTailHttpResponseMessage extends HttpResponsedMessage {
    private b resultData;

    public AddTailHttpResponseMessage() {
        super(1003019);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: getResultData */
    public b m36getResultData() {
        return this.resultData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        this.resultData = AddTailSocketResponseMessage.getResult(this, i, bArr);
    }
}
