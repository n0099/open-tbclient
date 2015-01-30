package com.baidu.tieba.tbadkCore.util;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.bm;
import java.util.Map;
/* loaded from: classes.dex */
public class k {
    private static String bAl = "tbgametype";

    public static String iu(String str) {
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

    public static boolean hz(String str) {
        Map<String, String> cK;
        if (!TextUtils.isEmpty(str) && (cK = bm.cK(bm.cL(str))) != null) {
            String str2 = cK.get(bAl);
            return !TextUtils.isEmpty(str2) && str2.equals("1");
        }
        return false;
    }
}
