package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
import com.baidu.tieba.usermute.data.MuteUser;
import com.baidu.tieba.usermute.response.UserMuteAddResponseMessage;
/* loaded from: classes.dex */
class y implements UserMuteAddAndDelModel.a {
    final /* synthetic */ PbActivity dht;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(PbActivity pbActivity) {
        this.dht = pbActivity;
    }

    @Override // com.baidu.tieba.usermute.UserMuteAddAndDelModel.a
    public void a(UserMuteAddResponseMessage userMuteAddResponseMessage) {
        df dfVar;
        String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
        dfVar = this.dht.dfV;
        com.baidu.tieba.pb.data.e pbData = dfVar.getPbData();
        if (pbData != null) {
            MuteUser muteUser = new MuteUser();
            muteUser.setUserId(str);
            pbData.avD().add(muteUser);
        }
    }
}
