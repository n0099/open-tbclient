package com.baidu.tieba.setting.more;

import android.app.TimePickerDialog;
import android.widget.TimePicker;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class ag implements TimePickerDialog.OnTimeSetListener {
    final /* synthetic */ MsgRemindActivity dLd;
    private final /* synthetic */ int val$id;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(MsgRemindActivity msgRemindActivity, int i) {
        this.dLd = msgRemindActivity;
        this.val$id = i;
    }

    @Override // android.app.TimePickerDialog.OnTimeSetListener
    public void onTimeSet(TimePicker timePicker, int i, int i2) {
        ah ahVar;
        ah ahVar2;
        if (this.val$id == t.g.sign_remind) {
            com.baidu.tbadk.coreExtra.messageCenter.c.zk().setSignAlertTime(i, i2);
            ahVar2 = this.dLd.dLb;
            ahVar2.aHN();
        } else if (this.val$id == t.g.no_disturb_end_time || this.val$id == t.g.no_disturb_start_time) {
            String str = String.valueOf(String.valueOf(i < 10 ? "0" : "") + i) + ":" + (String.valueOf(i2 < 10 ? "0" : "") + i2);
            if (this.val$id == t.g.no_disturb_start_time) {
                com.baidu.tbadk.coreExtra.messageCenter.c.zk().ei(str);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.zk().ej(str);
            }
            ahVar = this.dLd.dLb;
            ahVar.aHO();
        }
    }
}
