package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class e {
    public static final int[] ghG = {3, 8, 13};
    public static final int[] ghH = {2, 12};
    public static final int[] ghI = {20};
    public static final int[] ghJ = {3, 13, 23};
    private SparseIntArray ghK = new SparseIntArray();
    private String ghL;
    private final int[] ghM;

    public e(String str, int[] iArr) {
        this.ghM = iArr;
        this.ghL = str;
    }

    public void tq(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.ghK != null) {
            this.ghK.clear();
            if (this.ghM != null) {
                for (int i2 : this.ghM) {
                    if (i2 >= 0) {
                        this.ghK.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void brP() {
        tq(0);
    }

    public void bG(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.ghK != null) {
            this.ghK.append(i2, i);
        }
    }

    public int tr(int i) {
        if (i >= 0 && this.ghK != null) {
            return this.ghK.get(i, -1);
        }
        return -1;
    }

    public void ts(int i) {
        if (this.ghK != null) {
            this.ghK.delete(i);
        }
    }
}
