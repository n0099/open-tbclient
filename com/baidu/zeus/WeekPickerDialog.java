package com.baidu.zeus;

import android.content.Context;
import android.content.DialogInterface;
import java.util.Calendar;
/* loaded from: classes.dex */
class WeekPickerDialog extends DatePickerDialog {
    public WeekPickerDialog(Context context, String str, String str2, JsPromptResult jsPromptResult) {
        this(context, 0, str, str2, jsPromptResult);
    }

    public WeekPickerDialog(Context context, int i, String str, String str2, JsPromptResult jsPromptResult) {
        super(context, i, str, str2, jsPromptResult);
        setTitle(PickerHelper.getStringById(WebChromeClient.STRING_DLG_TITLE_WEEK, "Set Week"));
    }

    @Override // com.baidu.zeus.DatePickerDialog, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.mDatePicker.clearFocus();
        if (this.mRes != null) {
            if (i == -1) {
                this.mRes.confirm("");
            } else if (i == -3) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(this.mDatePicker.getYear(), this.mDatePicker.getMonth(), this.mDatePicker.getDayOfMonth());
                this.mRes.confirm(String.format("%d-W%d", Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(3))));
            } else {
                this.mRes.cancel();
            }
            this.mRes.setReady();
            this.mRes = null;
        }
    }
}
