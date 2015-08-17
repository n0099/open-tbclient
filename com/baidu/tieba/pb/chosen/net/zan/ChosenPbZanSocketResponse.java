package com.baidu.tieba.pb.chosen.net.zan;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.FineZan.FineZanResIdl;
/* loaded from: classes.dex */
public class ChosenPbZanSocketResponse extends SocketResponsedMessage {
    public ChosenPbZanSocketResponse() {
        super(307005);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) {
        FineZanResIdl fineZanResIdl = (FineZanResIdl) new Wire(new Class[0]).parseFrom(bArr, FineZanResIdl.class);
        if (fineZanResIdl != null && fineZanResIdl.error != null) {
            setError(fineZanResIdl.error.errorno.intValue());
            setErrorString(fineZanResIdl.error.usermsg);
        }
    }
}
