package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
import com.baidu.tieba.usermute.data.MuteUser;
import com.baidu.tieba.usermute.response.UserMuteAddResponseMessage;
/* loaded from: classes.dex */
class h implements UserMuteAddAndDelModel.a {
    final /* synthetic */ PbActivity cCm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PbActivity pbActivity) {
        this.cCm = pbActivity;
    }

    @Override // com.baidu.tieba.usermute.UserMuteAddAndDelModel.a
    public void a(UserMuteAddResponseMessage userMuteAddResponseMessage) {
        cc ccVar;
        String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
        ccVar = this.cCm.cBG;
        com.baidu.tieba.pb.a.c pbData = ccVar.getPbData();
        if (pbData != null) {
            MuteUser muteUser = new MuteUser();
            muteUser.setUserId(str);
            pbData.ajF().add(muteUser);
        }
    }
}
