package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class e {
    public static final int[] fpj = {3, 8, 13};
    public static final int[] fpk = {2, 12};
    public static final int[] fpl = {20};
    public static final int[] fpm = {3, 13, 23};
    private SparseIntArray fpn = new SparseIntArray();
    private String fpo;
    private final int[] fpp;

    public e(String str, int[] iArr) {
        this.fpp = iArr;
        this.fpo = str;
    }

    public void rR(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.fpn != null) {
            this.fpn.clear();
            if (this.fpp != null) {
                for (int i2 : this.fpp) {
                    if (i2 >= 0) {
                        this.fpn.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void bho() {
        rR(0);
    }

    public void bl(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.fpn != null) {
            this.fpn.append(i2, i);
        }
    }

    public int rS(int i) {
        if (i >= 0 && this.fpn != null) {
            return this.fpn.get(i, -1);
        }
        return -1;
    }

    public void rT(int i) {
        if (this.fpn != null) {
            this.fpn.delete(i);
        }
    }
}
