package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class e {
    public static final int[] hpb = {3, 8, 13};
    public static final int[] hpc = {2, 12};
    public static final int[] hpd = {20};
    public static final int[] hpe = {3, 13, 23};
    private SparseIntArray hpf = new SparseIntArray();
    private String hpg;
    private final int[] hph;

    public e(String str, int[] iArr) {
        this.hph = iArr;
        this.hpg = str;
    }

    public void vH(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.hpf != null) {
            this.hpf.clear();
            if (this.hph != null) {
                for (int i2 : this.hph) {
                    if (i2 >= 0) {
                        this.hpf.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void bEt() {
        vH(0);
    }

    public void bR(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.hpf != null) {
            this.hpf.append(i2, i);
        }
    }

    public int vI(int i) {
        if (i >= 0 && this.hpf != null) {
            return this.hpf.get(i, -1);
        }
        return -1;
    }

    public void vJ(int i) {
        if (this.hpf != null) {
            this.hpf.delete(i);
        }
    }
}
