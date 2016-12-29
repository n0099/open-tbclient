package com.baidu.tieba.tbadkCore.util;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.bc;
import java.util.Map;
/* loaded from: classes.dex */
public class m {
    private static String eia = "tbgametype";

    public static String qr(String str) {
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

    public static boolean oh(String str) {
        Map<String, String> dI;
        if (!TextUtils.isEmpty(str) && (dI = bc.dI(bc.dJ(str))) != null) {
            String str2 = dI.get(eia);
            return !TextUtils.isEmpty(str2) && str2.equals("1");
        }
        return false;
    }
}
