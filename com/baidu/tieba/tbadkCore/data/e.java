package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class e {
    public static final int[] hnW = {3, 8, 13};
    public static final int[] hnX = {2, 12};
    public static final int[] hnY = {20};
    public static final int[] hnZ = {3, 13, 23};
    private SparseIntArray hoa = new SparseIntArray();
    private String hob;
    private final int[] hoc;

    public e(String str, int[] iArr) {
        this.hoc = iArr;
        this.hob = str;
    }

    public void vE(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.hoa != null) {
            this.hoa.clear();
            if (this.hoc != null) {
                for (int i2 : this.hoc) {
                    if (i2 >= 0) {
                        this.hoa.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void bDK() {
        vE(0);
    }

    public void bR(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.hoa != null) {
            this.hoa.append(i2, i);
        }
    }

    public int vF(int i) {
        if (i >= 0 && this.hoa != null) {
            return this.hoa.get(i, -1);
        }
        return -1;
    }

    public void vG(int i) {
        if (this.hoa != null) {
            this.hoa.delete(i);
        }
    }
}
