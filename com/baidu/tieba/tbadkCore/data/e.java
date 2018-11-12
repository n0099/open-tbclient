package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class e {
    public static final int[] hdR = {3, 8, 13};
    public static final int[] hdS = {2, 12};
    public static final int[] hdT = {20};
    public static final int[] hdU = {3, 13, 23};
    private SparseIntArray hdV = new SparseIntArray();
    private String hdW;
    private final int[] hdX;

    public e(String str, int[] iArr) {
        this.hdX = iArr;
        this.hdW = str;
    }

    public void uV(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.hdV != null) {
            this.hdV.clear();
            if (this.hdX != null) {
                for (int i2 : this.hdX) {
                    if (i2 >= 0) {
                        this.hdV.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void bAY() {
        uV(0);
    }

    public void bS(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.hdV != null) {
            this.hdV.append(i2, i);
        }
    }

    public int uW(int i) {
        if (i >= 0 && this.hdV != null) {
            return this.hdV.get(i, -1);
        }
        return -1;
    }

    public void uX(int i) {
        if (this.hdV != null) {
            this.hdV.delete(i);
        }
    }
}
