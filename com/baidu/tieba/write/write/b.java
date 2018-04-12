package com.baidu.tieba.write.write;

import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class b {
    private ArrayList<String> haj;
    private String hak;

    public SpannableStringBuilder i(EditText editText) {
        Spannable text;
        if (editText == null || (text = editText.getText()) == null) {
            return null;
        }
        String obj = text.toString();
        if (StringUtils.isNull(obj)) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
        a(text, spannableStringBuilder);
        com.baidu.tbadk.plugins.b.a(spannableStringBuilder);
        b(spannableStringBuilder);
        return spannableStringBuilder;
    }

    private void a(Spannable spannable, Spannable spannable2) {
        ImageSpan[] imageSpanArr;
        if (spannable != null && spannable2 != null && (imageSpanArr = (ImageSpan[]) spannable.getSpans(0, spannable.length(), ImageSpan.class)) != null) {
            for (ImageSpan imageSpan : imageSpanArr) {
                if (imageSpan != null) {
                    spannable2.setSpan(imageSpan, spannable.getSpanStart(imageSpan), spannable.getSpanEnd(imageSpan), spannable.getSpanFlags(imageSpan));
                }
            }
        }
    }

    private void b(Spannable spannable) {
        if (spannable != null && !v.w(this.haj)) {
            String obj = spannable.toString();
            if (!TextUtils.isEmpty(obj)) {
                Iterator<String> it = this.haj.iterator();
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
                int color = ak.getColor(d.C0126d.cp_cont_i);
                int color2 = ak.getColor(d.C0126d.cp_cont_h_alpha85);
                ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(color);
                BackgroundColorSpan backgroundColorSpan = new BackgroundColorSpan(color2);
                spannable.setSpan(foregroundColorSpan, indexOf, i, 33);
                spannable.setSpan(backgroundColorSpan, indexOf, i, 33);
                indexOf = str.indexOf(str2, indexOf + 1);
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
        if (v.w(bAU())) {
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
        SpannableStringBuilder i;
        if (editText != null && (i = i(editText)) != null) {
            int selectionEnd = editText.getSelectionEnd();
            editText.setText(i);
            editText.setSelection(selectionEnd);
        }
    }

    public void ax(ArrayList<String> arrayList) {
        this.haj = arrayList;
    }

    public ArrayList<String> bAU() {
        return this.haj;
    }

    public void uB(String str) {
        this.hak = str;
    }

    public String bAY() {
        return this.hak;
    }
}
