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
    private ArrayList<String> jlq;
    private int jlr;
    private int jls;
    private int jlt = -1;
    private boolean jlu = false;
    private boolean jlv = false;

    public SpannableStringBuilder b(Editable editable) {
        if (editable == null || StringUtils.isNull(editable.toString()) || v.T(this.jlq)) {
            return null;
        }
        String obj = editable.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
        boolean z = this.jlt >= 0;
        this.jlt = -1;
        Iterator<String> it = this.jlq.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!StringUtils.isNull(next)) {
                a(spannableStringBuilder, obj, next);
            }
        }
        if (this.jlt >= 0 || z) {
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
                if (this.jlt == -1) {
                    this.jlt = indexOf + length;
                } else if (indexOf + length < this.jlt) {
                    this.jlt = indexOf + length;
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
        if (this.jlr != 0) {
            this.fym = al.getColor(this.jlr);
        }
        if (this.jls != 0) {
            this.bgColor = al.getColor(this.jls);
        }
    }

    public void aE(ArrayList<String> arrayList) {
        this.jlq = arrayList;
    }

    public ArrayList<String> cnV() {
        return this.jlq;
    }

    public void AW(int i) {
        this.jlr = i;
        this.fym = al.getColor(this.jlr);
    }

    public void AX(int i) {
        this.jls = i;
        this.bgColor = al.getColor(this.jls);
    }

    public int cnW() {
        return this.jlt;
    }

    public void qU(boolean z) {
        this.jlu = z;
    }

    public boolean cnX() {
        return this.jlu;
    }

    public void qV(boolean z) {
        this.jlv = z;
    }

    public boolean cnY() {
        return this.jlv;
    }

    public void El(String str) {
        this.blU = str;
    }

    public String cnZ() {
        return this.blU;
    }
}
