package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class e {
    public static final int[] goJ = {3, 8, 13};
    public static final int[] goK = {2, 12};
    public static final int[] goL = {20};
    public static final int[] goM = {3, 13, 23};
    private SparseIntArray goN = new SparseIntArray();
    private String goO;
    private final int[] goP;

    public e(String str, int[] iArr) {
        this.goP = iArr;
        this.goO = str;
    }

    public void tN(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.goN != null) {
            this.goN.clear();
            if (this.goP != null) {
                for (int i2 : this.goP) {
                    if (i2 >= 0) {
                        this.goN.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void btW() {
        tN(0);
    }

    public void bU(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.goN != null) {
            this.goN.append(i2, i);
        }
    }

    public int tO(int i) {
        if (i >= 0 && this.goN != null) {
            return this.goN.get(i, -1);
        }
        return -1;
    }

    public void tP(int i) {
        if (this.goN != null) {
            this.goN.delete(i);
        }
    }
}
