package com.baidu.zeus;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import java.util.Calendar;
/* loaded from: classes.dex */
class DatePickerDialog extends AlertDialog implements DialogInterface.OnClickListener, DatePicker.OnDateChangedListener {
    private static final String DAY = "day";
    private static final String MONTH = "month";
    private static final String YEAR = "year";
    final DatePicker mDatePicker;
    private DialogInterface.OnDismissListener mDlgDismissListener;
    JsPromptResult mRes;
    View mView;

    void initDatePicker(String str, String str2) {
        int i = 1900;
        Calendar calendar = PickerHelper.getCalendar(str, str2);
        int i2 = calendar.get(1);
        if (i2 >= 1900) {
            i = i2 > 2100 ? 2100 : i2;
        }
        this.mDatePicker.init(i, calendar.get(2), calendar.get(5), this);
    }

    public DatePickerDialog(Context context, String str, String str2, JsPromptResult jsPromptResult) {
        this(context, 0, str, str2, jsPromptResult);
    }

    public DatePickerDialog(Context context, int i, String str, String str2, JsPromptResult jsPromptResult) {
        super(context, i);
        this.mDlgDismissListener = new DialogInterface.OnDismissListener() { // from class: com.baidu.zeus.DatePickerDialog.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (DatePickerDialog.this.mRes != null) {
                    DatePickerDialog.this.mRes.cancel();
                    DatePickerDialog.this.mRes.setReady();
                    DatePickerDialog.this.mRes = null;
                }
            }
        };
        this.mRes = jsPromptResult;
        setButton(-1, PickerHelper.getStringById(152, "Clear"), this);
        setButton(-3, PickerHelper.getStringById(150, "Set"), this);
        setButton(-2, PickerHelper.getStringById(151, "Cancel"), this);
        setTitle(PickerHelper.getStringById(100, "Set Date"));
        this.mDatePicker = new DatePicker(context);
        PickerHelper.hideCalendarViewIfNeeded(this.mDatePicker);
        DatePicker datePicker = this.mDatePicker;
        initDatePicker(str, str2);
        setOnDismissListener(this.mDlgDismissListener);
        setView(datePicker);
        this.mView = datePicker;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.mDatePicker.clearFocus();
        if (this.mRes != null) {
            if (i == -1) {
                Calendar.getInstance();
                this.mRes.confirm("");
            } else if (i == -3) {
                this.mRes.confirm(String.format("%d-%02d-%02d", Integer.valueOf(this.mDatePicker.getYear()), Integer.valueOf(this.mDatePicker.getMonth() + 1), Integer.valueOf(this.mDatePicker.getDayOfMonth())));
            } else {
                this.mRes.cancel();
            }
            this.mRes.setReady();
            this.mRes = null;
        }
    }

    @Override // android.widget.DatePicker.OnDateChangedListener
    public void onDateChanged(DatePicker datePicker, int i, int i2, int i3) {
        this.mDatePicker.init(i, i2, i3, null);
    }

    public DatePicker getDatePicker() {
        return this.mDatePicker;
    }

    public void updateDate(int i, int i2, int i3) {
        this.mDatePicker.updateDate(i, i2, i3);
    }

    @Override // android.app.Dialog
    public Bundle onSaveInstanceState() {
        Bundle onSaveInstanceState = super.onSaveInstanceState();
        onSaveInstanceState.putInt(YEAR, this.mDatePicker.getYear());
        onSaveInstanceState.putInt(MONTH, this.mDatePicker.getMonth());
        onSaveInstanceState.putInt(DAY, this.mDatePicker.getDayOfMonth());
        return onSaveInstanceState;
    }

    @Override // android.app.Dialog
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.mDatePicker.init(bundle.getInt(YEAR), bundle.getInt(MONTH), bundle.getInt(DAY), this);
    }
}
