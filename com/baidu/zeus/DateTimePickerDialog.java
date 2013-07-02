package com.baidu.zeus;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TimePicker;
import java.util.Calendar;
/* loaded from: classes.dex */
class DateTimePickerDialog extends AlertDialog implements DialogInterface.OnClickListener, DatePicker.OnDateChangedListener, TimePicker.OnTimeChangedListener {
    private static final String DAY = "day";
    private static final String HOUR = "hour";
    private static final String IS_24_HOUR = "is24hour";
    private static final String MINUTE = "minute";
    private static final String MONTH = "month";
    private static final String YEAR = "year";
    private final DatePicker mDatePicker;
    boolean mDateTimeLocal;
    private final String mDateTimeString;
    private final String mDateTimeStringLocal;
    private DialogInterface.OnDismissListener mDlgDismissListener;
    boolean mIs24HourView;
    JsPromptResult mRes;
    private final TimePicker mTimePicker;
    String mValue;

    @Override // android.app.Dialog
    public Bundle onSaveInstanceState() {
        Bundle onSaveInstanceState = super.onSaveInstanceState();
        onSaveInstanceState.putInt(YEAR, this.mDatePicker.getYear());
        onSaveInstanceState.putInt(MONTH, this.mDatePicker.getMonth());
        onSaveInstanceState.putInt(DAY, this.mDatePicker.getDayOfMonth());
        onSaveInstanceState.putInt(HOUR, this.mTimePicker.getCurrentHour().intValue());
        onSaveInstanceState.putInt(MINUTE, this.mTimePicker.getCurrentMinute().intValue());
        onSaveInstanceState.putBoolean(IS_24_HOUR, this.mTimePicker.is24HourView());
        return onSaveInstanceState;
    }

    public DateTimePickerDialog(Context context, String str, String str2, JsPromptResult jsPromptResult, boolean z) {
        this(context, 0, str, str2, jsPromptResult, z);
    }

    public DateTimePickerDialog(Context context, int i, String str, String str2, JsPromptResult jsPromptResult, boolean z) {
        super(context, i);
        this.mDateTimeLocal = false;
        this.mDlgDismissListener = new DialogInterface.OnDismissListener() { // from class: com.baidu.zeus.DateTimePickerDialog.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (DateTimePickerDialog.this.mRes != null) {
                    DateTimePickerDialog.this.mRes.cancel();
                    DateTimePickerDialog.this.mRes.setReady();
                    DateTimePickerDialog.this.mRes = null;
                }
            }
        };
        this.mDateTimeString = "%d-%02d-%02dT%02d:%02dZ";
        this.mDateTimeStringLocal = "%d-%02d-%02dT%02d:%02d";
        this.mRes = jsPromptResult;
        this.mDateTimeLocal = z;
        this.mIs24HourView = true;
        setButton(-1, PickerHelper.getStringById(WebChromeClient.STRING_DLG_BTN_CLEAR, "Clear"), this);
        setButton(-3, PickerHelper.getStringById(WebChromeClient.STRING_DLG_BTN_SET, "Set"), this);
        setButton(-2, PickerHelper.getStringById(WebChromeClient.STRING_DLG_BTN_CANCEL, "Cancel"), this);
        setTitle(PickerHelper.getStringById(WebChromeClient.STRING_DLG_TITLE_DATETIME, "Set Date And Time"));
        this.mDatePicker = new DatePicker(context);
        PickerHelper.hideCalendarViewIfNeeded(this.mDatePicker);
        DatePicker datePicker = this.mDatePicker;
        this.mTimePicker = new TimePicker(context);
        TimePicker timePicker = this.mTimePicker;
        initDateTimePicker(str, str2);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        linearLayout.addView(this.mDatePicker, layoutParams);
        linearLayout.addView(this.mTimePicker, layoutParams);
        setView(linearLayout);
        setOnDismissListener(this.mDlgDismissListener);
    }

    void initDateTimePicker(String str, String str2) {
        int i = 1900;
        Calendar calendar = PickerHelper.getCalendar(str, str2);
        int i2 = calendar.get(1);
        if (i2 >= 1900) {
            i = i2 > 2100 ? 2100 : i2;
        }
        this.mDatePicker.init(i, calendar.get(2), calendar.get(5), this);
        this.mTimePicker.setIs24HourView(Boolean.valueOf(this.mIs24HourView));
        this.mTimePicker.setCurrentHour(Integer.valueOf(calendar.get(11)));
        this.mTimePicker.setCurrentMinute(Integer.valueOf(calendar.get(12)));
        this.mTimePicker.setOnTimeChangedListener(this);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.mTimePicker.clearFocus();
        this.mDatePicker.clearFocus();
        if (this.mRes != null) {
            String str = this.mDateTimeLocal ? "%d-%02d-%02dT%02d:%02d" : "%d-%02d-%02dT%02d:%02dZ";
            if (i == -1) {
                this.mRes.confirm("");
            } else if (i == -3) {
                this.mRes.confirm(String.format(str, Integer.valueOf(this.mDatePicker.getYear()), Integer.valueOf(this.mDatePicker.getMonth() + 1), Integer.valueOf(this.mDatePicker.getDayOfMonth()), this.mTimePicker.getCurrentHour(), this.mTimePicker.getCurrentMinute()));
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

    public void updateTime(int i, int i2) {
        this.mTimePicker.setCurrentHour(Integer.valueOf(i));
        this.mTimePicker.setCurrentMinute(Integer.valueOf(i2));
    }

    @Override // android.widget.TimePicker.OnTimeChangedListener
    public void onTimeChanged(TimePicker timePicker, int i, int i2) {
    }

    @Override // android.app.Dialog
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.mDatePicker.init(bundle.getInt(YEAR), bundle.getInt(MONTH), bundle.getInt(DAY), this);
        int i = bundle.getInt(HOUR);
        int i2 = bundle.getInt(MINUTE);
        this.mTimePicker.setIs24HourView(Boolean.valueOf(bundle.getBoolean(IS_24_HOUR)));
        this.mTimePicker.setCurrentHour(Integer.valueOf(i));
        this.mTimePicker.setCurrentMinute(Integer.valueOf(i2));
    }
}
