package com.baidu.tieba.realauthen.b;

import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.u.a;
import java.lang.reflect.Field;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class a {
    public static void a(EditText editText, InputFilter[] inputFilterArr) {
        if (editText != null) {
            editText.setFilters(inputFilterArr);
        }
    }

    public static boolean p(CharSequence charSequence) {
        return Pattern.compile("[^一-龥]").matcher(charSequence).find();
    }

    public static void f(EditText editText) {
        a(editText, new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.realauthen.b.a.1
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                if (TextUtils.isEmpty(charSequence)) {
                    return "";
                }
                while (i < i2) {
                    if (!a.p(charSequence) || charSequence.toString().contains("·") || charSequence.toString().contains("•")) {
                        i++;
                    } else {
                        return "";
                    }
                }
                return null;
            }
        }});
    }

    public static void g(EditText editText) {
        if (editText != null) {
            try {
                Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField.setAccessible(true);
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    declaredField.set(editText, Integer.valueOf(a.f.sdk_cursor_hk_bg));
                } else {
                    declaredField.set(editText, Integer.valueOf(a.f.sdk_cursor_qm_bg));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
