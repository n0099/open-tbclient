package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class e {
    public static final int[] fxF = {3, 8, 13};
    public static final int[] fxG = {2, 12};
    public static final int[] fxH = {20};
    public static final int[] fxI = {3, 13, 23};
    private SparseIntArray fxJ = new SparseIntArray();
    private String fxK;
    private final int[] fxL;

    public e(String str, int[] iArr) {
        this.fxL = iArr;
        this.fxK = str;
    }

    public void rU(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.fxJ != null) {
            this.fxJ.clear();
            if (this.fxL != null) {
                for (int i2 : this.fxL) {
                    if (i2 >= 0) {
                        this.fxJ.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void biN() {
        rU(0);
    }

    public void bn(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.fxJ != null) {
            this.fxJ.append(i2, i);
        }
    }

    public int rV(int i) {
        if (i >= 0 && this.fxJ != null) {
            return this.fxJ.get(i, -1);
        }
        return -1;
    }

    public void rW(int i) {
        if (this.fxJ != null) {
            this.fxJ.delete(i);
        }
    }
}
