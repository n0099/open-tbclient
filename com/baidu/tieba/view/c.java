package com.baidu.tieba.view;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
/* loaded from: classes.dex */
public class c extends TimePickerDialog {
    private int dcR;
    private int fVK;
    private boolean fVL;

    public c(Context context, TimePickerDialog.OnTimeSetListener onTimeSetListener, int i, int i2, boolean z) {
        super(context, onTimeSetListener, i, i2, z);
        this.dcR = -1;
        this.fVK = -1;
        this.fVL = false;
        this.dcR = i;
        this.fVK = i2;
    }

    @Override // android.app.TimePickerDialog
    public void updateTime(int i, int i2) {
        super.updateTime(i, i2);
        this.dcR = i;
        this.fVK = i2;
        this.fVL = false;
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
        bundle.putInt("hour_key", this.dcR);
        bundle.putInt("min_key", this.fVK);
        return bundle;
    }

    @Override // android.app.TimePickerDialog, android.app.Dialog
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        updateTime(0, 0);
        this.dcR = bundle.getInt("hour_key");
        this.fVK = bundle.getInt("min_key");
        updateTime(this.dcR, this.fVK);
    }

    @Override // android.app.TimePickerDialog, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            this.fVL = true;
        } else if (this.dcR >= 0 && this.fVK >= 0) {
            updateTime(this.dcR, this.fVK);
        }
        super.onClick(dialogInterface, i);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        if (!this.fVL) {
            updateTime(this.dcR, this.fVK);
        }
        super.onStop();
    }
}
