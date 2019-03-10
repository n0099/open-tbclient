package com.baidu.tieba.view;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
/* loaded from: classes.dex */
public class b extends TimePickerDialog {
    private int aFU;
    private int jhN;
    private boolean jhO;

    public b(Context context, TimePickerDialog.OnTimeSetListener onTimeSetListener, int i, int i2, boolean z) {
        super(context, onTimeSetListener, i, i2, z);
        this.aFU = -1;
        this.jhN = -1;
        this.jhO = false;
        this.aFU = i;
        this.jhN = i2;
    }

    @Override // android.app.TimePickerDialog
    public void updateTime(int i, int i2) {
        super.updateTime(i, i2);
        this.aFU = i;
        this.jhN = i2;
        this.jhO = false;
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
        bundle.putInt("hour_key", this.aFU);
        bundle.putInt("min_key", this.jhN);
        return bundle;
    }

    @Override // android.app.TimePickerDialog, android.app.Dialog
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        updateTime(0, 0);
        this.aFU = bundle.getInt("hour_key");
        this.jhN = bundle.getInt("min_key");
        updateTime(this.aFU, this.jhN);
    }

    @Override // android.app.TimePickerDialog, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            this.jhO = true;
        } else if (this.aFU >= 0 && this.jhN >= 0) {
            updateTime(this.aFU, this.jhN);
        }
        super.onClick(dialogInterface, i);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        if (!this.jhO) {
            updateTime(this.aFU, this.jhN);
        }
        super.onStop();
    }
}
