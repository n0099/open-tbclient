package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class f {
    public static final int[] jhM = {3, 8, 13};
    public static final int[] jhN = {2, 12};
    public static final int[] jhO = {20};
    public static final int[] jhP = {3, 13, 23};
    private SparseIntArray jhQ = new SparseIntArray();
    private String jhR;
    private final int[] jhS;

    public f(String str, int[] iArr) {
        this.jhS = iArr;
        this.jhR = str;
    }

    public void zN(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.jhQ != null) {
            this.jhQ.clear();
            if (this.jhS != null) {
                for (int i2 : this.jhS) {
                    if (i2 >= 0) {
                        this.jhQ.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void cnR() {
        zN(0);
    }

    public void cr(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.jhQ != null) {
            this.jhQ.append(i2, i);
        }
    }

    public int zO(int i) {
        if (i >= 0 && this.jhQ != null) {
            return this.jhQ.get(i, -1);
        }
        return -1;
    }

    public void zP(int i) {
        if (this.jhQ != null) {
            this.jhQ.delete(i);
        }
    }
}
