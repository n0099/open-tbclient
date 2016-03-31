package com.baidu.tieba.setting.more;

import android.app.TimePickerDialog;
import android.widget.TimePicker;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class ai implements TimePickerDialog.OnTimeSetListener {
    final /* synthetic */ MsgRemindActivity edA;
    private final /* synthetic */ int val$id;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(MsgRemindActivity msgRemindActivity, int i) {
        this.edA = msgRemindActivity;
        this.val$id = i;
    }

    @Override // android.app.TimePickerDialog.OnTimeSetListener
    public void onTimeSet(TimePicker timePicker, int i, int i2) {
        aj ajVar;
        aj ajVar2;
        if (this.val$id == t.g.sign_remind) {
            com.baidu.tbadk.coreExtra.messageCenter.c.zM().setSignAlertTime(i, i2);
            ajVar2 = this.edA.edy;
            ajVar2.aOB();
        } else if (this.val$id == t.g.no_disturb_end_time || this.val$id == t.g.no_disturb_start_time) {
            String str = String.valueOf(String.valueOf(i < 10 ? "0" : "") + i) + ":" + (String.valueOf(i2 < 10 ? "0" : "") + i2);
            if (this.val$id == t.g.no_disturb_start_time) {
                com.baidu.tbadk.coreExtra.messageCenter.c.zM().ep(str);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.zM().eq(str);
            }
            ajVar = this.edA.edy;
            ajVar.aOC();
        }
    }
}
