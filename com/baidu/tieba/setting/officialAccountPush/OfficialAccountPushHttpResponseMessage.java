package com.baidu.tieba.setting.officialAccountPush;

import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import tbclient.Error;
import tbclient.GetOfficialSwitch.DataRes;
import tbclient.GetOfficialSwitch.GetOfficialSwitchResIdl;
/* loaded from: classes5.dex */
public class OfficialAccountPushHttpResponseMessage extends TbHttpResponsedMessage {
    public ArrayList<OfficialAccountPushInfo> official_list;

    public OfficialAccountPushHttpResponseMessage(int i2) {
        super(i2);
    }

    public ArrayList<OfficialAccountPushInfo> getList() {
        return this.official_list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        String str;
        Integer num;
        if (bArr == null) {
            return;
        }
        GetOfficialSwitchResIdl getOfficialSwitchResIdl = (GetOfficialSwitchResIdl) new Wire(new Class[0]).parseFrom(bArr, GetOfficialSwitchResIdl.class);
        if (getOfficialSwitchResIdl == null) {
            return;
        }
        Error error = getOfficialSwitchResIdl.error;
        if (error != null && (num = error.errorno) != null) {
            setError(num.intValue());
        }
        Error error2 = getOfficialSwitchResIdl.error;
        if (error2 != null && (str = error2.usermsg) != null && str.length() > 0) {
            setErrorString(getOfficialSwitchResIdl.error.usermsg);
        }
        DataRes dataRes = getOfficialSwitchResIdl.data;
        if (dataRes == null || dataRes.official_list == null) {
            return;
        }
        this.official_list = new ArrayList<>();
        for (int i3 = 0; i3 < getOfficialSwitchResIdl.data.official_list.size(); i3++) {
            OfficialAccountPushInfo officialAccountPushInfo = new OfficialAccountPushInfo();
            officialAccountPushInfo.a(getOfficialSwitchResIdl.data.official_list.get(i3));
            this.official_list.add(officialAccountPushInfo);
        }
    }
}
