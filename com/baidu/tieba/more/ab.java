package com.baidu.tieba.more;

import android.app.TimePickerDialog;
import android.widget.TimePicker;
/* loaded from: classes.dex */
class ab implements TimePickerDialog.OnTimeSetListener {
    final /* synthetic */ MsgRemindActivity a;
    private final /* synthetic */ int b;
    private final /* synthetic */ com.baidu.tieba.ai c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(MsgRemindActivity msgRemindActivity, int i, com.baidu.tieba.ai aiVar) {
        this.a = msgRemindActivity;
        this.b = i;
        this.c = aiVar;
    }

    @Override // android.app.TimePickerDialog.OnTimeSetListener
    public void onTimeSet(TimePicker timePicker, int i, int i2) {
        ac acVar;
        ac acVar2;
        if (this.b == com.baidu.tieba.v.sign_remind) {
            this.c.a(i, i2);
            acVar2 = this.a.a;
            acVar2.b();
        } else if (this.b == com.baidu.tieba.v.no_disturb_end_time || this.b == com.baidu.tieba.v.no_disturb_start_time) {
            String str = String.valueOf(String.valueOf(i < 10 ? "0" : "") + i) + ":" + (String.valueOf(i2 < 10 ? "0" : "") + i2);
            if (this.b == com.baidu.tieba.v.no_disturb_start_time) {
                this.c.h(str);
            } else {
                this.c.i(str);
            }
            acVar = this.a.a;
            acVar.c();
        }
    }
}
