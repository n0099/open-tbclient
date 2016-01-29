package com.baidu.tieba.setting.usermutelist;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.setting.usermutelist.h;
import com.baidu.tieba.t;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
/* loaded from: classes.dex */
class d implements h.b {
    final /* synthetic */ UserMuteListActivity dMp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(UserMuteListActivity userMuteListActivity) {
        this.dMp = userMuteListActivity;
    }

    @Override // com.baidu.tieba.setting.usermutelist.h.b
    public void j(long j, String str) {
        UserMuteAddAndDelModel userMuteAddAndDelModel;
        if (!com.baidu.adp.lib.util.i.iZ()) {
            this.dMp.showToast(t.j.neterror);
            return;
        }
        TiebaStatic.log("c10047");
        userMuteAddAndDelModel = this.dMp.cMI;
        userMuteAddAndDelModel.a(true, new StringBuilder(String.valueOf(j)).toString(), str, null, null, UserMuteAddAndDelModel.From.Setting);
    }
}
