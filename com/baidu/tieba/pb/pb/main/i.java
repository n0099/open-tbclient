package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
import com.baidu.tieba.usermute.data.MuteUser;
import com.baidu.tieba.usermute.response.UserMuteAddResponseMessage;
/* loaded from: classes.dex */
class i implements UserMuteAddAndDelModel.a {
    final /* synthetic */ PbActivity cFS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(PbActivity pbActivity) {
        this.cFS = pbActivity;
    }

    @Override // com.baidu.tieba.usermute.UserMuteAddAndDelModel.a
    public void a(UserMuteAddResponseMessage userMuteAddResponseMessage) {
        cf cfVar;
        String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
        cfVar = this.cFS.cFl;
        com.baidu.tieba.pb.a.c pbData = cfVar.getPbData();
        if (pbData != null) {
            MuteUser muteUser = new MuteUser();
            muteUser.setUserId(str);
            pbData.akN().add(muteUser);
        }
    }
}
