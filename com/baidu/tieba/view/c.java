package com.baidu.tieba.view;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
/* loaded from: classes.dex */
public class c extends TimePickerDialog {
    private int cTo;
    private int fIi;
    private boolean fIj;

    public c(Context context, TimePickerDialog.OnTimeSetListener onTimeSetListener, int i, int i2, boolean z) {
        super(context, onTimeSetListener, i, i2, z);
        this.cTo = -1;
        this.fIi = -1;
        this.fIj = false;
        this.cTo = i;
        this.fIi = i2;
    }

    @Override // android.app.TimePickerDialog
    public void updateTime(int i, int i2) {
        super.updateTime(i, i2);
        this.cTo = i;
        this.fIi = i2;
        this.fIj = false;
    }

    @Override // android.app.TimePickerDialog, android.app.Dialog
    public Bundle onSaveInstanceState() {
        Bundle bundle = null;
        try {
            bundle = super.onSaveInstanceState();
        } catch (Exception e) {
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt("hour_key", this.cTo);
        bundle.putInt("min_key", this.fIi);
        return bundle;
    }

    @Override // android.app.TimePickerDialog, android.app.Dialog
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        updateTime(0, 0);
        this.cTo = bundle.getInt("hour_key");
        this.fIi = bundle.getInt("min_key");
        updateTime(this.cTo, this.fIi);
    }

    @Override // android.app.TimePickerDialog, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            this.fIj = true;
        } else if (this.cTo >= 0 && this.fIi >= 0) {
            updateTime(this.cTo, this.fIi);
        }
        super.onClick(dialogInterface, i);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        if (!this.fIj) {
            updateTime(this.cTo, this.fIi);
        }
        super.onStop();
    }
}
