package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class f {
    public static final int[] meB = {3, 8, 13};
    public static final int[] meC = {2, 12};
    public static final int[] meD = {20};
    public static final int[] meE = {3, 13, 23};
    private SparseIntArray meF = new SparseIntArray();
    private String meG;
    private final int[] meH;

    public f(String str, int[] iArr) {
        this.meH = iArr;
        this.meG = str;
    }

    public void HL(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.meF != null) {
            this.meF.clear();
            if (this.meH != null) {
                for (int i2 : this.meH) {
                    if (i2 >= 0) {
                        this.meF.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void dwq() {
        HL(0);
    }

    public void dk(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.meF != null) {
            this.meF.append(i2, i);
        }
    }

    public int HM(int i) {
        if (i >= 0 && this.meF != null) {
            return this.meF.get(i, -1);
        }
        return -1;
    }

    public void HN(int i) {
        if (this.meF != null) {
            this.meF.delete(i);
        }
    }
}
