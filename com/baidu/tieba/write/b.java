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
    private ArrayList<String> hss;
    private String hst;
    private int hsu;
    private int hsv;
    private int hsw;
    private int hsx = -1;
    private boolean hsy = false;
    private boolean hsz = false;

    public SpannableStringBuilder b(Editable editable) {
        if (editable == null || StringUtils.isNull(editable.toString()) || w.z(this.hss)) {
            return null;
        }
        String obj = editable.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
        boolean z = this.hsx >= 0;
        this.hsx = -1;
        Iterator<String> it = this.hss.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!StringUtils.isNull(next)) {
                a(spannableStringBuilder, obj, next);
            }
        }
        if (this.hsx >= 0 || z) {
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
        if (this.hsw != 0 || this.bgColor != 0) {
            int indexOf = str.indexOf(str2);
            int length = str2.length();
            if (indexOf >= 0) {
                if (this.hsx == -1) {
                    this.hsx = indexOf + length;
                } else if (indexOf + length < this.hsx) {
                    this.hsx = indexOf + length;
                }
            }
            while (indexOf >= 0) {
                if (this.hsw != 0) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.hsw), indexOf, indexOf + length, 33);
                }
                if (this.bgColor != 0) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.bgColor), indexOf, indexOf + length, 33);
                }
                indexOf = str.indexOf(str2, indexOf + 1);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.hsu != 0) {
            this.hsw = am.getColor(this.hsu);
        }
        if (this.hsv != 0) {
            this.bgColor = am.getColor(this.hsv);
        }
    }

    public void az(ArrayList<String> arrayList) {
        this.hss = arrayList;
    }

    public ArrayList<String> bFj() {
        return this.hss;
    }

    public void vi(int i) {
        this.hsu = i;
        this.hsw = am.getColor(this.hsu);
    }

    public void vj(int i) {
        this.hsv = i;
        this.bgColor = am.getColor(this.hsv);
    }

    public int bFk() {
        return this.hsx;
    }

    public void nn(boolean z) {
        this.hsy = z;
    }

    public boolean bFl() {
        return this.hsy;
    }

    public void no(boolean z) {
        this.hsz = z;
    }

    public boolean bFm() {
        return this.hsz;
    }

    public void vv(String str) {
        this.hst = str;
    }

    public String bFn() {
        return this.hst;
    }
}
