package com.baidu.tieba.view;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
/* loaded from: classes.dex */
public class b extends TimePickerDialog {
    private int czN;
    private int mhB;
    private boolean mhC;

    public b(Context context, TimePickerDialog.OnTimeSetListener onTimeSetListener, int i, int i2, boolean z) {
        super(context, onTimeSetListener, i, i2, z);
        this.czN = -1;
        this.mhB = -1;
        this.mhC = false;
        this.czN = i;
        this.mhB = i2;
    }

    @Override // android.app.TimePickerDialog
    public void updateTime(int i, int i2) {
        super.updateTime(i, i2);
        this.czN = i;
        this.mhB = i2;
        this.mhC = false;
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
        bundle.putInt("hour_key", this.czN);
        bundle.putInt("min_key", this.mhB);
        return bundle;
    }

    @Override // android.app.TimePickerDialog, android.app.Dialog
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        updateTime(0, 0);
        this.czN = bundle.getInt("hour_key");
        this.mhB = bundle.getInt("min_key");
        updateTime(this.czN, this.mhB);
    }

    @Override // android.app.TimePickerDialog, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            this.mhC = true;
        } else if (this.czN >= 0 && this.mhB >= 0) {
            updateTime(this.czN, this.mhB);
        }
        super.onClick(dialogInterface, i);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        if (!this.mhC) {
            updateTime(this.czN, this.mhB);
        }
        super.onStop();
    }
}
