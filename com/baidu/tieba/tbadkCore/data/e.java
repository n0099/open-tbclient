package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class e {
    public static final int[] fvo = {3, 8, 13};
    public static final int[] fvp = {2, 12};
    public static final int[] fvq = {20};
    public static final int[] fvr = {3, 13, 23};
    private SparseIntArray fvs = new SparseIntArray();
    private String fvt;
    private final int[] fvu;

    public e(String str, int[] iArr) {
        this.fvu = iArr;
        this.fvt = str;
    }

    public void rO(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.fvs != null) {
            this.fvs.clear();
            if (this.fvu != null) {
                for (int i2 : this.fvu) {
                    if (i2 >= 0) {
                        this.fvs.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void bhM() {
        rO(0);
    }

    public void bn(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.fvs != null) {
            this.fvs.append(i2, i);
        }
    }

    public int rP(int i) {
        if (i >= 0 && this.fvs != null) {
            return this.fvs.get(i, -1);
        }
        return -1;
    }

    public void rQ(int i) {
        if (this.fvs != null) {
            this.fvs.delete(i);
        }
    }
}
