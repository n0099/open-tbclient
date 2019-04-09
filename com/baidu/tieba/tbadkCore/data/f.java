package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class f {
    public static final int[] iFl = {3, 8, 13};
    public static final int[] iFm = {2, 12};
    public static final int[] iFn = {20};
    public static final int[] iFo = {3, 13, 23};
    private SparseIntArray iFp = new SparseIntArray();
    private String iFq;
    private final int[] iFr;

    public f(String str, int[] iArr) {
        this.iFr = iArr;
        this.iFq = str;
    }

    public void zm(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.iFp != null) {
            this.iFp.clear();
            if (this.iFr != null) {
                for (int i2 : this.iFr) {
                    if (i2 >= 0) {
                        this.iFp.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void cdQ() {
        zm(0);
    }

    public void cn(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.iFp != null) {
            this.iFp.append(i2, i);
        }
    }

    public int zn(int i) {
        if (i >= 0 && this.iFp != null) {
            return this.iFp.get(i, -1);
        }
        return -1;
    }

    public void zo(int i) {
        if (this.iFp != null) {
            this.iFp.delete(i);
        }
    }
}
