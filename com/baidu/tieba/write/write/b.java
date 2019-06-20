package com.baidu.tieba.write.write;

import android.text.Editable;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.widget.EditText;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class b {
    private String bsb;
    private ArrayList<String> jEf;

    public void m(EditText editText) {
        Editable text;
        Object[] spans;
        if (editText != null && (text = editText.getText()) != null) {
            for (Object obj : text.getSpans(0, text.length(), Object.class)) {
                if ((obj instanceof ForegroundColorSpan) || (obj instanceof BackgroundColorSpan)) {
                    text.removeSpan(obj);
                }
            }
            com.baidu.tbadk.plugins.b.a(text);
            b((Spannable) text);
        }
    }

    private void b(Spannable spannable) {
        if (spannable != null && !v.aa(this.jEf)) {
            String obj = spannable.toString();
            if (!TextUtils.isEmpty(obj)) {
                Iterator<String> it = this.jEf.iterator();
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
                int color = al.getColor(R.color.cp_btn_a);
                int color2 = al.getColor(R.color.cp_cont_h_alpha85);
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

    public boolean n(EditText editText) {
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
        if (v.aa(cwd())) {
            return false;
        }
        return n(editText) || n(editText2);
    }

    public void b(EditText editText, EditText editText2) {
        o(editText);
        o(editText2);
        a(editText, editText2);
    }

    public void c(EditText editText, EditText editText2) {
        b(editText, editText2);
    }

    public void o(EditText editText) {
        if (editText != null) {
            m(editText);
        }
    }

    public void aI(ArrayList<String> arrayList) {
        this.jEf = arrayList;
    }

    public ArrayList<String> cwd() {
        return this.jEf;
    }

    public void FG(String str) {
        this.bsb = str;
    }

    public String cwh() {
        return this.bsb;
    }
}
