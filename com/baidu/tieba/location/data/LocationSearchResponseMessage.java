package com.baidu.tieba.location.data;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.squareup.wire.Wire;
import d.b.i0.n1.c.a;
import tbclient.GetSuggestionByAddrName.GetSuggestionByAddrNameResIdl;
/* loaded from: classes3.dex */
public class LocationSearchResponseMessage extends SocketResponsedMessage {
    public a mLocationData;

    public LocationSearchResponseMessage() {
        super(303018);
    }

    public a getLocationData() {
        return this.mLocationData;
    }

    public void setLocationData(a aVar) {
        this.mLocationData = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetSuggestionByAddrNameResIdl getSuggestionByAddrNameResIdl = (GetSuggestionByAddrNameResIdl) new Wire(new Class[0]).parseFrom(bArr, GetSuggestionByAddrNameResIdl.class);
        setError(getSuggestionByAddrNameResIdl.error.errorno.intValue());
        setErrorString(getSuggestionByAddrNameResIdl.error.usermsg);
        if (getError() != 0) {
            return;
        }
        a aVar = new a();
        this.mLocationData = aVar;
        aVar.b(getSuggestionByAddrNameResIdl.data);
        BdLog.detailException(null);
    }
}
