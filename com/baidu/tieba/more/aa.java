package com.baidu.tieba.more;

import android.app.TimePickerDialog;
import android.widget.TimePicker;
/* loaded from: classes.dex */
final class aa implements TimePickerDialog.OnTimeSetListener {
    final /* synthetic */ MsgRemindActivity a;
    private final /* synthetic */ int b;
    private final /* synthetic */ com.baidu.tieba.p c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(MsgRemindActivity msgRemindActivity, int i, com.baidu.tieba.p pVar) {
        this.a = msgRemindActivity;
        this.b = i;
        this.c = pVar;
    }

    @Override // android.app.TimePickerDialog.OnTimeSetListener
    public final void onTimeSet(TimePicker timePicker, int i, int i2) {
        ab abVar;
        ab abVar2;
        if (this.b == com.baidu.tieba.a.h.sign_remind) {
            this.c.a(i, i2);
            abVar2 = this.a.a;
            abVar2.d();
        } else if (this.b == com.baidu.tieba.a.h.no_disturb_end_time || this.b == com.baidu.tieba.a.h.no_disturb_start_time) {
            String str = String.valueOf(String.valueOf(i < 10 ? "0" : "") + i) + ":" + (String.valueOf(i2 < 10 ? "0" : "") + i2);
            if (this.b == com.baidu.tieba.a.h.no_disturb_start_time) {
                com.baidu.tieba.p pVar = this.c;
                com.baidu.tieba.p.h(str);
            } else {
                com.baidu.tieba.p pVar2 = this.c;
                com.baidu.tieba.p.i(str);
            }
            abVar = this.a.a;
            abVar.e();
        }
    }
}
