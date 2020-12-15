package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class f {
    public static final int[] nli = {3, 8, 13};
    public static final int[] nlj = {2, 12};
    public static final int[] nlk = {20};
    public static final int[] nll = {3, 13, 23};
    private SparseIntArray nlm = new SparseIntArray();
    private String nln;
    private final int[] nlo;

    public f(String str, int[] iArr) {
        this.nlo = iArr;
        this.nln = str;
    }

    public void KR(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.nlm != null) {
            this.nlm.clear();
            if (this.nlo != null) {
                for (int i2 : this.nlo) {
                    if (i2 >= 0) {
                        this.nlm.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void dOO() {
        KR(0);
    }

    public void dy(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.nlm != null) {
            this.nlm.append(i2, i);
        }
    }

    public int KS(int i) {
        if (i >= 0 && this.nlm != null) {
            return this.nlm.get(i, -1);
        }
        return -1;
    }

    public void KT(int i) {
        if (this.nlm != null) {
            this.nlm.delete(i);
        }
    }
}
