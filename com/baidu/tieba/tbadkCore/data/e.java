package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class e {
    public static final int[] hpc = {3, 8, 13};
    public static final int[] hpd = {2, 12};
    public static final int[] hpe = {20};
    public static final int[] hpf = {3, 13, 23};
    private SparseIntArray hpg = new SparseIntArray();
    private String hph;
    private final int[] hpi;

    public e(String str, int[] iArr) {
        this.hpi = iArr;
        this.hph = str;
    }

    public void vH(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.hpg != null) {
            this.hpg.clear();
            if (this.hpi != null) {
                for (int i2 : this.hpi) {
                    if (i2 >= 0) {
                        this.hpg.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void bEt() {
        vH(0);
    }

    public void bR(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.hpg != null) {
            this.hpg.append(i2, i);
        }
    }

    public int vI(int i) {
        if (i >= 0 && this.hpg != null) {
            return this.hpg.get(i, -1);
        }
        return -1;
    }

    public void vJ(int i) {
        if (this.hpg != null) {
            this.hpg.delete(i);
        }
    }
}
