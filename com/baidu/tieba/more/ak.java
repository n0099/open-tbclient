package com.baidu.tieba.more;

import android.app.TimePickerDialog;
import android.widget.TimePicker;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class ak implements TimePickerDialog.OnTimeSetListener {
    final /* synthetic */ SignRemindActivity a;
    private final /* synthetic */ TiebaApplication b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(SignRemindActivity signRemindActivity, TiebaApplication tiebaApplication) {
        this.a = signRemindActivity;
        this.b = tiebaApplication;
    }

    @Override // android.app.TimePickerDialog.OnTimeSetListener
    public void onTimeSet(TimePicker timePicker, int i, int i2) {
        this.b.a(i, i2);
        this.a.d();
    }
}
