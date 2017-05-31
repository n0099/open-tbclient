package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class e {
    public static final int[] fBA = {3, 8, 13};
    public static final int[] fBB = {2, 12};
    public static final int[] fBC = {20};
    public static final int[] fBD = {3, 13, 23};
    private SparseIntArray fBE = new SparseIntArray();
    private String fBF;
    private final int[] fBG;

    public e(String str, int[] iArr) {
        this.fBG = iArr;
        this.fBF = str;
    }

    public void si(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.fBE != null) {
            this.fBE.clear();
            if (this.fBG != null) {
                for (int i2 : this.fBG) {
                    if (i2 >= 0) {
                        this.fBE.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void bhH() {
        si(0);
    }

    public void bk(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.fBE != null) {
            this.fBE.append(i2, i);
        }
    }

    public int sj(int i) {
        if (i >= 0 && this.fBE != null) {
            return this.fBE.get(i, -1);
        }
        return -1;
    }

    public void sk(int i) {
        if (this.fBE != null) {
            this.fBE.delete(i);
        }
    }
}
