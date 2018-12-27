package com.baidu.tieba.view;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
/* loaded from: classes.dex */
public class b extends TimePickerDialog {
    private int hQe;
    private boolean hQf;
    private int mHour;

    public b(Context context, TimePickerDialog.OnTimeSetListener onTimeSetListener, int i, int i2, boolean z) {
        super(context, onTimeSetListener, i, i2, z);
        this.mHour = -1;
        this.hQe = -1;
        this.hQf = false;
        this.mHour = i;
        this.hQe = i2;
    }

    @Override // android.app.TimePickerDialog
    public void updateTime(int i, int i2) {
        super.updateTime(i, i2);
        this.mHour = i;
        this.hQe = i2;
        this.hQf = false;
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
        bundle.putInt("hour_key", this.mHour);
        bundle.putInt("min_key", this.hQe);
        return bundle;
    }

    @Override // android.app.TimePickerDialog, android.app.Dialog
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        updateTime(0, 0);
        this.mHour = bundle.getInt("hour_key");
        this.hQe = bundle.getInt("min_key");
        updateTime(this.mHour, this.hQe);
    }

    @Override // android.app.TimePickerDialog, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            this.hQf = true;
        } else if (this.mHour >= 0 && this.hQe >= 0) {
            updateTime(this.mHour, this.hQe);
        }
        super.onClick(dialogInterface, i);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        if (!this.hQf) {
            updateTime(this.mHour, this.hQe);
        }
        super.onStop();
    }
}
