package com.baidu.tieba.setting.more;

import android.app.TimePickerDialog;
import android.widget.TimePicker;
import com.baidu.tbadk.game.GameInfoData;
/* loaded from: classes.dex */
class ai implements TimePickerDialog.OnTimeSetListener {
    final /* synthetic */ MsgRemindActivity cbb;
    private final /* synthetic */ int val$id;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(MsgRemindActivity msgRemindActivity, int i) {
        this.cbb = msgRemindActivity;
        this.val$id = i;
    }

    @Override // android.app.TimePickerDialog.OnTimeSetListener
    public void onTimeSet(TimePicker timePicker, int i, int i2) {
        if (this.val$id == com.baidu.tieba.v.sign_remind) {
            com.baidu.tbadk.coreExtra.messageCenter.c.vq().setSignAlertTime(i, i2);
            this.cbb.caY.ahi();
        } else if (this.val$id == com.baidu.tieba.v.no_disturb_end_time || this.val$id == com.baidu.tieba.v.no_disturb_start_time) {
            String str = String.valueOf(String.valueOf(i < 10 ? GameInfoData.NOT_FROM_DETAIL : "") + i) + ":" + (String.valueOf(i2 < 10 ? GameInfoData.NOT_FROM_DETAIL : "") + i2);
            if (this.val$id == com.baidu.tieba.v.no_disturb_start_time) {
                com.baidu.tbadk.coreExtra.messageCenter.c.vq().dr(str);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.vq().ds(str);
            }
            this.cbb.caY.ahj();
        }
    }
}
