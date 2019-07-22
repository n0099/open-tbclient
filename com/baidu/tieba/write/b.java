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
    private int bgColor;
    private String bsQ;
    private int fTT;
    private ArrayList<String> jLh;
    private int jLi;
    private int jLj;
    private int jLk = -1;
    private boolean jLl = false;
    private boolean jLm = false;

    public SpannableStringBuilder b(Editable editable) {
        if (editable == null || StringUtils.isNull(editable.toString()) || v.aa(this.jLh)) {
            return null;
        }
        String obj = editable.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
        boolean z = this.jLk >= 0;
        this.jLk = -1;
        Iterator<String> it = this.jLh.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!StringUtils.isNull(next)) {
                a(spannableStringBuilder, obj, next);
            }
        }
        if (this.jLk >= 0 || z) {
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
        if (this.fTT != 0 || this.bgColor != 0) {
            int indexOf = str.indexOf(str2);
            int length = str2.length();
            if (indexOf >= 0) {
                if (this.jLk == -1) {
                    this.jLk = indexOf + length;
                } else if (indexOf + length < this.jLk) {
                    this.jLk = indexOf + length;
                }
            }
            while (indexOf >= 0) {
                if (this.fTT != 0) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.fTT), indexOf, indexOf + length, 33);
                }
                if (this.bgColor != 0) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.bgColor), indexOf, indexOf + length, 33);
                }
                indexOf = str.indexOf(str2, indexOf + 1);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.jLi != 0) {
            this.fTT = am.getColor(this.jLi);
        }
        if (this.jLj != 0) {
            this.bgColor = am.getColor(this.jLj);
        }
    }

    public void aI(ArrayList<String> arrayList) {
        this.jLh = arrayList;
    }

    public ArrayList<String> cze() {
        return this.jLh;
    }

    public void CI(int i) {
        this.jLi = i;
        this.fTT = am.getColor(this.jLi);
    }

    public void CJ(int i) {
        this.jLj = i;
        this.bgColor = am.getColor(this.jLj);
    }

    public int czf() {
        return this.jLk;
    }

    public void rZ(boolean z) {
        this.jLl = z;
    }

    public boolean czg() {
        return this.jLl;
    }

    public void sa(boolean z) {
        this.jLm = z;
    }

    public boolean czh() {
        return this.jLm;
    }

    public void GA(String str) {
        this.bsQ = str;
    }

    public String czi() {
        return this.bsQ;
    }
}
