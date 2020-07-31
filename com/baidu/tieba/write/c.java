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
    private String dwi;
    private int ije;
    private ArrayList<String> mtA;
    private int mtB;
    private int mtC;
    private int mtD = -1;
    private boolean mtE = false;
    private boolean mtF = false;

    public SpannableStringBuilder d(Editable editable) {
        if (editable == null || StringUtils.isNull(editable.toString()) || x.isEmpty(this.mtA)) {
            return null;
        }
        String obj = editable.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
        boolean z = this.mtD >= 0;
        this.mtD = -1;
        Iterator<String> it = this.mtA.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!StringUtils.isNull(next)) {
                a(spannableStringBuilder, obj, next);
            }
        }
        if (this.mtD >= 0 || z) {
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
        if (this.ije != 0 || this.bgColor != 0) {
            int indexOf = str.indexOf(str2);
            int length = str2.length();
            if (indexOf >= 0) {
                if (this.mtD == -1) {
                    this.mtD = indexOf + length;
                } else if (indexOf + length < this.mtD) {
                    this.mtD = indexOf + length;
                }
            }
            while (indexOf >= 0) {
                if (this.ije != 0) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.ije), indexOf, indexOf + length, 33);
                }
                if (this.bgColor != 0) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.bgColor), indexOf, indexOf + length, 33);
                }
                indexOf = str.indexOf(str2, indexOf + 1);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.mtB != 0) {
            this.ije = ao.getColor(this.mtB);
        }
        if (this.mtC != 0) {
            this.bgColor = ao.getColor(this.mtC);
        }
    }

    public void aZ(ArrayList<String> arrayList) {
        this.mtA = arrayList;
    }

    public ArrayList<String> dtY() {
        return this.mtA;
    }

    public void GV(int i) {
        this.mtB = i;
        this.ije = ao.getColor(this.mtB);
    }

    public void GW(int i) {
        this.mtC = i;
        this.bgColor = ao.getColor(this.mtC);
    }

    public int dtZ() {
        return this.mtD;
    }

    public void wi(boolean z) {
        this.mtE = z;
    }

    public boolean dua() {
        return this.mtE;
    }

    public void wj(boolean z) {
        this.mtF = z;
    }

    public boolean dub() {
        return this.mtF;
    }

    public void Py(String str) {
        this.dwi = str;
    }

    public String duc() {
        return this.dwi;
    }
}
