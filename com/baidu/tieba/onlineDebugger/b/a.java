package com.baidu.tieba.onlineDebugger.b;
/* loaded from: classes.dex */
public class a {
    public void ls(String str) {
        char[] charArray;
        if (str == null) {
            throw new RuntimeException("command null");
        }
        if (str.length() == 0) {
            throw new RuntimeException("command empty");
        }
        for (char c : str.toCharArray()) {
            if ((c < '0' || c > '9') && ((c < 'a' || c > 'z') && ((c < 'A' || c > 'Z') && c != ' ' && c != '_' && c != '=' && c != '.' && c != ',' && c != '(' && c != ')' && c != '$' && c != '#' && c != ' ' && (c < 19968 || c > 40891)))) {
                throw new RuntimeException("command has illegal char " + c + ":" + str);
            }
        }
    }
}
