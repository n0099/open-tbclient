package com.baidu.tieba.view;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
/* loaded from: classes.dex */
public class g extends TimePickerDialog {
    private int bev;
    private int ceI;
    private boolean ceJ;

    public g(Context context, TimePickerDialog.OnTimeSetListener onTimeSetListener, int i, int i2, boolean z) {
        super(context, onTimeSetListener, i, i2, z);
        this.bev = -1;
        this.ceI = -1;
        this.ceJ = false;
        this.bev = i;
        this.ceI = i2;
    }

    @Override // android.app.TimePickerDialog
    public void updateTime(int i, int i2) {
        super.updateTime(i, i2);
        this.bev = i;
        this.ceI = i2;
        this.ceJ = false;
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
        bundle.putInt("hour_key", this.bev);
        bundle.putInt("min_key", this.ceI);
        return bundle;
    }

    @Override // android.app.TimePickerDialog, android.app.Dialog
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        updateTime(0, 0);
        this.bev = bundle.getInt("hour_key");
        this.ceI = bundle.getInt("min_key");
        updateTime(this.bev, this.ceI);
    }

    @Override // android.app.TimePickerDialog, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            this.ceJ = true;
        } else if (this.bev >= 0 && this.ceI >= 0) {
            updateTime(this.bev, this.ceI);
        }
        super.onClick(dialogInterface, i);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        if (!this.ceJ) {
            updateTime(this.bev, this.ceI);
        }
        super.onStop();
    }
}
