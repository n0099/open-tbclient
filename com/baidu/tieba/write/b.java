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
    private ArrayList<String> haj;
    private String hak;
    private int hal;
    private int ham;
    private int han;
    private int hao = -1;
    private boolean hap = false;
    private boolean haq = false;

    public SpannableStringBuilder b(Editable editable) {
        if (editable == null || StringUtils.isNull(editable.toString()) || v.w(this.haj)) {
            return null;
        }
        String obj = editable.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
        boolean z = this.hao >= 0;
        this.hao = -1;
        Iterator<String> it = this.haj.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!StringUtils.isNull(next)) {
                a(spannableStringBuilder, obj, next);
            }
        }
        if (this.hao >= 0 || z) {
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
        if (this.han != 0 || this.bgColor != 0) {
            int indexOf = str.indexOf(str2);
            int length = str2.length();
            if (indexOf >= 0) {
                if (this.hao == -1) {
                    this.hao = indexOf + length;
                } else if (indexOf + length < this.hao) {
                    this.hao = indexOf + length;
                }
            }
            while (indexOf >= 0) {
                if (this.han != 0) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.han), indexOf, indexOf + length, 33);
                }
                if (this.bgColor != 0) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.bgColor), indexOf, indexOf + length, 33);
                }
                indexOf = str.indexOf(str2, indexOf + 1);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.hal != 0) {
            this.han = ak.getColor(this.hal);
        }
        if (this.ham != 0) {
            this.bgColor = ak.getColor(this.ham);
        }
    }

    public void ax(ArrayList<String> arrayList) {
        this.haj = arrayList;
    }

    public ArrayList<String> bAU() {
        return this.haj;
    }

    public void uL(int i) {
        this.hal = i;
        this.han = ak.getColor(this.hal);
    }

    public void uM(int i) {
        this.ham = i;
        this.bgColor = ak.getColor(this.ham);
    }

    public int bAV() {
        return this.hao;
    }

    public void ni(boolean z) {
        this.hap = z;
    }

    public boolean bAW() {
        return this.hap;
    }

    public void nj(boolean z) {
        this.haq = z;
    }

    public boolean bAX() {
        return this.haq;
    }

    public void uB(String str) {
        this.hak = str;
    }

    public String bAY() {
        return this.hak;
    }
}
