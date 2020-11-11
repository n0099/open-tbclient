package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class f {
    public static final int[] mWp = {3, 8, 13};
    public static final int[] mWq = {2, 12};
    public static final int[] mWr = {20};
    public static final int[] mWs = {3, 13, 23};
    private SparseIntArray mWt = new SparseIntArray();
    private String mWu;
    private final int[] mWv;

    public f(String str, int[] iArr) {
        this.mWv = iArr;
        this.mWu = str;
    }

    public void Jz(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.mWt != null) {
            this.mWt.clear();
            if (this.mWv != null) {
                for (int i2 : this.mWv) {
                    if (i2 >= 0) {
                        this.mWt.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void dJF() {
        Jz(0);
    }

    public void ds(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.mWt != null) {
            this.mWt.append(i2, i);
        }
    }

    public int JA(int i) {
        if (i >= 0 && this.mWt != null) {
            return this.mWt.get(i, -1);
        }
        return -1;
    }

    public void JB(int i) {
        if (this.mWt != null) {
            this.mWt.delete(i);
        }
    }
}
