package com.baidu.tieba.setting.more;

import android.app.TimePickerDialog;
import android.widget.TimePicker;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class ad implements TimePickerDialog.OnTimeSetListener {
    final /* synthetic */ MsgRemindActivity cNU;
    private final /* synthetic */ int val$id;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(MsgRemindActivity msgRemindActivity, int i) {
        this.cNU = msgRemindActivity;
        this.val$id = i;
    }

    @Override // android.app.TimePickerDialog.OnTimeSetListener
    public void onTimeSet(TimePicker timePicker, int i, int i2) {
        ae aeVar;
        ae aeVar2;
        if (this.val$id == i.f.sign_remind) {
            com.baidu.tbadk.coreExtra.messageCenter.c.xe().setSignAlertTime(i, i2);
            aeVar2 = this.cNU.cNS;
            aeVar2.ass();
        } else if (this.val$id == i.f.no_disturb_end_time || this.val$id == i.f.no_disturb_start_time) {
            String str = String.valueOf(String.valueOf(i < 10 ? "0" : "") + i) + ":" + (String.valueOf(i2 < 10 ? "0" : "") + i2);
            if (this.val$id == i.f.no_disturb_start_time) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xe().dY(str);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.xe().dZ(str);
            }
            aeVar = this.cNU.cNS;
            aeVar.ast();
        }
    }
}
