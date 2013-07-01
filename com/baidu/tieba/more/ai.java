package com.baidu.tieba.more;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class ai implements com.baidu.adp.widget.BdSwitchView.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SignRemindActivity f1087a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(SignRemindActivity signRemindActivity) {
        this.f1087a = signRemindActivity;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            TiebaApplication.f().p(true);
        } else {
            TiebaApplication.f().p(false);
        }
        this.f1087a.d();
    }
}
