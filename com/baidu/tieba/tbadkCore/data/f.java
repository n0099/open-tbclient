package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class f {
    public static final int[] lFk = {3, 8, 13};
    public static final int[] lFl = {2, 12};
    public static final int[] lFm = {20};
    public static final int[] lFn = {3, 13, 23};
    private SparseIntArray lFo = new SparseIntArray();
    private String lFp;
    private final int[] lFq;

    public f(String str, int[] iArr) {
        this.lFq = iArr;
        this.lFp = str;
    }

    public void ES(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.lFo != null) {
            this.lFo.clear();
            if (this.lFq != null) {
                for (int i2 : this.lFq) {
                    if (i2 >= 0) {
                        this.lFo.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void dhF() {
        ES(0);
    }

    public void da(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.lFo != null) {
            this.lFo.append(i2, i);
        }
    }

    public int ET(int i) {
        if (i >= 0 && this.lFo != null) {
            return this.lFo.get(i, -1);
        }
        return -1;
    }

    public void EU(int i) {
        if (this.lFo != null) {
            this.lFo.delete(i);
        }
    }
}
