package com.baidu.tieba.write;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c {
    private int bgColor;
    private String cBg;
    private int gOT;
    private int kLA;
    private int kLB = -1;
    private boolean kLC = false;
    private boolean kLD = false;
    private ArrayList<String> kLy;
    private int kLz;

    public SpannableStringBuilder a(Editable editable) {
        if (editable == null || StringUtils.isNull(editable.toString()) || v.isEmpty(this.kLy)) {
            return null;
        }
        String obj = editable.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
        boolean z = this.kLB >= 0;
        this.kLB = -1;
        Iterator<String> it = this.kLy.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!StringUtils.isNull(next)) {
                a(spannableStringBuilder, obj, next);
            }
        }
        if (this.kLB >= 0 || z) {
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
        if (this.gOT != 0 || this.bgColor != 0) {
            int indexOf = str.indexOf(str2);
            int length = str2.length();
            if (indexOf >= 0) {
                if (this.kLB == -1) {
                    this.kLB = indexOf + length;
                } else if (indexOf + length < this.kLB) {
                    this.kLB = indexOf + length;
                }
            }
            while (indexOf >= 0) {
                if (this.gOT != 0) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.gOT), indexOf, indexOf + length, 33);
                }
                if (this.bgColor != 0) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.bgColor), indexOf, indexOf + length, 33);
                }
                indexOf = str.indexOf(str2, indexOf + 1);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.kLz != 0) {
            this.gOT = am.getColor(this.kLz);
        }
        if (this.kLA != 0) {
            this.bgColor = am.getColor(this.kLA);
        }
    }

    public void aU(ArrayList<String> arrayList) {
        this.kLy = arrayList;
    }

    public ArrayList<String> cUc() {
        return this.kLy;
    }

    public void DZ(int i) {
        this.kLz = i;
        this.gOT = am.getColor(this.kLz);
    }

    public void Ea(int i) {
        this.kLA = i;
        this.bgColor = am.getColor(this.kLA);
    }

    public int cUd() {
        return this.kLB;
    }

    public void tG(boolean z) {
        this.kLC = z;
    }

    public boolean cUe() {
        return this.kLC;
    }

    public void tH(boolean z) {
        this.kLD = z;
    }

    public boolean cUf() {
        return this.kLD;
    }

    public void KK(String str) {
        this.cBg = str;
    }

    public String cUg() {
        return this.cBg;
    }
}
