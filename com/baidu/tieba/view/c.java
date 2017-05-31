package com.baidu.tieba.view;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
/* loaded from: classes.dex */
public class c extends TimePickerDialog {
    private int cYL;
    private int fQc;
    private boolean fQd;

    public c(Context context, TimePickerDialog.OnTimeSetListener onTimeSetListener, int i, int i2, boolean z) {
        super(context, onTimeSetListener, i, i2, z);
        this.cYL = -1;
        this.fQc = -1;
        this.fQd = false;
        this.cYL = i;
        this.fQc = i2;
    }

    @Override // android.app.TimePickerDialog
    public void updateTime(int i, int i2) {
        super.updateTime(i, i2);
        this.cYL = i;
        this.fQc = i2;
        this.fQd = false;
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
        bundle.putInt("hour_key", this.cYL);
        bundle.putInt("min_key", this.fQc);
        return bundle;
    }

    @Override // android.app.TimePickerDialog, android.app.Dialog
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        updateTime(0, 0);
        this.cYL = bundle.getInt("hour_key");
        this.fQc = bundle.getInt("min_key");
        updateTime(this.cYL, this.fQc);
    }

    @Override // android.app.TimePickerDialog, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            this.fQd = true;
        } else if (this.cYL >= 0 && this.fQc >= 0) {
            updateTime(this.cYL, this.fQc);
        }
        super.onClick(dialogInterface, i);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        if (!this.fQd) {
            updateTime(this.cYL, this.fQc);
        }
        super.onStop();
    }
}
