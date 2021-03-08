package com.baidu.tieba.write;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c {
    private int bgColor;
    private String evF;
    private int jPF;
    private ArrayList<String> ofb;
    private int ofc;
    private int ofd;
    private int ofe = -1;
    private boolean ofg = false;
    private boolean ofh = false;

    public SpannableStringBuilder d(Editable editable) {
        if (editable == null || StringUtils.isNull(editable.toString()) || y.isEmpty(this.ofb)) {
            return null;
        }
        String obj = editable.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
        boolean z = this.ofe >= 0;
        this.ofe = -1;
        Iterator<String> it = this.ofb.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!StringUtils.isNull(next)) {
                a(spannableStringBuilder, obj, next);
            }
        }
        if (this.ofe >= 0 || z) {
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
        if (this.jPF != 0 || this.bgColor != 0) {
            int indexOf = str.indexOf(str2);
            int length = str2.length();
            if (indexOf >= 0) {
                if (this.ofe == -1) {
                    this.ofe = indexOf + length;
                } else if (indexOf + length < this.ofe) {
                    this.ofe = indexOf + length;
                }
            }
            while (indexOf >= 0) {
                if (this.jPF != 0) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.jPF), indexOf, indexOf + length, 33);
                }
                if (this.bgColor != 0) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.bgColor), indexOf, indexOf + length, 33);
                }
                indexOf = str.indexOf(str2, indexOf + 1);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.ofc != 0) {
            this.jPF = ap.getColor(this.ofc);
        }
        if (this.ofd != 0) {
            this.bgColor = ap.getColor(this.ofd);
        }
    }

    public void bg(ArrayList<String> arrayList) {
        this.ofb = arrayList;
    }

    public ArrayList<String> dWD() {
        return this.ofb;
    }

    public void Lh(int i) {
        this.ofc = i;
        this.jPF = ap.getColor(this.ofc);
    }

    public void Li(int i) {
        this.ofd = i;
        this.bgColor = ap.getColor(this.ofd);
    }

    public int dWE() {
        return this.ofe;
    }

    public void zs(boolean z) {
        this.ofg = z;
    }

    public boolean dWF() {
        return this.ofg;
    }

    public void zt(boolean z) {
        this.ofh = z;
    }

    public boolean dWG() {
        return this.ofh;
    }

    public void Vo(String str) {
        this.evF = str;
    }

    public String dWH() {
        return this.evF;
    }
}
