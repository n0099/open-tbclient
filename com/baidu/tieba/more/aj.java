package com.baidu.tieba.more;

import android.app.TimePickerDialog;
import android.widget.TimePicker;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class aj implements TimePickerDialog.OnTimeSetListener {
    final /* synthetic */ MsgRemindActivity buU;
    private final /* synthetic */ TbadkCoreApplication buV;
    private final /* synthetic */ int val$id;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(MsgRemindActivity msgRemindActivity, int i, TbadkCoreApplication tbadkCoreApplication) {
        this.buU = msgRemindActivity;
        this.val$id = i;
        this.buV = tbadkCoreApplication;
    }

    @Override // android.app.TimePickerDialog.OnTimeSetListener
    public void onTimeSet(TimePicker timePicker, int i, int i2) {
        ak akVar;
        ak akVar2;
        if (this.val$id == com.baidu.tieba.w.sign_remind) {
            this.buV.setSignAlertTime(i, i2);
            akVar2 = this.buU.buT;
            akVar2.Vw();
        } else if (this.val$id == com.baidu.tieba.w.no_disturb_end_time || this.val$id == com.baidu.tieba.w.no_disturb_start_time) {
            String str = String.valueOf(String.valueOf(i < 10 ? "0" : "") + i) + ":" + (String.valueOf(i2 < 10 ? "0" : "") + i2);
            if (this.val$id == com.baidu.tieba.w.no_disturb_start_time) {
                this.buV.setNoDisturbStartTime(str);
            } else {
                this.buV.setNoDisturbEndTime(str);
            }
            akVar = this.buU.buT;
            akVar.Vx();
        }
    }
}
