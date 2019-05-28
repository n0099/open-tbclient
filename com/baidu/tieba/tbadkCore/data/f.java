package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class f {
    public static final int[] iYa = {3, 8, 13};
    public static final int[] iYb = {2, 12};
    public static final int[] iYc = {20};
    public static final int[] iYd = {3, 13, 23};
    private SparseIntArray iYe = new SparseIntArray();
    private String iYf;
    private final int[] iYg;

    public f(String str, int[] iArr) {
        this.iYg = iArr;
        this.iYf = str;
    }

    public void Au(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.iYe != null) {
            this.iYe.clear();
            if (this.iYg != null) {
                for (int i2 : this.iYg) {
                    if (i2 >= 0) {
                        this.iYe.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void clX() {
        Au(0);
    }

    public void cu(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.iYe != null) {
            this.iYe.append(i2, i);
        }
    }

    public int Av(int i) {
        if (i >= 0 && this.iYe != null) {
            return this.iYe.get(i, -1);
        }
        return -1;
    }

    public void Aw(int i) {
        if (this.iYe != null) {
            this.iYe.delete(i);
        }
    }
}
