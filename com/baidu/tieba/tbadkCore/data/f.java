package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class f {
    public static final int[] iFH = {3, 8, 13};
    public static final int[] iFI = {2, 12};
    public static final int[] iFJ = {20};
    public static final int[] iFK = {3, 13, 23};
    private SparseIntArray iFL = new SparseIntArray();
    private String iFM;
    private final int[] iFN;

    public f(String str, int[] iArr) {
        this.iFN = iArr;
        this.iFM = str;
    }

    public void zq(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.iFL != null) {
            this.iFL.clear();
            if (this.iFN != null) {
                for (int i2 : this.iFN) {
                    if (i2 >= 0) {
                        this.iFL.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void cdR() {
        zq(0);
    }

    public void cn(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.iFL != null) {
            this.iFL.append(i2, i);
        }
    }

    public int zr(int i) {
        if (i >= 0 && this.iFL != null) {
            return this.iFL.get(i, -1);
        }
        return -1;
    }

    public void zs(int i) {
        if (this.iFL != null) {
            this.iFL.delete(i);
        }
    }
}
