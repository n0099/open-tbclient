package com.baidu.tieba.view;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
/* loaded from: classes.dex */
public class a extends TimePickerDialog {
    private int bwZ;
    private int cXV;
    private boolean cXW;

    public a(Context context, TimePickerDialog.OnTimeSetListener onTimeSetListener, int i, int i2, boolean z) {
        super(context, onTimeSetListener, i, i2, z);
        this.bwZ = -1;
        this.cXV = -1;
        this.cXW = false;
        this.bwZ = i;
        this.cXV = i2;
    }

    @Override // android.app.TimePickerDialog
    public void updateTime(int i, int i2) {
        super.updateTime(i, i2);
        this.bwZ = i;
        this.cXV = i2;
        this.cXW = false;
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
        bundle.putInt("hour_key", this.bwZ);
        bundle.putInt("min_key", this.cXV);
        return bundle;
    }

    @Override // android.app.TimePickerDialog, android.app.Dialog
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        updateTime(0, 0);
        this.bwZ = bundle.getInt("hour_key");
        this.cXV = bundle.getInt("min_key");
        updateTime(this.bwZ, this.cXV);
    }

    @Override // android.app.TimePickerDialog, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            this.cXW = true;
        } else if (this.bwZ >= 0 && this.cXV >= 0) {
            updateTime(this.bwZ, this.cXV);
        }
        super.onClick(dialogInterface, i);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        if (!this.cXW) {
            updateTime(this.bwZ, this.cXV);
        }
        super.onStop();
    }
}
