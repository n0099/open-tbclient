package com.baidu.tieba.im.util;

import android.text.Editable;
import android.text.TextUtils;
import android.widget.EditText;
/* loaded from: classes.dex */
public final class o {
    public static int a(EditText editText) {
        Editable text;
        if (editText == null || (text = editText.getText()) == null) {
            return 0;
        }
        return a(text.toString());
    }

    public static boolean a(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || ((c >= '0' && c <= '9') || c == ' ');
    }

    public static int a(String str) {
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
}
