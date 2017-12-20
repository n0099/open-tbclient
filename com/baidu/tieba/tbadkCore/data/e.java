package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class e {
    public static final int[] gBn = {3, 8, 13};
    public static final int[] gBo = {2, 12};
    public static final int[] gBp = {20};
    public static final int[] gBq = {3, 13, 23};
    private SparseIntArray gBr = new SparseIntArray();
    private String gBs;
    private final int[] gBt;

    public e(String str, int[] iArr) {
        this.gBt = iArr;
        this.gBs = str;
    }

    public void us(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.gBr != null) {
            this.gBr.clear();
            if (this.gBt != null) {
                for (int i2 : this.gBt) {
                    if (i2 >= 0) {
                        this.gBr.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void bww() {
        us(0);
    }

    public void bV(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.gBr != null) {
            this.gBr.append(i2, i);
        }
    }

    public int ut(int i) {
        if (i >= 0 && this.gBr != null) {
            return this.gBr.get(i, -1);
        }
        return -1;
    }

    public void uu(int i) {
        if (this.gBr != null) {
            this.gBr.delete(i);
        }
    }
}
