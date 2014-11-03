package com.baidu.tieba.view;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
/* loaded from: classes.dex */
public class c extends TimePickerDialog {
    private int aZe;
    private int bQO;
    private boolean bQP;

    public c(Context context, TimePickerDialog.OnTimeSetListener onTimeSetListener, int i, int i2, boolean z) {
        super(context, onTimeSetListener, i, i2, z);
        this.aZe = -1;
        this.bQO = -1;
        this.bQP = false;
        this.aZe = i;
        this.bQO = i2;
    }

    @Override // android.app.TimePickerDialog
    public void updateTime(int i, int i2) {
        super.updateTime(i, i2);
        this.aZe = i;
        this.bQO = i2;
        this.bQP = false;
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
        bundle.putInt("hour_key", this.aZe);
        bundle.putInt("min_key", this.bQO);
        return bundle;
    }

    @Override // android.app.TimePickerDialog, android.app.Dialog
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        updateTime(0, 0);
        this.aZe = bundle.getInt("hour_key");
        this.bQO = bundle.getInt("min_key");
        updateTime(this.aZe, this.bQO);
    }

    @Override // android.app.TimePickerDialog, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            this.bQP = true;
        } else if (this.aZe >= 0 && this.bQO >= 0) {
            updateTime(this.aZe, this.bQO);
        }
        super.onClick(dialogInterface, i);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        if (!this.bQP) {
            updateTime(this.aZe, this.bQO);
        }
        super.onStop();
    }
}
