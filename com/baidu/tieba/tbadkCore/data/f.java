package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class f {
    public static final int[] keR = {3, 8, 13};
    public static final int[] keS = {2, 12};
    public static final int[] keT = {20};
    public static final int[] keU = {3, 13, 23};
    private SparseIntArray keV = new SparseIntArray();
    private String keW;
    private final int[] keX;

    public f(String str, int[] iArr) {
        this.keX = iArr;
        this.keW = str;
    }

    public void Cm(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.keV != null) {
            this.keV.clear();
            if (this.keX != null) {
                for (int i2 : this.keX) {
                    if (i2 >= 0) {
                        this.keV.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void cJb() {
        Cm(0);
    }

    public void cG(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.keV != null) {
            this.keV.append(i2, i);
        }
    }

    public int Cn(int i) {
        if (i >= 0 && this.keV != null) {
            return this.keV.get(i, -1);
        }
        return -1;
    }

    public void Co(int i) {
        if (this.keV != null) {
            this.keV.delete(i);
        }
    }
}
