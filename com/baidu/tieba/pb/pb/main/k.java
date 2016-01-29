package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
import com.baidu.tieba.usermute.data.MuteUser;
import com.baidu.tieba.usermute.response.UserMuteAddResponseMessage;
/* loaded from: classes.dex */
class k implements UserMuteAddAndDelModel.a {
    final /* synthetic */ PbActivity cNq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(PbActivity pbActivity) {
        this.cNq = pbActivity;
    }

    @Override // com.baidu.tieba.usermute.UserMuteAddAndDelModel.a
    public void a(UserMuteAddResponseMessage userMuteAddResponseMessage) {
        cm cmVar;
        String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
        cmVar = this.cNq.cMF;
        com.baidu.tieba.pb.a.c pbData = cmVar.getPbData();
        if (pbData != null) {
            MuteUser muteUser = new MuteUser();
            muteUser.setUserId(str);
            pbData.aoL().add(muteUser);
        }
    }
}
