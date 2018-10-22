package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class e {
    public static final int[] hcu = {3, 8, 13};
    public static final int[] hcv = {2, 12};
    public static final int[] hcw = {20};
    public static final int[] hcx = {3, 13, 23};
    private final int[] hcA;
    private SparseIntArray hcy = new SparseIntArray();
    private String hcz;

    public e(String str, int[] iArr) {
        this.hcA = iArr;
        this.hcz = str;
    }

    public void uC(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.hcy != null) {
            this.hcy.clear();
            if (this.hcA != null) {
                for (int i2 : this.hcA) {
                    if (i2 >= 0) {
                        this.hcy.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void bBC() {
        uC(0);
    }

    public void bO(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.hcy != null) {
            this.hcy.append(i2, i);
        }
    }

    public int uD(int i) {
        if (i >= 0 && this.hcy != null) {
            return this.hcy.get(i, -1);
        }
        return -1;
    }

    public void uE(int i) {
        if (this.hcy != null) {
            this.hcy.delete(i);
        }
    }
}
