package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class f {
    public static final int[] iYe = {3, 8, 13};
    public static final int[] iYf = {2, 12};
    public static final int[] iYg = {20};
    public static final int[] iYh = {3, 13, 23};
    private SparseIntArray iYi = new SparseIntArray();
    private String iYj;
    private final int[] iYk;

    public f(String str, int[] iArr) {
        this.iYk = iArr;
        this.iYj = str;
    }

    public void Au(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.iYi != null) {
            this.iYi.clear();
            if (this.iYk != null) {
                for (int i2 : this.iYk) {
                    if (i2 >= 0) {
                        this.iYi.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void clY() {
        Au(0);
    }

    public void cu(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.iYi != null) {
            this.iYi.append(i2, i);
        }
    }

    public int Av(int i) {
        if (i >= 0 && this.iYi != null) {
            return this.iYi.get(i, -1);
        }
        return -1;
    }

    public void Aw(int i) {
        if (this.iYi != null) {
            this.iYi.delete(i);
        }
    }
}
