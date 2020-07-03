package com.baidu.tieba.write;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c {
    private int bgColor;
    private String dqq;
    private int idc;
    private ArrayList<String> mlw;
    private int mlx;
    private int mly;
    private int mlz = -1;
    private boolean mlA = false;
    private boolean mlB = false;

    public SpannableStringBuilder d(Editable editable) {
        if (editable == null || StringUtils.isNull(editable.toString()) || w.isEmpty(this.mlw)) {
            return null;
        }
        String obj = editable.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
        boolean z = this.mlz >= 0;
        this.mlz = -1;
        Iterator<String> it = this.mlw.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!StringUtils.isNull(next)) {
                a(spannableStringBuilder, obj, next);
            }
        }
        if (this.mlz >= 0 || z) {
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
        if (this.idc != 0 || this.bgColor != 0) {
            int indexOf = str.indexOf(str2);
            int length = str2.length();
            if (indexOf >= 0) {
                if (this.mlz == -1) {
                    this.mlz = indexOf + length;
                } else if (indexOf + length < this.mlz) {
                    this.mlz = indexOf + length;
                }
            }
            while (indexOf >= 0) {
                if (this.idc != 0) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.idc), indexOf, indexOf + length, 33);
                }
                if (this.bgColor != 0) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.bgColor), indexOf, indexOf + length, 33);
                }
                indexOf = str.indexOf(str2, indexOf + 1);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.mlx != 0) {
            this.idc = an.getColor(this.mlx);
        }
        if (this.mly != 0) {
            this.bgColor = an.getColor(this.mly);
        }
    }

    public void aY(ArrayList<String> arrayList) {
        this.mlw = arrayList;
    }

    public ArrayList<String> dqI() {
        return this.mlw;
    }

    public void Gz(int i) {
        this.mlx = i;
        this.idc = an.getColor(this.mlx);
    }

    public void GA(int i) {
        this.mly = i;
        this.bgColor = an.getColor(this.mly);
    }

    public int dqJ() {
        return this.mlz;
    }

    public void vE(boolean z) {
        this.mlA = z;
    }

    public boolean dqK() {
        return this.mlA;
    }

    public void vF(boolean z) {
        this.mlB = z;
    }

    public boolean dqL() {
        return this.mlB;
    }

    public void OM(String str) {
        this.dqq = str;
    }

    public String dqM() {
        return this.dqq;
    }
}
