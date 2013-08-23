package com.baidu.tieba.more;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class aj implements com.baidu.adp.widget.BdSwitchView.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SignRemindActivity f1440a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(SignRemindActivity signRemindActivity) {
        this.f1440a = signRemindActivity;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            TiebaApplication.g().p(true);
        } else {
            TiebaApplication.g().p(false);
        }
        this.f1440a.d();
    }
}
