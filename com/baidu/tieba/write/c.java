package com.baidu.tieba.write;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c {
    private int bgColor;
    private String dqq;
    private int idc;
    private int mlA;
    private int mlB;
    private int mlC = -1;
    private boolean mlD = false;
    private boolean mlE = false;
    private ArrayList<String> mlz;

    public SpannableStringBuilder d(Editable editable) {
        if (editable == null || StringUtils.isNull(editable.toString()) || w.isEmpty(this.mlz)) {
            return null;
        }
        String obj = editable.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
        boolean z = this.mlC >= 0;
        this.mlC = -1;
        Iterator<String> it = this.mlz.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!StringUtils.isNull(next)) {
                a(spannableStringBuilder, obj, next);
            }
        }
        if (this.mlC >= 0 || z) {
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
        if (this.idc != 0 || this.bgColor != 0) {
            int indexOf = str.indexOf(str2);
            int length = str2.length();
            if (indexOf >= 0) {
                if (this.mlC == -1) {
                    this.mlC = indexOf + length;
                } else if (indexOf + length < this.mlC) {
                    this.mlC = indexOf + length;
                }
            }
            while (indexOf >= 0) {
                if (this.idc != 0) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.idc), indexOf, indexOf + length, 33);
                }
                if (this.bgColor != 0) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.bgColor), indexOf, indexOf + length, 33);
                }
                indexOf = str.indexOf(str2, indexOf + 1);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.mlA != 0) {
            this.idc = an.getColor(this.mlA);
        }
        if (this.mlB != 0) {
            this.bgColor = an.getColor(this.mlB);
        }
    }

    public void aY(ArrayList<String> arrayList) {
        this.mlz = arrayList;
    }

    public ArrayList<String> dqM() {
        return this.mlz;
    }

    public void Gz(int i) {
        this.mlA = i;
        this.idc = an.getColor(this.mlA);
    }

    public void GA(int i) {
        this.mlB = i;
        this.bgColor = an.getColor(this.mlB);
    }

    public int dqN() {
        return this.mlC;
    }

    public void vE(boolean z) {
        this.mlD = z;
    }

    public boolean dqO() {
        return this.mlD;
    }

    public void vF(boolean z) {
        this.mlE = z;
    }

    public boolean dqP() {
        return this.mlE;
    }

    public void ON(String str) {
        this.dqq = str;
    }

    public String dqQ() {
        return this.dqq;
    }
}
