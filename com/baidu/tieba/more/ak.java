package com.baidu.tieba.more;

import android.app.TimePickerDialog;
import android.widget.TimePicker;
/* loaded from: classes.dex */
class ak implements TimePickerDialog.OnTimeSetListener {
    final /* synthetic */ MsgRemindActivity brr;
    private final /* synthetic */ com.baidu.tieba.aj brs;
    private final /* synthetic */ int val$id;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(MsgRemindActivity msgRemindActivity, int i, com.baidu.tieba.aj ajVar) {
        this.brr = msgRemindActivity;
        this.val$id = i;
        this.brs = ajVar;
    }

    @Override // android.app.TimePickerDialog.OnTimeSetListener
    public void onTimeSet(TimePicker timePicker, int i, int i2) {
        al alVar;
        al alVar2;
        if (this.val$id == com.baidu.tieba.v.sign_remind) {
            this.brs.D(i, i2);
            alVar2 = this.brr.brq;
            alVar2.Vg();
        } else if (this.val$id == com.baidu.tieba.v.no_disturb_end_time || this.val$id == com.baidu.tieba.v.no_disturb_start_time) {
            String str = String.valueOf(String.valueOf(i < 10 ? "0" : "") + i) + ":" + (String.valueOf(i2 < 10 ? "0" : "") + i2);
            if (this.val$id == com.baidu.tieba.v.no_disturb_start_time) {
                this.brs.dZ(str);
            } else {
                this.brs.ea(str);
            }
            alVar = this.brr.brq;
            alVar.Vh();
        }
    }
}
