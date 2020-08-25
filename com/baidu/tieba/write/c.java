package com.baidu.tieba.write;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class c {
    private int bgColor;
    private String dFl;
    private int ixk;
    private ArrayList<String> mLP;
    private int mLQ;
    private int mLR;
    private int mLS = -1;
    private boolean mLT = false;
    private boolean mLU = false;

    public SpannableStringBuilder c(Editable editable) {
        if (editable == null || StringUtils.isNull(editable.toString()) || y.isEmpty(this.mLP)) {
            return null;
        }
        String obj = editable.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
        boolean z = this.mLS >= 0;
        this.mLS = -1;
        Iterator<String> it = this.mLP.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!StringUtils.isNull(next)) {
                a(spannableStringBuilder, obj, next);
            }
        }
        if (this.mLS >= 0 || z) {
            ImageSpan[] imageSpanArr = (ImageSpan[]) editable.getSpans(0, obj.length(), ImageSpan.class);
            if (imageSpanArr != null) {
                for (ImageSpan imageSpan : imageSpanArr) {
                    if (imageSpan != null) {
                        spannableStringBuilder.setSpan(imageSpan, editable.getSpanStart(imageSpan), editable.getSpanEnd(imageSpan), editable.getSpanFlags(imageSpan));
                    }
                }
            }
            return spannableStringBuilder;
        }
        return null;
    }

    private void a(SpannableStringBuilder spannableStringBuilder, String str, String str2) {
        if (spannableStringBuilder == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (this.ixk != 0 || this.bgColor != 0) {
            int indexOf = str.indexOf(str2);
            int length = str2.length();
            if (indexOf >= 0) {
                if (this.mLS == -1) {
                    this.mLS = indexOf + length;
                } else if (indexOf + length < this.mLS) {
                    this.mLS = indexOf + length;
                }
            }
            while (indexOf >= 0) {
                if (this.ixk != 0) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.ixk), indexOf, indexOf + length, 33);
                }
                if (this.bgColor != 0) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.bgColor), indexOf, indexOf + length, 33);
                }
                indexOf = str.indexOf(str2, indexOf + 1);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.mLQ != 0) {
            this.ixk = ap.getColor(this.mLQ);
        }
        if (this.mLR != 0) {
            this.bgColor = ap.getColor(this.mLR);
        }
    }

    public void bf(ArrayList<String> arrayList) {
        this.mLP = arrayList;
    }

    public ArrayList<String> dFu() {
        return this.mLP;
    }

    public void Jr(int i) {
        this.mLQ = i;
        this.ixk = ap.getColor(this.mLQ);
    }

    public void Js(int i) {
        this.mLR = i;
        this.bgColor = ap.getColor(this.mLR);
    }

    public int dFv() {
        return this.mLS;
    }

    public void wX(boolean z) {
        this.mLT = z;
    }

    public boolean dFw() {
        return this.mLT;
    }

    public void wY(boolean z) {
        this.mLU = z;
    }

    public boolean dFx() {
        return this.mLU;
    }

    public void Sw(String str) {
        this.dFl = str;
    }

    public String dFy() {
        return this.dFl;
    }
}
