package com.baidu.tieba.tbadkCore.util;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.bi;
import java.util.Map;
/* loaded from: classes.dex */
public class n {
    private static String evk = "tbgametype";

    public static String rb(String str) {
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

    public static boolean pc(String str) {
        Map<String, String> dF;
        if (!TextUtils.isEmpty(str) && (dF = bi.dF(bi.dG(str))) != null) {
            String str2 = dF.get(evk);
            return !TextUtils.isEmpty(str2) && str2.equals("1");
        }
        return false;
    }
}
