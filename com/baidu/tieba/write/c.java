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
    private String enb;
    private int jAl;
    private ArrayList<String> nTA;
    private int nTB;
    private int nTC;
    private int nTD = -1;
    private boolean nTE = false;
    private boolean nTF = false;

    public SpannableStringBuilder c(Editable editable) {
        if (editable == null || StringUtils.isNull(editable.toString()) || y.isEmpty(this.nTA)) {
            return null;
        }
        String obj = editable.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
        boolean z = this.nTD >= 0;
        this.nTD = -1;
        Iterator<String> it = this.nTA.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!StringUtils.isNull(next)) {
                a(spannableStringBuilder, obj, next);
            }
        }
        if (this.nTD >= 0 || z) {
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
        if (this.jAl != 0 || this.bgColor != 0) {
            int indexOf = str.indexOf(str2);
            int length = str2.length();
            if (indexOf >= 0) {
                if (this.nTD == -1) {
                    this.nTD = indexOf + length;
                } else if (indexOf + length < this.nTD) {
                    this.nTD = indexOf + length;
                }
            }
            while (indexOf >= 0) {
                if (this.jAl != 0) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.jAl), indexOf, indexOf + length, 33);
                }
                if (this.bgColor != 0) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.bgColor), indexOf, indexOf + length, 33);
                }
                indexOf = str.indexOf(str2, indexOf + 1);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.nTB != 0) {
            this.jAl = ap.getColor(this.nTB);
        }
        if (this.nTC != 0) {
            this.bgColor = ap.getColor(this.nTC);
        }
    }

    public void bn(ArrayList<String> arrayList) {
        this.nTA = arrayList;
    }

    public ArrayList<String> dYn() {
        return this.nTA;
    }

    public void MB(int i) {
        this.nTB = i;
        this.jAl = ap.getColor(this.nTB);
    }

    public void MC(int i) {
        this.nTC = i;
        this.bgColor = ap.getColor(this.nTC);
    }

    public int dYo() {
        return this.nTD;
    }

    public void zb(boolean z) {
        this.nTE = z;
    }

    public boolean dYp() {
        return this.nTE;
    }

    public void zc(boolean z) {
        this.nTF = z;
    }

    public boolean dYq() {
        return this.nTF;
    }

    public void VA(String str) {
        this.enb = str;
    }

    public String dYr() {
        return this.enb;
    }
}
