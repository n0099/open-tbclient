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
    private String cwW;
    private int gJE;
    private ArrayList<String> kHk;
    private int kHl;
    private int kHm;
    private int kHn = -1;
    private boolean kHo = false;
    private boolean kHp = false;

    public SpannableStringBuilder a(Editable editable) {
        if (editable == null || StringUtils.isNull(editable.toString()) || v.isEmpty(this.kHk)) {
            return null;
        }
        String obj = editable.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
        boolean z = this.kHn >= 0;
        this.kHn = -1;
        Iterator<String> it = this.kHk.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!StringUtils.isNull(next)) {
                a(spannableStringBuilder, obj, next);
            }
        }
        if (this.kHn >= 0 || z) {
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
        if (this.gJE != 0 || this.bgColor != 0) {
            int indexOf = str.indexOf(str2);
            int length = str2.length();
            if (indexOf >= 0) {
                if (this.kHn == -1) {
                    this.kHn = indexOf + length;
                } else if (indexOf + length < this.kHn) {
                    this.kHn = indexOf + length;
                }
            }
            while (indexOf >= 0) {
                if (this.gJE != 0) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.gJE), indexOf, indexOf + length, 33);
                }
                if (this.bgColor != 0) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.bgColor), indexOf, indexOf + length, 33);
                }
                indexOf = str.indexOf(str2, indexOf + 1);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.kHl != 0) {
            this.gJE = am.getColor(this.kHl);
        }
        if (this.kHm != 0) {
            this.bgColor = am.getColor(this.kHm);
        }
    }

    public void aV(ArrayList<String> arrayList) {
        this.kHk = arrayList;
    }

    public ArrayList<String> cRH() {
        return this.kHk;
    }

    public void DO(int i) {
        this.kHl = i;
        this.gJE = am.getColor(this.kHl);
    }

    public void DP(int i) {
        this.kHm = i;
        this.bgColor = am.getColor(this.kHm);
    }

    public int cRI() {
        return this.kHn;
    }

    public void tq(boolean z) {
        this.kHo = z;
    }

    public boolean cRJ() {
        return this.kHo;
    }

    public void tr(boolean z) {
        this.kHp = z;
    }

    public boolean cRK() {
        return this.kHp;
    }

    public void Kn(String str) {
        this.cwW = str;
    }

    public String cRL() {
        return this.cwW;
    }
}
