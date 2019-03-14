package com.baidu.tieba.myCollection.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import java.util.Collections;
import java.util.List;
import tbclient.GetStoreRemindTime.GetStoreRemindTimeResIdl;
/* loaded from: classes6.dex */
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
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetStoreRemindTimeResIdl getStoreRemindTimeResIdl = (GetStoreRemindTimeResIdl) new Wire(new Class[0]).parseFrom(bArr, GetStoreRemindTimeResIdl.class);
        if (getStoreRemindTimeResIdl.error != null) {
            setError(getStoreRemindTimeResIdl.error.errorno.intValue());
            setErrorString(getStoreRemindTimeResIdl.error.usermsg);
        }
        if (getError() == 0 && getStoreRemindTimeResIdl.data != null) {
            this.timeList = getStoreRemindTimeResIdl.data.remind_time;
        }
    }
}
