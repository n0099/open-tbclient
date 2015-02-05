package com.baidu.tieba.more;

import android.app.TimePickerDialog;
import android.widget.TimePicker;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class an implements TimePickerDialog.OnTimeSetListener {
    final /* synthetic */ MsgRemindActivity bwr;
    private final /* synthetic */ TbadkCoreApplication bwv;
    private final /* synthetic */ int val$id;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(MsgRemindActivity msgRemindActivity, int i, TbadkCoreApplication tbadkCoreApplication) {
        this.bwr = msgRemindActivity;
        this.val$id = i;
        this.bwv = tbadkCoreApplication;
    }

    @Override // android.app.TimePickerDialog.OnTimeSetListener
    public void onTimeSet(TimePicker timePicker, int i, int i2) {
        aw awVar;
        aw awVar2;
        if (this.val$id == com.baidu.tieba.w.sign_remind) {
            this.bwv.setSignAlertTime(i, i2);
            awVar2 = this.bwr.bwo;
            awVar2.VR();
        } else if (this.val$id == com.baidu.tieba.w.no_disturb_end_time || this.val$id == com.baidu.tieba.w.no_disturb_start_time) {
            String str = String.valueOf(String.valueOf(i < 10 ? "0" : "") + i) + ":" + (String.valueOf(i2 < 10 ? "0" : "") + i2);
            if (this.val$id == com.baidu.tieba.w.no_disturb_start_time) {
                this.bwv.setNoDisturbStartTime(str);
            } else {
                this.bwv.setNoDisturbEndTime(str);
            }
            awVar = this.bwr.bwo;
            awVar.VS();
        }
    }
}
