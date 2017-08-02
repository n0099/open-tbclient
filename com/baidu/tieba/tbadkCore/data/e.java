package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class e {
    public static final int[] ggb = {3, 8, 13};
    public static final int[] ggc = {2, 12};
    public static final int[] ggd = {20};
    public static final int[] gge = {3, 13, 23};
    private SparseIntArray ggf = new SparseIntArray();
    private String ggg;
    private final int[] ggh;

    public e(String str, int[] iArr) {
        this.ggh = iArr;
        this.ggg = str;
    }

    public void tf(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.ggf != null) {
            this.ggf.clear();
            if (this.ggh != null) {
                for (int i2 : this.ggh) {
                    if (i2 >= 0) {
                        this.ggf.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void brS() {
        tf(0);
    }

    public void bv(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.ggf != null) {
            this.ggf.append(i2, i);
        }
    }

    public int tg(int i) {
        if (i >= 0 && this.ggf != null) {
            return this.ggf.get(i, -1);
        }
        return -1;
    }

    public void th(int i) {
        if (this.ggf != null) {
            this.ggf.delete(i);
        }
    }
}
