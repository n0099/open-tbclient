package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class e {
    public static final int[] gwV = {3, 8, 13};
    public static final int[] gwW = {2, 12};
    public static final int[] gwX = {20};
    public static final int[] gwY = {3, 13, 23};
    private SparseIntArray gwZ = new SparseIntArray();
    private String gxa;
    private final int[] gxb;

    public e(String str, int[] iArr) {
        this.gxb = iArr;
        this.gxa = str;
    }

    public void tj(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.gwZ != null) {
            this.gwZ.clear();
            if (this.gxb != null) {
                for (int i2 : this.gxb) {
                    if (i2 >= 0) {
                        this.gwZ.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void brA() {
        tj(0);
    }

    public void bH(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.gwZ != null) {
            this.gwZ.append(i2, i);
        }
    }

    public int tk(int i) {
        if (i >= 0 && this.gwZ != null) {
            return this.gwZ.get(i, -1);
        }
        return -1;
    }

    public void tl(int i) {
        if (this.gwZ != null) {
            this.gwZ.delete(i);
        }
    }
}
