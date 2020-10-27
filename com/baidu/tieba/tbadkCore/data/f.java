package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class f {
    public static final int[] mQm = {3, 8, 13};
    public static final int[] mQn = {2, 12};
    public static final int[] mQo = {20};
    public static final int[] mQp = {3, 13, 23};
    private SparseIntArray mQq = new SparseIntArray();
    private String mQr;
    private final int[] mQs;

    public f(String str, int[] iArr) {
        this.mQs = iArr;
        this.mQr = str;
    }

    public void Jm(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.mQq != null) {
            this.mQq.clear();
            if (this.mQs != null) {
                for (int i2 : this.mQs) {
                    if (i2 >= 0) {
                        this.mQq.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void dHd() {
        Jm(0);
    }

    public void dq(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.mQq != null) {
            this.mQq.append(i2, i);
        }
    }

    public int Jn(int i) {
        if (i >= 0 && this.mQq != null) {
            return this.mQq.get(i, -1);
        }
        return -1;
    }

    public void Jo(int i) {
        if (this.mQq != null) {
            this.mQq.delete(i);
        }
    }
}
