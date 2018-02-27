package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class e {
    public static final int[] haa = {3, 8, 13};
    public static final int[] hab = {2, 12};
    public static final int[] hac = {20};
    public static final int[] had = {3, 13, 23};
    private SparseIntArray hae = new SparseIntArray();
    private String haf;
    private final int[] hag;

    public e(String str, int[] iArr) {
        this.hag = iArr;
        this.haf = str;
    }

    public void vI(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.hae != null) {
            this.hae.clear();
            if (this.hag != null) {
                for (int i2 : this.hag) {
                    if (i2 >= 0) {
                        this.hae.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void bwv() {
        vI(0);
    }

    public void cG(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.hae != null) {
            this.hae.append(i2, i);
        }
    }

    public int vJ(int i) {
        if (i >= 0 && this.hae != null) {
            return this.hae.get(i, -1);
        }
        return -1;
    }

    public void vK(int i) {
        if (this.hae != null) {
            this.hae.delete(i);
        }
    }
}
