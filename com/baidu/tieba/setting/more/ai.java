package com.baidu.tieba.setting.more;

import android.app.TimePickerDialog;
import android.widget.TimePicker;
import com.baidu.tbadk.game.GameInfoData;
/* loaded from: classes.dex */
class ai implements TimePickerDialog.OnTimeSetListener {
    final /* synthetic */ MsgRemindActivity cfT;
    private final /* synthetic */ int val$id;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(MsgRemindActivity msgRemindActivity, int i) {
        this.cfT = msgRemindActivity;
        this.val$id = i;
    }

    @Override // android.app.TimePickerDialog.OnTimeSetListener
    public void onTimeSet(TimePicker timePicker, int i, int i2) {
        ar arVar;
        ar arVar2;
        if (this.val$id == com.baidu.tieba.q.sign_remind) {
            com.baidu.tbadk.coreExtra.messageCenter.c.wg().setSignAlertTime(i, i2);
            arVar2 = this.cfT.cfQ;
            arVar2.ajp();
        } else if (this.val$id == com.baidu.tieba.q.no_disturb_end_time || this.val$id == com.baidu.tieba.q.no_disturb_start_time) {
            String str = String.valueOf(String.valueOf(i < 10 ? GameInfoData.NOT_FROM_DETAIL : "") + i) + ":" + (String.valueOf(i2 < 10 ? GameInfoData.NOT_FROM_DETAIL : "") + i2);
            if (this.val$id == com.baidu.tieba.q.no_disturb_start_time) {
                com.baidu.tbadk.coreExtra.messageCenter.c.wg().dL(str);
            } else {
                com.baidu.tbadk.coreExtra.messageCenter.c.wg().dM(str);
            }
            arVar = this.cfT.cfQ;
            arVar.ajq();
        }
    }
}
