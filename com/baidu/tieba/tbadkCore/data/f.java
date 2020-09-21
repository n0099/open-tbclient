package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class f {
    public static final int[] mnZ = {3, 8, 13};
    public static final int[] moa = {2, 12};
    public static final int[] mob = {20};
    public static final int[] moc = {3, 13, 23};
    private SparseIntArray mod = new SparseIntArray();
    private String moe;
    private final int[] mof;

    public f(String str, int[] iArr) {
        this.mof = iArr;
        this.moe = str;
    }

    public void Io(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.mod != null) {
            this.mod.clear();
            if (this.mof != null) {
                for (int i2 : this.mof) {
                    if (i2 >= 0) {
                        this.mod.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void dAj() {
        Io(0);
    }

    /* renamed from: do  reason: not valid java name */
    public void m43do(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.mod != null) {
            this.mod.append(i2, i);
        }
    }

    public int Ip(int i) {
        if (i >= 0 && this.mod != null) {
            return this.mod.get(i, -1);
        }
        return -1;
    }

    public void Iq(int i) {
        if (this.mod != null) {
            this.mod.delete(i);
        }
    }
}
