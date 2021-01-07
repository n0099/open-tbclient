package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class f {
    public static final int[] nqP = {3, 8, 13};
    public static final int[] nqQ = {2, 12};
    public static final int[] nqR = {20};
    public static final int[] nqS = {3, 13, 23};
    private SparseIntArray nqT = new SparseIntArray();
    private String nqU;
    private final int[] nqV;

    public f(String str, int[] iArr) {
        this.nqV = iArr;
        this.nqU = str;
    }

    public void KN(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.nqT != null) {
            this.nqT.clear();
            if (this.nqV != null) {
                for (int i2 : this.nqV) {
                    if (i2 >= 0) {
                        this.nqT.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void dOH() {
        KN(0);
    }

    public void du(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.nqT != null) {
            this.nqT.append(i2, i);
        }
    }

    public int KO(int i) {
        if (i >= 0 && this.nqT != null) {
            return this.nqT.get(i, -1);
        }
        return -1;
    }

    public void KP(int i) {
        if (this.nqT != null) {
            this.nqT.delete(i);
        }
    }
}
