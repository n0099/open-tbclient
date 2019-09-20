package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class f {
    public static final int[] jhX = {3, 8, 13};
    public static final int[] jhY = {2, 12};
    public static final int[] jhZ = {20};
    public static final int[] jia = {3, 13, 23};
    private SparseIntArray jib = new SparseIntArray();
    private String jic;
    private final int[] jie;

    public f(String str, int[] iArr) {
        this.jie = iArr;
        this.jic = str;
    }

    public void Bg(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.jib != null) {
            this.jib.clear();
            if (this.jie != null) {
                for (int i2 : this.jie) {
                    if (i2 >= 0) {
                        this.jib.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void cqa() {
        Bg(0);
    }

    public void cy(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.jib != null) {
            this.jib.append(i2, i);
        }
    }

    public int Bh(int i) {
        if (i >= 0 && this.jib != null) {
            return this.jib.get(i, -1);
        }
        return -1;
    }

    public void Bi(int i) {
        if (this.jib != null) {
            this.jib.delete(i);
        }
    }
}
