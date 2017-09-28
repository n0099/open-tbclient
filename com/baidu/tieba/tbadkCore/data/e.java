package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class e {
    public static final int[] ggi = {3, 8, 13};
    public static final int[] ggj = {2, 12};
    public static final int[] ggk = {20};
    public static final int[] ggl = {3, 13, 23};
    private SparseIntArray ggm = new SparseIntArray();
    private String ggn;
    private final int[] ggo;

    public e(String str, int[] iArr) {
        this.ggo = iArr;
        this.ggn = str;
    }

    public void tx(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.ggm != null) {
            this.ggm.clear();
            if (this.ggo != null) {
                for (int i2 : this.ggo) {
                    if (i2 >= 0) {
                        this.ggm.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void bqY() {
        tx(0);
    }

    public void bS(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.ggm != null) {
            this.ggm.append(i2, i);
        }
    }

    public int ty(int i) {
        if (i >= 0 && this.ggm != null) {
            return this.ggm.get(i, -1);
        }
        return -1;
    }

    public void tz(int i) {
        if (this.ggm != null) {
            this.ggm.delete(i);
        }
    }
}
