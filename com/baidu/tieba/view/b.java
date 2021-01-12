package com.baidu.tieba.view;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
/* loaded from: classes.dex */
public class b extends TimePickerDialog {
    private int dsU;
    private int nMP;
    private boolean nMQ;

    public b(Context context, TimePickerDialog.OnTimeSetListener onTimeSetListener, int i, int i2, boolean z) {
        super(context, onTimeSetListener, i, i2, z);
        this.dsU = -1;
        this.nMP = -1;
        this.nMQ = false;
        this.dsU = i;
        this.nMP = i2;
    }

    @Override // android.app.TimePickerDialog
    public void updateTime(int i, int i2) {
        super.updateTime(i, i2);
        this.dsU = i;
        this.nMP = i2;
        this.nMQ = false;
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
        bundle.putInt("min_key", this.nMP);
        return bundle;
    }

    @Override // android.app.TimePickerDialog, android.app.Dialog
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        updateTime(0, 0);
        this.dsU = bundle.getInt("hour_key");
        this.nMP = bundle.getInt("min_key");
        updateTime(this.dsU, this.nMP);
    }

    @Override // android.app.TimePickerDialog, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            this.nMQ = true;
        } else if (this.dsU >= 0 && this.nMP >= 0) {
            updateTime(this.dsU, this.nMP);
        }
        super.onClick(dialogInterface, i);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        if (!this.nMQ) {
            updateTime(this.dsU, this.nMP);
        }
        super.onStop();
    }
}
