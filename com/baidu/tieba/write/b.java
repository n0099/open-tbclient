package com.baidu.tieba.write;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class b {
    private int bgColor;
    private ArrayList<String> hrl;
    private String hrm;
    private int hrn;
    private int hro;
    private int hrp;
    private int hrq = -1;
    private boolean hrr = false;
    private boolean hrs = false;

    public SpannableStringBuilder b(Editable editable) {
        if (editable == null || StringUtils.isNull(editable.toString()) || w.A(this.hrl)) {
            return null;
        }
        String obj = editable.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
        boolean z = this.hrq >= 0;
        this.hrq = -1;
        Iterator<String> it = this.hrl.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!StringUtils.isNull(next)) {
                a(spannableStringBuilder, obj, next);
            }
        }
        if (this.hrq >= 0 || z) {
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
        if (this.hrp != 0 || this.bgColor != 0) {
            int indexOf = str.indexOf(str2);
            int length = str2.length();
            if (indexOf >= 0) {
                if (this.hrq == -1) {
                    this.hrq = indexOf + length;
                } else if (indexOf + length < this.hrq) {
                    this.hrq = indexOf + length;
                }
            }
            while (indexOf >= 0) {
                if (this.hrp != 0) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.hrp), indexOf, indexOf + length, 33);
                }
                if (this.bgColor != 0) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.bgColor), indexOf, indexOf + length, 33);
                }
                indexOf = str.indexOf(str2, indexOf + 1);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.hrn != 0) {
            this.hrp = am.getColor(this.hrn);
        }
        if (this.hro != 0) {
            this.bgColor = am.getColor(this.hro);
        }
    }

    public void aB(ArrayList<String> arrayList) {
        this.hrl = arrayList;
    }

    public ArrayList<String> bGy() {
        return this.hrl;
    }

    public void vj(int i) {
        this.hrn = i;
        this.hrp = am.getColor(this.hrn);
    }

    public void vk(int i) {
        this.hro = i;
        this.bgColor = am.getColor(this.hro);
    }

    public int bGz() {
        return this.hrq;
    }

    public void nz(boolean z) {
        this.hrr = z;
    }

    public boolean bGA() {
        return this.hrr;
    }

    public void nA(boolean z) {
        this.hrs = z;
    }

    public boolean bGB() {
        return this.hrs;
    }

    public void vu(String str) {
        this.hrm = str;
    }

    public String bGC() {
        return this.hrm;
    }
}
