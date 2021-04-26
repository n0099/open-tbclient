package com.baidu.tieba.lego.model;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.Lego.DataRes;
import tbclient.Lego.LegoResIdl;
/* loaded from: classes4.dex */
public class LegoHttpResponse extends HttpResponsedMessage {
    public DataRes resultData;

    public LegoHttpResponse(int i2) {
        super(CmdConfigHttp.CMD_ENTERTAINMENT);
    }

    public DataRes getResultData() {
        return this.resultData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        LegoResIdl legoResIdl = (LegoResIdl) new Wire(new Class[0]).parseFrom(bArr, LegoResIdl.class);
        if (legoResIdl == null) {
            return;
        }
        Error error = legoResIdl.error;
        if (error != null) {
            Integer num = error.errorno;
            if (num != null) {
                setError(num.intValue());
            }
            setErrorString(legoResIdl.error.usermsg);
        }
        this.resultData = legoResIdl.data;
    }
}
