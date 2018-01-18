package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class e {
    public static final int[] gXF = {3, 8, 13};
    public static final int[] gXG = {2, 12};
    public static final int[] gXH = {20};
    public static final int[] gXI = {3, 13, 23};
    private SparseIntArray gXJ = new SparseIntArray();
    private String gXK;
    private final int[] gXL;

    public e(String str, int[] iArr) {
        this.gXL = iArr;
        this.gXK = str;
    }

    public void vH(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.gXJ != null) {
            this.gXJ.clear();
            if (this.gXL != null) {
                for (int i2 : this.gXL) {
                    if (i2 >= 0) {
                        this.gXJ.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void bvi() {
        vH(0);
    }

    public void cL(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.gXJ != null) {
            this.gXJ.append(i2, i);
        }
    }

    public int vI(int i) {
        if (i >= 0 && this.gXJ != null) {
            return this.gXJ.get(i, -1);
        }
        return -1;
    }

    public void vJ(int i) {
        if (this.gXJ != null) {
            this.gXJ.delete(i);
        }
    }
}
