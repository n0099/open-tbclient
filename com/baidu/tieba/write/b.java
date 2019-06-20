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
    private int bgColor;
    private String bsb;
    private int fOW;
    private ArrayList<String> jEf;
    private int jEg;
    private int jEh;
    private int jEi = -1;
    private boolean jEj = false;
    private boolean jEk = false;

    public SpannableStringBuilder b(Editable editable) {
        if (editable == null || StringUtils.isNull(editable.toString()) || v.aa(this.jEf)) {
            return null;
        }
        String obj = editable.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
        boolean z = this.jEi >= 0;
        this.jEi = -1;
        Iterator<String> it = this.jEf.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!StringUtils.isNull(next)) {
                a(spannableStringBuilder, obj, next);
            }
        }
        if (this.jEi >= 0 || z) {
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
        if (this.fOW != 0 || this.bgColor != 0) {
            int indexOf = str.indexOf(str2);
            int length = str2.length();
            if (indexOf >= 0) {
                if (this.jEi == -1) {
                    this.jEi = indexOf + length;
                } else if (indexOf + length < this.jEi) {
                    this.jEi = indexOf + length;
                }
            }
            while (indexOf >= 0) {
                if (this.fOW != 0) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.fOW), indexOf, indexOf + length, 33);
                }
                if (this.bgColor != 0) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.bgColor), indexOf, indexOf + length, 33);
                }
                indexOf = str.indexOf(str2, indexOf + 1);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.jEg != 0) {
            this.fOW = al.getColor(this.jEg);
        }
        if (this.jEh != 0) {
            this.bgColor = al.getColor(this.jEh);
        }
    }

    public void aI(ArrayList<String> arrayList) {
        this.jEf = arrayList;
    }

    public ArrayList<String> cwd() {
        return this.jEf;
    }

    public void Cb(int i) {
        this.jEg = i;
        this.fOW = al.getColor(this.jEg);
    }

    public void Cc(int i) {
        this.jEh = i;
        this.bgColor = al.getColor(this.jEh);
    }

    public int cwe() {
        return this.jEi;
    }

    public void rK(boolean z) {
        this.jEj = z;
    }

    public boolean cwf() {
        return this.jEj;
    }

    public void rL(boolean z) {
        this.jEk = z;
    }

    public boolean cwg() {
        return this.jEk;
    }

    public void FG(String str) {
        this.bsb = str;
    }

    public String cwh() {
        return this.bsb;
    }
}
