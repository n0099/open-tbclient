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
    private String ebQ;
    private int jfY;
    private ArrayList<String> nyb;
    private int nyc;
    private int nyd;
    private int nye = -1;
    private boolean nyf = false;
    private boolean nyg = false;

    public SpannableStringBuilder c(Editable editable) {
        if (editable == null || StringUtils.isNull(editable.toString()) || y.isEmpty(this.nyb)) {
            return null;
        }
        String obj = editable.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
        boolean z = this.nye >= 0;
        this.nye = -1;
        Iterator<String> it = this.nyb.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!StringUtils.isNull(next)) {
                a(spannableStringBuilder, obj, next);
            }
        }
        if (this.nye >= 0 || z) {
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
        if (this.jfY != 0 || this.bgColor != 0) {
            int indexOf = str.indexOf(str2);
            int length = str2.length();
            if (indexOf >= 0) {
                if (this.nye == -1) {
                    this.nye = indexOf + length;
                } else if (indexOf + length < this.nye) {
                    this.nye = indexOf + length;
                }
            }
            while (indexOf >= 0) {
                if (this.jfY != 0) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.jfY), indexOf, indexOf + length, 33);
                }
                if (this.bgColor != 0) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.bgColor), indexOf, indexOf + length, 33);
                }
                indexOf = str.indexOf(str2, indexOf + 1);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.nyc != 0) {
            this.jfY = ap.getColor(this.nyc);
        }
        if (this.nyd != 0) {
            this.bgColor = ap.getColor(this.nyd);
        }
    }

    public void bk(ArrayList<String> arrayList) {
        this.nyb = arrayList;
    }

    public ArrayList<String> dQr() {
        return this.nyb;
    }

    public void KT(int i) {
        this.nyc = i;
        this.jfY = ap.getColor(this.nyc);
    }

    public void KU(int i) {
        this.nyd = i;
        this.bgColor = ap.getColor(this.nyd);
    }

    public int dQs() {
        return this.nye;
    }

    public void yg(boolean z) {
        this.nyf = z;
    }

    public boolean dQt() {
        return this.nyf;
    }

    public void yh(boolean z) {
        this.nyg = z;
    }

    public boolean dQu() {
        return this.nyg;
    }

    public void Uj(String str) {
        this.ebQ = str;
    }

    public String dQv() {
        return this.ebQ;
    }
}
