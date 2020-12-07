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
    private int jAj;
    private int nTA;
    private int nTB = -1;
    private boolean nTC = false;
    private boolean nTD = false;
    private ArrayList<String> nTy;
    private int nTz;

    public SpannableStringBuilder c(Editable editable) {
        if (editable == null || StringUtils.isNull(editable.toString()) || y.isEmpty(this.nTy)) {
            return null;
        }
        String obj = editable.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
        boolean z = this.nTB >= 0;
        this.nTB = -1;
        Iterator<String> it = this.nTy.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!StringUtils.isNull(next)) {
                a(spannableStringBuilder, obj, next);
            }
        }
        if (this.nTB >= 0 || z) {
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
        if (this.jAj != 0 || this.bgColor != 0) {
            int indexOf = str.indexOf(str2);
            int length = str2.length();
            if (indexOf >= 0) {
                if (this.nTB == -1) {
                    this.nTB = indexOf + length;
                } else if (indexOf + length < this.nTB) {
                    this.nTB = indexOf + length;
                }
            }
            while (indexOf >= 0) {
                if (this.jAj != 0) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.jAj), indexOf, indexOf + length, 33);
                }
                if (this.bgColor != 0) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.bgColor), indexOf, indexOf + length, 33);
                }
                indexOf = str.indexOf(str2, indexOf + 1);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.nTz != 0) {
            this.jAj = ap.getColor(this.nTz);
        }
        if (this.nTA != 0) {
            this.bgColor = ap.getColor(this.nTA);
        }
    }

    public void bn(ArrayList<String> arrayList) {
        this.nTy = arrayList;
    }

    public ArrayList<String> dYm() {
        return this.nTy;
    }

    public void MB(int i) {
        this.nTz = i;
        this.jAj = ap.getColor(this.nTz);
    }

    public void MC(int i) {
        this.nTA = i;
        this.bgColor = ap.getColor(this.nTA);
    }

    public int dYn() {
        return this.nTB;
    }

    public void zb(boolean z) {
        this.nTC = z;
    }

    public boolean dYo() {
        return this.nTC;
    }

    public void zc(boolean z) {
        this.nTD = z;
    }

    public boolean dYp() {
        return this.nTD;
    }

    public void VA(String str) {
        this.enb = str;
    }

    public String dYq() {
        return this.enb;
    }
}
