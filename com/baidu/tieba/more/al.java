package com.baidu.tieba.more;

import android.app.TimePickerDialog;
import android.widget.TimePicker;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class al implements TimePickerDialog.OnTimeSetListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SignRemindActivity f1405a;
    private final /* synthetic */ TiebaApplication b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(SignRemindActivity signRemindActivity, TiebaApplication tiebaApplication) {
        this.f1405a = signRemindActivity;
        this.b = tiebaApplication;
    }

    @Override // android.app.TimePickerDialog.OnTimeSetListener
    public void onTimeSet(TimePicker timePicker, int i, int i2) {
        this.b.a(i, i2);
        this.f1405a.d();
    }
}
