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
    private String eue;
    private int jNW;
    private ArrayList<String> ocW;
    private int ocX;
    private int ocY;
    private int ocZ = -1;
    private boolean oda = false;
    private boolean odb = false;

    public SpannableStringBuilder d(Editable editable) {
        if (editable == null || StringUtils.isNull(editable.toString()) || y.isEmpty(this.ocW)) {
            return null;
        }
        String obj = editable.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
        boolean z = this.ocZ >= 0;
        this.ocZ = -1;
        Iterator<String> it = this.ocW.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!StringUtils.isNull(next)) {
                a(spannableStringBuilder, obj, next);
            }
        }
        if (this.ocZ >= 0 || z) {
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
        if (this.jNW != 0 || this.bgColor != 0) {
            int indexOf = str.indexOf(str2);
            int length = str2.length();
            if (indexOf >= 0) {
                if (this.ocZ == -1) {
                    this.ocZ = indexOf + length;
                } else if (indexOf + length < this.ocZ) {
                    this.ocZ = indexOf + length;
                }
            }
            while (indexOf >= 0) {
                if (this.jNW != 0) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.jNW), indexOf, indexOf + length, 33);
                }
                if (this.bgColor != 0) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.bgColor), indexOf, indexOf + length, 33);
                }
                indexOf = str.indexOf(str2, indexOf + 1);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.ocX != 0) {
            this.jNW = ap.getColor(this.ocX);
        }
        if (this.ocY != 0) {
            this.bgColor = ap.getColor(this.ocY);
        }
    }

    public void bg(ArrayList<String> arrayList) {
        this.ocW = arrayList;
    }

    public ArrayList<String> dWv() {
        return this.ocW;
    }

    public void Ld(int i) {
        this.ocX = i;
        this.jNW = ap.getColor(this.ocX);
    }

    public void Le(int i) {
        this.ocY = i;
        this.bgColor = ap.getColor(this.ocY);
    }

    public int dWw() {
        return this.ocZ;
    }

    public void zt(boolean z) {
        this.oda = z;
    }

    public boolean dWx() {
        return this.oda;
    }

    public void zu(boolean z) {
        this.odb = z;
    }

    public boolean dWy() {
        return this.odb;
    }

    public void Vh(String str) {
        this.eue = str;
    }

    public String dWz() {
        return this.eue;
    }
}
