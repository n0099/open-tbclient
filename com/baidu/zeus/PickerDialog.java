package com.baidu.zeus;

import android.app.Dialog;
import android.content.Context;
/* loaded from: classes.dex */
final class PickerDialog {
    PickerDialog() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void showDialog(Context context, int i, String str, JsPromptResult jsPromptResult, WebChromeClient webChromeClient) {
        PickerHelper.mWebChromeClient = webChromeClient;
        Dialog createDialog = createDialog(context, i, str, jsPromptResult);
        if (createDialog != null) {
            createDialog.show();
        } else if (jsPromptResult != null) {
            jsPromptResult.cancel();
            jsPromptResult.setReady();
        }
    }

    private static Dialog createDialog(Context context, int i, String str, JsPromptResult jsPromptResult) {
        switch (i) {
            case 9000:
                return new ColorPickerDialog(context, str, jsPromptResult);
            case 9001:
                return new DatePickerDialog(context, str, "yyyy-MM-dd", jsPromptResult);
            case 9002:
                return new TimePickerDialog(context, str, "HH:mm", jsPromptResult);
            case 9003:
                return new DateTimePickerDialog(context, str, "yyyy-MM-dd'T'HH:mm'Z'", jsPromptResult, i == 9006);
            case 9004:
                return new WeekPickerDialog(context, str, "yyyy-'W'ww", jsPromptResult);
            case 9005:
                return new MonthPickerDialog(context, str, "yyyy-MM", jsPromptResult);
            case 9006:
                return new DateTimePickerDialog(context, str, "yyyy-MM-dd'T'HH:mm", jsPromptResult, i == 9006);
            default:
                return null;
        }
    }
}
