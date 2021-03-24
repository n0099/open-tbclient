package com.baidu.tieba.memberCenter.tail.message;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.IDataResponseMessage;
import d.b.i0.q1.h.a.f;
/* loaded from: classes3.dex */
public class SetTailHttpResponseMessage extends HttpResponsedMessage implements IDataResponseMessage<f> {
    public f resultData;

    public SetTailHttpResponseMessage() {
        super(CmdConfigHttp.CMD_TAIL_SET);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        this.resultData = SetTailSocketResponseMessage.getResult(this, i, bArr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.core.util.IDataResponseMessage
    public f getResultData() {
        return this.resultData;
    }
}
