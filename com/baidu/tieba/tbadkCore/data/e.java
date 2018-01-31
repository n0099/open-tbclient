package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class e {
    public static final int[] gXZ = {3, 8, 13};
    public static final int[] gYa = {2, 12};
    public static final int[] gYb = {20};
    public static final int[] gYc = {3, 13, 23};
    private SparseIntArray gYd = new SparseIntArray();
    private String gYe;
    private final int[] gYf;

    public e(String str, int[] iArr) {
        this.gYf = iArr;
        this.gYe = str;
    }

    public void vH(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.gYd != null) {
            this.gYd.clear();
            if (this.gYf != null) {
                for (int i2 : this.gYf) {
                    if (i2 >= 0) {
                        this.gYd.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void bvk() {
        vH(0);
    }

    public void cL(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.gYd != null) {
            this.gYd.append(i2, i);
        }
    }

    public int vI(int i) {
        if (i >= 0 && this.gYd != null) {
            return this.gYd.get(i, -1);
        }
        return -1;
    }

    public void vJ(int i) {
        if (this.gYd != null) {
            this.gYd.delete(i);
        }
    }
}
