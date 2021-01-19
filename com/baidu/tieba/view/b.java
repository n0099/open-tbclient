package com.baidu.tieba.view;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
/* loaded from: classes.dex */
public class b extends TimePickerDialog {
    private int dsU;
    private int nMQ;
    private boolean nMR;

    public b(Context context, TimePickerDialog.OnTimeSetListener onTimeSetListener, int i, int i2, boolean z) {
        super(context, onTimeSetListener, i, i2, z);
        this.dsU = -1;
        this.nMQ = -1;
        this.nMR = false;
        this.dsU = i;
        this.nMQ = i2;
    }

    @Override // android.app.TimePickerDialog
    public void updateTime(int i, int i2) {
        super.updateTime(i, i2);
        this.dsU = i;
        this.nMQ = i2;
        this.nMR = false;
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
        bundle.putInt("hour_key", this.dsU);
        bundle.putInt("min_key", this.nMQ);
        return bundle;
    }

    @Override // android.app.TimePickerDialog, android.app.Dialog
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        updateTime(0, 0);
        this.dsU = bundle.getInt("hour_key");
        this.nMQ = bundle.getInt("min_key");
        updateTime(this.dsU, this.nMQ);
    }

    @Override // android.app.TimePickerDialog, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            this.nMR = true;
        } else if (this.dsU >= 0 && this.nMQ >= 0) {
            updateTime(this.dsU, this.nMQ);
        }
        super.onClick(dialogInterface, i);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        if (!this.nMR) {
            updateTime(this.dsU, this.nMQ);
        }
        super.onStop();
    }
}
