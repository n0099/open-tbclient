package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class f {
    public static final int[] kRN = {3, 8, 13};
    public static final int[] kRO = {2, 12};
    public static final int[] kRP = {20};
    public static final int[] kRQ = {3, 13, 23};
    private SparseIntArray kRR = new SparseIntArray();
    private String kRS;
    private final int[] kRT;

    public f(String str, int[] iArr) {
        this.kRT = iArr;
        this.kRS = str;
    }

    public void De(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.kRR != null) {
            this.kRR.clear();
            if (this.kRT != null) {
                for (int i2 : this.kRT) {
                    if (i2 >= 0) {
                        this.kRR.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void cVY() {
        De(0);
    }

    public void cP(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.kRR != null) {
            this.kRR.append(i2, i);
        }
    }

    public int Df(int i) {
        if (i >= 0 && this.kRR != null) {
            return this.kRR.get(i, -1);
        }
        return -1;
    }

    public void Dg(int i) {
        if (this.kRR != null) {
            this.kRR.delete(i);
        }
    }
}
