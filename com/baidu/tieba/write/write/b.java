package com.baidu.tieba.write.write;

import android.text.Editable;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.widget.EditText;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public class b {
    private String daw;
    private final String lDF = "@[\\u4e00-\\u9fa5\\w\\ud83c\\udc00-\\ud83c\\udfff\\ud83d\\udc00-\\ud83d\\udfff\\u2600-\\u27ff]+";
    private ArrayList<String> lwO;

    public void a(EditText editText, boolean z) {
        Editable text;
        Object[] spans;
        if (editText != null && (text = editText.getText()) != null) {
            for (Object obj : text.getSpans(0, text.length(), Object.class)) {
                if ((obj instanceof ForegroundColorSpan) || (obj instanceof BackgroundColorSpan)) {
                    text.removeSpan(obj);
                }
            }
            com.baidu.tbadk.plugins.b.a(text);
            if (!z) {
                c(text);
            }
            b((Spannable) text);
        }
    }

    private void b(Spannable spannable) {
        if (spannable != null && !v.isEmpty(this.lwO)) {
            String obj = spannable.toString();
            if (!TextUtils.isEmpty(obj)) {
                Iterator<String> it = this.lwO.iterator();
                while (it.hasNext()) {
                    a(spannable, obj, it.next());
                }
            }
        }
    }

    private void a(Spannable spannable, String str, String str2) {
        if (spannable != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            int indexOf = str.indexOf(str2);
            int length = str2.length();
            while (indexOf >= 0) {
                int i = indexOf + length;
                int color = am.getColor(R.color.cp_cont_a);
                int color2 = am.getColor(R.color.cp_cont_h_alpha85);
                ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(color);
                BackgroundColorSpan backgroundColorSpan = new BackgroundColorSpan(color2);
                spannable.setSpan(foregroundColorSpan, indexOf, i, 33);
                spannable.setSpan(backgroundColorSpan, indexOf, i, 33);
                indexOf = str.indexOf(str2, i);
            }
        }
    }

    public int b(Spanned spanned) {
        if (spanned == null) {
            return 0;
        }
        BackgroundColorSpan[] backgroundColorSpanArr = (BackgroundColorSpan[]) spanned.getSpans(0, spanned.length(), BackgroundColorSpan.class);
        return (backgroundColorSpanArr == null || backgroundColorSpanArr.length <= 0) ? spanned.length() : spanned.getSpanEnd(backgroundColorSpanArr[0]);
    }

    public boolean h(EditText editText) {
        Editable text;
        if (editText == null || (text = editText.getText()) == null) {
            return false;
        }
        int b = b((Spanned) text);
        if (b > 0) {
            editText.requestFocus();
            editText.setSelection(b);
            return true;
        }
        editText.setSelection(editText.getSelectionEnd());
        return false;
    }

    public boolean a(EditText editText, EditText editText2) {
        if (v.isEmpty(deQ())) {
            return false;
        }
        return h(editText) || h(editText2);
    }

    public void b(EditText editText, EditText editText2) {
        b(editText, true);
        b(editText2, false);
        a(editText, editText2);
    }

    public void c(EditText editText, EditText editText2) {
        b(editText, editText2);
    }

    public void b(EditText editText, boolean z) {
        if (editText != null) {
            a(editText, z);
        }
    }

    public void aW(ArrayList<String> arrayList) {
        this.lwO = arrayList;
    }

    public ArrayList<String> deQ() {
        return this.lwO;
    }

    public void Ms(String str) {
        this.daw = str;
    }

    public String deU() {
        return this.daw;
    }

    private void c(Spannable spannable) {
        Matcher matcher = Pattern.compile("@[\\u4e00-\\u9fa5\\w\\ud83c\\udc00-\\ud83c\\udfff\\ud83d\\udc00-\\ud83d\\udfff\\u2600-\\u27ff]+").matcher(spannable);
        while (matcher.find()) {
            spannable.setSpan(new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_c)), matcher.start(), matcher.end(), 33);
        }
    }
}
