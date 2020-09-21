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
    private String dHt;
    private int iEM;
    private ArrayList<String> mWb;
    private int mWc;
    private int mWd;
    private int mWe = -1;
    private boolean mWf = false;
    private boolean mWg = false;

    public SpannableStringBuilder c(Editable editable) {
        if (editable == null || StringUtils.isNull(editable.toString()) || y.isEmpty(this.mWb)) {
            return null;
        }
        String obj = editable.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
        boolean z = this.mWe >= 0;
        this.mWe = -1;
        Iterator<String> it = this.mWb.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!StringUtils.isNull(next)) {
                a(spannableStringBuilder, obj, next);
            }
        }
        if (this.mWe >= 0 || z) {
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
        if (this.iEM != 0 || this.bgColor != 0) {
            int indexOf = str.indexOf(str2);
            int length = str2.length();
            if (indexOf >= 0) {
                if (this.mWe == -1) {
                    this.mWe = indexOf + length;
                } else if (indexOf + length < this.mWe) {
                    this.mWe = indexOf + length;
                }
            }
            while (indexOf >= 0) {
                if (this.iEM != 0) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.iEM), indexOf, indexOf + length, 33);
                }
                if (this.bgColor != 0) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.bgColor), indexOf, indexOf + length, 33);
                }
                indexOf = str.indexOf(str2, indexOf + 1);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.mWc != 0) {
            this.iEM = ap.getColor(this.mWc);
        }
        if (this.mWd != 0) {
            this.bgColor = ap.getColor(this.mWd);
        }
    }

    public void bh(ArrayList<String> arrayList) {
        this.mWb = arrayList;
    }

    public ArrayList<String> dJx() {
        return this.mWb;
    }

    public void JV(int i) {
        this.mWc = i;
        this.iEM = ap.getColor(this.mWc);
    }

    public void JW(int i) {
        this.mWd = i;
        this.bgColor = ap.getColor(this.mWd);
    }

    public int dJy() {
        return this.mWe;
    }

    public void xi(boolean z) {
        this.mWf = z;
    }

    public boolean dJz() {
        return this.mWf;
    }

    public void xj(boolean z) {
        this.mWg = z;
    }

    public boolean dJA() {
        return this.mWg;
    }

    public void SW(String str) {
        this.dHt = str;
    }

    public String dJB() {
        return this.dHt;
    }
}
