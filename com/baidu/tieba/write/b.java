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
    private String blU;
    private int fym;
    private ArrayList<String> jkX;
    private int jkY;
    private int jkZ;
    private int jla = -1;
    private boolean jlb = false;
    private boolean jlc = false;

    public SpannableStringBuilder b(Editable editable) {
        if (editable == null || StringUtils.isNull(editable.toString()) || v.T(this.jkX)) {
            return null;
        }
        String obj = editable.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
        boolean z = this.jla >= 0;
        this.jla = -1;
        Iterator<String> it = this.jkX.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!StringUtils.isNull(next)) {
                a(spannableStringBuilder, obj, next);
            }
        }
        if (this.jla >= 0 || z) {
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
        if (this.fym != 0 || this.bgColor != 0) {
            int indexOf = str.indexOf(str2);
            int length = str2.length();
            if (indexOf >= 0) {
                if (this.jla == -1) {
                    this.jla = indexOf + length;
                } else if (indexOf + length < this.jla) {
                    this.jla = indexOf + length;
                }
            }
            while (indexOf >= 0) {
                if (this.fym != 0) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.fym), indexOf, indexOf + length, 33);
                }
                if (this.bgColor != 0) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.bgColor), indexOf, indexOf + length, 33);
                }
                indexOf = str.indexOf(str2, indexOf + 1);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.jkY != 0) {
            this.fym = al.getColor(this.jkY);
        }
        if (this.jkZ != 0) {
            this.bgColor = al.getColor(this.jkZ);
        }
    }

    public void aE(ArrayList<String> arrayList) {
        this.jkX = arrayList;
    }

    public ArrayList<String> cnL() {
        return this.jkX;
    }

    public void AV(int i) {
        this.jkY = i;
        this.fym = al.getColor(this.jkY);
    }

    public void AW(int i) {
        this.jkZ = i;
        this.bgColor = al.getColor(this.jkZ);
    }

    public int cnM() {
        return this.jla;
    }

    public void qU(boolean z) {
        this.jlb = z;
    }

    public boolean cnN() {
        return this.jlb;
    }

    public void qV(boolean z) {
        this.jlc = z;
    }

    public boolean cnO() {
        return this.jlc;
    }

    public void Ei(String str) {
        this.blU = str;
    }

    public String cnP() {
        return this.blU;
    }
}
