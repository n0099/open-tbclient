package com.baidu.tieba.write;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c {
    private int bgColor;
    private String dwi;
    private int ijg;
    private ArrayList<String> mtC;
    private int mtD;
    private int mtE;
    private int mtF = -1;
    private boolean mtG = false;
    private boolean mtH = false;

    public SpannableStringBuilder d(Editable editable) {
        if (editable == null || StringUtils.isNull(editable.toString()) || x.isEmpty(this.mtC)) {
            return null;
        }
        String obj = editable.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
        boolean z = this.mtF >= 0;
        this.mtF = -1;
        Iterator<String> it = this.mtC.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!StringUtils.isNull(next)) {
                a(spannableStringBuilder, obj, next);
            }
        }
        if (this.mtF >= 0 || z) {
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
        if (this.ijg != 0 || this.bgColor != 0) {
            int indexOf = str.indexOf(str2);
            int length = str2.length();
            if (indexOf >= 0) {
                if (this.mtF == -1) {
                    this.mtF = indexOf + length;
                } else if (indexOf + length < this.mtF) {
                    this.mtF = indexOf + length;
                }
            }
            while (indexOf >= 0) {
                if (this.ijg != 0) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.ijg), indexOf, indexOf + length, 33);
                }
                if (this.bgColor != 0) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.bgColor), indexOf, indexOf + length, 33);
                }
                indexOf = str.indexOf(str2, indexOf + 1);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.mtD != 0) {
            this.ijg = ao.getColor(this.mtD);
        }
        if (this.mtE != 0) {
            this.bgColor = ao.getColor(this.mtE);
        }
    }

    public void aZ(ArrayList<String> arrayList) {
        this.mtC = arrayList;
    }

    public ArrayList<String> dtZ() {
        return this.mtC;
    }

    public void GV(int i) {
        this.mtD = i;
        this.ijg = ao.getColor(this.mtD);
    }

    public void GW(int i) {
        this.mtE = i;
        this.bgColor = ao.getColor(this.mtE);
    }

    public int dua() {
        return this.mtF;
    }

    public void wi(boolean z) {
        this.mtG = z;
    }

    public boolean dub() {
        return this.mtG;
    }

    public void wj(boolean z) {
        this.mtH = z;
    }

    public boolean duc() {
        return this.mtH;
    }

    public void Py(String str) {
        this.dwi = str;
    }

    public String dud() {
        return this.dwi;
    }
}
