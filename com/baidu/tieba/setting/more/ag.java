package com.baidu.tieba.setting.more;

import android.app.TimePickerDialog;
import android.widget.TimePicker;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class ag implements TimePickerDialog.OnTimeSetListener {
    final /* synthetic */ MsgRemindActivity duZ;
    private final /* synthetic */ int val$id;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(MsgRemindActivity msgRemindActivity, int i) {
        this.duZ = msgRemindActivity;
        this.val$id = i;
    }

    @Override // android.app.TimePickerDialog.OnTimeSetListener
    public void onTimeSet(TimePicker timePicker, int i, int i2) {
        ah ahVar;
        ah ahVar2;
        if (this.val$id == n.g.sign_remind) {
            com.baidu.tbadk.coreExtra.messageCenter.c.xS().setSignAlertTime(i, i2);
            ahVar2 = this.duZ.duX;
            ahVar2.aAG();
        } else if (this.val$id == n.g.no_disturb_end_time || this.val$id == n.g.no_disturb_start_time) {
            String str = String.valueOf(String.valueOf(i < 10 ? "0" : "") + i) + ":" + (String.valueOf(i2 < 10 ? "0" : "") + i2);
            if (this.val$id == n.g.no_disturb_start_time) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xS().ek(str);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.xS().el(str);
            }
            ahVar = this.duZ.duX;
            ahVar.aAH();
        }
    }
}
