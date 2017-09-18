package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class e {
    public static final int[] giB = {3, 8, 13};
    public static final int[] giC = {2, 12};
    public static final int[] giD = {20};
    public static final int[] giE = {3, 13, 23};
    private SparseIntArray giF = new SparseIntArray();
    private String giG;
    private final int[] giH;

    public e(String str, int[] iArr) {
        this.giH = iArr;
        this.giG = str;
    }

    public void ts(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.giF != null) {
            this.giF.clear();
            if (this.giH != null) {
                for (int i2 : this.giH) {
                    if (i2 >= 0) {
                        this.giF.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void bsa() {
        ts(0);
    }

    public void bK(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.giF != null) {
            this.giF.append(i2, i);
        }
    }

    public int tt(int i) {
        if (i >= 0 && this.giF != null) {
            return this.giF.get(i, -1);
        }
        return -1;
    }

    public void tu(int i) {
        if (this.giF != null) {
            this.giF.delete(i);
        }
    }
}
