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
    private int jNI;
    private ArrayList<String> ocw;
    private int ocx;
    private int ocy;
    private int ocz = -1;
    private boolean ocA = false;
    private boolean ocB = false;

    public SpannableStringBuilder d(Editable editable) {
        if (editable == null || StringUtils.isNull(editable.toString()) || y.isEmpty(this.ocw)) {
            return null;
        }
        String obj = editable.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
        boolean z = this.ocz >= 0;
        this.ocz = -1;
        Iterator<String> it = this.ocw.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!StringUtils.isNull(next)) {
                a(spannableStringBuilder, obj, next);
            }
        }
        if (this.ocz >= 0 || z) {
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
        if (this.jNI != 0 || this.bgColor != 0) {
            int indexOf = str.indexOf(str2);
            int length = str2.length();
            if (indexOf >= 0) {
                if (this.ocz == -1) {
                    this.ocz = indexOf + length;
                } else if (indexOf + length < this.ocz) {
                    this.ocz = indexOf + length;
                }
            }
            while (indexOf >= 0) {
                if (this.jNI != 0) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.jNI), indexOf, indexOf + length, 33);
                }
                if (this.bgColor != 0) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.bgColor), indexOf, indexOf + length, 33);
                }
                indexOf = str.indexOf(str2, indexOf + 1);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.ocx != 0) {
            this.jNI = ap.getColor(this.ocx);
        }
        if (this.ocy != 0) {
            this.bgColor = ap.getColor(this.ocy);
        }
    }

    public void bg(ArrayList<String> arrayList) {
        this.ocw = arrayList;
    }

    public ArrayList<String> dWn() {
        return this.ocw;
    }

    public void Lc(int i) {
        this.ocx = i;
        this.jNI = ap.getColor(this.ocx);
    }

    public void Ld(int i) {
        this.ocy = i;
        this.bgColor = ap.getColor(this.ocy);
    }

    public int dWo() {
        return this.ocz;
    }

    public void zt(boolean z) {
        this.ocA = z;
    }

    public boolean dWp() {
        return this.ocA;
    }

    public void zu(boolean z) {
        this.ocB = z;
    }

    public boolean dWq() {
        return this.ocB;
    }

    public void UV(String str) {
        this.eue = str;
    }

    public String dWr() {
        return this.eue;
    }
}
