package com.baidu.tieba.write;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c {
    private int bgColor;
    private String cBs;
    private int gQm;
    private ArrayList<String> kNt;
    private int kNu;
    private int kNv;
    private int kNw = -1;
    private boolean kNx = false;
    private boolean kNy = false;

    public SpannableStringBuilder a(Editable editable) {
        if (editable == null || StringUtils.isNull(editable.toString()) || v.isEmpty(this.kNt)) {
            return null;
        }
        String obj = editable.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
        boolean z = this.kNw >= 0;
        this.kNw = -1;
        Iterator<String> it = this.kNt.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!StringUtils.isNull(next)) {
                a(spannableStringBuilder, obj, next);
            }
        }
        if (this.kNw >= 0 || z) {
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
        if (this.gQm != 0 || this.bgColor != 0) {
            int indexOf = str.indexOf(str2);
            int length = str2.length();
            if (indexOf >= 0) {
                if (this.kNw == -1) {
                    this.kNw = indexOf + length;
                } else if (indexOf + length < this.kNw) {
                    this.kNw = indexOf + length;
                }
            }
            while (indexOf >= 0) {
                if (this.gQm != 0) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.gQm), indexOf, indexOf + length, 33);
                }
                if (this.bgColor != 0) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.bgColor), indexOf, indexOf + length, 33);
                }
                indexOf = str.indexOf(str2, indexOf + 1);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.kNu != 0) {
            this.gQm = am.getColor(this.kNu);
        }
        if (this.kNv != 0) {
            this.bgColor = am.getColor(this.kNv);
        }
    }

    public void aU(ArrayList<String> arrayList) {
        this.kNt = arrayList;
    }

    public ArrayList<String> cUx() {
        return this.kNt;
    }

    public void Eh(int i) {
        this.kNu = i;
        this.gQm = am.getColor(this.kNu);
    }

    public void Ei(int i) {
        this.kNv = i;
        this.bgColor = am.getColor(this.kNv);
    }

    public int cUy() {
        return this.kNw;
    }

    public void tN(boolean z) {
        this.kNx = z;
    }

    public boolean cUz() {
        return this.kNx;
    }

    public void tO(boolean z) {
        this.kNy = z;
    }

    public boolean cUA() {
        return this.kNy;
    }

    public void KL(String str) {
        this.cBs = str;
    }

    public String cUB() {
        return this.cBs;
    }
}
