package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class f {
    public static final int[] mDG = {3, 8, 13};
    public static final int[] mDH = {2, 12};
    public static final int[] mDI = {20};
    public static final int[] mDJ = {3, 13, 23};
    private SparseIntArray mDK = new SparseIntArray();
    private String mDL;
    private final int[] mDM;

    public f(String str, int[] iArr) {
        this.mDM = iArr;
        this.mDL = str;
    }

    public void IU(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.mDK != null) {
            this.mDK.clear();
            if (this.mDM != null) {
                for (int i2 : this.mDM) {
                    if (i2 >= 0) {
                        this.mDK.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void dDV() {
        IU(0);
    }

    /* renamed from: do  reason: not valid java name */
    public void m42do(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.mDK != null) {
            this.mDK.append(i2, i);
        }
    }

    public int IV(int i) {
        if (i >= 0 && this.mDK != null) {
            return this.mDK.get(i, -1);
        }
        return -1;
    }

    public void IW(int i) {
        if (this.mDK != null) {
            this.mDK.delete(i);
        }
    }
}
