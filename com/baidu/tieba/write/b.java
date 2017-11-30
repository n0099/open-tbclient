package com.baidu.tieba.write;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class b {
    private int bgColor;
    private ArrayList<String> hbh;
    private String hbi;
    private int hbj;
    private int hbk;
    private int hbl;
    private int hbm = -1;
    private boolean hbn = false;
    private boolean hbo = false;

    public SpannableStringBuilder b(Editable editable) {
        if (editable == null || StringUtils.isNull(editable.toString()) || v.w(this.hbh)) {
            return null;
        }
        String obj = editable.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
        boolean z = this.hbm >= 0;
        this.hbm = -1;
        Iterator<String> it = this.hbh.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!StringUtils.isNull(next)) {
                a(spannableStringBuilder, obj, next);
            }
        }
        if (this.hbm >= 0 || z) {
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
        if (this.hbl != 0 || this.bgColor != 0) {
            int indexOf = str.indexOf(str2);
            int length = str2.length();
            if (indexOf >= 0) {
                if (this.hbm == -1) {
                    this.hbm = indexOf + length;
                } else if (indexOf + length < this.hbm) {
                    this.hbm = indexOf + length;
                }
            }
            while (indexOf >= 0) {
                if (this.hbl != 0) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.hbl), indexOf, indexOf + length, 33);
                }
                if (this.bgColor != 0) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.bgColor), indexOf, indexOf + length, 33);
                }
                indexOf = str.indexOf(str2, indexOf + 1);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.hbj != 0) {
            this.hbl = aj.getColor(this.hbj);
        }
        if (this.hbk != 0) {
            this.bgColor = aj.getColor(this.hbk);
        }
    }

    public void aB(ArrayList<String> arrayList) {
        this.hbh = arrayList;
    }

    public ArrayList<String> bES() {
        return this.hbh;
    }

    public void vA(int i) {
        this.hbj = i;
        this.hbl = aj.getColor(this.hbj);
    }

    public void vB(int i) {
        this.hbk = i;
        this.bgColor = aj.getColor(this.hbk);
    }

    public int bET() {
        return this.hbm;
    }

    public void nS(boolean z) {
        this.hbn = z;
    }

    public boolean bEU() {
        return this.hbn;
    }

    public void nT(boolean z) {
        this.hbo = z;
    }

    public boolean bEV() {
        return this.hbo;
    }

    public void uw(String str) {
        this.hbi = str;
    }

    public String bEW() {
        return this.hbi;
    }
}
