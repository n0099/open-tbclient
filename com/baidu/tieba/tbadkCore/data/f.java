package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class f {
    public static final int[] kfQ = {3, 8, 13};
    public static final int[] kfR = {2, 12};
    public static final int[] kfS = {20};
    public static final int[] kfT = {3, 13, 23};
    private SparseIntArray kfU = new SparseIntArray();
    private String kfV;
    private final int[] kfW;

    public f(String str, int[] iArr) {
        this.kfW = iArr;
        this.kfV = str;
    }

    public void Cs(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.kfU != null) {
            this.kfU.clear();
            if (this.kfW != null) {
                for (int i2 : this.kfW) {
                    if (i2 >= 0) {
                        this.kfU.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void cKF() {
        Cs(0);
    }

    public void cJ(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.kfU != null) {
            this.kfU.append(i2, i);
        }
    }

    public int Ct(int i) {
        if (i >= 0 && this.kfU != null) {
            return this.kfU.get(i, -1);
        }
        return -1;
    }

    public void Cu(int i) {
        if (this.kfU != null) {
            this.kfU.delete(i);
        }
    }
}
