package com.baidu.tieba.more;

import android.view.View;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class ai implements com.baidu.adp.widget.BdSwitchView.c {
    final /* synthetic */ SignRemindActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(SignRemindActivity signRemindActivity) {
        this.a = signRemindActivity;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, com.baidu.adp.widget.BdSwitchView.d dVar) {
        if (dVar == com.baidu.adp.widget.BdSwitchView.d.ON) {
            TiebaApplication.d().p(true);
        } else {
            TiebaApplication.d().p(false);
        }
        this.a.d();
    }
}
