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
    private ArrayList<String> gQi;
    private String gQj;
    private int gQk;
    private int gQl;
    private int gQm;
    private int gQn = -1;
    private boolean gQo = false;
    private boolean gQp = false;

    public SpannableStringBuilder b(Editable editable) {
        if (editable == null || StringUtils.isNull(editable.toString()) || v.v(this.gQi)) {
            return null;
        }
        String obj = editable.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
        boolean z = this.gQn >= 0;
        this.gQn = -1;
        Iterator<String> it = this.gQi.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!StringUtils.isNull(next)) {
                a(spannableStringBuilder, obj, next);
            }
        }
        if (this.gQn >= 0 || z) {
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
                if (this.gQn == -1) {
                    this.gQn = indexOf + length;
                } else if (indexOf + length < this.gQn) {
                    this.gQn = indexOf + length;
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
        if (this.gQk != 0) {
            this.gQm = aj.getColor(this.gQk);
        }
        if (this.gQl != 0) {
            this.bgColor = aj.getColor(this.gQl);
        }
    }

    public void aB(ArrayList<String> arrayList) {
        this.gQi = arrayList;
    }

    public ArrayList<String> bCp() {
        return this.gQi;
    }

    public void vg(int i) {
        this.gQk = i;
        this.gQm = aj.getColor(this.gQk);
    }

    public void vh(int i) {
        this.gQl = i;
        this.bgColor = aj.getColor(this.gQl);
    }

    public int bCq() {
        return this.gQn;
    }

    public void nq(boolean z) {
        this.gQo = z;
    }

    public boolean bCr() {
        return this.gQo;
    }

    public void nr(boolean z) {
        this.gQp = z;
    }

    public boolean bCs() {
        return this.gQp;
    }

    public void tO(String str) {
        this.gQj = str;
    }

    public String bCt() {
        return this.gQj;
    }
}
