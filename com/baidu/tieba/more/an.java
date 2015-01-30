package com.baidu.tieba.more;

import android.app.TimePickerDialog;
import android.widget.TimePicker;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class an implements TimePickerDialog.OnTimeSetListener {
    final /* synthetic */ MsgRemindActivity bws;
    private final /* synthetic */ TbadkCoreApplication bww;
    private final /* synthetic */ int val$id;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(MsgRemindActivity msgRemindActivity, int i, TbadkCoreApplication tbadkCoreApplication) {
        this.bws = msgRemindActivity;
        this.val$id = i;
        this.bww = tbadkCoreApplication;
    }

    @Override // android.app.TimePickerDialog.OnTimeSetListener
    public void onTimeSet(TimePicker timePicker, int i, int i2) {
        aw awVar;
        aw awVar2;
        if (this.val$id == com.baidu.tieba.w.sign_remind) {
            this.bww.setSignAlertTime(i, i2);
            awVar2 = this.bws.bwp;
            awVar2.VW();
        } else if (this.val$id == com.baidu.tieba.w.no_disturb_end_time || this.val$id == com.baidu.tieba.w.no_disturb_start_time) {
            String str = String.valueOf(String.valueOf(i < 10 ? "0" : "") + i) + ":" + (String.valueOf(i2 < 10 ? "0" : "") + i2);
            if (this.val$id == com.baidu.tieba.w.no_disturb_start_time) {
                this.bww.setNoDisturbStartTime(str);
            } else {
                this.bww.setNoDisturbEndTime(str);
            }
            awVar = this.bws.bwp;
            awVar.VX();
        }
    }
}
