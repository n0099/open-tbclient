package com.baidu.tieba.write;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class b {
    private int bgColor;
    private ArrayList<String> hbk;
    private String hbl;
    private int hbm;
    private int hbn;
    private int hbo;
    private int hbp = -1;
    private boolean hbq = false;
    private boolean hbr = false;

    public SpannableStringBuilder b(Editable editable) {
        if (editable == null || StringUtils.isNull(editable.toString()) || v.w(this.hbk)) {
            return null;
        }
        String obj = editable.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
        boolean z = this.hbp >= 0;
        this.hbp = -1;
        Iterator<String> it = this.hbk.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!StringUtils.isNull(next)) {
                a(spannableStringBuilder, obj, next);
            }
        }
        if (this.hbp >= 0 || z) {
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
        if (this.hbo != 0 || this.bgColor != 0) {
            int indexOf = str.indexOf(str2);
            int length = str2.length();
            if (indexOf >= 0) {
                if (this.hbp == -1) {
                    this.hbp = indexOf + length;
                } else if (indexOf + length < this.hbp) {
                    this.hbp = indexOf + length;
                }
            }
            while (indexOf >= 0) {
                if (this.hbo != 0) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.hbo), indexOf, indexOf + length, 33);
                }
                if (this.bgColor != 0) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.bgColor), indexOf, indexOf + length, 33);
                }
                indexOf = str.indexOf(str2, indexOf + 1);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.hbm != 0) {
            this.hbo = ak.getColor(this.hbm);
        }
        if (this.hbn != 0) {
            this.bgColor = ak.getColor(this.hbn);
        }
    }

    public void ax(ArrayList<String> arrayList) {
        this.hbk = arrayList;
    }

    public ArrayList<String> bAS() {
        return this.hbk;
    }

    public void uJ(int i) {
        this.hbm = i;
        this.hbo = ak.getColor(this.hbm);
    }

    public void uK(int i) {
        this.hbn = i;
        this.bgColor = ak.getColor(this.hbn);
    }

    public int bAT() {
        return this.hbp;
    }

    public void nj(boolean z) {
        this.hbq = z;
    }

    public boolean bAU() {
        return this.hbq;
    }

    public void nk(boolean z) {
        this.hbr = z;
    }

    public boolean bAV() {
        return this.hbr;
    }

    public void uE(String str) {
        this.hbl = str;
    }

    public String bAW() {
        return this.hbl;
    }
}
