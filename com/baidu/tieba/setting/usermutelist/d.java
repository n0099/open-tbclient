package com.baidu.tieba.setting.usermutelist;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.i;
import com.baidu.tieba.setting.usermutelist.h;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
/* loaded from: classes.dex */
class d implements h.b {
    final /* synthetic */ UserMuteListActivity cOH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(UserMuteListActivity userMuteListActivity) {
        this.cOH = userMuteListActivity;
    }

    @Override // com.baidu.tieba.setting.usermutelist.h.b
    public void g(long j, String str) {
        UserMuteAddAndDelModel userMuteAddAndDelModel;
        if (!com.baidu.adp.lib.util.i.iM()) {
            this.cOH.showToast(i.h.neterror);
            return;
        }
        TiebaStatic.log("c10047");
        userMuteAddAndDelModel = this.cOH.chY;
        userMuteAddAndDelModel.a(true, new StringBuilder(String.valueOf(j)).toString(), str, null, null, UserMuteAddAndDelModel.From.Setting);
    }
}
