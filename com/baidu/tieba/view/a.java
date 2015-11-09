package com.baidu.tieba.view;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
/* loaded from: classes.dex */
public class a extends TimePickerDialog {
    private int bAJ;
    private int dkL;
    private boolean dkM;

    public a(Context context, TimePickerDialog.OnTimeSetListener onTimeSetListener, int i, int i2, boolean z) {
        super(context, onTimeSetListener, i, i2, z);
        this.bAJ = -1;
        this.dkL = -1;
        this.dkM = false;
        this.bAJ = i;
        this.dkL = i2;
    }

    @Override // android.app.TimePickerDialog
    public void updateTime(int i, int i2) {
        super.updateTime(i, i2);
        this.bAJ = i;
        this.dkL = i2;
        this.dkM = false;
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
        bundle.putInt("hour_key", this.bAJ);
        bundle.putInt("min_key", this.dkL);
        return bundle;
    }

    @Override // android.app.TimePickerDialog, android.app.Dialog
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        updateTime(0, 0);
        this.bAJ = bundle.getInt("hour_key");
        this.dkL = bundle.getInt("min_key");
        updateTime(this.bAJ, this.dkL);
    }

    @Override // android.app.TimePickerDialog, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            this.dkM = true;
        } else if (this.bAJ >= 0 && this.dkL >= 0) {
            updateTime(this.bAJ, this.dkL);
        }
        super.onClick(dialogInterface, i);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        if (!this.dkM) {
            updateTime(this.bAJ, this.dkL);
        }
        super.onStop();
    }
}
