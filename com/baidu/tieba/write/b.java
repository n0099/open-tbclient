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
    private int fOT;
    private ArrayList<String> jEb;
    private int jEc;
    private int jEd;
    private int jEe = -1;
    private boolean jEf = false;
    private boolean jEg = false;

    public SpannableStringBuilder b(Editable editable) {
        if (editable == null || StringUtils.isNull(editable.toString()) || v.aa(this.jEb)) {
            return null;
        }
        String obj = editable.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
        boolean z = this.jEe >= 0;
        this.jEe = -1;
        Iterator<String> it = this.jEb.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!StringUtils.isNull(next)) {
                a(spannableStringBuilder, obj, next);
            }
        }
        if (this.jEe >= 0 || z) {
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
        if (this.fOT != 0 || this.bgColor != 0) {
            int indexOf = str.indexOf(str2);
            int length = str2.length();
            if (indexOf >= 0) {
                if (this.jEe == -1) {
                    this.jEe = indexOf + length;
                } else if (indexOf + length < this.jEe) {
                    this.jEe = indexOf + length;
                }
            }
            while (indexOf >= 0) {
                if (this.fOT != 0) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.fOT), indexOf, indexOf + length, 33);
                }
                if (this.bgColor != 0) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.bgColor), indexOf, indexOf + length, 33);
                }
                indexOf = str.indexOf(str2, indexOf + 1);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.jEc != 0) {
            this.fOT = al.getColor(this.jEc);
        }
        if (this.jEd != 0) {
            this.bgColor = al.getColor(this.jEd);
        }
    }

    public void aI(ArrayList<String> arrayList) {
        this.jEb = arrayList;
    }

    public ArrayList<String> cwc() {
        return this.jEb;
    }

    public void Cb(int i) {
        this.jEc = i;
        this.fOT = al.getColor(this.jEc);
    }

    public void Cc(int i) {
        this.jEd = i;
        this.bgColor = al.getColor(this.jEd);
    }

    public int cwd() {
        return this.jEe;
    }

    public void rJ(boolean z) {
        this.jEf = z;
    }

    public boolean cwe() {
        return this.jEf;
    }

    public void rK(boolean z) {
        this.jEg = z;
    }

    public boolean cwf() {
        return this.jEg;
    }

    public void FE(String str) {
        this.bsb = str;
    }

    public String cwg() {
        return this.bsb;
    }
}
