package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class e {
    public static final int[] gNs = {3, 8, 13};
    public static final int[] gNt = {2, 12};
    public static final int[] gNu = {20};
    public static final int[] gNv = {3, 13, 23};
    private SparseIntArray gNw = new SparseIntArray();
    private String gNx;
    private final int[] gNy;

    public e(String str, int[] iArr) {
        this.gNy = iArr;
        this.gNx = str;
    }

    public void tF(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.gNw != null) {
            this.gNw.clear();
            if (this.gNy != null) {
                for (int i2 : this.gNy) {
                    if (i2 >= 0) {
                        this.gNw.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void bvG() {
        tF(0);
    }

    public void bJ(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.gNw != null) {
            this.gNw.append(i2, i);
        }
    }

    public int tG(int i) {
        if (i >= 0 && this.gNw != null) {
            return this.gNw.get(i, -1);
        }
        return -1;
    }

    public void tH(int i) {
        if (this.gNw != null) {
            this.gNw.delete(i);
        }
    }
}
