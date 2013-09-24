package com.baidu.tieba.more;

import android.app.TimePickerDialog;
import android.widget.TimePicker;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class ai implements TimePickerDialog.OnTimeSetListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MsgRemindActivity f1480a;
    private final /* synthetic */ int b;
    private final /* synthetic */ TiebaApplication c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(MsgRemindActivity msgRemindActivity, int i, TiebaApplication tiebaApplication) {
        this.f1480a = msgRemindActivity;
        this.b = i;
        this.c = tiebaApplication;
    }

    @Override // android.app.TimePickerDialog.OnTimeSetListener
    public void onTimeSet(TimePicker timePicker, int i, int i2) {
        aj ajVar;
        aj ajVar2;
        if (this.b == R.id.sign_remind) {
            this.c.a(i, i2);
            ajVar2 = this.f1480a.f1468a;
            ajVar2.c();
        } else if (this.b == R.id.no_disturb_end_time || this.b == R.id.no_disturb_start_time) {
            String str = String.valueOf(String.valueOf(i < 10 ? "0" : "") + i) + ":" + (String.valueOf(i2 < 10 ? "0" : "") + i2);
            if (this.b == R.id.no_disturb_start_time) {
                this.c.o(str);
            } else {
                this.c.p(str);
            }
            ajVar = this.f1480a.f1468a;
            ajVar.d();
        }
    }
}
