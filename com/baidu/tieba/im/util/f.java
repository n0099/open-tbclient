package com.baidu.tieba.im.util;

import android.text.Editable;
import android.text.TextUtils;
import android.widget.EditText;
/* loaded from: classes3.dex */
public class f {
    public static int d(EditText editText) {
        if (editText == null) {
            return 0;
        }
        return a(editText.getText());
    }

    public static int a(Editable editable) {
        if (editable == null) {
            return 0;
        }
        return hK(editable.toString());
    }

    public static int d(char c) {
        if (e(c)) {
            return 1;
        }
        return 2;
    }

    public static boolean e(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || ((c >= '0' && c <= '9') || c == ' ');
    }

    public static int hK(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (e(str.charAt(i2))) {
                i++;
            } else {
                i += 2;
            }
        }
        return i;
    }

    public static int e(EditText editText) {
        Editable text;
        if (editText == null || (text = editText.getText()) == null) {
            return 0;
        }
        String obj = text.toString();
        if (TextUtils.isEmpty(obj)) {
            return 0;
        }
        String trim = obj.trim();
        if (TextUtils.isEmpty(trim)) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < trim.length(); i2++) {
            if (e(trim.charAt(i2))) {
                i++;
            } else {
                i += 2;
            }
        }
        return i;
    }

    public static boolean f(EditText editText) {
        String obj = editText.getText().toString();
        int length = obj.length();
        String trim = obj.trim();
        int length2 = trim.length();
        if (length2 < length) {
            editText.setText(trim);
            editText.setSelection(length2);
            return false;
        }
        return true;
    }
}
