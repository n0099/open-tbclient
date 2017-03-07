package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class e {
    public static final int[] ftF = {3, 8, 13};
    public static final int[] ftG = {2, 12};
    public static final int[] ftH = {20};
    public static final int[] ftI = {3, 13, 23};
    private SparseIntArray ftJ = new SparseIntArray();
    private String ftK;
    private final int[] ftL;

    public e(String str, int[] iArr) {
        this.ftL = iArr;
        this.ftK = str;
    }

    public void rQ(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.ftJ != null) {
            this.ftJ.clear();
            if (this.ftL != null) {
                for (int i2 : this.ftL) {
                    if (i2 >= 0) {
                        this.ftJ.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void bhb() {
        rQ(0);
    }

    public void bq(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.ftJ != null) {
            this.ftJ.append(i2, i);
        }
    }

    public int rR(int i) {
        if (i >= 0 && this.ftJ != null) {
            return this.ftJ.get(i, -1);
        }
        return -1;
    }

    public void rS(int i) {
        if (this.ftJ != null) {
            this.ftJ.delete(i);
        }
    }
}
