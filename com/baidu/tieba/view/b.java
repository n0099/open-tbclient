package com.baidu.tieba.view;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
/* loaded from: classes.dex */
public class b extends TimePickerDialog {
    private int bGq;
    private int kGQ;
    private boolean kGR;

    public b(Context context, TimePickerDialog.OnTimeSetListener onTimeSetListener, int i, int i2, boolean z) {
        super(context, onTimeSetListener, i, i2, z);
        this.bGq = -1;
        this.kGQ = -1;
        this.kGR = false;
        this.bGq = i;
        this.kGQ = i2;
    }

    @Override // android.app.TimePickerDialog
    public void updateTime(int i, int i2) {
        super.updateTime(i, i2);
        this.bGq = i;
        this.kGQ = i2;
        this.kGR = false;
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
        bundle.putInt("hour_key", this.bGq);
        bundle.putInt("min_key", this.kGQ);
        return bundle;
    }

    @Override // android.app.TimePickerDialog, android.app.Dialog
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        updateTime(0, 0);
        this.bGq = bundle.getInt("hour_key");
        this.kGQ = bundle.getInt("min_key");
        updateTime(this.bGq, this.kGQ);
    }

    @Override // android.app.TimePickerDialog, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            this.kGR = true;
        } else if (this.bGq >= 0 && this.kGQ >= 0) {
            updateTime(this.bGq, this.kGQ);
        }
        super.onClick(dialogInterface, i);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        if (!this.kGR) {
            updateTime(this.bGq, this.kGQ);
        }
        super.onStop();
    }
}
