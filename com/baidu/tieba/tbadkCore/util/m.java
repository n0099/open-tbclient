package com.baidu.tieba.tbadkCore.util;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.bf;
import java.util.Map;
/* loaded from: classes.dex */
public class m {
    private static String eEa = "tbgametype";

    public static String rL(String str) {
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

    public static boolean pF(String str) {
        Map<String, String> dK;
        if (!TextUtils.isEmpty(str) && (dK = bf.dK(bf.dL(str))) != null) {
            String str2 = dK.get(eEa);
            return !TextUtils.isEmpty(str2) && str2.equals("1");
        }
        return false;
    }
}
