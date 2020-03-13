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
    private String cBh;
    private int gPf;
    private ArrayList<String> kLK;
    private int kLL;
    private int kLM;
    private int kLN = -1;
    private boolean kLO = false;
    private boolean kLP = false;

    public SpannableStringBuilder a(Editable editable) {
        if (editable == null || StringUtils.isNull(editable.toString()) || v.isEmpty(this.kLK)) {
            return null;
        }
        String obj = editable.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
        boolean z = this.kLN >= 0;
        this.kLN = -1;
        Iterator<String> it = this.kLK.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!StringUtils.isNull(next)) {
                a(spannableStringBuilder, obj, next);
            }
        }
        if (this.kLN >= 0 || z) {
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
        if (this.gPf != 0 || this.bgColor != 0) {
            int indexOf = str.indexOf(str2);
            int length = str2.length();
            if (indexOf >= 0) {
                if (this.kLN == -1) {
                    this.kLN = indexOf + length;
                } else if (indexOf + length < this.kLN) {
                    this.kLN = indexOf + length;
                }
            }
            while (indexOf >= 0) {
                if (this.gPf != 0) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.gPf), indexOf, indexOf + length, 33);
                }
                if (this.bgColor != 0) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.bgColor), indexOf, indexOf + length, 33);
                }
                indexOf = str.indexOf(str2, indexOf + 1);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.kLL != 0) {
            this.gPf = am.getColor(this.kLL);
        }
        if (this.kLM != 0) {
            this.bgColor = am.getColor(this.kLM);
        }
    }

    public void aU(ArrayList<String> arrayList) {
        this.kLK = arrayList;
    }

    public ArrayList<String> cUd() {
        return this.kLK;
    }

    public void DZ(int i) {
        this.kLL = i;
        this.gPf = am.getColor(this.kLL);
    }

    public void Ea(int i) {
        this.kLM = i;
        this.bgColor = am.getColor(this.kLM);
    }

    public int cUe() {
        return this.kLN;
    }

    public void tG(boolean z) {
        this.kLO = z;
    }

    public boolean cUf() {
        return this.kLO;
    }

    public void tH(boolean z) {
        this.kLP = z;
    }

    public boolean cUg() {
        return this.kLP;
    }

    public void KL(String str) {
        this.cBh = str;
    }

    public String cUh() {
        return this.cBh;
    }
}
