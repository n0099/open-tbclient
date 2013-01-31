package com.baidu.zeus;

import android.content.Context;
import android.util.Log;
/* loaded from: classes.dex */
public class ErrorStrings {
    private static final String LOGTAG = "Http";

    private ErrorStrings() {
    }

    public static String getString(int i, Context context) {
        return context.getText(getResource(i)).toString();
    }

    public static int getResource(int i) {
        switch (i) {
            case -15:
                return 17039612;
            case -14:
                return 17039611;
            case -13:
                return 17039610;
            case -12:
                return 17039367;
            case -11:
                return 17039609;
            case -10:
                return 17039368;
            case -9:
                return 17039608;
            case -8:
                return 17039607;
            case -7:
                return 17039606;
            case -6:
                return 17039605;
            case -5:
                return 17039604;
            case -4:
                return 17039603;
            case -3:
                return 17039602;
            case -2:
                return 17039601;
            case -1:
                return 17039600;
            case 0:
                return 17039599;
            default:
                Log.w(LOGTAG, "Using generic message for unknown error code: " + i);
                return 17039600;
        }
    }
}
