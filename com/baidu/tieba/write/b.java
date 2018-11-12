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
    private int dZb;
    private ArrayList<String> hJm;
    private int hJn;
    private int hJo;
    private int hJp = -1;
    private boolean hJq = false;
    private boolean hJr = false;

    public SpannableStringBuilder b(Editable editable) {
        if (editable == null || StringUtils.isNull(editable.toString()) || v.I(this.hJm)) {
            return null;
        }
        String obj = editable.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
        boolean z = this.hJp >= 0;
        this.hJp = -1;
        Iterator<String> it = this.hJm.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!StringUtils.isNull(next)) {
                a(spannableStringBuilder, obj, next);
            }
        }
        if (this.hJp >= 0 || z) {
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
        if (this.dZb != 0 || this.bgColor != 0) {
            int indexOf = str.indexOf(str2);
            int length = str2.length();
            if (indexOf >= 0) {
                if (this.hJp == -1) {
                    this.hJp = indexOf + length;
                } else if (indexOf + length < this.hJp) {
                    this.hJp = indexOf + length;
                }
            }
            while (indexOf >= 0) {
                if (this.dZb != 0) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.dZb), indexOf, indexOf + length, 33);
                }
                if (this.bgColor != 0) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.bgColor), indexOf, indexOf + length, 33);
                }
                indexOf = str.indexOf(str2, indexOf + 1);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.hJn != 0) {
            this.dZb = al.getColor(this.hJn);
        }
        if (this.hJo != 0) {
            this.bgColor = al.getColor(this.hJo);
        }
    }

    public void az(ArrayList<String> arrayList) {
        this.hJm = arrayList;
    }

    public ArrayList<String> bKP() {
        return this.hJm;
    }

    public void wy(int i) {
        this.hJn = i;
        this.dZb = al.getColor(this.hJn);
    }

    public void wz(int i) {
        this.hJo = i;
        this.bgColor = al.getColor(this.hJo);
    }

    public int bKQ() {
        return this.hJp;
    }

    public void oo(boolean z) {
        this.hJq = z;
    }

    public boolean bKR() {
        return this.hJq;
    }

    public void op(boolean z) {
        this.hJr = z;
    }

    public boolean bKS() {
        return this.hJr;
    }

    public void wO(String str) {
        this.Zm = str;
    }

    public String bKT() {
        return this.Zm;
    }
}
