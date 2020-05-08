package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class f {
    public static final int[] kRR = {3, 8, 13};
    public static final int[] kRS = {2, 12};
    public static final int[] kRT = {20};
    public static final int[] kRU = {3, 13, 23};
    private SparseIntArray kRV = new SparseIntArray();
    private String kRW;
    private final int[] kRX;

    public f(String str, int[] iArr) {
        this.kRX = iArr;
        this.kRW = str;
    }

    public void De(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.kRV != null) {
            this.kRV.clear();
            if (this.kRX != null) {
                for (int i2 : this.kRX) {
                    if (i2 >= 0) {
                        this.kRV.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void cVV() {
        De(0);
    }

    public void cP(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.kRV != null) {
            this.kRV.append(i2, i);
        }
    }

    public int Df(int i) {
        if (i >= 0 && this.kRV != null) {
            return this.kRV.get(i, -1);
        }
        return -1;
    }

    public void Dg(int i) {
        if (this.kRV != null) {
            this.kRV.delete(i);
        }
    }
}
