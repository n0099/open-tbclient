package com.baidu.tieba.tbadkCore.util;

import android.text.TextUtils;
import com.baidu.mobstat.Config;
/* loaded from: classes.dex */
public class b {
    private static String hBv = "tbgametype";

    public static String CK(String str) {
        String[] split;
        if (TextUtils.isEmpty(str) || (split = str.split(Config.TRACE_TODAY_VISIT_SPLIT)) == null) {
            return null;
        }
        for (String str2 : split) {
            if (!TextUtils.isEmpty(str2) && str2.contains("TBCGameID=")) {
                int indexOf = str2.indexOf("=");
                if (indexOf + 1 >= str2.length()) {
                    return "";
                }
                return str2.substring(indexOf + 1, str2.length());
            }
        }
        return "";
    }
}
