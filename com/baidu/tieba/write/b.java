package com.baidu.tieba.write;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.w;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class b {
    private int bgColor;
    private ArrayList<String> hnf;
    private String hng;
    private int hnh;
    private int hni;
    private int hnj;
    private int hnk = -1;
    private boolean hnl = false;
    private boolean hnm = false;

    public SpannableStringBuilder b(Editable editable) {
        if (editable == null || StringUtils.isNull(editable.toString()) || w.z(this.hnf)) {
            return null;
        }
        String obj = editable.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
        boolean z = this.hnk >= 0;
        this.hnk = -1;
        Iterator<String> it = this.hnf.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!StringUtils.isNull(next)) {
                a(spannableStringBuilder, obj, next);
            }
        }
        if (this.hnk >= 0 || z) {
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
        if (this.hnj != 0 || this.bgColor != 0) {
            int indexOf = str.indexOf(str2);
            int length = str2.length();
            if (indexOf >= 0) {
                if (this.hnk == -1) {
                    this.hnk = indexOf + length;
                } else if (indexOf + length < this.hnk) {
                    this.hnk = indexOf + length;
                }
            }
            while (indexOf >= 0) {
                if (this.hnj != 0) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.hnj), indexOf, indexOf + length, 33);
                }
                if (this.bgColor != 0) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.bgColor), indexOf, indexOf + length, 33);
                }
                indexOf = str.indexOf(str2, indexOf + 1);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.hnh != 0) {
            this.hnj = al.getColor(this.hnh);
        }
        if (this.hni != 0) {
            this.bgColor = al.getColor(this.hni);
        }
    }

    public void ax(ArrayList<String> arrayList) {
        this.hnf = arrayList;
    }

    public ArrayList<String> bFY() {
        return this.hnf;
    }

    public void va(int i) {
        this.hnh = i;
        this.hnj = al.getColor(this.hnh);
    }

    public void vb(int i) {
        this.hni = i;
        this.bgColor = al.getColor(this.hni);
    }

    public int bFZ() {
        return this.hnk;
    }

    public void nr(boolean z) {
        this.hnl = z;
    }

    public boolean bGa() {
        return this.hnl;
    }

    public void ns(boolean z) {
        this.hnm = z;
    }

    public boolean bGb() {
        return this.hnm;
    }

    public void vy(String str) {
        this.hng = str;
    }

    public String bGc() {
        return this.hng;
    }
}
