package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class f {
    public static final int[] nyw = {3, 8, 13};
    public static final int[] nyx = {2, 12};
    public static final int[] nyy = {20};
    public static final int[] nyz = {3, 13, 23};
    private SparseIntArray nyA = new SparseIntArray();
    private String nyB;
    private final int[] nyC;

    public f(String str, int[] iArr) {
        this.nyC = iArr;
        this.nyB = str;
    }

    public void JE(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.nyA != null) {
            this.nyA.clear();
            if (this.nyC != null) {
                for (int i2 : this.nyC) {
                    if (i2 >= 0) {
                        this.nyA.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void dNq() {
        JE(0);
    }

    public void ds(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.nyA != null) {
            this.nyA.append(i2, i);
        }
    }

    public int JF(int i) {
        if (i >= 0 && this.nyA != null) {
            return this.nyA.get(i, -1);
        }
        return -1;
    }

    public void JG(int i) {
        if (this.nyA != null) {
            this.nyA.delete(i);
        }
    }
}
