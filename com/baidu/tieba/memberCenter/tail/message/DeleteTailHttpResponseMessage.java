package com.baidu.tieba.memberCenter.tail.message;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.IDataResponseMessage;
import d.a.n0.s1.h.a.c;
/* loaded from: classes3.dex */
public class DeleteTailHttpResponseMessage extends HttpResponsedMessage implements IDataResponseMessage<c> {
    public c resultData;

    public DeleteTailHttpResponseMessage() {
        super(CmdConfigHttp.CMD_TAIL_DELETE);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        this.resultData = DeleteTailSocketResponseMessage.getResult(this, i2, bArr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.core.util.IDataResponseMessage
    public c getResultData() {
        return this.resultData;
    }
}
