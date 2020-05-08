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
public class c {
    private int bgColor;
    private String daw;
    private int hAr;
    private ArrayList<String> lwO;
    private int lwP;
    private int lwQ;
    private int lwR = -1;
    private boolean lwS = false;
    private boolean lwT = false;

    public SpannableStringBuilder a(Editable editable) {
        if (editable == null || StringUtils.isNull(editable.toString()) || v.isEmpty(this.lwO)) {
            return null;
        }
        String obj = editable.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
        boolean z = this.lwR >= 0;
        this.lwR = -1;
        Iterator<String> it = this.lwO.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!StringUtils.isNull(next)) {
                a(spannableStringBuilder, obj, next);
            }
        }
        if (this.lwR >= 0 || z) {
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
        if (this.hAr != 0 || this.bgColor != 0) {
            int indexOf = str.indexOf(str2);
            int length = str2.length();
            if (indexOf >= 0) {
                if (this.lwR == -1) {
                    this.lwR = indexOf + length;
                } else if (indexOf + length < this.lwR) {
                    this.lwR = indexOf + length;
                }
            }
            while (indexOf >= 0) {
                if (this.hAr != 0) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.hAr), indexOf, indexOf + length, 33);
                }
                if (this.bgColor != 0) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.bgColor), indexOf, indexOf + length, 33);
                }
                indexOf = str.indexOf(str2, indexOf + 1);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.lwP != 0) {
            this.hAr = am.getColor(this.lwP);
        }
        if (this.lwQ != 0) {
            this.bgColor = am.getColor(this.lwQ);
        }
    }

    public void aW(ArrayList<String> arrayList) {
        this.lwO = arrayList;
    }

    public ArrayList<String> deP() {
        return this.lwO;
    }

    public void EI(int i) {
        this.lwP = i;
        this.hAr = am.getColor(this.lwP);
    }

    public void EJ(int i) {
        this.lwQ = i;
        this.bgColor = am.getColor(this.lwQ);
    }

    public int deQ() {
        return this.lwR;
    }

    public void uN(boolean z) {
        this.lwS = z;
    }

    public boolean deR() {
        return this.lwS;
    }

    public void uO(boolean z) {
        this.lwT = z;
    }

    public boolean deS() {
        return this.lwT;
    }

    public void Ms(String str) {
        this.daw = str;
    }

    public String deT() {
        return this.daw;
    }
}
