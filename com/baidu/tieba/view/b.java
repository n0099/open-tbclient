package com.baidu.tieba.view;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
/* loaded from: classes.dex */
public class b extends TimePickerDialog {
    private int dsI;
    private int nNX;
    private boolean nNY;

    public b(Context context, TimePickerDialog.OnTimeSetListener onTimeSetListener, int i, int i2, boolean z) {
        super(context, onTimeSetListener, i, i2, z);
        this.dsI = -1;
        this.nNX = -1;
        this.nNY = false;
        this.dsI = i;
        this.nNX = i2;
    }

    @Override // android.app.TimePickerDialog
    public void updateTime(int i, int i2) {
        super.updateTime(i, i2);
        this.dsI = i;
        this.nNX = i2;
        this.nNY = false;
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
        bundle.putInt("hour_key", this.dsI);
        bundle.putInt("min_key", this.nNX);
        return bundle;
    }

    @Override // android.app.TimePickerDialog, android.app.Dialog
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        updateTime(0, 0);
        this.dsI = bundle.getInt("hour_key");
        this.nNX = bundle.getInt("min_key");
        updateTime(this.dsI, this.nNX);
    }

    @Override // android.app.TimePickerDialog, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            this.nNY = true;
        } else if (this.dsI >= 0 && this.nNX >= 0) {
            updateTime(this.dsI, this.nNX);
        }
        super.onClick(dialogInterface, i);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        if (!this.nNY) {
            updateTime(this.dsI, this.nNX);
        }
        super.onStop();
    }
}
