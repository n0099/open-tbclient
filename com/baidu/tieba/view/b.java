package com.baidu.tieba.view;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
/* loaded from: classes.dex */
public class b extends TimePickerDialog {
    private int eqE;
    private int hnK;
    private boolean hnL;

    public b(Context context, TimePickerDialog.OnTimeSetListener onTimeSetListener, int i, int i2, boolean z) {
        super(context, onTimeSetListener, i, i2, z);
        this.eqE = -1;
        this.hnK = -1;
        this.hnL = false;
        this.eqE = i;
        this.hnK = i2;
    }

    @Override // android.app.TimePickerDialog
    public void updateTime(int i, int i2) {
        super.updateTime(i, i2);
        this.eqE = i;
        this.hnK = i2;
        this.hnL = false;
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
        bundle.putInt("hour_key", this.eqE);
        bundle.putInt("min_key", this.hnK);
        return bundle;
    }

    @Override // android.app.TimePickerDialog, android.app.Dialog
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        updateTime(0, 0);
        this.eqE = bundle.getInt("hour_key");
        this.hnK = bundle.getInt("min_key");
        updateTime(this.eqE, this.hnK);
    }

    @Override // android.app.TimePickerDialog, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            this.hnL = true;
        } else if (this.eqE >= 0 && this.hnK >= 0) {
            updateTime(this.eqE, this.hnK);
        }
        super.onClick(dialogInterface, i);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        if (!this.hnL) {
            updateTime(this.eqE, this.hnK);
        }
        super.onStop();
    }
}
