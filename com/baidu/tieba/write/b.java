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
public class b {
    private String bLi;
    private int bgColor;
    private int fVe;
    private ArrayList<String> jLY;
    private int jLZ;
    private int jMa;
    private int jMb = -1;
    private boolean jMc = false;
    private boolean jMd = false;

    public SpannableStringBuilder a(Editable editable) {
        if (editable == null || StringUtils.isNull(editable.toString()) || v.isEmpty(this.jLY)) {
            return null;
        }
        String obj = editable.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
        boolean z = this.jMb >= 0;
        this.jMb = -1;
        Iterator<String> it = this.jLY.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!StringUtils.isNull(next)) {
                a(spannableStringBuilder, obj, next);
            }
        }
        if (this.jMb >= 0 || z) {
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
        if (this.fVe != 0 || this.bgColor != 0) {
            int indexOf = str.indexOf(str2);
            int length = str2.length();
            if (indexOf >= 0) {
                if (this.jMb == -1) {
                    this.jMb = indexOf + length;
                } else if (indexOf + length < this.jMb) {
                    this.jMb = indexOf + length;
                }
            }
            while (indexOf >= 0) {
                if (this.fVe != 0) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.fVe), indexOf, indexOf + length, 33);
                }
                if (this.bgColor != 0) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.bgColor), indexOf, indexOf + length, 33);
                }
                indexOf = str.indexOf(str2, indexOf + 1);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.jLZ != 0) {
            this.fVe = am.getColor(this.jLZ);
        }
        if (this.jMa != 0) {
            this.bgColor = am.getColor(this.jMa);
        }
    }

    public void aM(ArrayList<String> arrayList) {
        this.jLY = arrayList;
    }

    public ArrayList<String> cxw() {
        return this.jLY;
    }

    public void Br(int i) {
        this.jLZ = i;
        this.fVe = am.getColor(this.jLZ);
    }

    public void Bs(int i) {
        this.jMa = i;
        this.bgColor = am.getColor(this.jMa);
    }

    public int cxx() {
        return this.jMb;
    }

    public void rK(boolean z) {
        this.jMc = z;
    }

    public boolean cxy() {
        return this.jMc;
    }

    public void rL(boolean z) {
        this.jMd = z;
    }

    public boolean cxz() {
        return this.jMd;
    }

    public void Fv(String str) {
        this.bLi = str;
    }

    public String cxA() {
        return this.bLi;
    }
}
