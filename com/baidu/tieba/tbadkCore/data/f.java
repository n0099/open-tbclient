package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class f {
    public static final int[] nlg = {3, 8, 13};
    public static final int[] nlh = {2, 12};
    public static final int[] nli = {20};
    public static final int[] nlj = {3, 13, 23};
    private SparseIntArray nlk = new SparseIntArray();
    private String nll;
    private final int[] nlm;

    public f(String str, int[] iArr) {
        this.nlm = iArr;
        this.nll = str;
    }

    public void KR(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.nlk != null) {
            this.nlk.clear();
            if (this.nlm != null) {
                for (int i2 : this.nlm) {
                    if (i2 >= 0) {
                        this.nlk.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void dON() {
        KR(0);
    }

    public void dy(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.nlk != null) {
            this.nlk.append(i2, i);
        }
    }

    public int KS(int i) {
        if (i >= 0 && this.nlk != null) {
            return this.nlk.get(i, -1);
        }
        return -1;
    }

    public void KT(int i) {
        if (this.nlk != null) {
            this.nlk.delete(i);
        }
    }
}
