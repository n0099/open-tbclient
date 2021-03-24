package com.baidu.wallet.home.ui.widget;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.wallet.paysdk.ui.widget.PayTypeItemView;
/* loaded from: classes5.dex */
public class MaskTextView extends TextView {
    public String mOriginalText;

    public MaskTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private int a(String str) {
        if (!TextUtils.isEmpty(str)) {
            int indexOf = str.indexOf("#");
            int lastIndexOf = str.lastIndexOf("#");
            if (indexOf != -1 && lastIndexOf != -1 && indexOf < lastIndexOf) {
                String replace = str.substring(indexOf, lastIndexOf + 1).replace("#", "");
                try {
                    return Color.parseColor("#" + replace);
                } catch (Exception unused) {
                }
            }
        }
        return -1;
    }

    private String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int indexOf = str.indexOf("#");
        int lastIndexOf = str.lastIndexOf("#");
        return (indexOf == -1 || lastIndexOf == -1 || indexOf >= lastIndexOf) ? str : str.replace(str.substring(indexOf, lastIndexOf + 1), "");
    }

    private String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (com.baidu.wallet.home.storage.a.a(getContext())) {
            int indexOf = str.indexOf(PayTypeItemView.PayTypeItemViewData.MASK_FLAG);
            int lastIndexOf = str.lastIndexOf(PayTypeItemView.PayTypeItemViewData.MASK_FLAG);
            if (indexOf == -1 || lastIndexOf == -1 || indexOf == lastIndexOf) {
                return str;
            }
            String substring = str.substring(indexOf, lastIndexOf + 1);
            if (substring.length() <= 2) {
                return str.replace(substring, "");
            }
            return str.replace(substring, "****");
        }
        return str.replace(PayTypeItemView.PayTypeItemViewData.MASK_FLAG, "");
    }

    public void resetMaskText() {
        if (TextUtils.isEmpty(this.mOriginalText)) {
            return;
        }
        setMaskText(this.mOriginalText);
    }

    public void setMaskText(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mOriginalText = str;
        int a2 = a(str);
        String b2 = b(str);
        if (b2.contains(PayTypeItemView.PayTypeItemViewData.MASK_FLAG)) {
            if (TextUtils.isEmpty(b2)) {
                return;
            }
            if (com.baidu.wallet.home.storage.a.a(getContext())) {
                super.setText(c(b2));
                return;
            }
            int indexOf = b2.indexOf(PayTypeItemView.PayTypeItemViewData.MASK_FLAG);
            int lastIndexOf = b2.lastIndexOf(PayTypeItemView.PayTypeItemViewData.MASK_FLAG);
            int length = (lastIndexOf - (b2.length() - c(b2).length())) + 1;
            if (indexOf != -1 && lastIndexOf != -1 && indexOf != lastIndexOf) {
                String c2 = c(b2);
                if (a2 != -1 && indexOf <= length && length <= c2.length()) {
                    SpannableString spannableString = new SpannableString(c2);
                    spannableString.setSpan(new ForegroundColorSpan(a2), indexOf, length, 33);
                    super.setText(spannableString);
                    return;
                }
                super.setText(c2);
                return;
            }
            super.setText(c(b2));
            return;
        }
        if (a2 != -1) {
            setTextColor(a2);
        }
        super.setText(b2);
    }
}
