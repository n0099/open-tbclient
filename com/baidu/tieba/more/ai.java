package com.baidu.tieba.more;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class ai implements com.baidu.adp.widget.BdSwitchView.c {
    final /* synthetic */ SignRemindActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(SignRemindActivity signRemindActivity) {
        this.a = signRemindActivity;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            TiebaApplication.f().p(true);
        } else {
            TiebaApplication.f().p(false);
        }
        this.a.d();
    }
}
