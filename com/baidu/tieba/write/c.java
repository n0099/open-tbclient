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
    private String dFp;
    private int ixq;
    private ArrayList<String> mMh;
    private int mMi;
    private int mMj;
    private int mMk = -1;
    private boolean mMl = false;
    private boolean mMm = false;

    public SpannableStringBuilder c(Editable editable) {
        if (editable == null || StringUtils.isNull(editable.toString()) || y.isEmpty(this.mMh)) {
            return null;
        }
        String obj = editable.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
        boolean z = this.mMk >= 0;
        this.mMk = -1;
        Iterator<String> it = this.mMh.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!StringUtils.isNull(next)) {
                a(spannableStringBuilder, obj, next);
            }
        }
        if (this.mMk >= 0 || z) {
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
        if (this.ixq != 0 || this.bgColor != 0) {
            int indexOf = str.indexOf(str2);
            int length = str2.length();
            if (indexOf >= 0) {
                if (this.mMk == -1) {
                    this.mMk = indexOf + length;
                } else if (indexOf + length < this.mMk) {
                    this.mMk = indexOf + length;
                }
            }
            while (indexOf >= 0) {
                if (this.ixq != 0) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.ixq), indexOf, indexOf + length, 33);
                }
                if (this.bgColor != 0) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.bgColor), indexOf, indexOf + length, 33);
                }
                indexOf = str.indexOf(str2, indexOf + 1);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.mMi != 0) {
            this.ixq = ap.getColor(this.mMi);
        }
        if (this.mMj != 0) {
            this.bgColor = ap.getColor(this.mMj);
        }
    }

    public void bf(ArrayList<String> arrayList) {
        this.mMh = arrayList;
    }

    public ArrayList<String> dFD() {
        return this.mMh;
    }

    public void Jr(int i) {
        this.mMi = i;
        this.ixq = ap.getColor(this.mMi);
    }

    public void Js(int i) {
        this.mMj = i;
        this.bgColor = ap.getColor(this.mMj);
    }

    public int dFE() {
        return this.mMk;
    }

    public void wZ(boolean z) {
        this.mMl = z;
    }

    public boolean dFF() {
        return this.mMl;
    }

    public void xa(boolean z) {
        this.mMm = z;
    }

    public boolean dFG() {
        return this.mMm;
    }

    public void Sw(String str) {
        this.dFp = str;
    }

    public String dFH() {
        return this.dFp;
    }
}
