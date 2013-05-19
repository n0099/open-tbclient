package com.baidu.tieba.more;

import android.view.View;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class af implements com.baidu.adp.widget.BdSwitchView.c {
    final /* synthetic */ MsgRemindActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(MsgRemindActivity msgRemindActivity) {
        this.a = msgRemindActivity;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, com.baidu.adp.widget.BdSwitchView.d dVar) {
        if (dVar == com.baidu.adp.widget.BdSwitchView.d.ON) {
            TiebaApplication.d().k(true);
        } else {
            TiebaApplication.d().k(false);
        }
        com.baidu.tieba.d.k.t();
    }
}
