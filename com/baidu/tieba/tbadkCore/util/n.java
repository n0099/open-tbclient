package com.baidu.tieba.tbadkCore.util;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.bf;
import java.util.Map;
/* loaded from: classes.dex */
public class n {
    private static String cFg = "tbgametype";

    public static String mA(String str) {
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

    public static boolean kx(String str) {
        Map<String, String> dE;
        if (!TextUtils.isEmpty(str) && (dE = bf.dE(bf.dF(str))) != null) {
            String str2 = dE.get(cFg);
            return !TextUtils.isEmpty(str2) && str2.equals("1");
        }
        return false;
    }
}
