package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class e {
    public static final int[] hct = {3, 8, 13};
    public static final int[] hcu = {2, 12};
    public static final int[] hcv = {20};
    public static final int[] hcw = {3, 13, 23};
    private SparseIntArray hcx = new SparseIntArray();
    private String hcy;
    private final int[] hcz;

    public e(String str, int[] iArr) {
        this.hcz = iArr;
        this.hcy = str;
    }

    public void uC(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.hcx != null) {
            this.hcx.clear();
            if (this.hcz != null) {
                for (int i2 : this.hcz) {
                    if (i2 >= 0) {
                        this.hcx.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void bBC() {
        uC(0);
    }

    public void bO(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.hcx != null) {
            this.hcx.append(i2, i);
        }
    }

    public int uD(int i) {
        if (i >= 0 && this.hcx != null) {
            return this.hcx.get(i, -1);
        }
        return -1;
    }

    public void uE(int i) {
        if (this.hcx != null) {
            this.hcx.delete(i);
        }
    }
}
