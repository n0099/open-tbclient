package com.baidu.tieba.memberCenter.tail.message;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.IDataResponseMessage;
import d.a.k0.r1.h.a.b;
/* loaded from: classes3.dex */
public class AddTailHttpResponseMessage extends HttpResponsedMessage implements IDataResponseMessage<b> {
    public b resultData;

    public AddTailHttpResponseMessage() {
        super(CmdConfigHttp.CMD_TAIL_ADD);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        this.resultData = AddTailSocketResponseMessage.getResult(this, i2, bArr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.core.util.IDataResponseMessage
    public b getResultData() {
        return this.resultData;
    }
}
