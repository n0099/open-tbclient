package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class f {
    public static final int[] lkh = {3, 8, 13};
    public static final int[] lki = {2, 12};
    public static final int[] lkj = {20};
    public static final int[] lkk = {3, 13, 23};
    private SparseIntArray lkl = new SparseIntArray();
    private String lkm;
    private final int[] lkn;

    public f(String str, int[] iArr) {
        this.lkn = iArr;
        this.lkm = str;
    }

    public void DO(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.lkl != null) {
            this.lkl.clear();
            if (this.lkn != null) {
                for (int i2 : this.lkn) {
                    if (i2 >= 0) {
                        this.lkl.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void dda() {
        DO(0);
    }

    public void cU(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.lkl != null) {
            this.lkl.append(i2, i);
        }
    }

    public int DP(int i) {
        if (i >= 0 && this.lkl != null) {
            return this.lkl.get(i, -1);
        }
        return -1;
    }

    public void DQ(int i) {
        if (this.lkl != null) {
            this.lkl.delete(i);
        }
    }
}
