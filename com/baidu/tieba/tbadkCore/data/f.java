package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class f {
    public static final int[] jev = {3, 8, 13};
    public static final int[] jew = {2, 12};
    public static final int[] jex = {20};
    public static final int[] jey = {3, 13, 23};
    private String jeA;
    private final int[] jeB;
    private SparseIntArray jez = new SparseIntArray();

    public f(String str, int[] iArr) {
        this.jeB = iArr;
        this.jeA = str;
    }

    public void Ba(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.jez != null) {
            this.jez.clear();
            if (this.jeB != null) {
                for (int i2 : this.jeB) {
                    if (i2 >= 0) {
                        this.jez.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void coQ() {
        Ba(0);
    }

    public void cz(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.jez != null) {
            this.jez.append(i2, i);
        }
    }

    public int Bb(int i) {
        if (i >= 0 && this.jez != null) {
            return this.jez.get(i, -1);
        }
        return -1;
    }

    public void Bc(int i) {
        if (this.jez != null) {
            this.jez.delete(i);
        }
    }
}
