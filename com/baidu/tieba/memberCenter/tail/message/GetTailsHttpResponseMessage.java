package com.baidu.tieba.memberCenter.tail.message;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.memberCenter.tail.data.d;
/* loaded from: classes9.dex */
public class GetTailsHttpResponseMessage extends HttpResponsedMessage {
    private d resultData;

    public GetTailsHttpResponseMessage() {
        super(1003021);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: getResultData */
    public d m46getResultData() {
        return this.resultData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        this.resultData = GetTailsSocketResponseMessage.getResult(this, i, bArr);
    }
}
