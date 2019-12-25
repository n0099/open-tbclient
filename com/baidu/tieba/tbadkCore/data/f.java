package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class f {
    public static final int[] kbi = {3, 8, 13};
    public static final int[] kbj = {2, 12};
    public static final int[] kbk = {20};
    public static final int[] kbl = {3, 13, 23};
    private SparseIntArray kbm = new SparseIntArray();
    private String kbn;
    private final int[] kbo;

    public f(String str, int[] iArr) {
        this.kbo = iArr;
        this.kbn = str;
    }

    public void Ch(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.kbm != null) {
            this.kbm.clear();
            if (this.kbo != null) {
                for (int i2 : this.kbo) {
                    if (i2 >= 0) {
                        this.kbm.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void cHV() {
        Ch(0);
    }

    public void cH(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.kbm != null) {
            this.kbm.append(i2, i);
        }
    }

    public int Ci(int i) {
        if (i >= 0 && this.kbm != null) {
            return this.kbm.get(i, -1);
        }
        return -1;
    }

    public void Cj(int i) {
        if (this.kbm != null) {
            this.kbm.delete(i);
        }
    }
}
