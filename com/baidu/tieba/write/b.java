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
    private int hDA;
    private int hDB = -1;
    private boolean hDC = false;
    private boolean hDD = false;
    private ArrayList<String> hDw;
    private String hDx;
    private int hDy;
    private int hDz;

    public SpannableStringBuilder b(Editable editable) {
        if (editable == null || StringUtils.isNull(editable.toString()) || v.E(this.hDw)) {
            return null;
        }
        String obj = editable.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
        boolean z = this.hDB >= 0;
        this.hDB = -1;
        Iterator<String> it = this.hDw.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!StringUtils.isNull(next)) {
                a(spannableStringBuilder, obj, next);
            }
        }
        if (this.hDB >= 0 || z) {
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
        if (this.hDA != 0 || this.bgColor != 0) {
            int indexOf = str.indexOf(str2);
            int length = str2.length();
            if (indexOf >= 0) {
                if (this.hDB == -1) {
                    this.hDB = indexOf + length;
                } else if (indexOf + length < this.hDB) {
                    this.hDB = indexOf + length;
                }
            }
            while (indexOf >= 0) {
                if (this.hDA != 0) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.hDA), indexOf, indexOf + length, 33);
                }
                if (this.bgColor != 0) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.bgColor), indexOf, indexOf + length, 33);
                }
                indexOf = str.indexOf(str2, indexOf + 1);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.hDy != 0) {
            this.hDA = aj.getColor(this.hDy);
        }
        if (this.hDz != 0) {
            this.bgColor = aj.getColor(this.hDz);
        }
    }

    public void aw(ArrayList<String> arrayList) {
        this.hDw = arrayList;
    }

    public ArrayList<String> bFC() {
        return this.hDw;
    }

    public void xf(int i) {
        this.hDy = i;
        this.hDA = aj.getColor(this.hDy);
    }

    public void xg(int i) {
        this.hDz = i;
        this.bgColor = aj.getColor(this.hDz);
    }

    public int bFD() {
        return this.hDB;
    }

    public void nA(boolean z) {
        this.hDC = z;
    }

    public boolean bFE() {
        return this.hDC;
    }

    public void nB(boolean z) {
        this.hDD = z;
    }

    public boolean bFF() {
        return this.hDD;
    }

    public void un(String str) {
        this.hDx = str;
    }

    public String bFG() {
        return this.hDx;
    }
}
