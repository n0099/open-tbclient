package com.baidu.tieba.view;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
/* loaded from: classes.dex */
public class a extends TimePickerDialog {
    private int dwd;
    private int gCc;
    private boolean gCd;

    public a(Context context, TimePickerDialog.OnTimeSetListener onTimeSetListener, int i, int i2, boolean z) {
        super(context, onTimeSetListener, i, i2, z);
        this.dwd = -1;
        this.gCc = -1;
        this.gCd = false;
        this.dwd = i;
        this.gCc = i2;
    }

    @Override // android.app.TimePickerDialog
    public void updateTime(int i, int i2) {
        super.updateTime(i, i2);
        this.dwd = i;
        this.gCc = i2;
        this.gCd = false;
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
        bundle.putInt("hour_key", this.dwd);
        bundle.putInt("min_key", this.gCc);
        return bundle;
    }

    @Override // android.app.TimePickerDialog, android.app.Dialog
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        updateTime(0, 0);
        this.dwd = bundle.getInt("hour_key");
        this.gCc = bundle.getInt("min_key");
        updateTime(this.dwd, this.gCc);
    }

    @Override // android.app.TimePickerDialog, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            this.gCd = true;
        } else if (this.dwd >= 0 && this.gCc >= 0) {
            updateTime(this.dwd, this.gCc);
        }
        super.onClick(dialogInterface, i);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        if (!this.gCd) {
            updateTime(this.dwd, this.gCc);
        }
        super.onStop();
    }
}
