package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class e {
    public static final int[] gpM = {3, 8, 13};
    public static final int[] gpN = {2, 12};
    public static final int[] gpO = {20};
    public static final int[] gpP = {3, 13, 23};
    private SparseIntArray gpQ = new SparseIntArray();
    private String gpR;
    private final int[] gpS;

    public e(String str, int[] iArr) {
        this.gpS = iArr;
        this.gpR = str;
    }

    public void tR(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.gpQ != null) {
            this.gpQ.clear();
            if (this.gpS != null) {
                for (int i2 : this.gpS) {
                    if (i2 >= 0) {
                        this.gpQ.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void bui() {
        tR(0);
    }

    public void bT(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.gpQ != null) {
            this.gpQ.append(i2, i);
        }
    }

    public int tS(int i) {
        if (i >= 0 && this.gpQ != null) {
            return this.gpQ.get(i, -1);
        }
        return -1;
    }

    public void tT(int i) {
        if (this.gpQ != null) {
            this.gpQ.delete(i);
        }
    }
}
