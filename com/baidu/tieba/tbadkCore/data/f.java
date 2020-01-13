package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class f {
    public static final int[] keM = {3, 8, 13};
    public static final int[] keN = {2, 12};
    public static final int[] keO = {20};
    public static final int[] keP = {3, 13, 23};
    private SparseIntArray keQ = new SparseIntArray();
    private String keR;
    private final int[] keS;

    public f(String str, int[] iArr) {
        this.keS = iArr;
        this.keR = str;
    }

    public void Cm(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.keQ != null) {
            this.keQ.clear();
            if (this.keS != null) {
                for (int i2 : this.keS) {
                    if (i2 >= 0) {
                        this.keQ.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void cIZ() {
        Cm(0);
    }

    public void cG(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.keQ != null) {
            this.keQ.append(i2, i);
        }
    }

    public int Cn(int i) {
        if (i >= 0 && this.keQ != null) {
            return this.keQ.get(i, -1);
        }
        return -1;
    }

    public void Co(int i) {
        if (this.keQ != null) {
            this.keQ.delete(i);
        }
    }
}
