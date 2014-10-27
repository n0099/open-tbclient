package com.baidu.tieba.im.util;

import android.text.Editable;
import android.text.TextUtils;
import android.widget.EditText;
/* loaded from: classes.dex */
public class j {
    public static int b(EditText editText) {
        if (editText == null) {
            return 0;
        }
        return a(editText.getText());
    }

    public static int a(Editable editable) {
        if (editable == null) {
            return 0;
        }
        return fy(editable.toString());
    }

    public static int b(char c) {
        if (a(c)) {
            return 1;
        }
        return 2;
    }

    public static boolean a(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || ((c >= '0' && c <= '9') || c == ' ');
    }

    public static int fy(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (a(str.charAt(i2))) {
                i++;
            } else {
                i += 2;
            }
        }
        return i;
    }

    public static int c(EditText editText) {
        Editable text;
        if (editText == null || (text = editText.getText()) == null) {
            return 0;
        }
        String editable = text.toString();
        if (TextUtils.isEmpty(editable)) {
            return 0;
        }
        String trim = editable.trim();
        if (TextUtils.isEmpty(trim)) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < trim.length(); i2++) {
            if (a(trim.charAt(i2))) {
                i++;
            } else {
                i += 2;
            }
        }
        return i;
    }

    public static boolean d(EditText editText) {
        String editable = editText.getText().toString();
        int length = editable.length();
        String trim = editable.trim();
        int length2 = trim.length();
        if (length2 < length) {
            editText.setText(trim);
            editText.setSelection(length2);
            return false;
        }
        return true;
    }

    public static String g(String str, int i, int i2) {
        StringBuilder sb = new StringBuilder();
        if (TextUtils.isEmpty(str) || i > i2) {
            return sb.toString();
        }
        if (i >= 0 && i2 >= 0) {
            int i3 = 0;
            for (int i4 = 0; i4 < str.length(); i4++) {
                char charAt = str.charAt(i4);
                if (i3 >= i2) {
                    return sb.toString();
                }
                if (i3 >= i) {
                    sb.append(charAt);
                }
                if (a(charAt)) {
                    i3++;
                } else {
                    i3 += 2;
                }
            }
        }
        return sb.toString();
    }
}
