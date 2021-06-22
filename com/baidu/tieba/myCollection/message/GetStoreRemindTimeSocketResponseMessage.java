package com.baidu.tieba.myCollection.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import java.util.Collections;
import java.util.List;
import tbclient.Error;
import tbclient.GetStoreRemindTime.DataRes;
import tbclient.GetStoreRemindTime.GetStoreRemindTimeResIdl;
/* loaded from: classes5.dex */
public class GetStoreRemindTimeSocketResponseMessage extends SocketResponsedMessage {
    public List<String> timeList;

    public GetStoreRemindTimeSocketResponseMessage() {
        super(309117);
        this.timeList = Collections.EMPTY_LIST;
    }

    public List<String> getTimeList() {
        return this.timeList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        DataRes dataRes;
        GetStoreRemindTimeResIdl getStoreRemindTimeResIdl = (GetStoreRemindTimeResIdl) new Wire(new Class[0]).parseFrom(bArr, GetStoreRemindTimeResIdl.class);
        Error error = getStoreRemindTimeResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(getStoreRemindTimeResIdl.error.usermsg);
        }
        if (getError() == 0 && (dataRes = getStoreRemindTimeResIdl.data) != null) {
            this.timeList = dataRes.remind_time;
        }
    }
}
