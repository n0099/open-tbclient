package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class e {
    public static final int[] gvU = {3, 8, 13};
    public static final int[] gvV = {2, 12};
    public static final int[] gvW = {20};
    public static final int[] gvX = {3, 13, 23};
    private SparseIntArray gvY = new SparseIntArray();
    private String gvZ;
    private final int[] gwa;

    public e(String str, int[] iArr) {
        this.gwa = iArr;
        this.gvZ = str;
    }

    public void tl(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.gvY != null) {
            this.gvY.clear();
            if (this.gwa != null) {
                for (int i2 : this.gwa) {
                    if (i2 >= 0) {
                        this.gvY.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void brC() {
        tl(0);
    }

    public void bI(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.gvY != null) {
            this.gvY.append(i2, i);
        }
    }

    public int tm(int i) {
        if (i >= 0 && this.gvY != null) {
            return this.gvY.get(i, -1);
        }
        return -1;
    }

    public void tn(int i) {
        if (this.gvY != null) {
            this.gvY.delete(i);
        }
    }
}
