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
    private String Zv;
    private int bgColor;
    private int ejb;
    private ArrayList<String> hUP;
    private int hUQ;
    private int hUR;
    private int hUS = -1;
    private boolean hUT = false;
    private boolean hUU = false;

    public SpannableStringBuilder b(Editable editable) {
        if (editable == null || StringUtils.isNull(editable.toString()) || v.I(this.hUP)) {
            return null;
        }
        String obj = editable.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
        boolean z = this.hUS >= 0;
        this.hUS = -1;
        Iterator<String> it = this.hUP.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!StringUtils.isNull(next)) {
                a(spannableStringBuilder, obj, next);
            }
        }
        if (this.hUS >= 0 || z) {
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
        if (this.ejb != 0 || this.bgColor != 0) {
            int indexOf = str.indexOf(str2);
            int length = str2.length();
            if (indexOf >= 0) {
                if (this.hUS == -1) {
                    this.hUS = indexOf + length;
                } else if (indexOf + length < this.hUS) {
                    this.hUS = indexOf + length;
                }
            }
            while (indexOf >= 0) {
                if (this.ejb != 0) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.ejb), indexOf, indexOf + length, 33);
                }
                if (this.bgColor != 0) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.bgColor), indexOf, indexOf + length, 33);
                }
                indexOf = str.indexOf(str2, indexOf + 1);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.hUQ != 0) {
            this.ejb = al.getColor(this.hUQ);
        }
        if (this.hUR != 0) {
            this.bgColor = al.getColor(this.hUR);
        }
    }

    public void aA(ArrayList<String> arrayList) {
        this.hUP = arrayList;
    }

    public ArrayList<String> bOt() {
        return this.hUP;
    }

    public void xk(int i) {
        this.hUQ = i;
        this.ejb = al.getColor(this.hUQ);
    }

    public void xl(int i) {
        this.hUR = i;
        this.bgColor = al.getColor(this.hUR);
    }

    public int bOu() {
        return this.hUS;
    }

    public void ou(boolean z) {
        this.hUT = z;
    }

    public boolean bOv() {
        return this.hUT;
    }

    public void ov(boolean z) {
        this.hUU = z;
    }

    public boolean bOw() {
        return this.hUU;
    }

    public void xK(String str) {
        this.Zv = str;
    }

    public String bOx() {
        return this.Zv;
    }
}
