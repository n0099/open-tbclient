package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class f {
    public static final int[] kfS = {3, 8, 13};
    public static final int[] kfT = {2, 12};
    public static final int[] kfU = {20};
    public static final int[] kfV = {3, 13, 23};
    private SparseIntArray kfW = new SparseIntArray();
    private String kfX;
    private final int[] kfY;

    public f(String str, int[] iArr) {
        this.kfY = iArr;
        this.kfX = str;
    }

    public void Cs(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.kfW != null) {
            this.kfW.clear();
            if (this.kfY != null) {
                for (int i2 : this.kfY) {
                    if (i2 >= 0) {
                        this.kfW.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void cKH() {
        Cs(0);
    }

    public void cJ(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.kfW != null) {
            this.kfW.append(i2, i);
        }
    }

    public int Ct(int i) {
        if (i >= 0 && this.kfW != null) {
            return this.kfW.get(i, -1);
        }
        return -1;
    }

    public void Cu(int i) {
        if (this.kfW != null) {
            this.kfW.delete(i);
        }
    }
}
