package com.baidu.tieba.setting.usermutelist;

import com.baidu.tieba.i;
import com.baidu.tieba.setting.usermutelist.h;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
/* loaded from: classes.dex */
class d implements h.b {
    final /* synthetic */ UserMuteListActivity cHG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(UserMuteListActivity userMuteListActivity) {
        this.cHG = userMuteListActivity;
    }

    @Override // com.baidu.tieba.setting.usermutelist.h.b
    public void f(long j, String str) {
        UserMuteAddAndDelModel userMuteAddAndDelModel;
        if (com.baidu.adp.lib.util.i.iL()) {
            userMuteAddAndDelModel = this.cHG.cbJ;
            userMuteAddAndDelModel.a(true, new StringBuilder(String.valueOf(j)).toString(), str, null, null, UserMuteAddAndDelModel.From.Setting);
            return;
        }
        this.cHG.showToast(i.h.neterror);
    }
}
