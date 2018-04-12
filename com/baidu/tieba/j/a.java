package com.baidu.tieba.j;

import com.baidu.ar.util.Constants;
/* loaded from: classes.dex */
public class a {
    public static String g(Throwable th) {
        if (th == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(th.toString());
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace != null) {
            for (int i = 0; i < stackTrace.length; i++) {
                StackTraceElement stackTraceElement = stackTrace[i];
                if (stackTraceElement != null && i < 7) {
                    sb.append(" ----> ").append(stackTraceElement.getClassName()).append(Constants.DOT).append(stackTraceElement.getMethodName()).append("()");
                }
            }
        }
        return sb.toString();
    }
}
