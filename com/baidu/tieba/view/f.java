package com.baidu.tieba.view;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
/* loaded from: classes.dex */
public class f extends TimePickerDialog {

    /* renamed from: a  reason: collision with root package name */
    private int f2687a;
    private int b;
    private boolean c;

    public f(Context context, TimePickerDialog.OnTimeSetListener onTimeSetListener, int i, int i2, boolean z) {
        super(context, onTimeSetListener, i, i2, z);
        this.f2687a = -1;
        this.b = -1;
        this.c = false;
        this.f2687a = i;
        this.b = i2;
    }

    @Override // android.app.TimePickerDialog
    public void updateTime(int i, int i2) {
        super.updateTime(i, i2);
        this.f2687a = i;
        this.b = i2;
        this.c = false;
    }

    @Override // android.app.TimePickerDialog, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            this.c = true;
        } else if (this.f2687a >= 0 && this.b >= 0) {
            updateTime(this.f2687a, this.b);
        }
        super.onClick(dialogInterface, i);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        if (!this.c) {
            updateTime(this.f2687a, this.b);
        }
        super.onStop();
    }
}
