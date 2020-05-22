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
    private String dlF;
    private int hPe;
    private ArrayList<String> lQc;
    private int lQd;
    private int lQe;
    private int lQf = -1;
    private boolean lQg = false;
    private boolean lQh = false;

    public SpannableStringBuilder a(Editable editable) {
        if (editable == null || StringUtils.isNull(editable.toString()) || v.isEmpty(this.lQc)) {
            return null;
        }
        String obj = editable.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
        boolean z = this.lQf >= 0;
        this.lQf = -1;
        Iterator<String> it = this.lQc.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!StringUtils.isNull(next)) {
                a(spannableStringBuilder, obj, next);
            }
        }
        if (this.lQf >= 0 || z) {
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
        if (this.hPe != 0 || this.bgColor != 0) {
            int indexOf = str.indexOf(str2);
            int length = str2.length();
            if (indexOf >= 0) {
                if (this.lQf == -1) {
                    this.lQf = indexOf + length;
                } else if (indexOf + length < this.lQf) {
                    this.lQf = indexOf + length;
                }
            }
            while (indexOf >= 0) {
                if (this.hPe != 0) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.hPe), indexOf, indexOf + length, 33);
                }
                if (this.bgColor != 0) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.bgColor), indexOf, indexOf + length, 33);
                }
                indexOf = str.indexOf(str2, indexOf + 1);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.lQd != 0) {
            this.hPe = am.getColor(this.lQd);
        }
        if (this.lQe != 0) {
            this.bgColor = am.getColor(this.lQe);
        }
    }

    public void aX(ArrayList<String> arrayList) {
        this.lQc = arrayList;
    }

    public ArrayList<String> dmg() {
        return this.lQc;
    }

    public void Ft(int i) {
        this.lQd = i;
        this.hPe = am.getColor(this.lQd);
    }

    public void Fu(int i) {
        this.lQe = i;
        this.bgColor = am.getColor(this.lQe);
    }

    public int dmh() {
        return this.lQf;
    }

    public void vl(boolean z) {
        this.lQg = z;
    }

    public boolean dmi() {
        return this.lQg;
    }

    public void vm(boolean z) {
        this.lQh = z;
    }

    public boolean dmj() {
        return this.lQh;
    }

    public void Of(String str) {
        this.dlF = str;
    }

    public String dmk() {
        return this.dlF;
    }
}
