package com.baidu.zeus;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.TimePicker;
import java.util.Calendar;
/* loaded from: classes.dex */
class TimePickerDialog extends AlertDialog implements DialogInterface.OnClickListener, TimePicker.OnTimeChangedListener {
    private static final String HOUR = "hour";
    private static final String IS_24_HOUR = "is24hour";
    private static final String MINUTE = "minute";
    private DialogInterface.OnDismissListener mDlgDismissListener;
    boolean mIs24HourView;
    JsPromptResult mRes;
    private final TimePicker mTimePicker;

    public TimePickerDialog(Context context, String str, String str2, JsPromptResult jsPromptResult) {
        this(context, 0, str, str2, jsPromptResult);
    }

    public TimePickerDialog(Context context, int i, String str, String str2, JsPromptResult jsPromptResult) {
        super(context, i);
        this.mDlgDismissListener = new DialogInterface.OnDismissListener() { // from class: com.baidu.zeus.TimePickerDialog.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (TimePickerDialog.this.mRes != null) {
                    TimePickerDialog.this.mRes.cancel();
                    TimePickerDialog.this.mRes.setReady();
                    TimePickerDialog.this.mRes = null;
                }
            }
        };
        this.mIs24HourView = true;
        this.mRes = jsPromptResult;
        setButton(-1, PickerHelper.getStringById(WebChromeClient.STRING_DLG_BTN_CLEAR, "Clear"), this);
        setButton(-3, PickerHelper.getStringById(WebChromeClient.STRING_DLG_BTN_SET, "Set"), this);
        setButton(-2, PickerHelper.getStringById(WebChromeClient.STRING_DLG_BTN_CANCEL, "Cancel"), this);
        setTitle(PickerHelper.getStringById(WebChromeClient.STRING_DLG_TITLE_TIME, "Set Time"));
        this.mTimePicker = new TimePicker(context);
        setView(this.mTimePicker);
        initTimePicker(str, str2);
        setOnDismissListener(this.mDlgDismissListener);
    }

    void initTimePicker(String str, String str2) {
        Calendar calendar = PickerHelper.getCalendar(str, str2);
        this.mTimePicker.setIs24HourView(Boolean.valueOf(this.mIs24HourView));
        this.mTimePicker.setCurrentHour(Integer.valueOf(calendar.get(11)));
        this.mTimePicker.setCurrentMinute(Integer.valueOf(calendar.get(12)));
        this.mTimePicker.setOnTimeChangedListener(this);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.mTimePicker.clearFocus();
        if (this.mRes != null) {
            if (i == -3) {
                this.mRes.confirm(String.format("%02d:%02d", this.mTimePicker.getCurrentHour(), this.mTimePicker.getCurrentMinute()));
            } else if (i == -1) {
                this.mRes.confirm("");
            } else {
                this.mRes.cancel();
            }
            this.mRes.setReady();
            this.mRes = null;
        }
    }

    public void updateTime(int i, int i2) {
        this.mTimePicker.setCurrentHour(Integer.valueOf(i));
        this.mTimePicker.setCurrentMinute(Integer.valueOf(i2));
    }

    @Override // android.widget.TimePicker.OnTimeChangedListener
    public void onTimeChanged(TimePicker timePicker, int i, int i2) {
    }

    @Override // android.app.Dialog
    public Bundle onSaveInstanceState() {
        Bundle onSaveInstanceState = super.onSaveInstanceState();
        onSaveInstanceState.putInt(HOUR, this.mTimePicker.getCurrentHour().intValue());
        onSaveInstanceState.putInt(MINUTE, this.mTimePicker.getCurrentMinute().intValue());
        onSaveInstanceState.putBoolean(IS_24_HOUR, this.mTimePicker.is24HourView());
        return onSaveInstanceState;
    }

    @Override // android.app.Dialog
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        int i = bundle.getInt(HOUR);
        int i2 = bundle.getInt(MINUTE);
        this.mTimePicker.setIs24HourView(Boolean.valueOf(bundle.getBoolean(IS_24_HOUR)));
        this.mTimePicker.setCurrentHour(Integer.valueOf(i));
        this.mTimePicker.setCurrentMinute(Integer.valueOf(i2));
    }
}
