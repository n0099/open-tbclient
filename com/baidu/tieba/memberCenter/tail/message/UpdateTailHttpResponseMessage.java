package com.baidu.tieba.memberCenter.tail.message;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.IDataResponseMessage;
import d.a.n0.s1.h.a.g;
/* loaded from: classes3.dex */
public class UpdateTailHttpResponseMessage extends HttpResponsedMessage implements IDataResponseMessage<g> {
    public g resultData;

    public UpdateTailHttpResponseMessage() {
        super(CmdConfigHttp.CMD_TAIL_UPDATE);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        this.resultData = UpdateTailSocketResponseMessage.getResult(this, i2, bArr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.core.util.IDataResponseMessage
    public g getResultData() {
        return this.resultData;
    }
}
