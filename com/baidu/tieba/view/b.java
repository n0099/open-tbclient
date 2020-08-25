package com.baidu.tieba.view;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
/* loaded from: classes2.dex */
public class b extends TimePickerDialog {
    private int cKL;
    private int mGK;
    private boolean mGL;

    public b(Context context, TimePickerDialog.OnTimeSetListener onTimeSetListener, int i, int i2, boolean z) {
        super(context, onTimeSetListener, i, i2, z);
        this.cKL = -1;
        this.mGK = -1;
        this.mGL = false;
        this.cKL = i;
        this.mGK = i2;
    }

    @Override // android.app.TimePickerDialog
    public void updateTime(int i, int i2) {
        super.updateTime(i, i2);
        this.cKL = i;
        this.mGK = i2;
        this.mGL = false;
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
        bundle.putInt("hour_key", this.cKL);
        bundle.putInt("min_key", this.mGK);
        return bundle;
    }

    @Override // android.app.TimePickerDialog, android.app.Dialog
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        updateTime(0, 0);
        this.cKL = bundle.getInt("hour_key");
        this.mGK = bundle.getInt("min_key");
        updateTime(this.cKL, this.mGK);
    }

    @Override // android.app.TimePickerDialog, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            this.mGL = true;
        } else if (this.cKL >= 0 && this.mGK >= 0) {
            updateTime(this.cKL, this.mGK);
        }
        super.onClick(dialogInterface, i);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        if (!this.mGL) {
            updateTime(this.cKL, this.mGK);
        }
        super.onStop();
    }
}
