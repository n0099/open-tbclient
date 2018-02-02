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
    private ArrayList<String> hBZ;
    private String hCa;
    private int hCb;
    private int hCc;
    private int hCd;
    private int hCe = -1;
    private boolean hCf = false;
    private boolean hCg = false;

    public SpannableStringBuilder b(Editable editable) {
        if (editable == null || StringUtils.isNull(editable.toString()) || v.E(this.hBZ)) {
            return null;
        }
        String obj = editable.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
        boolean z = this.hCe >= 0;
        this.hCe = -1;
        Iterator<String> it = this.hBZ.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!StringUtils.isNull(next)) {
                a(spannableStringBuilder, obj, next);
            }
        }
        if (this.hCe >= 0 || z) {
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
        if (this.hCd != 0 || this.bgColor != 0) {
            int indexOf = str.indexOf(str2);
            int length = str2.length();
            if (indexOf >= 0) {
                if (this.hCe == -1) {
                    this.hCe = indexOf + length;
                } else if (indexOf + length < this.hCe) {
                    this.hCe = indexOf + length;
                }
            }
            while (indexOf >= 0) {
                if (this.hCd != 0) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.hCd), indexOf, indexOf + length, 33);
                }
                if (this.bgColor != 0) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.bgColor), indexOf, indexOf + length, 33);
                }
                indexOf = str.indexOf(str2, indexOf + 1);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.hCb != 0) {
            this.hCd = aj.getColor(this.hCb);
        }
        if (this.hCc != 0) {
            this.bgColor = aj.getColor(this.hCc);
        }
    }

    public void av(ArrayList<String> arrayList) {
        this.hBZ = arrayList;
    }

    public ArrayList<String> bEO() {
        return this.hBZ;
    }

    public void xg(int i) {
        this.hCb = i;
        this.hCd = aj.getColor(this.hCb);
    }

    public void xh(int i) {
        this.hCc = i;
        this.bgColor = aj.getColor(this.hCc);
    }

    public int bEP() {
        return this.hCe;
    }

    public void nt(boolean z) {
        this.hCf = z;
    }

    public boolean bEQ() {
        return this.hCf;
    }

    public void nu(boolean z) {
        this.hCg = z;
    }

    public boolean bER() {
        return this.hCg;
    }

    public void uh(String str) {
        this.hCa = str;
    }

    public String bES() {
        return this.hCa;
    }
}
