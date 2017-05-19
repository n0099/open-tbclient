package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class e {
    public static final int[] ftJ = {3, 8, 13};
    public static final int[] ftK = {2, 12};
    public static final int[] ftL = {20};
    public static final int[] ftM = {3, 13, 23};
    private SparseIntArray ftN = new SparseIntArray();
    private String ftO;
    private final int[] ftP;

    public e(String str, int[] iArr) {
        this.ftP = iArr;
        this.ftO = str;
    }

    public void rM(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.ftN != null) {
            this.ftN.clear();
            if (this.ftP != null) {
                for (int i2 : this.ftP) {
                    if (i2 >= 0) {
                        this.ftN.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void bgk() {
        rM(0);
    }

    public void bk(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.ftN != null) {
            this.ftN.append(i2, i);
        }
    }

    public int rN(int i) {
        if (i >= 0 && this.ftN != null) {
            return this.ftN.get(i, -1);
        }
        return -1;
    }

    public void rO(int i) {
        if (this.ftN != null) {
            this.ftN.delete(i);
        }
    }
}
