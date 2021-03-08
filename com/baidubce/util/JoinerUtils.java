package com.baidubce.util;

import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class JoinerUtils {
    public static String on(String str, List<String> list) {
        Iterator<String> it;
        String str2 = "";
        while (true) {
            String str3 = str2;
            if (list.iterator().hasNext()) {
                str2 = str3 + it.next() + str;
            } else {
                return str3.substring(0, str3.length() - 1);
            }
        }
    }

    public static String on(String str, Object... objArr) {
        String str2 = "";
        for (int i = 0; i < objArr.length; i++) {
            str2 = str2 + objArr[i] + str;
        }
        return str2.substring(0, str2.length() - 1);
    }

    public static String cut(String str, String str2) {
        return str2.replace(str, "");
    }
}
