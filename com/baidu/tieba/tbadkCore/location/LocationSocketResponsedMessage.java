package com.baidu.tieba.tbadkCore.location;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.squareup.wire.Wire;
import tbclient.GetPoisByLocation.GetPoisByLocationResIdl;
/* loaded from: classes2.dex */
public class LocationSocketResponsedMessage extends SocketResponsedMessage {
    private LocationData mLocationData;

    public LocationSocketResponsedMessage() {
        super(CmdConfigSocket.CMD_GET_LOCATION);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetPoisByLocationResIdl getPoisByLocationResIdl = (GetPoisByLocationResIdl) new Wire(new Class[0]).parseFrom(bArr, GetPoisByLocationResIdl.class);
        setError(getPoisByLocationResIdl.error.errorno.intValue());
        setErrorString(getPoisByLocationResIdl.error.usermsg);
        if (getError() == 0) {
            this.mLocationData = new LocationData();
            this.mLocationData.parserProtoBuf(getPoisByLocationResIdl.data);
            BdLog.detailException(null);
        }
    }

    public LocationData getLocationData() {
        return this.mLocationData;
    }

    public void setLocationData(LocationData locationData) {
        this.mLocationData = locationData;
    }
}
