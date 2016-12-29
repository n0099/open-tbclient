package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class f {
    public static final int[] ffV = {3, 8, 13};
    public static final int[] ffW = {2, 12};
    public static final int[] ffX = {20};
    public static final int[] ffY = {3, 13, 23};
    private SparseIntArray ffZ = new SparseIntArray();
    private String fga;
    private final int[] fgb;

    public f(String str, int[] iArr) {
        this.fgb = iArr;
        this.fga = str;
    }

    public void re(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.ffZ != null) {
            this.ffZ.clear();
            if (this.fgb != null) {
                for (int i2 : this.fgb) {
                    if (i2 >= 0) {
                        this.ffZ.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void bfy() {
        re(0);
    }

    public void bk(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.ffZ != null) {
            this.ffZ.append(i2, i);
        }
    }

    public int rf(int i) {
        if (i >= 0 && this.ffZ != null) {
            return this.ffZ.get(i, -1);
        }
        return -1;
    }

    public void rg(int i) {
        if (this.ffZ != null) {
            this.ffZ.delete(i);
        }
    }
}
