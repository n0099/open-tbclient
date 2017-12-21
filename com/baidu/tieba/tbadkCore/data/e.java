package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class e {
    public static final int[] gBs = {3, 8, 13};
    public static final int[] gBt = {2, 12};
    public static final int[] gBu = {20};
    public static final int[] gBv = {3, 13, 23};
    private SparseIntArray gBw = new SparseIntArray();
    private String gBx;
    private final int[] gBy;

    public e(String str, int[] iArr) {
        this.gBy = iArr;
        this.gBx = str;
    }

    public void us(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.gBw != null) {
            this.gBw.clear();
            if (this.gBy != null) {
                for (int i2 : this.gBy) {
                    if (i2 >= 0) {
                        this.gBw.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void bwx() {
        us(0);
    }

    public void bV(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.gBw != null) {
            this.gBw.append(i2, i);
        }
    }

    public int ut(int i) {
        if (i >= 0 && this.gBw != null) {
            return this.gBw.get(i, -1);
        }
        return -1;
    }

    public void uu(int i) {
        if (this.gBw != null) {
            this.gBw.delete(i);
        }
    }
}
