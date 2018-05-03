package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class e {
    public static final int[] gvR = {3, 8, 13};
    public static final int[] gvS = {2, 12};
    public static final int[] gvT = {20};
    public static final int[] gvU = {3, 13, 23};
    private SparseIntArray gvV = new SparseIntArray();
    private String gvW;
    private final int[] gvX;

    public e(String str, int[] iArr) {
        this.gvX = iArr;
        this.gvW = str;
    }

    public void tk(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.gvV != null) {
            this.gvV.clear();
            if (this.gvX != null) {
                for (int i2 : this.gvX) {
                    if (i2 >= 0) {
                        this.gvV.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void brC() {
        tk(0);
    }

    public void bH(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.gvV != null) {
            this.gvV.append(i2, i);
        }
    }

    public int tl(int i) {
        if (i >= 0 && this.gvV != null) {
            return this.gvV.get(i, -1);
        }
        return -1;
    }

    public void tm(int i) {
        if (this.gvV != null) {
            this.gvV.delete(i);
        }
    }
}
