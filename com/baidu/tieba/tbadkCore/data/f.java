package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class f {
    public static final int[] nqQ = {3, 8, 13};
    public static final int[] nqR = {2, 12};
    public static final int[] nqS = {20};
    public static final int[] nqT = {3, 13, 23};
    private SparseIntArray nqU = new SparseIntArray();
    private String nqV;
    private final int[] nqW;

    public f(String str, int[] iArr) {
        this.nqW = iArr;
        this.nqV = str;
    }

    public void KN(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.nqU != null) {
            this.nqU.clear();
            if (this.nqW != null) {
                for (int i2 : this.nqW) {
                    if (i2 >= 0) {
                        this.nqU.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void dOG() {
        KN(0);
    }

    public void du(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.nqU != null) {
            this.nqU.append(i2, i);
        }
    }

    public int KO(int i) {
        if (i >= 0 && this.nqU != null) {
            return this.nqU.get(i, -1);
        }
        return -1;
    }

    public void KP(int i) {
        if (this.nqU != null) {
            this.nqU.delete(i);
        }
    }
}
