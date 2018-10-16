package com.baidu.tieba.write;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class b {
    private String Zm;
    private int bgColor;
    private ArrayList<String> hHB;
    private int hHC;
    private int hHD;
    private int hHE;
    private int hHF = -1;
    private boolean hHG = false;
    private boolean hHH = false;

    public SpannableStringBuilder b(Editable editable) {
        if (editable == null || StringUtils.isNull(editable.toString()) || v.J(this.hHB)) {
            return null;
        }
        String obj = editable.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
        boolean z = this.hHF >= 0;
        this.hHF = -1;
        Iterator<String> it = this.hHB.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!StringUtils.isNull(next)) {
                a(spannableStringBuilder, obj, next);
            }
        }
        if (this.hHF >= 0 || z) {
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
        if (this.hHE != 0 || this.bgColor != 0) {
            int indexOf = str.indexOf(str2);
            int length = str2.length();
            if (indexOf >= 0) {
                if (this.hHF == -1) {
                    this.hHF = indexOf + length;
                } else if (indexOf + length < this.hHF) {
                    this.hHF = indexOf + length;
                }
            }
            while (indexOf >= 0) {
                if (this.hHE != 0) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.hHE), indexOf, indexOf + length, 33);
                }
                if (this.bgColor != 0) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.bgColor), indexOf, indexOf + length, 33);
                }
                indexOf = str.indexOf(str2, indexOf + 1);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.hHC != 0) {
            this.hHE = al.getColor(this.hHC);
        }
        if (this.hHD != 0) {
            this.bgColor = al.getColor(this.hHD);
        }
    }

    public void aA(ArrayList<String> arrayList) {
        this.hHB = arrayList;
    }

    public ArrayList<String> bLq() {
        return this.hHB;
    }

    public void wf(int i) {
        this.hHC = i;
        this.hHE = al.getColor(this.hHC);
    }

    public void wg(int i) {
        this.hHD = i;
        this.bgColor = al.getColor(this.hHD);
    }

    public int bLr() {
        return this.hHF;
    }

    public void oa(boolean z) {
        this.hHG = z;
    }

    public boolean bLs() {
        return this.hHG;
    }

    public void ob(boolean z) {
        this.hHH = z;
    }

    public boolean bLt() {
        return this.hHH;
    }

    public void wJ(String str) {
        this.Zm = str;
    }

    public String bLu() {
        return this.Zm;
    }
}
