package com.baidu.tieba.write;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class b {
    private int bgColor;
    private ArrayList<String> hag;
    private String hah;
    private int hai;
    private int haj;
    private int hak;
    private int hal = -1;
    private boolean ham = false;
    private boolean han = false;

    public SpannableStringBuilder b(Editable editable) {
        if (editable == null || StringUtils.isNull(editable.toString()) || v.w(this.hag)) {
            return null;
        }
        String obj = editable.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
        boolean z = this.hal >= 0;
        this.hal = -1;
        Iterator<String> it = this.hag.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!StringUtils.isNull(next)) {
                a(spannableStringBuilder, obj, next);
            }
        }
        if (this.hal >= 0 || z) {
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
        if (this.hak != 0 || this.bgColor != 0) {
            int indexOf = str.indexOf(str2);
            int length = str2.length();
            if (indexOf >= 0) {
                if (this.hal == -1) {
                    this.hal = indexOf + length;
                } else if (indexOf + length < this.hal) {
                    this.hal = indexOf + length;
                }
            }
            while (indexOf >= 0) {
                if (this.hak != 0) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.hak), indexOf, indexOf + length, 33);
                }
                if (this.bgColor != 0) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.bgColor), indexOf, indexOf + length, 33);
                }
                indexOf = str.indexOf(str2, indexOf + 1);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.hai != 0) {
            this.hak = ak.getColor(this.hai);
        }
        if (this.haj != 0) {
            this.bgColor = ak.getColor(this.haj);
        }
    }

    public void ax(ArrayList<String> arrayList) {
        this.hag = arrayList;
    }

    public ArrayList<String> bAU() {
        return this.hag;
    }

    public void uK(int i) {
        this.hai = i;
        this.hak = ak.getColor(this.hai);
    }

    public void uL(int i) {
        this.haj = i;
        this.bgColor = ak.getColor(this.haj);
    }

    public int bAV() {
        return this.hal;
    }

    public void ni(boolean z) {
        this.ham = z;
    }

    public boolean bAW() {
        return this.ham;
    }

    public void nj(boolean z) {
        this.han = z;
    }

    public boolean bAX() {
        return this.han;
    }

    public void uB(String str) {
        this.hah = str;
    }

    public String bAY() {
        return this.hah;
    }
}
