package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class e {
    public static final int[] gUY = {3, 8, 13};
    public static final int[] gUZ = {2, 12};
    public static final int[] gVa = {20};
    public static final int[] gVb = {3, 13, 23};
    private SparseIntArray gVc = new SparseIntArray();
    private String gVd;
    private final int[] gVe;

    public e(String str, int[] iArr) {
        this.gVe = iArr;
        this.gVd = str;
    }

    public void uf(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.gVc != null) {
            this.gVc.clear();
            if (this.gVe != null) {
                for (int i2 : this.gVe) {
                    if (i2 >= 0) {
                        this.gVc.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void byn() {
        uf(0);
    }

    public void bL(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.gVc != null) {
            this.gVc.append(i2, i);
        }
    }

    public int ug(int i) {
        if (i >= 0 && this.gVc != null) {
            return this.gVc.get(i, -1);
        }
        return -1;
    }

    public void uh(int i) {
        if (this.gVc != null) {
            this.gVc.delete(i);
        }
    }
}
