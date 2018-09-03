package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class e {
    public static final int[] gNu = {3, 8, 13};
    public static final int[] gNv = {2, 12};
    public static final int[] gNw = {20};
    public static final int[] gNx = {3, 13, 23};
    private final int[] gNA;
    private SparseIntArray gNy = new SparseIntArray();
    private String gNz;

    public e(String str, int[] iArr) {
        this.gNA = iArr;
        this.gNz = str;
    }

    public void tF(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.gNy != null) {
            this.gNy.clear();
            if (this.gNA != null) {
                for (int i2 : this.gNA) {
                    if (i2 >= 0) {
                        this.gNy.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void bvH() {
        tF(0);
    }

    public void bJ(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.gNy != null) {
            this.gNy.append(i2, i);
        }
    }

    public int tG(int i) {
        if (i >= 0 && this.gNy != null) {
            return this.gNy.get(i, -1);
        }
        return -1;
    }

    public void tH(int i) {
        if (this.gNy != null) {
            this.gNy.delete(i);
        }
    }
}
