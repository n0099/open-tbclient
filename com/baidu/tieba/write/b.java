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
    private ArrayList<String> hec;
    private String hed;
    private int hee;
    private int hef;
    private int heg;
    private int heh = -1;
    private boolean hei = false;
    private boolean hej = false;

    public SpannableStringBuilder b(Editable editable) {
        if (editable == null || StringUtils.isNull(editable.toString()) || v.w(this.hec)) {
            return null;
        }
        String obj = editable.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
        boolean z = this.heh >= 0;
        this.heh = -1;
        Iterator<String> it = this.hec.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!StringUtils.isNull(next)) {
                a(spannableStringBuilder, obj, next);
            }
        }
        if (this.heh >= 0 || z) {
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
        if (this.heg != 0 || this.bgColor != 0) {
            int indexOf = str.indexOf(str2);
            int length = str2.length();
            if (indexOf >= 0) {
                if (this.heh == -1) {
                    this.heh = indexOf + length;
                } else if (indexOf + length < this.heh) {
                    this.heh = indexOf + length;
                }
            }
            while (indexOf >= 0) {
                if (this.heg != 0) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.heg), indexOf, indexOf + length, 33);
                }
                if (this.bgColor != 0) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.bgColor), indexOf, indexOf + length, 33);
                }
                indexOf = str.indexOf(str2, indexOf + 1);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.hee != 0) {
            this.heg = aj.getColor(this.hee);
        }
        if (this.hef != 0) {
            this.bgColor = aj.getColor(this.hef);
        }
    }

    public void aC(ArrayList<String> arrayList) {
        this.hec = arrayList;
    }

    public ArrayList<String> bFE() {
        return this.hec;
    }

    public void vM(int i) {
        this.hee = i;
        this.heg = aj.getColor(this.hee);
    }

    public void vN(int i) {
        this.hef = i;
        this.bgColor = aj.getColor(this.hef);
    }

    public int bFF() {
        return this.heh;
    }

    public void nT(boolean z) {
        this.hei = z;
    }

    public boolean bFG() {
        return this.hei;
    }

    public void nU(boolean z) {
        this.hej = z;
    }

    public boolean bFH() {
        return this.hej;
    }

    public void uB(String str) {
        this.hed = str;
    }

    public String bFI() {
        return this.hed;
    }
}
