package com.baidu.tieba.write;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class b {
    private int bgColor;
    private ArrayList<String> hLY;
    private String hLZ;
    private int hMa;
    private int hMb;
    private int hMc;
    private int hMd = -1;
    private boolean hMe = false;
    private boolean hMf = false;

    public SpannableStringBuilder b(Editable editable) {
        if (editable == null || StringUtils.isNull(editable.toString()) || v.G(this.hLY)) {
            return null;
        }
        String obj = editable.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
        boolean z = this.hMd >= 0;
        this.hMd = -1;
        Iterator<String> it = this.hLY.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!StringUtils.isNull(next)) {
                a(spannableStringBuilder, obj, next);
            }
        }
        if (this.hMd >= 0 || z) {
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
        if (this.hMc != 0 || this.bgColor != 0) {
            int indexOf = str.indexOf(str2);
            int length = str2.length();
            if (indexOf >= 0) {
                if (this.hMd == -1) {
                    this.hMd = indexOf + length;
                } else if (indexOf + length < this.hMd) {
                    this.hMd = indexOf + length;
                }
            }
            while (indexOf >= 0) {
                if (this.hMc != 0) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.hMc), indexOf, indexOf + length, 33);
                }
                if (this.bgColor != 0) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.bgColor), indexOf, indexOf + length, 33);
                }
                indexOf = str.indexOf(str2, indexOf + 1);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.hMa != 0) {
            this.hMc = aj.getColor(this.hMa);
        }
        if (this.hMb != 0) {
            this.bgColor = aj.getColor(this.hMb);
        }
    }

    public void aB(ArrayList<String> arrayList) {
        this.hLY = arrayList;
    }

    public ArrayList<String> bLm() {
        return this.hLY;
    }

    public void yD(int i) {
        this.hMa = i;
        this.hMc = aj.getColor(this.hMa);
    }

    public void yE(int i) {
        this.hMb = i;
        this.bgColor = aj.getColor(this.hMb);
    }

    public int bLn() {
        return this.hMd;
    }

    public void on(boolean z) {
        this.hMe = z;
    }

    public boolean bLo() {
        return this.hMe;
    }

    public void oo(boolean z) {
        this.hMf = z;
    }

    public boolean bLp() {
        return this.hMf;
    }

    public void uE(String str) {
        this.hLZ = str;
    }

    public String bLq() {
        return this.hLZ;
    }
}
