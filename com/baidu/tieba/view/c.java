package com.baidu.tieba.view;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
/* loaded from: classes.dex */
public class c extends TimePickerDialog {
    private int ciY;
    private int eWe;
    private boolean eWf;

    public c(Context context, TimePickerDialog.OnTimeSetListener onTimeSetListener, int i, int i2, boolean z) {
        super(context, onTimeSetListener, i, i2, z);
        this.ciY = -1;
        this.eWe = -1;
        this.eWf = false;
        this.ciY = i;
        this.eWe = i2;
    }

    @Override // android.app.TimePickerDialog
    public void updateTime(int i, int i2) {
        super.updateTime(i, i2);
        this.ciY = i;
        this.eWe = i2;
        this.eWf = false;
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
        bundle.putInt("min_key", this.eWe);
        return bundle;
    }

    @Override // android.app.TimePickerDialog, android.app.Dialog
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        updateTime(0, 0);
        this.ciY = bundle.getInt("hour_key");
        this.eWe = bundle.getInt("min_key");
        updateTime(this.ciY, this.eWe);
    }

    @Override // android.app.TimePickerDialog, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            this.eWf = true;
        } else if (this.ciY >= 0 && this.eWe >= 0) {
            updateTime(this.ciY, this.eWe);
        }
        super.onClick(dialogInterface, i);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        if (!this.eWf) {
            updateTime(this.ciY, this.eWe);
        }
        super.onStop();
    }
}
