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
    private ArrayList<String> hDj;
    private String hDk;
    private int hDl;
    private int hDm;
    private int hDn;
    private int hDo = -1;
    private boolean hDp = false;
    private boolean hDq = false;

    public SpannableStringBuilder b(Editable editable) {
        if (editable == null || StringUtils.isNull(editable.toString()) || v.E(this.hDj)) {
            return null;
        }
        String obj = editable.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
        boolean z = this.hDo >= 0;
        this.hDo = -1;
        Iterator<String> it = this.hDj.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!StringUtils.isNull(next)) {
                a(spannableStringBuilder, obj, next);
            }
        }
        if (this.hDo >= 0 || z) {
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
        if (this.hDn != 0 || this.bgColor != 0) {
            int indexOf = str.indexOf(str2);
            int length = str2.length();
            if (indexOf >= 0) {
                if (this.hDo == -1) {
                    this.hDo = indexOf + length;
                } else if (indexOf + length < this.hDo) {
                    this.hDo = indexOf + length;
                }
            }
            while (indexOf >= 0) {
                if (this.hDn != 0) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.hDn), indexOf, indexOf + length, 33);
                }
                if (this.bgColor != 0) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.bgColor), indexOf, indexOf + length, 33);
                }
                indexOf = str.indexOf(str2, indexOf + 1);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.hDl != 0) {
            this.hDn = aj.getColor(this.hDl);
        }
        if (this.hDm != 0) {
            this.bgColor = aj.getColor(this.hDm);
        }
    }

    public void aw(ArrayList<String> arrayList) {
        this.hDj = arrayList;
    }

    public ArrayList<String> bFB() {
        return this.hDj;
    }

    public void xg(int i) {
        this.hDl = i;
        this.hDn = aj.getColor(this.hDl);
    }

    public void xh(int i) {
        this.hDm = i;
        this.bgColor = aj.getColor(this.hDm);
    }

    public int bFC() {
        return this.hDo;
    }

    public void nA(boolean z) {
        this.hDp = z;
    }

    public boolean bFD() {
        return this.hDp;
    }

    public void nB(boolean z) {
        this.hDq = z;
    }

    public boolean bFE() {
        return this.hDq;
    }

    public void un(String str) {
        this.hDk = str;
    }

    public String bFF() {
        return this.hDk;
    }
}
