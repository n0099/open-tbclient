package com.baidu.tieba.tbadkCore.util;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.be;
import java.util.Map;
/* loaded from: classes.dex */
public class n {
    private static String cMz = "tbgametype";

    public static String mQ(String str) {
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

    public static boolean kB(String str) {
        Map<String, String> dB;
        if (!TextUtils.isEmpty(str) && (dB = be.dB(be.dC(str))) != null) {
            String str2 = dB.get(cMz);
            return !TextUtils.isEmpty(str2) && str2.equals("1");
        }
        return false;
    }
}
