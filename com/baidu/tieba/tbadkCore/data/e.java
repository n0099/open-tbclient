package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class e {
    public static final int[] gjf = {3, 8, 13};
    public static final int[] gjg = {2, 12};
    public static final int[] gjh = {20};
    public static final int[] gji = {3, 13, 23};
    private SparseIntArray gjj = new SparseIntArray();
    private String gjk;
    private final int[] gjl;

    public e(String str, int[] iArr) {
        this.gjl = iArr;
        this.gjk = str;
    }

    public void to(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.gjj != null) {
            this.gjj.clear();
            if (this.gjl != null) {
                for (int i2 : this.gjl) {
                    if (i2 >= 0) {
                        this.gjj.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void bsH() {
        to(0);
    }

    public void bE(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.gjj != null) {
            this.gjj.append(i2, i);
        }
    }

    public int tp(int i) {
        if (i >= 0 && this.gjj != null) {
            return this.gjj.get(i, -1);
        }
        return -1;
    }

    public void tq(int i) {
        if (this.gjj != null) {
            this.gjj.delete(i);
        }
    }
}
