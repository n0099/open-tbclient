package com.baidu.tieba.view;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
/* loaded from: classes.dex */
public class c extends TimePickerDialog {
    private int a;
    private int b;
    private boolean c;

    public c(Context context, TimePickerDialog.OnTimeSetListener onTimeSetListener, int i, int i2, boolean z) {
        super(context, onTimeSetListener, i, i2, z);
        this.a = -1;
        this.b = -1;
        this.c = false;
        this.a = i;
        this.b = i2;
    }

    @Override // android.app.TimePickerDialog
    public void updateTime(int i, int i2) {
        super.updateTime(i, i2);
        this.a = i;
        this.b = i2;
        this.c = false;
    }

    @Override // android.app.TimePickerDialog, android.app.Dialog
    public Bundle onSaveInstanceState() {
        Bundle onSaveInstanceState = super.onSaveInstanceState();
        if (onSaveInstanceState == null) {
            onSaveInstanceState = new Bundle();
        }
        onSaveInstanceState.putInt("hour_key", this.a);
        onSaveInstanceState.putInt("min_key", this.b);
        return onSaveInstanceState;
    }

    @Override // android.app.TimePickerDialog, android.app.Dialog
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        updateTime(0, 0);
        this.a = bundle.getInt("hour_key");
        this.b = bundle.getInt("min_key");
        updateTime(this.a, this.b);
    }

    @Override // android.app.TimePickerDialog, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            this.c = true;
        } else if (this.a >= 0 && this.b >= 0) {
            updateTime(this.a, this.b);
        }
        super.onClick(dialogInterface, i);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        if (!this.c) {
            updateTime(this.a, this.b);
        }
        super.onStop();
    }
}
