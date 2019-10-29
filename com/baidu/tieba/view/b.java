package com.baidu.tieba.view;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
/* loaded from: classes.dex */
public class b extends TimePickerDialog {
    private int bcm;
    private int jJS;
    private boolean jJT;

    public b(Context context, TimePickerDialog.OnTimeSetListener onTimeSetListener, int i, int i2, boolean z) {
        super(context, onTimeSetListener, i, i2, z);
        this.bcm = -1;
        this.jJS = -1;
        this.jJT = false;
        this.bcm = i;
        this.jJS = i2;
    }

    @Override // android.app.TimePickerDialog
    public void updateTime(int i, int i2) {
        super.updateTime(i, i2);
        this.bcm = i;
        this.jJS = i2;
        this.jJT = false;
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
        bundle.putInt("hour_key", this.bcm);
        bundle.putInt("min_key", this.jJS);
        return bundle;
    }

    @Override // android.app.TimePickerDialog, android.app.Dialog
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        updateTime(0, 0);
        this.bcm = bundle.getInt("hour_key");
        this.jJS = bundle.getInt("min_key");
        updateTime(this.bcm, this.jJS);
    }

    @Override // android.app.TimePickerDialog, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            this.jJT = true;
        } else if (this.bcm >= 0 && this.jJS >= 0) {
            updateTime(this.bcm, this.jJS);
        }
        super.onClick(dialogInterface, i);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        if (!this.jJT) {
            updateTime(this.bcm, this.jJS);
        }
        super.onStop();
    }
}
