package com.baidu.tieba.view;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
/* loaded from: classes.dex */
public class d extends TimePickerDialog {
    private int eFJ;
    private int hAw;
    private boolean hAx;

    public d(Context context, TimePickerDialog.OnTimeSetListener onTimeSetListener, int i, int i2, boolean z) {
        super(context, onTimeSetListener, i, i2, z);
        this.eFJ = -1;
        this.hAw = -1;
        this.hAx = false;
        this.eFJ = i;
        this.hAw = i2;
    }

    @Override // android.app.TimePickerDialog
    public void updateTime(int i, int i2) {
        super.updateTime(i, i2);
        this.eFJ = i;
        this.hAw = i2;
        this.hAx = false;
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
        bundle.putInt("hour_key", this.eFJ);
        bundle.putInt("min_key", this.hAw);
        return bundle;
    }

    @Override // android.app.TimePickerDialog, android.app.Dialog
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        updateTime(0, 0);
        this.eFJ = bundle.getInt("hour_key");
        this.hAw = bundle.getInt("min_key");
        updateTime(this.eFJ, this.hAw);
    }

    @Override // android.app.TimePickerDialog, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            this.hAx = true;
        } else if (this.eFJ >= 0 && this.hAw >= 0) {
            updateTime(this.eFJ, this.hAw);
        }
        super.onClick(dialogInterface, i);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        if (!this.hAx) {
            updateTime(this.eFJ, this.hAw);
        }
        super.onStop();
    }
}
