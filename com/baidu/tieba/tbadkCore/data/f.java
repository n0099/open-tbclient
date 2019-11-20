package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class f {
    public static final int[] jgV = {3, 8, 13};
    public static final int[] jgW = {2, 12};
    public static final int[] jgX = {20};
    public static final int[] jgY = {3, 13, 23};
    private SparseIntArray jgZ = new SparseIntArray();
    private String jha;
    private final int[] jhb;

    public f(String str, int[] iArr) {
        this.jhb = iArr;
        this.jha = str;
    }

    public void zM(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.jgZ != null) {
            this.jgZ.clear();
            if (this.jhb != null) {
                for (int i2 : this.jhb) {
                    if (i2 >= 0) {
                        this.jgZ.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void cnP() {
        zM(0);
    }

    public void cp(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.jgZ != null) {
            this.jgZ.append(i2, i);
        }
    }

    public int zN(int i) {
        if (i >= 0 && this.jgZ != null) {
            return this.jgZ.get(i, -1);
        }
        return -1;
    }

    public void zO(int i) {
        if (this.jgZ != null) {
            this.jgZ.delete(i);
        }
    }
}
