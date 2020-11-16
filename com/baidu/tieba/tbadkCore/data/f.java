package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class f {
    public static final int[] mXi = {3, 8, 13};
    public static final int[] mXj = {2, 12};
    public static final int[] mXk = {20};
    public static final int[] mXl = {3, 13, 23};
    private SparseIntArray mXm = new SparseIntArray();
    private String mXn;
    private final int[] mXo;

    public f(String str, int[] iArr) {
        this.mXo = iArr;
        this.mXn = str;
    }

    public void Kb(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.mXm != null) {
            this.mXm.clear();
            if (this.mXo != null) {
                for (int i2 : this.mXo) {
                    if (i2 >= 0) {
                        this.mXm.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void dJw() {
        Kb(0);
    }

    public void dt(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.mXm != null) {
            this.mXm.append(i2, i);
        }
    }

    public int Kc(int i) {
        if (i >= 0 && this.mXm != null) {
            return this.mXm.get(i, -1);
        }
        return -1;
    }

    public void Kd(int i) {
        if (this.mXm != null) {
            this.mXm.delete(i);
        }
    }
}
