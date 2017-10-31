package com.baidu.tieba.write;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class b {
    private int bgColor;
    private ArrayList<String> gPa;
    private String gPb;
    private int gPc;
    private int gPd;
    private int gPe;
    private int gPf = -1;
    private boolean gPg = false;
    private boolean gPh = false;

    public SpannableStringBuilder b(Editable editable) {
        if (editable == null || StringUtils.isNull(editable.toString()) || v.v(this.gPa)) {
            return null;
        }
        String obj = editable.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
        boolean z = this.gPf >= 0;
        this.gPf = -1;
        Iterator<String> it = this.gPa.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!StringUtils.isNull(next)) {
                a(spannableStringBuilder, obj, next);
            }
        }
        if (this.gPf >= 0 || z) {
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
        if (this.gPe != 0 || this.bgColor != 0) {
            int indexOf = str.indexOf(str2);
            int length = str2.length();
            if (indexOf >= 0) {
                if (this.gPf == -1) {
                    this.gPf = indexOf + length;
                } else if (indexOf + length < this.gPf) {
                    this.gPf = indexOf + length;
                }
            }
            while (indexOf >= 0) {
                if (this.gPe != 0) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.gPe), indexOf, indexOf + length, 33);
                }
                if (this.bgColor != 0) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.bgColor), indexOf, indexOf + length, 33);
                }
                indexOf = str.indexOf(str2, indexOf + 1);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.gPc != 0) {
            this.gPe = aj.getColor(this.gPc);
        }
        if (this.gPd != 0) {
            this.bgColor = aj.getColor(this.gPd);
        }
    }

    public void aB(ArrayList<String> arrayList) {
        this.gPa = arrayList;
    }

    public ArrayList<String> bCd() {
        return this.gPa;
    }

    public void vc(int i) {
        this.gPc = i;
        this.gPe = aj.getColor(this.gPc);
    }

    public void vd(int i) {
        this.gPd = i;
        this.bgColor = aj.getColor(this.gPd);
    }

    public int bCe() {
        return this.gPf;
    }

    public void ni(boolean z) {
        this.gPg = z;
    }

    public boolean bCf() {
        return this.gPg;
    }

    public void nj(boolean z) {
        this.gPh = z;
    }

    public boolean bCg() {
        return this.gPh;
    }

    public void tI(String str) {
        this.gPb = str;
    }

    public String bCh() {
        return this.gPb;
    }
}
