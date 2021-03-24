package com.baidu.tieba.setting.officialAccountPush;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import tbclient.Error;
import tbclient.GetOfficialSwitch.DataRes;
import tbclient.GetOfficialSwitch.GetOfficialSwitchResIdl;
/* loaded from: classes5.dex */
public class OfficialAccountPushSocketResponseMessage extends SocketResponsedMessage {
    public ArrayList<OfficialAccountPushInfo> official_list;

    public OfficialAccountPushSocketResponseMessage() {
        super(309620);
    }

    public ArrayList<OfficialAccountPushInfo> getList() {
        return this.official_list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
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
        for (int i2 = 0; i2 < getOfficialSwitchResIdl.data.official_list.size(); i2++) {
            OfficialAccountPushInfo officialAccountPushInfo = new OfficialAccountPushInfo();
            officialAccountPushInfo.a(getOfficialSwitchResIdl.data.official_list.get(i2));
            this.official_list.add(officialAccountPushInfo);
        }
    }
}
