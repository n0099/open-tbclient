package com.baidu.tieba.view;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
/* loaded from: classes.dex */
public class c extends TimePickerDialog {
    private int ciY;
    private int eWf;
    private boolean eWg;

    public c(Context context, TimePickerDialog.OnTimeSetListener onTimeSetListener, int i, int i2, boolean z) {
        super(context, onTimeSetListener, i, i2, z);
        this.ciY = -1;
        this.eWf = -1;
        this.eWg = false;
        this.ciY = i;
        this.eWf = i2;
    }

    @Override // android.app.TimePickerDialog
    public void updateTime(int i, int i2) {
        super.updateTime(i, i2);
        this.ciY = i;
        this.eWf = i2;
        this.eWg = false;
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
        bundle.putInt("hour_key", this.ciY);
        bundle.putInt("min_key", this.eWf);
        return bundle;
    }

    @Override // android.app.TimePickerDialog, android.app.Dialog
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        updateTime(0, 0);
        this.ciY = bundle.getInt("hour_key");
        this.eWf = bundle.getInt("min_key");
        updateTime(this.ciY, this.eWf);
    }

    @Override // android.app.TimePickerDialog, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            this.eWg = true;
        } else if (this.ciY >= 0 && this.eWf >= 0) {
            updateTime(this.ciY, this.eWf);
        }
        super.onClick(dialogInterface, i);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        if (!this.eWg) {
            updateTime(this.ciY, this.eWf);
        }
        super.onStop();
    }
}
