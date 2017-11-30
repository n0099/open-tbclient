package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class e {
    public static final int[] gyE = {3, 8, 13};
    public static final int[] gyF = {2, 12};
    public static final int[] gyG = {20};
    public static final int[] gyH = {3, 13, 23};
    private SparseIntArray gyI = new SparseIntArray();
    private String gyJ;
    private final int[] gyK;

    public e(String str, int[] iArr) {
        this.gyK = iArr;
        this.gyJ = str;
    }

    public void uh(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.gyI != null) {
            this.gyI.clear();
            if (this.gyK != null) {
                for (int i2 : this.gyK) {
                    if (i2 >= 0) {
                        this.gyI.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void bvQ() {
        uh(0);
    }

    public void bU(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.gyI != null) {
            this.gyI.append(i2, i);
        }
    }

    public int ui(int i) {
        if (i >= 0 && this.gyI != null) {
            return this.gyI.get(i, -1);
        }
        return -1;
    }

    public void uj(int i) {
        if (this.gyI != null) {
            this.gyI.delete(i);
        }
    }
}
