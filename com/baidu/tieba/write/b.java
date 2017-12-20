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
    private ArrayList<String> hdX;
    private String hdY;
    private int hdZ;
    private int hea;
    private int heb;
    private int hec = -1;
    private boolean hed = false;
    private boolean hee = false;

    public SpannableStringBuilder b(Editable editable) {
        if (editable == null || StringUtils.isNull(editable.toString()) || v.w(this.hdX)) {
            return null;
        }
        String obj = editable.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
        boolean z = this.hec >= 0;
        this.hec = -1;
        Iterator<String> it = this.hdX.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!StringUtils.isNull(next)) {
                a(spannableStringBuilder, obj, next);
            }
        }
        if (this.hec >= 0 || z) {
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
        if (this.heb != 0 || this.bgColor != 0) {
            int indexOf = str.indexOf(str2);
            int length = str2.length();
            if (indexOf >= 0) {
                if (this.hec == -1) {
                    this.hec = indexOf + length;
                } else if (indexOf + length < this.hec) {
                    this.hec = indexOf + length;
                }
            }
            while (indexOf >= 0) {
                if (this.heb != 0) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.heb), indexOf, indexOf + length, 33);
                }
                if (this.bgColor != 0) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.bgColor), indexOf, indexOf + length, 33);
                }
                indexOf = str.indexOf(str2, indexOf + 1);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.hdZ != 0) {
            this.heb = aj.getColor(this.hdZ);
        }
        if (this.hea != 0) {
            this.bgColor = aj.getColor(this.hea);
        }
    }

    public void aC(ArrayList<String> arrayList) {
        this.hdX = arrayList;
    }

    public ArrayList<String> bFD() {
        return this.hdX;
    }

    public void vM(int i) {
        this.hdZ = i;
        this.heb = aj.getColor(this.hdZ);
    }

    public void vN(int i) {
        this.hea = i;
        this.bgColor = aj.getColor(this.hea);
    }

    public int bFE() {
        return this.hec;
    }

    public void nT(boolean z) {
        this.hed = z;
    }

    public boolean bFF() {
        return this.hed;
    }

    public void nU(boolean z) {
        this.hee = z;
    }

    public boolean bFG() {
        return this.hee;
    }

    public void uB(String str) {
        this.hdY = str;
    }

    public String bFH() {
        return this.hdY;
    }
}
