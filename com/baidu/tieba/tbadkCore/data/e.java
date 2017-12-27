package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class e {
    public static final int[] hif = {3, 8, 13};
    public static final int[] hig = {2, 12};
    public static final int[] hih = {20};
    public static final int[] hii = {3, 13, 23};
    private SparseIntArray hij = new SparseIntArray();
    private String hik;
    private final int[] hil;

    public e(String str, int[] iArr) {
        this.hil = iArr;
        this.hik = str;
    }

    public void xf(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.hij != null) {
            this.hij.clear();
            if (this.hil != null) {
                for (int i2 : this.hil) {
                    if (i2 >= 0) {
                        this.hij.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void bBM() {
        xf(0);
    }

    public void cS(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.hij != null) {
            this.hij.append(i2, i);
        }
    }

    public int xg(int i) {
        if (i >= 0 && this.hij != null) {
            return this.hij.get(i, -1);
        }
        return -1;
    }

    public void xh(int i) {
        if (this.hij != null) {
            this.hij.delete(i);
        }
    }
}
