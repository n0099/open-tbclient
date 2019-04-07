package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class f {
    public static final int[] iFk = {3, 8, 13};
    public static final int[] iFl = {2, 12};
    public static final int[] iFm = {20};
    public static final int[] iFn = {3, 13, 23};
    private SparseIntArray iFo = new SparseIntArray();
    private String iFp;
    private final int[] iFq;

    public f(String str, int[] iArr) {
        this.iFq = iArr;
        this.iFp = str;
    }

    public void zm(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.iFo != null) {
            this.iFo.clear();
            if (this.iFq != null) {
                for (int i2 : this.iFq) {
                    if (i2 >= 0) {
                        this.iFo.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void cdQ() {
        zm(0);
    }

    public void cn(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.iFo != null) {
            this.iFo.append(i2, i);
        }
    }

    public int zn(int i) {
        if (i >= 0 && this.iFo != null) {
            return this.iFo.get(i, -1);
        }
        return -1;
    }

    public void zo(int i) {
        if (this.iFo != null) {
            this.iFo.delete(i);
        }
    }
}
