package com.baidu.tieba.pb.chosen.net.zan;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.ExcZan.ExcZanResIdl;
/* loaded from: classes3.dex */
public class ChosenPbZanSocketResponse extends SocketResponsedMessage {
    public ChosenPbZanSocketResponse() {
        super(309095);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        Error error;
        ExcZanResIdl excZanResIdl = (ExcZanResIdl) new Wire(new Class[0]).parseFrom(bArr, ExcZanResIdl.class);
        if (excZanResIdl == null || (error = excZanResIdl.error) == null) {
            return;
        }
        setError(error.errorno.intValue());
        setErrorString(excZanResIdl.error.usermsg);
    }
}
