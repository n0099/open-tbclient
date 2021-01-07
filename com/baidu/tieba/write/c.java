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
    private ArrayList<String> nWU;
    private int nWV;
    private int nWW;
    private int nWX = -1;
    private boolean nWY = false;
    private boolean nWZ = false;

    public SpannableStringBuilder d(Editable editable) {
        if (editable == null || StringUtils.isNull(editable.toString()) || x.isEmpty(this.nWU)) {
            return null;
        }
        String obj = editable.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
        boolean z = this.nWX >= 0;
        this.nWX = -1;
        Iterator<String> it = this.nWU.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!StringUtils.isNull(next)) {
                a(spannableStringBuilder, obj, next);
            }
        }
        if (this.nWX >= 0 || z) {
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
                if (this.nWX == -1) {
                    this.nWX = indexOf + length;
                } else if (indexOf + length < this.nWX) {
                    this.nWX = indexOf + length;
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
        if (this.nWV != 0) {
            this.jMK = ao.getColor(this.nWV);
        }
        if (this.nWW != 0) {
            this.bgColor = ao.getColor(this.nWW);
        }
    }

    public void bm(ArrayList<String> arrayList) {
        this.nWU = arrayList;
    }

    public ArrayList<String> dXR() {
        return this.nWU;
    }

    public void Mo(int i) {
        this.nWV = i;
        this.jMK = ao.getColor(this.nWV);
    }

    public void Mp(int i) {
        this.nWW = i;
        this.bgColor = ao.getColor(this.nWW);
    }

    public int dXS() {
        return this.nWX;
    }

    public void zb(boolean z) {
        this.nWY = z;
    }

    public boolean dXT() {
        return this.nWY;
    }

    public void zc(boolean z) {
        this.nWZ = z;
    }

    public boolean dXU() {
        return this.nWZ;
    }

    public void Ve(String str) {
        this.ewK = str;
    }

    public String dXV() {
        return this.ewK;
    }
}
