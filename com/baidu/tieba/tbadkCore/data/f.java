package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class f {
    public static final int[] kge = {3, 8, 13};
    public static final int[] kgf = {2, 12};
    public static final int[] kgg = {20};
    public static final int[] kgh = {3, 13, 23};
    private SparseIntArray kgi = new SparseIntArray();
    private String kgj;
    private final int[] kgk;

    public f(String str, int[] iArr) {
        this.kgk = iArr;
        this.kgj = str;
    }

    public void Cs(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.kgi != null) {
            this.kgi.clear();
            if (this.kgk != null) {
                for (int i2 : this.kgk) {
                    if (i2 >= 0) {
                        this.kgi.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void cKI() {
        Cs(0);
    }

    public void cJ(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.kgi != null) {
            this.kgi.append(i2, i);
        }
    }

    public int Ct(int i) {
        if (i >= 0 && this.kgi != null) {
            return this.kgi.get(i, -1);
        }
        return -1;
    }

    public void Cu(int i) {
        if (this.kgi != null) {
            this.kgi.delete(i);
        }
    }
}
