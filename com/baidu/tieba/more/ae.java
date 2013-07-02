package com.baidu.tieba.more;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
class ae implements com.baidu.adp.widget.BdSwitchView.c {
    final /* synthetic */ MsgRemindActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(MsgRemindActivity msgRemindActivity) {
        this.a = msgRemindActivity;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            TiebaApplication.f().k(true);
        } else {
            TiebaApplication.f().k(false);
        }
        DatabaseService.w();
    }
}
