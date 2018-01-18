package com.baidu.tieba.view;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
/* loaded from: classes.dex */
public class d extends TimePickerDialog {
    private int eAS;
    private int hyw;
    private boolean hyx;

    public d(Context context, TimePickerDialog.OnTimeSetListener onTimeSetListener, int i, int i2, boolean z) {
        super(context, onTimeSetListener, i, i2, z);
        this.eAS = -1;
        this.hyw = -1;
        this.hyx = false;
        this.eAS = i;
        this.hyw = i2;
    }

    @Override // android.app.TimePickerDialog
    public void updateTime(int i, int i2) {
        super.updateTime(i, i2);
        this.eAS = i;
        this.hyw = i2;
        this.hyx = false;
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
        bundle.putInt("hour_key", this.eAS);
        bundle.putInt("min_key", this.hyw);
        return bundle;
    }

    @Override // android.app.TimePickerDialog, android.app.Dialog
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        updateTime(0, 0);
        this.eAS = bundle.getInt("hour_key");
        this.hyw = bundle.getInt("min_key");
        updateTime(this.eAS, this.hyw);
    }

    @Override // android.app.TimePickerDialog, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            this.hyx = true;
        } else if (this.eAS >= 0 && this.hyw >= 0) {
            updateTime(this.eAS, this.hyw);
        }
        super.onClick(dialogInterface, i);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        if (!this.hyx) {
            updateTime(this.eAS, this.hyw);
        }
        super.onStop();
    }
}
