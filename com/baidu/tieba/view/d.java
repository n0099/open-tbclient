package com.baidu.tieba.view;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
/* loaded from: classes.dex */
public class d extends TimePickerDialog {
    private int ezt;
    private int hIP;
    private boolean hIQ;

    public d(Context context, TimePickerDialog.OnTimeSetListener onTimeSetListener, int i, int i2, boolean z) {
        super(context, onTimeSetListener, i, i2, z);
        this.ezt = -1;
        this.hIP = -1;
        this.hIQ = false;
        this.ezt = i;
        this.hIP = i2;
    }

    @Override // android.app.TimePickerDialog
    public void updateTime(int i, int i2) {
        super.updateTime(i, i2);
        this.ezt = i;
        this.hIP = i2;
        this.hIQ = false;
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
        bundle.putInt("hour_key", this.ezt);
        bundle.putInt("min_key", this.hIP);
        return bundle;
    }

    @Override // android.app.TimePickerDialog, android.app.Dialog
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        updateTime(0, 0);
        this.ezt = bundle.getInt("hour_key");
        this.hIP = bundle.getInt("min_key");
        updateTime(this.ezt, this.hIP);
    }

    @Override // android.app.TimePickerDialog, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            this.hIQ = true;
        } else if (this.ezt >= 0 && this.hIP >= 0) {
            updateTime(this.ezt, this.hIP);
        }
        super.onClick(dialogInterface, i);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        if (!this.hIQ) {
            updateTime(this.ezt, this.hIP);
        }
        super.onStop();
    }
}
