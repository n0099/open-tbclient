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
    private int fOU;
    private ArrayList<String> jEc;
    private int jEd;
    private int jEe;
    private int jEf = -1;
    private boolean jEg = false;
    private boolean jEh = false;

    public SpannableStringBuilder b(Editable editable) {
        if (editable == null || StringUtils.isNull(editable.toString()) || v.aa(this.jEc)) {
            return null;
        }
        String obj = editable.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
        boolean z = this.jEf >= 0;
        this.jEf = -1;
        Iterator<String> it = this.jEc.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!StringUtils.isNull(next)) {
                a(spannableStringBuilder, obj, next);
            }
        }
        if (this.jEf >= 0 || z) {
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
        if (this.fOU != 0 || this.bgColor != 0) {
            int indexOf = str.indexOf(str2);
            int length = str2.length();
            if (indexOf >= 0) {
                if (this.jEf == -1) {
                    this.jEf = indexOf + length;
                } else if (indexOf + length < this.jEf) {
                    this.jEf = indexOf + length;
                }
            }
            while (indexOf >= 0) {
                if (this.fOU != 0) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.fOU), indexOf, indexOf + length, 33);
                }
                if (this.bgColor != 0) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.bgColor), indexOf, indexOf + length, 33);
                }
                indexOf = str.indexOf(str2, indexOf + 1);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.jEd != 0) {
            this.fOU = al.getColor(this.jEd);
        }
        if (this.jEe != 0) {
            this.bgColor = al.getColor(this.jEe);
        }
    }

    public void aI(ArrayList<String> arrayList) {
        this.jEc = arrayList;
    }

    public ArrayList<String> cwe() {
        return this.jEc;
    }

    public void Cb(int i) {
        this.jEd = i;
        this.fOU = al.getColor(this.jEd);
    }

    public void Cc(int i) {
        this.jEe = i;
        this.bgColor = al.getColor(this.jEe);
    }

    public int cwf() {
        return this.jEf;
    }

    public void rJ(boolean z) {
        this.jEg = z;
    }

    public boolean cwg() {
        return this.jEg;
    }

    public void rK(boolean z) {
        this.jEh = z;
    }

    public boolean cwh() {
        return this.jEh;
    }

    public void FE(String str) {
        this.bsb = str;
    }

    public String cwi() {
        return this.bsb;
    }
}
