package com.baidu.tieba.view;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
/* loaded from: classes.dex */
public class c extends TimePickerDialog {
    private int djY;
    private int gfj;
    private boolean gfk;

    public c(Context context, TimePickerDialog.OnTimeSetListener onTimeSetListener, int i, int i2, boolean z) {
        super(context, onTimeSetListener, i, i2, z);
        this.djY = -1;
        this.gfj = -1;
        this.gfk = false;
        this.djY = i;
        this.gfj = i2;
    }

    @Override // android.app.TimePickerDialog
    public void updateTime(int i, int i2) {
        super.updateTime(i, i2);
        this.djY = i;
        this.gfj = i2;
        this.gfk = false;
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
        bundle.putInt("hour_key", this.djY);
        bundle.putInt("min_key", this.gfj);
        return bundle;
    }

    @Override // android.app.TimePickerDialog, android.app.Dialog
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        updateTime(0, 0);
        this.djY = bundle.getInt("hour_key");
        this.gfj = bundle.getInt("min_key");
        updateTime(this.djY, this.gfj);
    }

    @Override // android.app.TimePickerDialog, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            this.gfk = true;
        } else if (this.djY >= 0 && this.gfj >= 0) {
            updateTime(this.djY, this.gfj);
        }
        super.onClick(dialogInterface, i);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        if (!this.gfk) {
            updateTime(this.djY, this.gfj);
        }
        super.onStop();
    }
}
