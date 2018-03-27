package com.baidu.tieba.view;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
/* loaded from: classes.dex */
public class d extends TimePickerDialog {
    private int eFN;
    private int hAH;
    private boolean hAI;

    public d(Context context, TimePickerDialog.OnTimeSetListener onTimeSetListener, int i, int i2, boolean z) {
        super(context, onTimeSetListener, i, i2, z);
        this.eFN = -1;
        this.hAH = -1;
        this.hAI = false;
        this.eFN = i;
        this.hAH = i2;
    }

    @Override // android.app.TimePickerDialog
    public void updateTime(int i, int i2) {
        super.updateTime(i, i2);
        this.eFN = i;
        this.hAH = i2;
        this.hAI = false;
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
        bundle.putInt("hour_key", this.eFN);
        bundle.putInt("min_key", this.hAH);
        return bundle;
    }

    @Override // android.app.TimePickerDialog, android.app.Dialog
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        updateTime(0, 0);
        this.eFN = bundle.getInt("hour_key");
        this.hAH = bundle.getInt("min_key");
        updateTime(this.eFN, this.hAH);
    }

    @Override // android.app.TimePickerDialog, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            this.hAI = true;
        } else if (this.eFN >= 0 && this.hAH >= 0) {
            updateTime(this.eFN, this.hAH);
        }
        super.onClick(dialogInterface, i);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        if (!this.hAI) {
            updateTime(this.eFN, this.hAH);
        }
        super.onStop();
    }
}
