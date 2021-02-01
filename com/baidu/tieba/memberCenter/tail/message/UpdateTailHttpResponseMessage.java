package com.baidu.tieba.memberCenter.tail.message;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.memberCenter.tail.data.g;
/* loaded from: classes9.dex */
public class UpdateTailHttpResponseMessage extends HttpResponsedMessage {
    private g resultData;

    public UpdateTailHttpResponseMessage() {
        super(1003023);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: getResultData */
    public g m44getResultData() {
        return this.resultData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        this.resultData = UpdateTailSocketResponseMessage.getResult(this, i, bArr);
    }
}
