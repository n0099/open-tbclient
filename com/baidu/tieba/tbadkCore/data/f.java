package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class f {
    public static final int[] lMA = {3, 8, 13};
    public static final int[] lMB = {2, 12};
    public static final int[] lMC = {20};
    public static final int[] lMD = {3, 13, 23};
    private SparseIntArray lME = new SparseIntArray();
    private String lMF;
    private final int[] lMG;

    public f(String str, int[] iArr) {
        this.lMG = iArr;
        this.lMF = str;
    }

    public void Fo(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.lME != null) {
            this.lME.clear();
            if (this.lMG != null) {
                for (int i2 : this.lMG) {
                    if (i2 >= 0) {
                        this.lME.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void dkN() {
        Fo(0);
    }

    public void dc(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.lME != null) {
            this.lME.append(i2, i);
        }
    }

    public int Fp(int i) {
        if (i >= 0 && this.lME != null) {
            return this.lME.get(i, -1);
        }
        return -1;
    }

    public void Fq(int i) {
        if (this.lME != null) {
            this.lME.delete(i);
        }
    }
}
