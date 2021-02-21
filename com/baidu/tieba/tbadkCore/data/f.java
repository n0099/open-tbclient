package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class f {
    public static final int[] nws = {3, 8, 13};
    public static final int[] nwt = {2, 12};
    public static final int[] nwu = {20};
    public static final int[] nwv = {3, 13, 23};
    private SparseIntArray nww = new SparseIntArray();
    private String nwx;
    private final int[] nwy;

    public f(String str, int[] iArr) {
        this.nwy = iArr;
        this.nwx = str;
    }

    public void JA(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.nww != null) {
            this.nww.clear();
            if (this.nwy != null) {
                for (int i2 : this.nwy) {
                    if (i2 >= 0) {
                        this.nww.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void dNi() {
        JA(0);
    }

    public void ds(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.nww != null) {
            this.nww.append(i2, i);
        }
    }

    public int JB(int i) {
        if (i >= 0 && this.nww != null) {
            return this.nww.get(i, -1);
        }
        return -1;
    }

    public void JC(int i) {
        if (this.nww != null) {
            this.nww.delete(i);
        }
    }
}
