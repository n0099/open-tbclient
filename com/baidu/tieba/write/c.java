package com.baidu.tieba.write;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c {
    private int bgColor;
    private String erX;
    private int jIe;
    private ArrayList<String> nSp;
    private int nSq;
    private int nSr;
    private int nSs = -1;
    private boolean nSt = false;
    private boolean nSu = false;

    public SpannableStringBuilder d(Editable editable) {
        if (editable == null || StringUtils.isNull(editable.toString()) || x.isEmpty(this.nSp)) {
            return null;
        }
        String obj = editable.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
        boolean z = this.nSs >= 0;
        this.nSs = -1;
        Iterator<String> it = this.nSp.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!StringUtils.isNull(next)) {
                a(spannableStringBuilder, obj, next);
            }
        }
        if (this.nSs >= 0 || z) {
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
        if (this.jIe != 0 || this.bgColor != 0) {
            int indexOf = str.indexOf(str2);
            int length = str2.length();
            if (indexOf >= 0) {
                if (this.nSs == -1) {
                    this.nSs = indexOf + length;
                } else if (indexOf + length < this.nSs) {
                    this.nSs = indexOf + length;
                }
            }
            while (indexOf >= 0) {
                if (this.jIe != 0) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.jIe), indexOf, indexOf + length, 33);
                }
                if (this.bgColor != 0) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.bgColor), indexOf, indexOf + length, 33);
                }
                indexOf = str.indexOf(str2, indexOf + 1);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.nSq != 0) {
            this.jIe = ao.getColor(this.nSq);
        }
        if (this.nSr != 0) {
            this.bgColor = ao.getColor(this.nSr);
        }
    }

    public void bh(ArrayList<String> arrayList) {
        this.nSp = arrayList;
    }

    public ArrayList<String> dTZ() {
        return this.nSp;
    }

    public void KH(int i) {
        this.nSq = i;
        this.jIe = ao.getColor(this.nSq);
    }

    public void KI(int i) {
        this.nSr = i;
        this.bgColor = ao.getColor(this.nSr);
    }

    public int dUa() {
        return this.nSs;
    }

    public void yX(boolean z) {
        this.nSt = z;
    }

    public boolean dUb() {
        return this.nSt;
    }

    public void yY(boolean z) {
        this.nSu = z;
    }

    public boolean dUc() {
        return this.nSu;
    }

    public void TW(String str) {
        this.erX = str;
    }

    public String dUd() {
        return this.erX;
    }
}
