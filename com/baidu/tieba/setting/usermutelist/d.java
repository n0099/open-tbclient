package com.baidu.tieba.setting.usermutelist;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.setting.usermutelist.h;
import com.baidu.tieba.t;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
/* loaded from: classes.dex */
class d implements h.b {
    final /* synthetic */ UserMuteListActivity eeP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(UserMuteListActivity userMuteListActivity) {
        this.eeP = userMuteListActivity;
    }

    @Override // com.baidu.tieba.setting.usermutelist.h.b
    public void s(long j, String str) {
        UserMuteAddAndDelModel userMuteAddAndDelModel;
        if (!com.baidu.adp.lib.util.i.jf()) {
            this.eeP.showToast(t.j.neterror);
            return;
        }
        TiebaStatic.log("c10047");
        userMuteAddAndDelModel = this.eeP.dgD;
        userMuteAddAndDelModel.a(true, new StringBuilder(String.valueOf(j)).toString(), str, null, null, UserMuteAddAndDelModel.From.Setting);
    }
}
