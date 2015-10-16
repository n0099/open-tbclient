package com.baidu.tieba.view;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
/* loaded from: classes.dex */
public class a extends TimePickerDialog {
    private int bAm;
    private int djf;
    private boolean djg;

    public a(Context context, TimePickerDialog.OnTimeSetListener onTimeSetListener, int i, int i2, boolean z) {
        super(context, onTimeSetListener, i, i2, z);
        this.bAm = -1;
        this.djf = -1;
        this.djg = false;
        this.bAm = i;
        this.djf = i2;
    }

    @Override // android.app.TimePickerDialog
    public void updateTime(int i, int i2) {
        super.updateTime(i, i2);
        this.bAm = i;
        this.djf = i2;
        this.djg = false;
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
        bundle.putInt("hour_key", this.bAm);
        bundle.putInt("min_key", this.djf);
        return bundle;
    }

    @Override // android.app.TimePickerDialog, android.app.Dialog
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        updateTime(0, 0);
        this.bAm = bundle.getInt("hour_key");
        this.djf = bundle.getInt("min_key");
        updateTime(this.bAm, this.djf);
    }

    @Override // android.app.TimePickerDialog, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            this.djg = true;
        } else if (this.bAm >= 0 && this.djf >= 0) {
            updateTime(this.bAm, this.djf);
        }
        super.onClick(dialogInterface, i);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        if (!this.djg) {
            updateTime(this.bAm, this.djf);
        }
        super.onStop();
    }
}
