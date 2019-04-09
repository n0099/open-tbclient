package com.baidu.tieba.view;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
/* loaded from: classes.dex */
public class b extends TimePickerDialog {
    private int aFZ;
    private int jhu;
    private boolean jhv;

    public b(Context context, TimePickerDialog.OnTimeSetListener onTimeSetListener, int i, int i2, boolean z) {
        super(context, onTimeSetListener, i, i2, z);
        this.aFZ = -1;
        this.jhu = -1;
        this.jhv = false;
        this.aFZ = i;
        this.jhu = i2;
    }

    @Override // android.app.TimePickerDialog
    public void updateTime(int i, int i2) {
        super.updateTime(i, i2);
        this.aFZ = i;
        this.jhu = i2;
        this.jhv = false;
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
        bundle.putInt("hour_key", this.aFZ);
        bundle.putInt("min_key", this.jhu);
        return bundle;
    }

    @Override // android.app.TimePickerDialog, android.app.Dialog
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        updateTime(0, 0);
        this.aFZ = bundle.getInt("hour_key");
        this.jhu = bundle.getInt("min_key");
        updateTime(this.aFZ, this.jhu);
    }

    @Override // android.app.TimePickerDialog, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            this.jhv = true;
        } else if (this.aFZ >= 0 && this.jhu >= 0) {
            updateTime(this.aFZ, this.jhu);
        }
        super.onClick(dialogInterface, i);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        if (!this.jhv) {
            updateTime(this.aFZ, this.jhu);
        }
        super.onStop();
    }
}
