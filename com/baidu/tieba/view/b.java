package com.baidu.tieba.view;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
/* loaded from: classes.dex */
public class b extends TimePickerDialog {
    private int eut;
    private int hoT;
    private boolean hoU;

    public b(Context context, TimePickerDialog.OnTimeSetListener onTimeSetListener, int i, int i2, boolean z) {
        super(context, onTimeSetListener, i, i2, z);
        this.eut = -1;
        this.hoT = -1;
        this.hoU = false;
        this.eut = i;
        this.hoT = i2;
    }

    @Override // android.app.TimePickerDialog
    public void updateTime(int i, int i2) {
        super.updateTime(i, i2);
        this.eut = i;
        this.hoT = i2;
        this.hoU = false;
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
        bundle.putInt("hour_key", this.eut);
        bundle.putInt("min_key", this.hoT);
        return bundle;
    }

    @Override // android.app.TimePickerDialog, android.app.Dialog
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        updateTime(0, 0);
        this.eut = bundle.getInt("hour_key");
        this.hoT = bundle.getInt("min_key");
        updateTime(this.eut, this.hoT);
    }

    @Override // android.app.TimePickerDialog, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            this.hoU = true;
        } else if (this.eut >= 0 && this.hoT >= 0) {
            updateTime(this.eut, this.hoT);
        }
        super.onClick(dialogInterface, i);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        if (!this.hoU) {
            updateTime(this.eut, this.hoT);
        }
        super.onStop();
    }
}
