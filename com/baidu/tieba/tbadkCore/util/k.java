package com.baidu.tieba.tbadkCore.util;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.bm;
import java.util.Map;
/* loaded from: classes.dex */
public class k {
    private static String bAk = "tbgametype";

    public static String is(String str) {
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

    public static boolean hw(String str) {
        Map<String, String> cH;
        if (!TextUtils.isEmpty(str) && (cH = bm.cH(bm.cI(str))) != null) {
            String str2 = cH.get(bAk);
            return !TextUtils.isEmpty(str2) && str2.equals("1");
        }
        return false;
    }
}
