package com.baidu.webkit.internal.utils;

import java.io.File;
import java.util.Stack;
/* loaded from: classes2.dex */
public final class a {
    private static String a = "none";

    public static boolean a(String str) {
        String[] list;
        Stack stack = new Stack();
        if (str == null) {
            return false;
        }
        stack.push(str);
        while (stack.size() > 0) {
            String str2 = (String) stack.pop();
            File file = new File(str2);
            if (file.isDirectory()) {
                String[] list2 = file.list();
                if (list2 != null && list2.length > 0) {
                    stack.push(str2);
                    String str3 = str2 + "/";
                    int length = file.list().length;
                    for (int i = 0; i < length; i++) {
                        stack.push(str3 + list[i]);
                    }
                } else if (!file.delete()) {
                    a = "remove fail, can not delete file = " + file.getAbsolutePath();
                    return false;
                }
            } else if (!file.delete()) {
                a = "remove fail, can not delete file = " + file.getAbsolutePath();
                return false;
            }
        }
        return true;
    }
}
