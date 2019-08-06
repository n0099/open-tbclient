package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class f {
    public static final int[] jfC = {3, 8, 13};
    public static final int[] jfD = {2, 12};
    public static final int[] jfE = {20};
    public static final int[] jfF = {3, 13, 23};
    private SparseIntArray jfG = new SparseIntArray();
    private String jfH;
    private final int[] jfI;

    public f(String str, int[] iArr) {
        this.jfI = iArr;
        this.jfH = str;
    }

    public void Bc(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.jfG != null) {
            this.jfG.clear();
            if (this.jfI != null) {
                for (int i2 : this.jfI) {
                    if (i2 >= 0) {
                        this.jfG.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void cpm() {
        Bc(0);
    }

    public void cz(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.jfG != null) {
            this.jfG.append(i2, i);
        }
    }

    public int Bd(int i) {
        if (i >= 0 && this.jfG != null) {
            return this.jfG.get(i, -1);
        }
        return -1;
    }

    public void Be(int i) {
        if (this.jfG != null) {
            this.jfG.delete(i);
        }
    }
}
