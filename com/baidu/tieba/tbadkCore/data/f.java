package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class f {
    public static final int[] iFI = {3, 8, 13};
    public static final int[] iFJ = {2, 12};
    public static final int[] iFK = {20};
    public static final int[] iFL = {3, 13, 23};
    private SparseIntArray iFM = new SparseIntArray();
    private String iFN;
    private final int[] iFO;

    public f(String str, int[] iArr) {
        this.iFO = iArr;
        this.iFN = str;
    }

    public void zq(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.iFM != null) {
            this.iFM.clear();
            if (this.iFO != null) {
                for (int i2 : this.iFO) {
                    if (i2 >= 0) {
                        this.iFM.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void cdS() {
        zq(0);
    }

    public void cn(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.iFM != null) {
            this.iFM.append(i2, i);
        }
    }

    public int zr(int i) {
        if (i >= 0 && this.iFM != null) {
            return this.iFM.get(i, -1);
        }
        return -1;
    }

    public void zs(int i) {
        if (this.iFM != null) {
            this.iFM.delete(i);
        }
    }
}
