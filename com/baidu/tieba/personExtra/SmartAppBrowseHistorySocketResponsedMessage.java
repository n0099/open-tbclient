package com.baidu.tieba.personExtra;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import d.b.i0.h2.a;
import tbclient.Error;
import tbclient.HistorySwan.HistorySwanResIdl;
/* loaded from: classes3.dex */
public class SmartAppBrowseHistorySocketResponsedMessage extends SocketResponsedMessage {
    public a mData;

    public SmartAppBrowseHistorySocketResponsedMessage() {
        super(309638);
    }

    public a getData() {
        return this.mData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        HistorySwanResIdl historySwanResIdl = (HistorySwanResIdl) new Wire(new Class[0]).parseFrom(bArr, HistorySwanResIdl.class);
        if (historySwanResIdl == null) {
            return;
        }
        Error error = historySwanResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(historySwanResIdl.error.usermsg);
        }
        if (historySwanResIdl.data != null) {
            a aVar = new a();
            this.mData = aVar;
            aVar.b(historySwanResIdl.data);
        }
    }
}
