package com.baidu.tieba.myCollection.message;

import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import java.util.Collections;
import java.util.List;
import tbclient.Error;
import tbclient.GetStoreRemindTime.DataRes;
import tbclient.GetStoreRemindTime.GetStoreRemindTimeResIdl;
/* loaded from: classes4.dex */
public class GetStoreRemindTimeHttpResponseMessage extends TbHttpResponsedMessage {
    public List<String> timeList;

    public GetStoreRemindTimeHttpResponseMessage(int i) {
        super(i);
        this.timeList = Collections.EMPTY_LIST;
    }

    public List<String> getTimeList() {
        return this.timeList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
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
