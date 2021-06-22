package com.baidubce.util;

import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class JoinerUtils {
    public static String cut(String str, String str2) {
        return str2.replace(str, "");
    }

    public static String on(String str, List<String> list) {
        Iterator<String> it;
        String str2 = "";
        while (list.iterator().hasNext()) {
            str2 = str2 + it.next() + str;
        }
        return str2.substring(0, str2.length() - 1);
    }

    public static String on(String str, Object... objArr) {
        String str2 = "";
        for (Object obj : objArr) {
            str2 = str2 + obj + str;
        }
        return str2.substring(0, str2.length() - 1);
    }
}
