package com.baidu.tieba.setting.more;

import android.app.TimePickerDialog;
import android.widget.TimePicker;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class af implements TimePickerDialog.OnTimeSetListener {
    final /* synthetic */ MsgRemindActivity dnM;
    private final /* synthetic */ int val$id;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(MsgRemindActivity msgRemindActivity, int i) {
        this.dnM = msgRemindActivity;
        this.val$id = i;
    }

    @Override // android.app.TimePickerDialog.OnTimeSetListener
    public void onTimeSet(TimePicker timePicker, int i, int i2) {
        ag agVar;
        ag agVar2;
        if (this.val$id == n.f.sign_remind) {
            com.baidu.tbadk.coreExtra.messageCenter.c.yg().setSignAlertTime(i, i2);
            agVar2 = this.dnM.dnK;
            agVar2.ayA();
        } else if (this.val$id == n.f.no_disturb_end_time || this.val$id == n.f.no_disturb_start_time) {
            String str = String.valueOf(String.valueOf(i < 10 ? "0" : "") + i) + ":" + (String.valueOf(i2 < 10 ? "0" : "") + i2);
            if (this.val$id == n.f.no_disturb_start_time) {
                com.baidu.tbadk.coreExtra.messageCenter.c.yg().eh(str);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.yg().ei(str);
            }
            agVar = this.dnM.dnK;
            agVar.ayB();
        }
    }
}
