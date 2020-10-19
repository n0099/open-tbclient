package com.baidu.tieba.write.write;

import android.text.Editable;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.widget.EditText;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.spanGroup.TbLinkForegroundColorSpan;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class c {
    private String dTu;
    private ArrayList<String> nlA;
    private final String nth = "@[\\u4e00-\\u9fa5\\w\\ud83c\\udc00-\\ud83c\\udfff\\ud83d\\udc00-\\ud83d\\udfff\\u2600-\\u27ff]+";

    public void a(EditText editText, boolean z) {
        Editable text;
        Object[] spans;
        if (editText != null && (text = editText.getText()) != null) {
            for (Object obj : text.getSpans(0, text.length(), Object.class)) {
                if (((obj instanceof ForegroundColorSpan) && !(obj instanceof TbLinkForegroundColorSpan)) || (obj instanceof BackgroundColorSpan)) {
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
        if (spannable != null && !y.isEmpty(this.nlA)) {
            String obj = spannable.toString();
            if (!TextUtils.isEmpty(obj)) {
                Iterator<String> it = this.nlA.iterator();
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
                int color = ap.getColor(R.color.cp_cont_a);
                int color2 = ap.getColor(R.color.cp_cont_h_alpha85);
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

    public boolean i(EditText editText) {
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
        if (y.isEmpty(dNj())) {
            return false;
        }
        return i(editText) || i(editText2);
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

    public void bh(ArrayList<String> arrayList) {
        this.nlA = arrayList;
    }

    public ArrayList<String> dNj() {
        return this.nlA;
    }

    public void TK(String str) {
        this.dTu = str;
    }

    public String dNn() {
        return this.dTu;
    }

    private void c(Spannable spannable) {
        Matcher matcher = Pattern.compile("@[\\u4e00-\\u9fa5\\w\\ud83c\\udc00-\\ud83c\\udfff\\ud83d\\udc00-\\ud83d\\udfff\\u2600-\\u27ff]+").matcher(spannable);
        while (matcher.find()) {
            spannable.setSpan(new ForegroundColorSpan(ap.getColor(R.color.cp_link_tip_c)), matcher.start(), matcher.end(), 33);
        }
    }

    public boolean d(Spannable spannable) {
        return Pattern.compile("@[\\u4e00-\\u9fa5\\w\\ud83c\\udc00-\\ud83c\\udfff\\ud83d\\udc00-\\ud83d\\udfff\\u2600-\\u27ff]+").matcher(spannable).find();
    }
}
