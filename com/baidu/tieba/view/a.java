package com.baidu.tieba.view;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
/* loaded from: classes.dex */
public class a extends TimePickerDialog {
    private int bTv;
    private int dQX;
    private boolean dQY;

    public a(Context context, TimePickerDialog.OnTimeSetListener onTimeSetListener, int i, int i2, boolean z) {
        super(context, onTimeSetListener, i, i2, z);
        this.bTv = -1;
        this.dQX = -1;
        this.dQY = false;
        this.bTv = i;
        this.dQX = i2;
    }

    @Override // android.app.TimePickerDialog
    public void updateTime(int i, int i2) {
        super.updateTime(i, i2);
        this.bTv = i;
        this.dQX = i2;
        this.dQY = false;
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
        bundle.putInt("hour_key", this.bTv);
        bundle.putInt("min_key", this.dQX);
        return bundle;
    }

    @Override // android.app.TimePickerDialog, android.app.Dialog
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        updateTime(0, 0);
        this.bTv = bundle.getInt("hour_key");
        this.dQX = bundle.getInt("min_key");
        updateTime(this.bTv, this.dQX);
    }

    @Override // android.app.TimePickerDialog, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            this.dQY = true;
        } else if (this.bTv >= 0 && this.dQX >= 0) {
            updateTime(this.bTv, this.dQX);
        }
        super.onClick(dialogInterface, i);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        if (!this.dQY) {
            updateTime(this.bTv, this.dQX);
        }
        super.onStop();
    }
}
