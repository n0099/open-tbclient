package com.baidu.tieba.lego.model;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.squareup.wire.Wire;
import tbclient.Lego.DataRes;
import tbclient.Lego.LegoResIdl;
/* loaded from: classes9.dex */
public class LegoSocketResponse extends SocketResponsedMessage {
    private DataRes resultData;

    public LegoSocketResponse() {
        super(CmdConfigSocket.CMD_ENTERTAINMENT);
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
