package com.baidu.tieba.view;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
/* loaded from: classes.dex */
public class d extends TimePickerDialog {
    private int eBn;
    private int hyQ;
    private boolean hyR;

    public d(Context context, TimePickerDialog.OnTimeSetListener onTimeSetListener, int i, int i2, boolean z) {
        super(context, onTimeSetListener, i, i2, z);
        this.eBn = -1;
        this.hyQ = -1;
        this.hyR = false;
        this.eBn = i;
        this.hyQ = i2;
    }

    @Override // android.app.TimePickerDialog
    public void updateTime(int i, int i2) {
        super.updateTime(i, i2);
        this.eBn = i;
        this.hyQ = i2;
        this.hyR = false;
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
        bundle.putInt("hour_key", this.eBn);
        bundle.putInt("min_key", this.hyQ);
        return bundle;
    }

    @Override // android.app.TimePickerDialog, android.app.Dialog
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        updateTime(0, 0);
        this.eBn = bundle.getInt("hour_key");
        this.hyQ = bundle.getInt("min_key");
        updateTime(this.eBn, this.hyQ);
    }

    @Override // android.app.TimePickerDialog, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            this.hyR = true;
        } else if (this.eBn >= 0 && this.hyQ >= 0) {
            updateTime(this.eBn, this.hyQ);
        }
        super.onClick(dialogInterface, i);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        if (!this.hyR) {
            updateTime(this.eBn, this.hyQ);
        }
        super.onStop();
    }
}
