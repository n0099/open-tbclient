package com.baidu.tieba.more;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
class af implements com.baidu.adp.widget.BdSwitchView.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MsgRemindActivity f1436a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(MsgRemindActivity msgRemindActivity) {
        this.f1436a = msgRemindActivity;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            TiebaApplication.g().k(true);
        } else {
            TiebaApplication.g().k(false);
        }
        DatabaseService.u();
    }
}
