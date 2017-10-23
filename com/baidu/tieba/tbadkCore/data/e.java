package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class e {
    public static final int[] gfT = {3, 8, 13};
    public static final int[] gfU = {2, 12};
    public static final int[] gfV = {20};
    public static final int[] gfW = {3, 13, 23};
    private SparseIntArray gfX = new SparseIntArray();
    private String gfY;
    private final int[] gfZ;

    public e(String str, int[] iArr) {
        this.gfZ = iArr;
        this.gfY = str;
    }

    public void tw(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.gfX != null) {
            this.gfX.clear();
            if (this.gfZ != null) {
                for (int i2 : this.gfZ) {
                    if (i2 >= 0) {
                        this.gfX.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void bqQ() {
        tw(0);
    }

    public void bS(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.gfX != null) {
            this.gfX.append(i2, i);
        }
    }

    public int tx(int i) {
        if (i >= 0 && this.gfX != null) {
            return this.gfX.get(i, -1);
        }
        return -1;
    }

    public void ty(int i) {
        if (this.gfX != null) {
            this.gfX.delete(i);
        }
    }
}
