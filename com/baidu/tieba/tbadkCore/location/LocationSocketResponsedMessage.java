package com.baidu.tieba.tbadkCore.location;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.squareup.wire.Wire;
import tbclient.GetPoisByLocation.GetPoisByLocationResIdl;
/* loaded from: classes5.dex */
public class LocationSocketResponsedMessage extends SocketResponsedMessage {
    public LocationData mLocationData;

    public LocationSocketResponsedMessage() {
        super(303017);
    }

    public LocationData getLocationData() {
        return this.mLocationData;
    }

    public void setLocationData(LocationData locationData) {
        this.mLocationData = locationData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        GetPoisByLocationResIdl getPoisByLocationResIdl = (GetPoisByLocationResIdl) new Wire(new Class[0]).parseFrom(bArr, GetPoisByLocationResIdl.class);
        setError(getPoisByLocationResIdl.error.errorno.intValue());
        setErrorString(getPoisByLocationResIdl.error.usermsg);
        if (getError() != 0) {
            return;
        }
        LocationData locationData = new LocationData();
        this.mLocationData = locationData;
        locationData.parserProtoBuf(getPoisByLocationResIdl.data);
        BdLog.detailException(null);
    }
}
