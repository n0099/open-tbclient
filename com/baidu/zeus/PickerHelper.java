package com.baidu.zeus;

import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class PickerHelper {
    static final String BTN_CANCEL = "Cancel";
    static final String BTN_CLEAR = "Clear";
    static final String BTN_SET = "Set";
    static final String TITLE_COLOR = "Set Color";
    static final String TITLE_DATE = "Set Date";
    static final String TITLE_DATETIME = "Set Date And Time";
    static final String TITLE_MONTH = "Set Month";
    static final String TITLE_TIME = "Set Time";
    static final String TITLE_WEEK = "Set Week";
    static WebChromeClient mWebChromeClient = null;

    PickerHelper() {
    }

    public static String getStringById(int i, String str) {
        String stringById;
        return (mWebChromeClient == null || (stringById = mWebChromeClient.getStringById(i)) == null || stringById.length() == 0) ? str : stringById;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Calendar getCalendar(String str, String str2) {
        Calendar calendar = Calendar.getInstance();
        if (str == null || str.length() <= 0) {
            return calendar;
        }
        try {
            SimpleDateFormat simpleDateFormat = (SimpleDateFormat) DateFormat.getTimeInstance();
            simpleDateFormat.applyPattern(str2);
            calendar.setTime(simpleDateFormat.parse(str));
            return calendar;
        } catch (Exception e) {
            return Calendar.getInstance();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void hideCalendarViewIfNeeded(DatePicker datePicker) {
        if (datePicker != null) {
            try {
                ((View) datePicker.getClass().getDeclaredMethod("getCalendarView", new Class[0]).invoke(datePicker, new Object[0])).setVisibility(8);
            } catch (Exception e) {
                Log.i("BaiduBrowser", "ok, android 2.x no such method!");
            }
        }
    }
}
