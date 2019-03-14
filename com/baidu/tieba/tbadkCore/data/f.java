package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class f {
    public static final int[] iFA = {3, 8, 13};
    public static final int[] iFB = {2, 12};
    public static final int[] iFC = {20};
    public static final int[] iFD = {3, 13, 23};
    private SparseIntArray iFE = new SparseIntArray();
    private String iFF;
    private final int[] iFG;

    public f(String str, int[] iArr) {
        this.iFG = iArr;
        this.iFF = str;
    }

    public void zq(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.iFE != null) {
            this.iFE.clear();
            if (this.iFG != null) {
                for (int i2 : this.iFG) {
                    if (i2 >= 0) {
                        this.iFE.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void cdU() {
        zq(0);
    }

    public void cn(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.iFE != null) {
            this.iFE.append(i2, i);
        }
    }

    public int zr(int i) {
        if (i >= 0 && this.iFE != null) {
            return this.iFE.get(i, -1);
        }
        return -1;
    }

    public void zs(int i) {
        if (this.iFE != null) {
            this.iFE.delete(i);
        }
    }
}
