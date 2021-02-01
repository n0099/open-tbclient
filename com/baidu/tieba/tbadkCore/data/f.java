package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class f {
    public static final int[] nvS = {3, 8, 13};
    public static final int[] nvT = {2, 12};
    public static final int[] nvU = {20};
    public static final int[] nvV = {3, 13, 23};
    private SparseIntArray nvW = new SparseIntArray();
    private String nvX;
    private final int[] nvY;

    public f(String str, int[] iArr) {
        this.nvY = iArr;
        this.nvX = str;
    }

    public void JA(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.nvW != null) {
            this.nvW.clear();
            if (this.nvY != null) {
                for (int i2 : this.nvY) {
                    if (i2 >= 0) {
                        this.nvW.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void dNa() {
        JA(0);
    }

    public void dr(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.nvW != null) {
            this.nvW.append(i2, i);
        }
    }

    public int JB(int i) {
        if (i >= 0 && this.nvW != null) {
            return this.nvW.get(i, -1);
        }
        return -1;
    }

    public void JC(int i) {
        if (this.nvW != null) {
            this.nvW.delete(i);
        }
    }
}
