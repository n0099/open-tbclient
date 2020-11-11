package com.baidu.tieba.write;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c {
    private int bgColor;
    private String ehI;
    private int jlW;
    private ArrayList<String> nDV;
    private int nDW;
    private int nDX;
    private int nDY = -1;
    private boolean nDZ = false;
    private boolean nEa = false;

    public SpannableStringBuilder c(Editable editable) {
        if (editable == null || StringUtils.isNull(editable.toString()) || y.isEmpty(this.nDV)) {
            return null;
        }
        String obj = editable.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
        boolean z = this.nDY >= 0;
        this.nDY = -1;
        Iterator<String> it = this.nDV.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!StringUtils.isNull(next)) {
                a(spannableStringBuilder, obj, next);
            }
        }
        if (this.nDY >= 0 || z) {
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
        if (this.jlW != 0 || this.bgColor != 0) {
            int indexOf = str.indexOf(str2);
            int length = str2.length();
            if (indexOf >= 0) {
                if (this.nDY == -1) {
                    this.nDY = indexOf + length;
                } else if (indexOf + length < this.nDY) {
                    this.nDY = indexOf + length;
                }
            }
            while (indexOf >= 0) {
                if (this.jlW != 0) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.jlW), indexOf, indexOf + length, 33);
                }
                if (this.bgColor != 0) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.bgColor), indexOf, indexOf + length, 33);
                }
                indexOf = str.indexOf(str2, indexOf + 1);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.nDW != 0) {
            this.jlW = ap.getColor(this.nDW);
        }
        if (this.nDX != 0) {
            this.bgColor = ap.getColor(this.nDX);
        }
    }

    public void bk(ArrayList<String> arrayList) {
        this.nDV = arrayList;
    }

    public ArrayList<String> dST() {
        return this.nDV;
    }

    public void Lg(int i) {
        this.nDW = i;
        this.jlW = ap.getColor(this.nDW);
    }

    public void Lh(int i) {
        this.nDX = i;
        this.bgColor = ap.getColor(this.nDX);
    }

    public int dSU() {
        return this.nDY;
    }

    public void yp(boolean z) {
        this.nDZ = z;
    }

    public boolean dSV() {
        return this.nDZ;
    }

    public void yq(boolean z) {
        this.nEa = z;
    }

    public boolean dSW() {
        return this.nEa;
    }

    public void UA(String str) {
        this.ehI = str;
    }

    public String dSX() {
        return this.ehI;
    }
}
