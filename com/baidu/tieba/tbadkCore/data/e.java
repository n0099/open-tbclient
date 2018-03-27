package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class e {
    private SparseIntArray haB = new SparseIntArray();
    private String haC;
    private final int[] haD;
    public static final int[] hax = {3, 8, 13};
    public static final int[] hay = {2, 12};
    public static final int[] haz = {20};
    public static final int[] haA = {3, 13, 23};

    public e(String str, int[] iArr) {
        this.haD = iArr;
        this.haC = str;
    }

    public void vI(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.haB != null) {
            this.haB.clear();
            if (this.haD != null) {
                for (int i2 : this.haD) {
                    if (i2 >= 0) {
                        this.haB.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void bwA() {
        vI(0);
    }

    public void cG(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.haB != null) {
            this.haB.append(i2, i);
        }
    }

    public int vJ(int i) {
        if (i >= 0 && this.haB != null) {
            return this.haB.get(i, -1);
        }
        return -1;
    }

    public void vK(int i) {
        if (this.haB != null) {
            this.haB.delete(i);
        }
    }
}
