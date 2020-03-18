package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class f {
    public static final int[] khG = {3, 8, 13};
    public static final int[] khH = {2, 12};
    public static final int[] khI = {20};
    public static final int[] khJ = {3, 13, 23};
    private SparseIntArray khK = new SparseIntArray();
    private String khL;
    private final int[] khM;

    public f(String str, int[] iArr) {
        this.khM = iArr;
        this.khL = str;
    }

    public void CA(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.khK != null) {
            this.khK.clear();
            if (this.khM != null) {
                for (int i2 : this.khM) {
                    if (i2 >= 0) {
                        this.khK.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void cLc() {
        CA(0);
    }

    public void cK(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.khK != null) {
            this.khK.append(i2, i);
        }
    }

    public int CB(int i) {
        if (i >= 0 && this.khK != null) {
            return this.khK.get(i, -1);
        }
        return -1;
    }

    public void CC(int i) {
        if (this.khK != null) {
            this.khK.delete(i);
        }
    }
}
