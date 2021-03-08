package com.baidu.tieba.memberCenter.tail.message;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.memberCenter.tail.data.f;
/* loaded from: classes8.dex */
public class SetTailHttpResponseMessage extends HttpResponsedMessage {
    private f resultData;

    public SetTailHttpResponseMessage() {
        super(1003022);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: getResultData */
    public f m43getResultData() {
        return this.resultData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        this.resultData = SetTailSocketResponseMessage.getResult(this, i, bArr);
    }
}
