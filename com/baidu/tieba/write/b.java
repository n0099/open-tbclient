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
    private ArrayList<String> hsu;
    private String hsv;
    private int hsw;
    private int hsx;
    private int hsy;
    private int hsz = -1;
    private boolean hsA = false;
    private boolean hsB = false;

    public SpannableStringBuilder b(Editable editable) {
        if (editable == null || StringUtils.isNull(editable.toString()) || w.z(this.hsu)) {
            return null;
        }
        String obj = editable.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
        boolean z = this.hsz >= 0;
        this.hsz = -1;
        Iterator<String> it = this.hsu.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!StringUtils.isNull(next)) {
                a(spannableStringBuilder, obj, next);
            }
        }
        if (this.hsz >= 0 || z) {
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
        if (this.hsy != 0 || this.bgColor != 0) {
            int indexOf = str.indexOf(str2);
            int length = str2.length();
            if (indexOf >= 0) {
                if (this.hsz == -1) {
                    this.hsz = indexOf + length;
                } else if (indexOf + length < this.hsz) {
                    this.hsz = indexOf + length;
                }
            }
            while (indexOf >= 0) {
                if (this.hsy != 0) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.hsy), indexOf, indexOf + length, 33);
                }
                if (this.bgColor != 0) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.bgColor), indexOf, indexOf + length, 33);
                }
                indexOf = str.indexOf(str2, indexOf + 1);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.hsw != 0) {
            this.hsy = am.getColor(this.hsw);
        }
        if (this.hsx != 0) {
            this.bgColor = am.getColor(this.hsx);
        }
    }

    public void az(ArrayList<String> arrayList) {
        this.hsu = arrayList;
    }

    public ArrayList<String> bFn() {
        return this.hsu;
    }

    public void vi(int i) {
        this.hsw = i;
        this.hsy = am.getColor(this.hsw);
    }

    public void vj(int i) {
        this.hsx = i;
        this.bgColor = am.getColor(this.hsx);
    }

    public int bFo() {
        return this.hsz;
    }

    public void nn(boolean z) {
        this.hsA = z;
    }

    public boolean bFp() {
        return this.hsA;
    }

    public void no(boolean z) {
        this.hsB = z;
    }

    public boolean bFq() {
        return this.hsB;
    }

    public void vz(String str) {
        this.hsv = str;
    }

    public String bFr() {
        return this.hsv;
    }
}
