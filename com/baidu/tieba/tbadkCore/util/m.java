package com.baidu.tieba.tbadkCore.util;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.ba;
import java.util.Map;
/* loaded from: classes.dex */
public class m {
    private static String erk = "tbgametype";

    public static String qL(String str) {
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

    public static boolean ox(String str) {
        Map<String, String> dG;
        if (!TextUtils.isEmpty(str) && (dG = ba.dG(ba.dH(str))) != null) {
            String str2 = dG.get(erk);
            return !TextUtils.isEmpty(str2) && str2.equals("1");
        }
        return false;
    }
}
