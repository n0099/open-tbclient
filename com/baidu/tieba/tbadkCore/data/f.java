package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class f {
    public static final int[] iXY = {3, 8, 13};
    public static final int[] iXZ = {2, 12};
    public static final int[] iYa = {20};
    public static final int[] iYb = {3, 13, 23};
    private SparseIntArray iYc = new SparseIntArray();
    private String iYd;
    private final int[] iYe;

    public f(String str, int[] iArr) {
        this.iYe = iArr;
        this.iYd = str;
    }

    public void Au(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.iYc != null) {
            this.iYc.clear();
            if (this.iYe != null) {
                for (int i2 : this.iYe) {
                    if (i2 >= 0) {
                        this.iYc.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void clV() {
        Au(0);
    }

    public void cu(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.iYc != null) {
            this.iYc.append(i2, i);
        }
    }

    public int Av(int i) {
        if (i >= 0 && this.iYc != null) {
            return this.iYc.get(i, -1);
        }
        return -1;
    }

    public void Aw(int i) {
        if (this.iYc != null) {
            this.iYc.delete(i);
        }
    }
}
