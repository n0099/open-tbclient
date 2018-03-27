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
    private ArrayList<String> hDH;
    private String hDI;
    private int hDJ;
    private int hDK;
    private int hDL;
    private int hDM = -1;
    private boolean hDN = false;
    private boolean hDO = false;

    public SpannableStringBuilder b(Editable editable) {
        if (editable == null || StringUtils.isNull(editable.toString()) || v.E(this.hDH)) {
            return null;
        }
        String obj = editable.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
        boolean z = this.hDM >= 0;
        this.hDM = -1;
        Iterator<String> it = this.hDH.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!StringUtils.isNull(next)) {
                a(spannableStringBuilder, obj, next);
            }
        }
        if (this.hDM >= 0 || z) {
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
        if (this.hDL != 0 || this.bgColor != 0) {
            int indexOf = str.indexOf(str2);
            int length = str2.length();
            if (indexOf >= 0) {
                if (this.hDM == -1) {
                    this.hDM = indexOf + length;
                } else if (indexOf + length < this.hDM) {
                    this.hDM = indexOf + length;
                }
            }
            while (indexOf >= 0) {
                if (this.hDL != 0) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.hDL), indexOf, indexOf + length, 33);
                }
                if (this.bgColor != 0) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.bgColor), indexOf, indexOf + length, 33);
                }
                indexOf = str.indexOf(str2, indexOf + 1);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.hDJ != 0) {
            this.hDL = aj.getColor(this.hDJ);
        }
        if (this.hDK != 0) {
            this.bgColor = aj.getColor(this.hDK);
        }
    }

    public void aw(ArrayList<String> arrayList) {
        this.hDH = arrayList;
    }

    public ArrayList<String> bFG() {
        return this.hDH;
    }

    public void xg(int i) {
        this.hDJ = i;
        this.hDL = aj.getColor(this.hDJ);
    }

    public void xh(int i) {
        this.hDK = i;
        this.bgColor = aj.getColor(this.hDK);
    }

    public int bFH() {
        return this.hDM;
    }

    public void nF(boolean z) {
        this.hDN = z;
    }

    public boolean bFI() {
        return this.hDN;
    }

    public void nG(boolean z) {
        this.hDO = z;
    }

    public boolean bFJ() {
        return this.hDO;
    }

    public void un(String str) {
        this.hDI = str;
    }

    public String bFK() {
        return this.hDI;
    }
}
