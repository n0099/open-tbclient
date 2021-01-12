package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class f {
    public static final int[] nmi = {3, 8, 13};
    public static final int[] nmj = {2, 12};
    public static final int[] nmk = {20};
    public static final int[] nml = {3, 13, 23};
    private SparseIntArray nmm = new SparseIntArray();
    private String nmn;
    private final int[] nmo;

    public f(String str, int[] iArr) {
        this.nmo = iArr;
        this.nmn = str;
    }

    public void Jg(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.nmm != null) {
            this.nmm.clear();
            if (this.nmo != null) {
                for (int i2 : this.nmo) {
                    if (i2 >= 0) {
                        this.nmm.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void dKP() {
        Jg(0);
    }

    public void du(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.nmm != null) {
            this.nmm.append(i2, i);
        }
    }

    public int Jh(int i) {
        if (i >= 0 && this.nmm != null) {
            return this.nmm.get(i, -1);
        }
        return -1;
    }

    public void Ji(int i) {
        if (this.nmm != null) {
            this.nmm.delete(i);
        }
    }
}
