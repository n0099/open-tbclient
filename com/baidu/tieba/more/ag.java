package com.baidu.tieba.more;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
class ag implements com.baidu.adp.widget.BdSwitchView.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MsgRemindActivity f1402a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(MsgRemindActivity msgRemindActivity) {
        this.f1402a = msgRemindActivity;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            TiebaApplication.f().m(true);
        } else {
            TiebaApplication.f().m(false);
        }
        DatabaseService.w();
    }
}
