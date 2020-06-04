package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class f {
    public static final int[] llq = {3, 8, 13};
    public static final int[] llr = {2, 12};
    public static final int[] lls = {20};
    public static final int[] llt = {3, 13, 23};
    private SparseIntArray llu = new SparseIntArray();
    private String llv;
    private final int[] llw;

    public f(String str, int[] iArr) {
        this.llw = iArr;
        this.llv = str;
    }

    public void DQ(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.llu != null) {
            this.llu.clear();
            if (this.llw != null) {
                for (int i2 : this.llw) {
                    if (i2 >= 0) {
                        this.llu.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void ddp() {
        DQ(0);
    }

    public void cU(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.llu != null) {
            this.llu.append(i2, i);
        }
    }

    public int DR(int i) {
        if (i >= 0 && this.llu != null) {
            return this.llu.get(i, -1);
        }
        return -1;
    }

    public void DS(int i) {
        if (this.llu != null) {
            this.llu.delete(i);
        }
    }
}
