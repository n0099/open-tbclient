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
public class b {
    private int bgColor;
    private String bsQ;
    private int fUJ;
    private ArrayList<String> jMo;
    private int jMp;
    private int jMq;
    private int jMr = -1;
    private boolean jMs = false;
    private boolean jMt = false;

    public SpannableStringBuilder b(Editable editable) {
        if (editable == null || StringUtils.isNull(editable.toString()) || v.aa(this.jMo)) {
            return null;
        }
        String obj = editable.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
        boolean z = this.jMr >= 0;
        this.jMr = -1;
        Iterator<String> it = this.jMo.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!StringUtils.isNull(next)) {
                a(spannableStringBuilder, obj, next);
            }
        }
        if (this.jMr >= 0 || z) {
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
        if (this.fUJ != 0 || this.bgColor != 0) {
            int indexOf = str.indexOf(str2);
            int length = str2.length();
            if (indexOf >= 0) {
                if (this.jMr == -1) {
                    this.jMr = indexOf + length;
                } else if (indexOf + length < this.jMr) {
                    this.jMr = indexOf + length;
                }
            }
            while (indexOf >= 0) {
                if (this.fUJ != 0) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.fUJ), indexOf, indexOf + length, 33);
                }
                if (this.bgColor != 0) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.bgColor), indexOf, indexOf + length, 33);
                }
                indexOf = str.indexOf(str2, indexOf + 1);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.jMp != 0) {
            this.fUJ = am.getColor(this.jMp);
        }
        if (this.jMq != 0) {
            this.bgColor = am.getColor(this.jMq);
        }
    }

    public void aI(ArrayList<String> arrayList) {
        this.jMo = arrayList;
    }

    public ArrayList<String> czz() {
        return this.jMo;
    }

    public void CK(int i) {
        this.jMp = i;
        this.fUJ = am.getColor(this.jMp);
    }

    public void CL(int i) {
        this.jMq = i;
        this.bgColor = am.getColor(this.jMq);
    }

    public int czA() {
        return this.jMr;
    }

    public void sa(boolean z) {
        this.jMs = z;
    }

    public boolean czB() {
        return this.jMs;
    }

    public void sb(boolean z) {
        this.jMt = z;
    }

    public boolean czC() {
        return this.jMt;
    }

    public void GB(String str) {
        this.bsQ = str;
    }

    public String czD() {
        return this.bsQ;
    }
}
