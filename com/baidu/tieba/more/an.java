package com.baidu.tieba.more;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class an implements com.baidu.adp.widget.BdSwitchView.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SignRemindActivity f1484a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(SignRemindActivity signRemindActivity) {
        this.f1484a = signRemindActivity;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            TiebaApplication.g().q(true);
        } else {
            TiebaApplication.g().q(false);
        }
        this.f1484a.d();
    }
}
