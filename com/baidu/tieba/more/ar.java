package com.baidu.tieba.more;

import android.app.TimePickerDialog;
import android.widget.TimePicker;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class ar implements TimePickerDialog.OnTimeSetListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TiebaApplication f1985a;
    final /* synthetic */ SignRemindActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(SignRemindActivity signRemindActivity, TiebaApplication tiebaApplication) {
        this.b = signRemindActivity;
        this.f1985a = tiebaApplication;
    }

    @Override // android.app.TimePickerDialog.OnTimeSetListener
    public void onTimeSet(TimePicker timePicker, int i, int i2) {
        this.f1985a.a(i, i2);
        this.b.c();
    }
}
