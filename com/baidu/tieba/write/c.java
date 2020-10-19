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
/* loaded from: classes.dex */
public class c {
    private int bgColor;
    private String dTu;
    private int iTC;
    private ArrayList<String> nlA;
    private int nlB;
    private int nlC;
    private int nlD = -1;
    private boolean nlE = false;
    private boolean nlF = false;

    public SpannableStringBuilder c(Editable editable) {
        if (editable == null || StringUtils.isNull(editable.toString()) || y.isEmpty(this.nlA)) {
            return null;
        }
        String obj = editable.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
        boolean z = this.nlD >= 0;
        this.nlD = -1;
        Iterator<String> it = this.nlA.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!StringUtils.isNull(next)) {
                a(spannableStringBuilder, obj, next);
            }
        }
        if (this.nlD >= 0 || z) {
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
        if (this.iTC != 0 || this.bgColor != 0) {
            int indexOf = str.indexOf(str2);
            int length = str2.length();
            if (indexOf >= 0) {
                if (this.nlD == -1) {
                    this.nlD = indexOf + length;
                } else if (indexOf + length < this.nlD) {
                    this.nlD = indexOf + length;
                }
            }
            while (indexOf >= 0) {
                if (this.iTC != 0) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.iTC), indexOf, indexOf + length, 33);
                }
                if (this.bgColor != 0) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.bgColor), indexOf, indexOf + length, 33);
                }
                indexOf = str.indexOf(str2, indexOf + 1);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.nlB != 0) {
            this.iTC = ap.getColor(this.nlB);
        }
        if (this.nlC != 0) {
            this.bgColor = ap.getColor(this.nlC);
        }
    }

    public void bh(ArrayList<String> arrayList) {
        this.nlA = arrayList;
    }

    public ArrayList<String> dNj() {
        return this.nlA;
    }

    public void KB(int i) {
        this.nlB = i;
        this.iTC = ap.getColor(this.nlB);
    }

    public void KC(int i) {
        this.nlC = i;
        this.bgColor = ap.getColor(this.nlC);
    }

    public int dNk() {
        return this.nlD;
    }

    public void xP(boolean z) {
        this.nlE = z;
    }

    public boolean dNl() {
        return this.nlE;
    }

    public void xQ(boolean z) {
        this.nlF = z;
    }

    public boolean dNm() {
        return this.nlF;
    }

    public void TK(String str) {
        this.dTu = str;
    }

    public String dNn() {
        return this.dTu;
    }
}
