package com.baidu.zeus;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
/* loaded from: classes.dex */
class MonthPickerDialog extends DatePickerDialog {
    public MonthPickerDialog(Context context, String str, String str2, JsPromptResult jsPromptResult) {
        this(context, 0, str, str2, jsPromptResult);
    }

    public MonthPickerDialog(Context context, int i, String str, String str2, JsPromptResult jsPromptResult) {
        super(context, i, str, str2, jsPromptResult);
        setTitle(PickerHelper.getStringById(103, "Set Month"));
        View findViewById = this.mView.findViewById(16908673);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
    }

    @Override // com.baidu.zeus.DatePickerDialog, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.mDatePicker.clearFocus();
        if (this.mRes != null) {
            if (i == -1) {
                this.mRes.confirm("");
            } else if (i == -3) {
                this.mRes.confirm(String.format("%d-%02d", Integer.valueOf(this.mDatePicker.getYear()), Integer.valueOf(this.mDatePicker.getMonth() + 1)));
            } else {
                this.mRes.cancel();
            }
            this.mRes.setReady();
            this.mRes = null;
        }
    }
}
