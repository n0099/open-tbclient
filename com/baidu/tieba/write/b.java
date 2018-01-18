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
    private ArrayList<String> hBF;
    private String hBG;
    private int hBH;
    private int hBI;
    private int hBJ;
    private int hBK = -1;
    private boolean hBL = false;
    private boolean hBM = false;

    public SpannableStringBuilder b(Editable editable) {
        if (editable == null || StringUtils.isNull(editable.toString()) || v.E(this.hBF)) {
            return null;
        }
        String obj = editable.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
        boolean z = this.hBK >= 0;
        this.hBK = -1;
        Iterator<String> it = this.hBF.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!StringUtils.isNull(next)) {
                a(spannableStringBuilder, obj, next);
            }
        }
        if (this.hBK >= 0 || z) {
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
        if (this.hBJ != 0 || this.bgColor != 0) {
            int indexOf = str.indexOf(str2);
            int length = str2.length();
            if (indexOf >= 0) {
                if (this.hBK == -1) {
                    this.hBK = indexOf + length;
                } else if (indexOf + length < this.hBK) {
                    this.hBK = indexOf + length;
                }
            }
            while (indexOf >= 0) {
                if (this.hBJ != 0) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.hBJ), indexOf, indexOf + length, 33);
                }
                if (this.bgColor != 0) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.bgColor), indexOf, indexOf + length, 33);
                }
                indexOf = str.indexOf(str2, indexOf + 1);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.hBH != 0) {
            this.hBJ = aj.getColor(this.hBH);
        }
        if (this.hBI != 0) {
            this.bgColor = aj.getColor(this.hBI);
        }
    }

    public void av(ArrayList<String> arrayList) {
        this.hBF = arrayList;
    }

    public ArrayList<String> bEM() {
        return this.hBF;
    }

    public void xg(int i) {
        this.hBH = i;
        this.hBJ = aj.getColor(this.hBH);
    }

    public void xh(int i) {
        this.hBI = i;
        this.bgColor = aj.getColor(this.hBI);
    }

    public int bEN() {
        return this.hBK;
    }

    public void nq(boolean z) {
        this.hBL = z;
    }

    public boolean bEO() {
        return this.hBL;
    }

    public void nr(boolean z) {
        this.hBM = z;
    }

    public boolean bEP() {
        return this.hBM;
    }

    public void tZ(String str) {
        this.hBG = str;
    }

    public String bEQ() {
        return this.hBG;
    }
}
