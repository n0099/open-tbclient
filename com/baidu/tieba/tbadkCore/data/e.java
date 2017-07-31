package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class e {
    public static final int[] ghm = {3, 8, 13};
    public static final int[] ghn = {2, 12};
    public static final int[] gho = {20};
    public static final int[] ghp = {3, 13, 23};
    private SparseIntArray ghq = new SparseIntArray();
    private String ghr;
    private final int[] ghs;

    public e(String str, int[] iArr) {
        this.ghs = iArr;
        this.ghr = str;
    }

    public void te(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.ghq != null) {
            this.ghq.clear();
            if (this.ghs != null) {
                for (int i2 : this.ghs) {
                    if (i2 >= 0) {
                        this.ghq.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void brZ() {
        te(0);
    }

    public void bw(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.ghq != null) {
            this.ghq.append(i2, i);
        }
    }

    public int tf(int i) {
        if (i >= 0 && this.ghq != null) {
            return this.ghq.get(i, -1);
        }
        return -1;
    }

    public void tg(int i) {
        if (this.ghq != null) {
            this.ghq.delete(i);
        }
    }
}
