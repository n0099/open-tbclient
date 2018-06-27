package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class e {
    public static final int[] gMu = {3, 8, 13};
    public static final int[] gMv = {2, 12};
    public static final int[] gMw = {20};
    public static final int[] gMx = {3, 13, 23};
    private final int[] gMA;
    private SparseIntArray gMy = new SparseIntArray();
    private String gMz;

    public e(String str, int[] iArr) {
        this.gMA = iArr;
        this.gMz = str;
    }

    public void tH(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.gMy != null) {
            this.gMy.clear();
            if (this.gMA != null) {
                for (int i2 : this.gMA) {
                    if (i2 >= 0) {
                        this.gMy.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void bxd() {
        tH(0);
    }

    public void bI(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.gMy != null) {
            this.gMy.append(i2, i);
        }
    }

    public int tI(int i) {
        if (i >= 0 && this.gMy != null) {
            return this.gMy.get(i, -1);
        }
        return -1;
    }

    public void tJ(int i) {
        if (this.gMy != null) {
            this.gMy.delete(i);
        }
    }
}
