package com.baidu.tieba.tbadkCore.location;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.squareup.wire.Wire;
import tbclient.GetPoisByLocation.GetPoisByLocationResIdl;
/* loaded from: classes.dex */
public class LocationSocketResponsedMessage extends SocketResponsedMessage {
    private a mLocationData;

    public LocationSocketResponsedMessage() {
        super(303017);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) {
        GetPoisByLocationResIdl getPoisByLocationResIdl = (GetPoisByLocationResIdl) new Wire(new Class[0]).parseFrom(bArr, GetPoisByLocationResIdl.class);
        setError(getPoisByLocationResIdl.error.errorno.intValue());
        setErrorString(getPoisByLocationResIdl.error.usermsg);
        if (getError() == 0) {
            this.mLocationData = new a();
            this.mLocationData.a(getPoisByLocationResIdl.data);
            BdLog.detailException(null);
        }
    }

    public a getLocationData() {
        return this.mLocationData;
    }
}
