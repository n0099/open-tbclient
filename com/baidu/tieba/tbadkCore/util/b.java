package com.baidu.tieba.tbadkCore.util;

import android.text.TextUtils;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes.dex */
public class b {
    private static String glz = "tbgametype";

    public static String wh(String str) {
        String[] split;
        if (TextUtils.isEmpty(str) || (split = str.split(":")) == null) {
            return null;
        }
        for (String str2 : split) {
            if (!TextUtils.isEmpty(str2) && str2.contains("TBCGameID=")) {
                int indexOf = str2.indexOf(ETAG.EQUAL);
                if (indexOf + 1 >= str2.length()) {
                    return "";
                }
                return str2.substring(indexOf + 1, str2.length());
            }
        }
        return "";
    }
}
