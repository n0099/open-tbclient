package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class f {
    public static final int[] lMC = {3, 8, 13};
    public static final int[] lMD = {2, 12};
    public static final int[] lME = {20};
    public static final int[] lMF = {3, 13, 23};
    private SparseIntArray lMG = new SparseIntArray();
    private String lMH;
    private final int[] lMI;

    public f(String str, int[] iArr) {
        this.lMI = iArr;
        this.lMH = str;
    }

    public void Fo(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.lMG != null) {
            this.lMG.clear();
            if (this.lMI != null) {
                for (int i2 : this.lMI) {
                    if (i2 >= 0) {
                        this.lMG.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void dkO() {
        Fo(0);
    }

    public void dc(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.lMG != null) {
            this.lMG.append(i2, i);
        }
    }

    public int Fp(int i) {
        if (i >= 0 && this.lMG != null) {
            return this.lMG.get(i, -1);
        }
        return -1;
    }

    public void Fq(int i) {
        if (this.lMG != null) {
            this.lMG.delete(i);
        }
    }
}
