package com.baidu.tieba.view;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
/* loaded from: classes.dex */
public class b extends TimePickerDialog {
    private int aIA;
    private int jGB;
    private boolean jGC;

    public b(Context context, TimePickerDialog.OnTimeSetListener onTimeSetListener, int i, int i2, boolean z) {
        super(context, onTimeSetListener, i, i2, z);
        this.aIA = -1;
        this.jGB = -1;
        this.jGC = false;
        this.aIA = i;
        this.jGB = i2;
    }

    @Override // android.app.TimePickerDialog
    public void updateTime(int i, int i2) {
        super.updateTime(i, i2);
        this.aIA = i;
        this.jGB = i2;
        this.jGC = false;
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
        bundle.putInt("hour_key", this.aIA);
        bundle.putInt("min_key", this.jGB);
        return bundle;
    }

    @Override // android.app.TimePickerDialog, android.app.Dialog
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        updateTime(0, 0);
        this.aIA = bundle.getInt("hour_key");
        this.jGB = bundle.getInt("min_key");
        updateTime(this.aIA, this.jGB);
    }

    @Override // android.app.TimePickerDialog, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            this.jGC = true;
        } else if (this.aIA >= 0 && this.jGB >= 0) {
            updateTime(this.aIA, this.jGB);
        }
        super.onClick(dialogInterface, i);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        if (!this.jGC) {
            updateTime(this.aIA, this.jGB);
        }
        super.onStop();
    }
}
