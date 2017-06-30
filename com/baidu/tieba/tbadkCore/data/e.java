package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class e {
    public static final int[] fLE = {3, 8, 13};
    public static final int[] fLF = {2, 12};
    public static final int[] fLG = {20};
    public static final int[] fLH = {3, 13, 23};
    private SparseIntArray fLI = new SparseIntArray();
    private String fLJ;
    private final int[] fLK;

    public e(String str, int[] iArr) {
        this.fLK = iArr;
        this.fLJ = str;
    }

    public void sB(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.fLI != null) {
            this.fLI.clear();
            if (this.fLK != null) {
                for (int i2 : this.fLK) {
                    if (i2 >= 0) {
                        this.fLI.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void blV() {
        sB(0);
    }

    public void bt(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.fLI != null) {
            this.fLI.append(i2, i);
        }
    }

    public int sC(int i) {
        if (i >= 0 && this.fLI != null) {
            return this.fLI.get(i, -1);
        }
        return -1;
    }

    public void sD(int i) {
        if (this.fLI != null) {
            this.fLI.delete(i);
        }
    }
}
