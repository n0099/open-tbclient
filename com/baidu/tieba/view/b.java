package com.baidu.tieba.view;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
/* loaded from: classes.dex */
public class b extends TimePickerDialog {
    private int cvc;
    private int lMw;
    private boolean lMx;

    public b(Context context, TimePickerDialog.OnTimeSetListener onTimeSetListener, int i, int i2, boolean z) {
        super(context, onTimeSetListener, i, i2, z);
        this.cvc = -1;
        this.lMw = -1;
        this.lMx = false;
        this.cvc = i;
        this.lMw = i2;
    }

    @Override // android.app.TimePickerDialog
    public void updateTime(int i, int i2) {
        super.updateTime(i, i2);
        this.cvc = i;
        this.lMw = i2;
        this.lMx = false;
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
        bundle.putInt("hour_key", this.cvc);
        bundle.putInt("min_key", this.lMw);
        return bundle;
    }

    @Override // android.app.TimePickerDialog, android.app.Dialog
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        updateTime(0, 0);
        this.cvc = bundle.getInt("hour_key");
        this.lMw = bundle.getInt("min_key");
        updateTime(this.cvc, this.lMw);
    }

    @Override // android.app.TimePickerDialog, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            this.lMx = true;
        } else if (this.cvc >= 0 && this.lMw >= 0) {
            updateTime(this.cvc, this.lMw);
        }
        super.onClick(dialogInterface, i);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        if (!this.lMx) {
            updateTime(this.cvc, this.lMw);
        }
        super.onStop();
    }
}
