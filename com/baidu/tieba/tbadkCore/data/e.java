package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class e {
    public static final int[] ggh = {3, 8, 13};
    public static final int[] ggi = {2, 12};
    public static final int[] ggj = {20};
    public static final int[] ggk = {3, 13, 23};
    private SparseIntArray ggl = new SparseIntArray();
    private String ggm;
    private final int[] ggn;

    public e(String str, int[] iArr) {
        this.ggn = iArr;
        this.ggm = str;
    }

    public void tx(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.ggl != null) {
            this.ggl.clear();
            if (this.ggn != null) {
                for (int i2 : this.ggn) {
                    if (i2 >= 0) {
                        this.ggl.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void bqX() {
        tx(0);
    }

    public void bS(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.ggl != null) {
            this.ggl.append(i2, i);
        }
    }

    public int ty(int i) {
        if (i >= 0 && this.ggl != null) {
            return this.ggl.get(i, -1);
        }
        return -1;
    }

    public void tz(int i) {
        if (this.ggl != null) {
            this.ggl.delete(i);
        }
    }
}
