package com.baidu.tieba.pb.chosen.net.zan;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.ExcZan.ExcZanResIdl;
/* loaded from: classes3.dex */
public class ChosenPbZanSocketResponse extends SocketResponsedMessage {
    public ChosenPbZanSocketResponse() {
        super(309095);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        ExcZanResIdl excZanResIdl = (ExcZanResIdl) new Wire(new Class[0]).parseFrom(bArr, ExcZanResIdl.class);
        if (excZanResIdl != null && excZanResIdl.error != null) {
            setError(excZanResIdl.error.errorno.intValue());
            setErrorString(excZanResIdl.error.usermsg);
        }
    }
}
