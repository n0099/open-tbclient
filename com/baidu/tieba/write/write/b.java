package com.baidu.tieba.write.write;

import android.text.Editable;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.widget.EditText;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class b {
    private ArrayList<String> hrl;
    private String hrm;

    public void i(EditText editText) {
        Editable text;
        Object[] spans;
        if (editText != null && (text = editText.getText()) != null) {
            for (Object obj : text.getSpans(0, text.length(), Object.class)) {
                if ((obj instanceof ForegroundColorSpan) || (obj instanceof BackgroundColorSpan)) {
                    text.removeSpan(obj);
                }
            }
            com.baidu.tbadk.plugins.b.a(text);
            b(text);
        }
    }

    private void b(Spannable spannable) {
        if (spannable != null && !w.A(this.hrl)) {
            String obj = spannable.toString();
            if (!TextUtils.isEmpty(obj)) {
                Iterator<String> it = this.hrl.iterator();
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
                int color = am.getColor(d.C0142d.cp_cont_i);
                int color2 = am.getColor(d.C0142d.cp_cont_h_alpha85);
                ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(color);
                BackgroundColorSpan backgroundColorSpan = new BackgroundColorSpan(color2);
                spannable.setSpan(foregroundColorSpan, indexOf, i, 33);
                spannable.setSpan(backgroundColorSpan, indexOf, i, 33);
                indexOf = str.indexOf(str2, i);
            }
        }
    }

    public int a(Spanned spanned) {
        if (spanned == null) {
            return 0;
        }
        BackgroundColorSpan[] backgroundColorSpanArr = (BackgroundColorSpan[]) spanned.getSpans(0, spanned.length(), BackgroundColorSpan.class);
        return (backgroundColorSpanArr == null || backgroundColorSpanArr.length <= 0) ? spanned.length() : spanned.getSpanEnd(backgroundColorSpanArr[0]);
    }

    public boolean j(EditText editText) {
        Editable text;
        if (editText == null || (text = editText.getText()) == null) {
            return false;
        }
        int a = a(text);
        if (a > 0) {
            editText.requestFocus();
            editText.setSelection(a);
            return true;
        }
        editText.setSelection(editText.getSelectionEnd());
        return false;
    }

    public boolean a(EditText editText, EditText editText2) {
        if (w.A(bGy())) {
            return false;
        }
        return j(editText) || j(editText2);
    }

    public void b(EditText editText, EditText editText2) {
        k(editText);
        k(editText2);
        a(editText, editText2);
    }

    public void c(EditText editText, EditText editText2) {
        b(editText, editText2);
    }

    public void k(EditText editText) {
        if (editText != null) {
            i(editText);
        }
    }

    public void aB(ArrayList<String> arrayList) {
        this.hrl = arrayList;
    }

    public ArrayList<String> bGy() {
        return this.hrl;
    }

    public void vu(String str) {
        this.hrm = str;
    }

    public String bGC() {
        return this.hrm;
    }
}
