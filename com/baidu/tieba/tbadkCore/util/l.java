package com.baidu.tieba.tbadkCore.util;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.ax;
import java.util.Map;
/* loaded from: classes.dex */
public class l {
    private static String caG = "tbgametype";

    public static String kC(String str) {
        String[] split;
        if (TextUtils.isEmpty(str) || (split = str.split(":")) == null) {
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

    public static boolean ji(String str) {
        Map<String, String> df;
        if (!TextUtils.isEmpty(str) && (df = ax.df(ax.dg(str))) != null) {
            String str2 = df.get(caG);
            return !TextUtils.isEmpty(str2) && str2.equals("1");
        }
        return false;
    }
}
