package com.baidu.tieba.view;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
/* loaded from: classes.dex */
public class g extends TimePickerDialog {
    private int beu;
    private int ceH;
    private boolean ceI;

    public g(Context context, TimePickerDialog.OnTimeSetListener onTimeSetListener, int i, int i2, boolean z) {
        super(context, onTimeSetListener, i, i2, z);
        this.beu = -1;
        this.ceH = -1;
        this.ceI = false;
        this.beu = i;
        this.ceH = i2;
    }

    @Override // android.app.TimePickerDialog
    public void updateTime(int i, int i2) {
        super.updateTime(i, i2);
        this.beu = i;
        this.ceH = i2;
        this.ceI = false;
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
        bundle.putInt("hour_key", this.beu);
        bundle.putInt("min_key", this.ceH);
        return bundle;
    }

    @Override // android.app.TimePickerDialog, android.app.Dialog
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        updateTime(0, 0);
        this.beu = bundle.getInt("hour_key");
        this.ceH = bundle.getInt("min_key");
        updateTime(this.beu, this.ceH);
    }

    @Override // android.app.TimePickerDialog, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            this.ceI = true;
        } else if (this.beu >= 0 && this.ceH >= 0) {
            updateTime(this.beu, this.ceH);
        }
        super.onClick(dialogInterface, i);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        if (!this.ceI) {
            updateTime(this.beu, this.ceH);
        }
        super.onStop();
    }
}
