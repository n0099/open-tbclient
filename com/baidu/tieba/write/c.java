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
public class c {
    private int bgColor;
    private String cxh;
    private int gMR;
    private ArrayList<String> kKQ;
    private int kKR;
    private int kKS;
    private int kKT = -1;
    private boolean kKU = false;
    private boolean kKV = false;

    public SpannableStringBuilder a(Editable editable) {
        if (editable == null || StringUtils.isNull(editable.toString()) || v.isEmpty(this.kKQ)) {
            return null;
        }
        String obj = editable.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
        boolean z = this.kKT >= 0;
        this.kKT = -1;
        Iterator<String> it = this.kKQ.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!StringUtils.isNull(next)) {
                a(spannableStringBuilder, obj, next);
            }
        }
        if (this.kKT >= 0 || z) {
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
        if (this.gMR != 0 || this.bgColor != 0) {
            int indexOf = str.indexOf(str2);
            int length = str2.length();
            if (indexOf >= 0) {
                if (this.kKT == -1) {
                    this.kKT = indexOf + length;
                } else if (indexOf + length < this.kKT) {
                    this.kKT = indexOf + length;
                }
            }
            while (indexOf >= 0) {
                if (this.gMR != 0) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.gMR), indexOf, indexOf + length, 33);
                }
                if (this.bgColor != 0) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.bgColor), indexOf, indexOf + length, 33);
                }
                indexOf = str.indexOf(str2, indexOf + 1);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.kKR != 0) {
            this.gMR = am.getColor(this.kKR);
        }
        if (this.kKS != 0) {
            this.bgColor = am.getColor(this.kKS);
        }
    }

    public void aV(ArrayList<String> arrayList) {
        this.kKQ = arrayList;
    }

    public ArrayList<String> cSM() {
        return this.kKQ;
    }

    public void DU(int i) {
        this.kKR = i;
        this.gMR = am.getColor(this.kKR);
    }

    public void DV(int i) {
        this.kKS = i;
        this.bgColor = am.getColor(this.kKS);
    }

    public int cSN() {
        return this.kKT;
    }

    public void tC(boolean z) {
        this.kKU = z;
    }

    public boolean cSO() {
        return this.kKU;
    }

    public void tD(boolean z) {
        this.kKV = z;
    }

    public boolean cSP() {
        return this.kKV;
    }

    public void Kx(String str) {
        this.cxh = str;
    }

    public String cSQ() {
        return this.cxh;
    }
}
