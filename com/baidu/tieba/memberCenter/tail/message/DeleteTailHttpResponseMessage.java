package com.baidu.tieba.memberCenter.tail.message;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.memberCenter.tail.data.c;
/* loaded from: classes9.dex */
public class DeleteTailHttpResponseMessage extends HttpResponsedMessage {
    private c resultData;

    public DeleteTailHttpResponseMessage() {
        super(1003020);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: getResultData */
    public c m44getResultData() {
        return this.resultData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        this.resultData = DeleteTailSocketResponseMessage.getResult(this, i, bArr);
    }
}
