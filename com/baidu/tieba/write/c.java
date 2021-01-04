package com.baidu.tieba.write;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c {
    private int bgColor;
    private String ewK;
    private int jMK;
    private ArrayList<String> nWV;
    private int nWW;
    private int nWX;
    private int nWY = -1;
    private boolean nWZ = false;
    private boolean nXa = false;

    public SpannableStringBuilder d(Editable editable) {
        if (editable == null || StringUtils.isNull(editable.toString()) || x.isEmpty(this.nWV)) {
            return null;
        }
        String obj = editable.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
        boolean z = this.nWY >= 0;
        this.nWY = -1;
        Iterator<String> it = this.nWV.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!StringUtils.isNull(next)) {
                a(spannableStringBuilder, obj, next);
            }
        }
        if (this.nWY >= 0 || z) {
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
        if (this.jMK != 0 || this.bgColor != 0) {
            int indexOf = str.indexOf(str2);
            int length = str2.length();
            if (indexOf >= 0) {
                if (this.nWY == -1) {
                    this.nWY = indexOf + length;
                } else if (indexOf + length < this.nWY) {
                    this.nWY = indexOf + length;
                }
            }
            while (indexOf >= 0) {
                if (this.jMK != 0) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.jMK), indexOf, indexOf + length, 33);
                }
                if (this.bgColor != 0) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.bgColor), indexOf, indexOf + length, 33);
                }
                indexOf = str.indexOf(str2, indexOf + 1);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.nWW != 0) {
            this.jMK = ao.getColor(this.nWW);
        }
        if (this.nWX != 0) {
            this.bgColor = ao.getColor(this.nWX);
        }
    }

    public void bm(ArrayList<String> arrayList) {
        this.nWV = arrayList;
    }

    public ArrayList<String> dXQ() {
        return this.nWV;
    }

    public void Mo(int i) {
        this.nWW = i;
        this.jMK = ao.getColor(this.nWW);
    }

    public void Mp(int i) {
        this.nWX = i;
        this.bgColor = ao.getColor(this.nWX);
    }

    public int dXR() {
        return this.nWY;
    }

    public void zb(boolean z) {
        this.nWZ = z;
    }

    public boolean dXS() {
        return this.nWZ;
    }

    public void zc(boolean z) {
        this.nXa = z;
    }

    public boolean dXT() {
        return this.nXa;
    }

    public void Vf(String str) {
        this.ewK = str;
    }

    public String dXU() {
        return this.ewK;
    }
}
