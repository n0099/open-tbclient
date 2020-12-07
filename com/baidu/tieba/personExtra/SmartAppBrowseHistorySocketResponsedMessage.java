package com.baidu.tieba.personExtra;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.HistorySwan.HistorySwanResIdl;
/* loaded from: classes24.dex */
public class SmartAppBrowseHistorySocketResponsedMessage extends SocketResponsedMessage {
    private a mData;

    public SmartAppBrowseHistorySocketResponsedMessage() {
        super(309638);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        HistorySwanResIdl historySwanResIdl = (HistorySwanResIdl) new Wire(new Class[0]).parseFrom(bArr, HistorySwanResIdl.class);
        if (historySwanResIdl != null) {
            if (historySwanResIdl.error != null) {
                setError(historySwanResIdl.error.errorno.intValue());
                setErrorString(historySwanResIdl.error.usermsg);
            }
            if (historySwanResIdl.data != null) {
                this.mData = new a();
                this.mData.a(historySwanResIdl.data);
            }
        }
    }

    public a getData() {
        return this.mData;
    }
}
