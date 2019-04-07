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
    private String blY;
    private int fxZ;
    private ArrayList<String> jkW;
    private int jkX;
    private int jkY;
    private int jkZ = -1;
    private boolean jla = false;
    private boolean jlb = false;

    public SpannableStringBuilder b(Editable editable) {
        if (editable == null || StringUtils.isNull(editable.toString()) || v.T(this.jkW)) {
            return null;
        }
        String obj = editable.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
        boolean z = this.jkZ >= 0;
        this.jkZ = -1;
        Iterator<String> it = this.jkW.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!StringUtils.isNull(next)) {
                a(spannableStringBuilder, obj, next);
            }
        }
        if (this.jkZ >= 0 || z) {
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
        if (this.fxZ != 0 || this.bgColor != 0) {
            int indexOf = str.indexOf(str2);
            int length = str2.length();
            if (indexOf >= 0) {
                if (this.jkZ == -1) {
                    this.jkZ = indexOf + length;
                } else if (indexOf + length < this.jkZ) {
                    this.jkZ = indexOf + length;
                }
            }
            while (indexOf >= 0) {
                if (this.fxZ != 0) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.fxZ), indexOf, indexOf + length, 33);
                }
                if (this.bgColor != 0) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.bgColor), indexOf, indexOf + length, 33);
                }
                indexOf = str.indexOf(str2, indexOf + 1);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.jkX != 0) {
            this.fxZ = al.getColor(this.jkX);
        }
        if (this.jkY != 0) {
            this.bgColor = al.getColor(this.jkY);
        }
    }

    public void aE(ArrayList<String> arrayList) {
        this.jkW = arrayList;
    }

    public ArrayList<String> cnW() {
        return this.jkW;
    }

    public void AS(int i) {
        this.jkX = i;
        this.fxZ = al.getColor(this.jkX);
    }

    public void AT(int i) {
        this.jkY = i;
        this.bgColor = al.getColor(this.jkY);
    }

    public int cnX() {
        return this.jkZ;
    }

    public void qU(boolean z) {
        this.jla = z;
    }

    public boolean cnY() {
        return this.jla;
    }

    public void qV(boolean z) {
        this.jlb = z;
    }

    public boolean cnZ() {
        return this.jlb;
    }

    public void Ei(String str) {
        this.blY = str;
    }

    public String coa() {
        return this.blY;
    }
}
