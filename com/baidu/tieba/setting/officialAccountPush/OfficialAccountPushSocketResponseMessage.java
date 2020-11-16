package com.baidu.tieba.setting.officialAccountPush;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import tbclient.GetOfficialSwitch.GetOfficialSwitchResIdl;
/* loaded from: classes25.dex */
public class OfficialAccountPushSocketResponseMessage extends SocketResponsedMessage {
    public ArrayList<OfficialAccountPushInfo> official_list;

    public OfficialAccountPushSocketResponseMessage() {
        super(309620);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetOfficialSwitchResIdl getOfficialSwitchResIdl;
        int i2 = 0;
        if (bArr != null && (getOfficialSwitchResIdl = (GetOfficialSwitchResIdl) new Wire(new Class[0]).parseFrom(bArr, GetOfficialSwitchResIdl.class)) != null) {
            if (getOfficialSwitchResIdl.error != null && getOfficialSwitchResIdl.error.errorno != null) {
                setError(getOfficialSwitchResIdl.error.errorno.intValue());
            }
            if (getOfficialSwitchResIdl.error != null && getOfficialSwitchResIdl.error.usermsg != null && getOfficialSwitchResIdl.error.usermsg.length() > 0) {
                setErrorString(getOfficialSwitchResIdl.error.usermsg);
            }
            if (getOfficialSwitchResIdl.data != null && getOfficialSwitchResIdl.data.official_list != null) {
                this.official_list = new ArrayList<>();
                while (true) {
                    int i3 = i2;
                    if (i3 < getOfficialSwitchResIdl.data.official_list.size()) {
                        OfficialAccountPushInfo officialAccountPushInfo = new OfficialAccountPushInfo();
                        officialAccountPushInfo.a(getOfficialSwitchResIdl.data.official_list.get(i3));
                        this.official_list.add(officialAccountPushInfo);
                        i2 = i3 + 1;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public ArrayList<OfficialAccountPushInfo> getList() {
        return this.official_list;
    }
}
