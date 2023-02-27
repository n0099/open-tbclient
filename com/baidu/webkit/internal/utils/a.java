package com.baidu.webkit.internal.utils;

import java.io.File;
import java.util.Stack;
/* loaded from: classes7.dex */
public final class a {
    public static String a = "none";

    public static boolean a(File file) {
        return file.setReadable(true, false);
    }

    public static boolean a(String str) {
        StringBuilder sb;
        Stack stack = new Stack();
        if (str == null) {
            return false;
        }
        stack.push(str);
        while (stack.size() > 0) {
            String str2 = (String) stack.pop();
            File file = new File(str2);
            if (file.isDirectory()) {
                String[] list = file.list();
                if (list != null && list.length > 0) {
                    stack.push(str2);
                    String str3 = str2 + "/";
                    for (String str4 : file.list()) {
                        stack.push(str3 + str4);
                    }
                } else if (!file.delete()) {
                    sb = new StringBuilder("remove fail, can not delete file = ");
                    sb.append(file.getAbsolutePath());
                    a = sb.toString();
                    return false;
                }
            } else if (!file.delete()) {
                sb = new StringBuilder("remove fail, can not delete file = ");
                sb.append(file.getAbsolutePath());
                a = sb.toString();
                return false;
            }
        }
        return true;
    }
}
