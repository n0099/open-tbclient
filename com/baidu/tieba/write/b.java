package com.baidu.tieba.write;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class b {
    private String Zm;
    private int bgColor;
    private int efE;
    private int hQA = -1;
    private boolean hQB = false;
    private boolean hQC = false;
    private ArrayList<String> hQx;
    private int hQy;
    private int hQz;

    public SpannableStringBuilder b(Editable editable) {
        if (editable == null || StringUtils.isNull(editable.toString()) || v.I(this.hQx)) {
            return null;
        }
        String obj = editable.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
        boolean z = this.hQA >= 0;
        this.hQA = -1;
        Iterator<String> it = this.hQx.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!StringUtils.isNull(next)) {
                a(spannableStringBuilder, obj, next);
            }
        }
        if (this.hQA >= 0 || z) {
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
        if (this.efE != 0 || this.bgColor != 0) {
            int indexOf = str.indexOf(str2);
            int length = str2.length();
            if (indexOf >= 0) {
                if (this.hQA == -1) {
                    this.hQA = indexOf + length;
                } else if (indexOf + length < this.hQA) {
                    this.hQA = indexOf + length;
                }
            }
            while (indexOf >= 0) {
                if (this.efE != 0) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.efE), indexOf, indexOf + length, 33);
                }
                if (this.bgColor != 0) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.bgColor), indexOf, indexOf + length, 33);
                }
                indexOf = str.indexOf(str2, indexOf + 1);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.hQy != 0) {
            this.efE = al.getColor(this.hQy);
        }
        if (this.hQz != 0) {
            this.bgColor = al.getColor(this.hQz);
        }
    }

    public void az(ArrayList<String> arrayList) {
        this.hQx = arrayList;
    }

    public ArrayList<String> bMU() {
        return this.hQx;
    }

    public void wV(int i) {
        this.hQy = i;
        this.efE = al.getColor(this.hQy);
    }

    public void wW(int i) {
        this.hQz = i;
        this.bgColor = al.getColor(this.hQz);
    }

    public int bMV() {
        return this.hQA;
    }

    public void oq(boolean z) {
        this.hQB = z;
    }

    public boolean bMW() {
        return this.hQB;
    }

    public void or(boolean z) {
        this.hQC = z;
    }

    public boolean bMX() {
        return this.hQC;
    }

    public void xr(String str) {
        this.Zm = str;
    }

    public String bMY() {
        return this.Zm;
    }
}
