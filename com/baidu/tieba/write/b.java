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
    private String blV;
    private int fyl;
    private ArrayList<String> jli;
    private int jlj;
    private int jlk;
    private int jll = -1;
    private boolean jlm = false;
    private boolean jln = false;

    public SpannableStringBuilder b(Editable editable) {
        if (editable == null || StringUtils.isNull(editable.toString()) || v.T(this.jli)) {
            return null;
        }
        String obj = editable.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
        boolean z = this.jll >= 0;
        this.jll = -1;
        Iterator<String> it = this.jli.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!StringUtils.isNull(next)) {
                a(spannableStringBuilder, obj, next);
            }
        }
        if (this.jll >= 0 || z) {
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
        if (this.fyl != 0 || this.bgColor != 0) {
            int indexOf = str.indexOf(str2);
            int length = str2.length();
            if (indexOf >= 0) {
                if (this.jll == -1) {
                    this.jll = indexOf + length;
                } else if (indexOf + length < this.jll) {
                    this.jll = indexOf + length;
                }
            }
            while (indexOf >= 0) {
                if (this.fyl != 0) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.fyl), indexOf, indexOf + length, 33);
                }
                if (this.bgColor != 0) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.bgColor), indexOf, indexOf + length, 33);
                }
                indexOf = str.indexOf(str2, indexOf + 1);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.jlj != 0) {
            this.fyl = al.getColor(this.jlj);
        }
        if (this.jlk != 0) {
            this.bgColor = al.getColor(this.jlk);
        }
    }

    public void aE(ArrayList<String> arrayList) {
        this.jli = arrayList;
    }

    public ArrayList<String> cnY() {
        return this.jli;
    }

    public void AW(int i) {
        this.jlj = i;
        this.fyl = al.getColor(this.jlj);
    }

    public void AX(int i) {
        this.jlk = i;
        this.bgColor = al.getColor(this.jlk);
    }

    public int cnZ() {
        return this.jll;
    }

    public void qU(boolean z) {
        this.jlm = z;
    }

    public boolean coa() {
        return this.jlm;
    }

    public void qV(boolean z) {
        this.jln = z;
    }

    public boolean cob() {
        return this.jln;
    }

    public void Ej(String str) {
        this.blV = str;
    }

    public String coc() {
        return this.blV;
    }
}
