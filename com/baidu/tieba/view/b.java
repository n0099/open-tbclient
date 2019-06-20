package com.baidu.tieba.view;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
/* loaded from: classes.dex */
public class b extends TimePickerDialog {
    private int aHS;
    private int jAs;
    private boolean jAt;

    public b(Context context, TimePickerDialog.OnTimeSetListener onTimeSetListener, int i, int i2, boolean z) {
        super(context, onTimeSetListener, i, i2, z);
        this.aHS = -1;
        this.jAs = -1;
        this.jAt = false;
        this.aHS = i;
        this.jAs = i2;
    }

    @Override // android.app.TimePickerDialog
    public void updateTime(int i, int i2) {
        super.updateTime(i, i2);
        this.aHS = i;
        this.jAs = i2;
        this.jAt = false;
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
        bundle.putInt("hour_key", this.aHS);
        bundle.putInt("min_key", this.jAs);
        return bundle;
    }

    @Override // android.app.TimePickerDialog, android.app.Dialog
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        updateTime(0, 0);
        this.aHS = bundle.getInt("hour_key");
        this.jAs = bundle.getInt("min_key");
        updateTime(this.aHS, this.jAs);
    }

    @Override // android.app.TimePickerDialog, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            this.jAt = true;
        } else if (this.aHS >= 0 && this.jAs >= 0) {
            updateTime(this.aHS, this.jAs);
        }
        super.onClick(dialogInterface, i);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        if (!this.jAt) {
            updateTime(this.aHS, this.jAs);
        }
        super.onStop();
    }
}
