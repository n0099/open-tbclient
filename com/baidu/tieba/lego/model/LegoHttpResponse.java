package com.baidu.tieba.lego.model;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.Lego.DataRes;
import tbclient.Lego.LegoResIdl;
/* loaded from: classes8.dex */
public class LegoHttpResponse extends HttpResponsedMessage {
    private DataRes resultData;

    public LegoHttpResponse(int i) {
        super(1003079);
    }

    public DataRes getResultData() {
        return this.resultData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        LegoResIdl legoResIdl = (LegoResIdl) new Wire(new Class[0]).parseFrom(bArr, LegoResIdl.class);
        if (legoResIdl != null) {
            if (legoResIdl.error != null) {
                if (legoResIdl.error.errorno != null) {
                    setError(legoResIdl.error.errorno.intValue());
                }
                setErrorString(legoResIdl.error.usermsg);
            }
            this.resultData = legoResIdl.data;
        }
    }
}
