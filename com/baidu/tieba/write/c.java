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
    private ArrayList<String> kKL;
    private int kKM;
    private int kKN;
    private int kKO = -1;
    private boolean kKP = false;
    private boolean kKQ = false;

    public SpannableStringBuilder a(Editable editable) {
        if (editable == null || StringUtils.isNull(editable.toString()) || v.isEmpty(this.kKL)) {
            return null;
        }
        String obj = editable.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
        boolean z = this.kKO >= 0;
        this.kKO = -1;
        Iterator<String> it = this.kKL.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!StringUtils.isNull(next)) {
                a(spannableStringBuilder, obj, next);
            }
        }
        if (this.kKO >= 0 || z) {
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
                if (this.kKO == -1) {
                    this.kKO = indexOf + length;
                } else if (indexOf + length < this.kKO) {
                    this.kKO = indexOf + length;
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
        if (this.kKM != 0) {
            this.gMR = am.getColor(this.kKM);
        }
        if (this.kKN != 0) {
            this.bgColor = am.getColor(this.kKN);
        }
    }

    public void aV(ArrayList<String> arrayList) {
        this.kKL = arrayList;
    }

    public ArrayList<String> cSK() {
        return this.kKL;
    }

    public void DU(int i) {
        this.kKM = i;
        this.gMR = am.getColor(this.kKM);
    }

    public void DV(int i) {
        this.kKN = i;
        this.bgColor = am.getColor(this.kKN);
    }

    public int cSL() {
        return this.kKO;
    }

    public void tC(boolean z) {
        this.kKP = z;
    }

    public boolean cSM() {
        return this.kKP;
    }

    public void tD(boolean z) {
        this.kKQ = z;
    }

    public boolean cSN() {
        return this.kKQ;
    }

    public void Kx(String str) {
        this.cxh = str;
    }

    public String cSO() {
        return this.cxh;
    }
}
