package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class e {
    public static final int[] hap = {3, 8, 13};
    public static final int[] haq = {2, 12};
    public static final int[] har = {20};
    public static final int[] has = {3, 13, 23};
    private SparseIntArray hat = new SparseIntArray();
    private String hau;
    private final int[] hav;

    public e(String str, int[] iArr) {
        this.hav = iArr;
        this.hau = str;
    }

    public void vH(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.hat != null) {
            this.hat.clear();
            if (this.hav != null) {
                for (int i2 : this.hav) {
                    if (i2 >= 0) {
                        this.hat.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void bww() {
        vH(0);
    }

    public void cG(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.hat != null) {
            this.hat.append(i2, i);
        }
    }

    public int vI(int i) {
        if (i >= 0 && this.hat != null) {
            return this.hat.get(i, -1);
        }
        return -1;
    }

    public void vJ(int i) {
        if (this.hat != null) {
            this.hat.delete(i);
        }
    }
}
