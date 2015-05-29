package com.baidu.tieba.view;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
/* loaded from: classes.dex */
public class a extends TimePickerDialog {
    private int biC;
    private int cxL;
    private boolean cxM;

    public a(Context context, TimePickerDialog.OnTimeSetListener onTimeSetListener, int i, int i2, boolean z) {
        super(context, onTimeSetListener, i, i2, z);
        this.biC = -1;
        this.cxL = -1;
        this.cxM = false;
        this.biC = i;
        this.cxL = i2;
    }

    @Override // android.app.TimePickerDialog
    public void updateTime(int i, int i2) {
        super.updateTime(i, i2);
        this.biC = i;
        this.cxL = i2;
        this.cxM = false;
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
        bundle.putInt("hour_key", this.biC);
        bundle.putInt("min_key", this.cxL);
        return bundle;
    }

    @Override // android.app.TimePickerDialog, android.app.Dialog
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        updateTime(0, 0);
        this.biC = bundle.getInt("hour_key");
        this.cxL = bundle.getInt("min_key");
        updateTime(this.biC, this.cxL);
    }

    @Override // android.app.TimePickerDialog, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            this.cxM = true;
        } else if (this.biC >= 0 && this.cxL >= 0) {
            updateTime(this.biC, this.cxL);
        }
        super.onClick(dialogInterface, i);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        if (!this.cxM) {
            updateTime(this.biC, this.cxL);
        }
        super.onStop();
    }
}
