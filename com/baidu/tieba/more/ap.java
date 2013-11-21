package com.baidu.tieba.more;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class ap implements com.baidu.adp.widget.BdSwitchView.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SignRemindActivity f1966a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(SignRemindActivity signRemindActivity) {
        this.f1966a = signRemindActivity;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            TiebaApplication.g().r(true);
        } else {
            TiebaApplication.g().r(false);
        }
        this.f1966a.c();
    }
}
