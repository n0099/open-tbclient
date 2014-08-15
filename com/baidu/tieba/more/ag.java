package com.baidu.tieba.more;

import android.app.TimePickerDialog;
import android.widget.TimePicker;
/* loaded from: classes.dex */
class ag implements TimePickerDialog.OnTimeSetListener {
    final /* synthetic */ MsgRemindActivity a;
    private final /* synthetic */ int b;
    private final /* synthetic */ com.baidu.tieba.ai c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(MsgRemindActivity msgRemindActivity, int i, com.baidu.tieba.ai aiVar) {
        this.a = msgRemindActivity;
        this.b = i;
        this.c = aiVar;
    }

    @Override // android.app.TimePickerDialog.OnTimeSetListener
    public void onTimeSet(TimePicker timePicker, int i, int i2) {
        ah ahVar;
        ah ahVar2;
        if (this.b == com.baidu.tieba.u.sign_remind) {
            this.c.a(i, i2);
            ahVar2 = this.a.a;
            ahVar2.b();
        } else if (this.b == com.baidu.tieba.u.no_disturb_end_time || this.b == com.baidu.tieba.u.no_disturb_start_time) {
            String str = String.valueOf(String.valueOf(i < 10 ? "0" : "") + i) + ":" + (String.valueOf(i2 < 10 ? "0" : "") + i2);
            if (this.b == com.baidu.tieba.u.no_disturb_start_time) {
                this.c.g(str);
            } else {
                this.c.h(str);
            }
            ahVar = this.a.a;
            ahVar.c();
        }
    }
}
