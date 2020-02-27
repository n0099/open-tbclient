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
    private String cBf;
    private int gOR;
    private ArrayList<String> kLw;
    private int kLx;
    private int kLy;
    private int kLz = -1;
    private boolean kLA = false;
    private boolean kLB = false;

    public SpannableStringBuilder a(Editable editable) {
        if (editable == null || StringUtils.isNull(editable.toString()) || v.isEmpty(this.kLw)) {
            return null;
        }
        String obj = editable.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
        boolean z = this.kLz >= 0;
        this.kLz = -1;
        Iterator<String> it = this.kLw.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!StringUtils.isNull(next)) {
                a(spannableStringBuilder, obj, next);
            }
        }
        if (this.kLz >= 0 || z) {
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
        if (this.gOR != 0 || this.bgColor != 0) {
            int indexOf = str.indexOf(str2);
            int length = str2.length();
            if (indexOf >= 0) {
                if (this.kLz == -1) {
                    this.kLz = indexOf + length;
                } else if (indexOf + length < this.kLz) {
                    this.kLz = indexOf + length;
                }
            }
            while (indexOf >= 0) {
                if (this.gOR != 0) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.gOR), indexOf, indexOf + length, 33);
                }
                if (this.bgColor != 0) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.bgColor), indexOf, indexOf + length, 33);
                }
                indexOf = str.indexOf(str2, indexOf + 1);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.kLx != 0) {
            this.gOR = am.getColor(this.kLx);
        }
        if (this.kLy != 0) {
            this.bgColor = am.getColor(this.kLy);
        }
    }

    public void aU(ArrayList<String> arrayList) {
        this.kLw = arrayList;
    }

    public ArrayList<String> cUa() {
        return this.kLw;
    }

    public void DZ(int i) {
        this.kLx = i;
        this.gOR = am.getColor(this.kLx);
    }

    public void Ea(int i) {
        this.kLy = i;
        this.bgColor = am.getColor(this.kLy);
    }

    public int cUb() {
        return this.kLz;
    }

    public void tG(boolean z) {
        this.kLA = z;
    }

    public boolean cUc() {
        return this.kLA;
    }

    public void tH(boolean z) {
        this.kLB = z;
    }

    public boolean cUd() {
        return this.kLB;
    }

    public void KK(String str) {
        this.cBf = str;
    }

    public String cUe() {
        return this.cBf;
    }
}
