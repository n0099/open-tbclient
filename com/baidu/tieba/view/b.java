package com.baidu.tieba.view;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
/* loaded from: classes.dex */
public class b extends TimePickerDialog {
    private int bKx;
    private int kHZ;
    private boolean kIa;

    public b(Context context, TimePickerDialog.OnTimeSetListener onTimeSetListener, int i, int i2, boolean z) {
        super(context, onTimeSetListener, i, i2, z);
        this.bKx = -1;
        this.kHZ = -1;
        this.kIa = false;
        this.bKx = i;
        this.kHZ = i2;
    }

    @Override // android.app.TimePickerDialog
    public void updateTime(int i, int i2) {
        super.updateTime(i, i2);
        this.bKx = i;
        this.kHZ = i2;
        this.kIa = false;
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
        bundle.putInt("hour_key", this.bKx);
        bundle.putInt("min_key", this.kHZ);
        return bundle;
    }

    @Override // android.app.TimePickerDialog, android.app.Dialog
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        updateTime(0, 0);
        this.bKx = bundle.getInt("hour_key");
        this.kHZ = bundle.getInt("min_key");
        updateTime(this.bKx, this.kHZ);
    }

    @Override // android.app.TimePickerDialog, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            this.kIa = true;
        } else if (this.bKx >= 0 && this.kHZ >= 0) {
            updateTime(this.bKx, this.kHZ);
        }
        super.onClick(dialogInterface, i);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        if (!this.kIa) {
            updateTime(this.bKx, this.kHZ);
        }
        super.onStop();
    }
}
