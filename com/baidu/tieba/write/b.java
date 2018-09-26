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
    private ArrayList<String> hAo;
    private String hAp;
    private int hAq;
    private int hAr;
    private int hAs;
    private int hAt = -1;
    private boolean hAu = false;
    private boolean hAv = false;

    public SpannableStringBuilder b(Editable editable) {
        if (editable == null || StringUtils.isNull(editable.toString()) || v.z(this.hAo)) {
            return null;
        }
        String obj = editable.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
        boolean z = this.hAt >= 0;
        this.hAt = -1;
        Iterator<String> it = this.hAo.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!StringUtils.isNull(next)) {
                a(spannableStringBuilder, obj, next);
            }
        }
        if (this.hAt >= 0 || z) {
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
        if (this.hAs != 0 || this.bgColor != 0) {
            int indexOf = str.indexOf(str2);
            int length = str2.length();
            if (indexOf >= 0) {
                if (this.hAt == -1) {
                    this.hAt = indexOf + length;
                } else if (indexOf + length < this.hAt) {
                    this.hAt = indexOf + length;
                }
            }
            while (indexOf >= 0) {
                if (this.hAs != 0) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.hAs), indexOf, indexOf + length, 33);
                }
                if (this.bgColor != 0) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.bgColor), indexOf, indexOf + length, 33);
                }
                indexOf = str.indexOf(str2, indexOf + 1);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.hAq != 0) {
            this.hAs = al.getColor(this.hAq);
        }
        if (this.hAr != 0) {
            this.bgColor = al.getColor(this.hAr);
        }
    }

    public void aA(ArrayList<String> arrayList) {
        this.hAo = arrayList;
    }

    public ArrayList<String> bIe() {
        return this.hAo;
    }

    public void vI(int i) {
        this.hAq = i;
        this.hAs = al.getColor(this.hAq);
    }

    public void vJ(int i) {
        this.hAr = i;
        this.bgColor = al.getColor(this.hAr);
    }

    public int bIf() {
        return this.hAt;
    }

    public void nK(boolean z) {
        this.hAu = z;
    }

    public boolean bIg() {
        return this.hAu;
    }

    public void nL(boolean z) {
        this.hAv = z;
    }

    public boolean bIh() {
        return this.hAv;
    }

    public void wi(String str) {
        this.hAp = str;
    }

    public String bIi() {
        return this.hAp;
    }
}
