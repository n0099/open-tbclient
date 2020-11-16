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
    private String ega;
    private int jmH;
    private ArrayList<String> nFs;
    private int nFt;
    private int nFu;
    private int nFv = -1;
    private boolean nFw = false;
    private boolean nFx = false;

    public SpannableStringBuilder c(Editable editable) {
        if (editable == null || StringUtils.isNull(editable.toString()) || y.isEmpty(this.nFs)) {
            return null;
        }
        String obj = editable.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
        boolean z = this.nFv >= 0;
        this.nFv = -1;
        Iterator<String> it = this.nFs.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!StringUtils.isNull(next)) {
                a(spannableStringBuilder, obj, next);
            }
        }
        if (this.nFv >= 0 || z) {
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
        if (this.jmH != 0 || this.bgColor != 0) {
            int indexOf = str.indexOf(str2);
            int length = str2.length();
            if (indexOf >= 0) {
                if (this.nFv == -1) {
                    this.nFv = indexOf + length;
                } else if (indexOf + length < this.nFv) {
                    this.nFv = indexOf + length;
                }
            }
            while (indexOf >= 0) {
                if (this.jmH != 0) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.jmH), indexOf, indexOf + length, 33);
                }
                if (this.bgColor != 0) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.bgColor), indexOf, indexOf + length, 33);
                }
                indexOf = str.indexOf(str2, indexOf + 1);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.nFt != 0) {
            this.jmH = ap.getColor(this.nFt);
        }
        if (this.nFu != 0) {
            this.bgColor = ap.getColor(this.nFu);
        }
    }

    public void bl(ArrayList<String> arrayList) {
        this.nFs = arrayList;
    }

    public ArrayList<String> dSS() {
        return this.nFs;
    }

    public void LJ(int i) {
        this.nFt = i;
        this.jmH = ap.getColor(this.nFt);
    }

    public void LK(int i) {
        this.nFu = i;
        this.bgColor = ap.getColor(this.nFu);
    }

    public int dST() {
        return this.nFv;
    }

    public void yw(boolean z) {
        this.nFw = z;
    }

    public boolean dSU() {
        return this.nFw;
    }

    public void yx(boolean z) {
        this.nFx = z;
    }

    public boolean dSV() {
        return this.nFx;
    }

    public void Ul(String str) {
        this.ega = str;
    }

    public String dSW() {
        return this.ega;
    }
}
