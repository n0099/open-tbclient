package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
import com.baidu.tieba.usermute.data.MuteUser;
import com.baidu.tieba.usermute.response.UserMuteAddResponseMessage;
/* loaded from: classes.dex */
class g implements UserMuteAddAndDelModel.a {
    final /* synthetic */ PbActivity cjN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PbActivity pbActivity) {
        this.cjN = pbActivity;
    }

    @Override // com.baidu.tieba.usermute.UserMuteAddAndDelModel.a
    public void a(UserMuteAddResponseMessage userMuteAddResponseMessage) {
        ca caVar;
        String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
        caVar = this.cjN.cjj;
        com.baidu.tieba.pb.a.c pbData = caVar.getPbData();
        if (pbData != null) {
            MuteUser muteUser = new MuteUser();
            muteUser.setUserId(str);
            pbData.afn().add(muteUser);
        }
    }
}
