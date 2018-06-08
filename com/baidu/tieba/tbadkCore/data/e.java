package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class e {
    public static final int[] gIu = {3, 8, 13};
    public static final int[] gIv = {2, 12};
    public static final int[] gIw = {20};
    public static final int[] gIx = {3, 13, 23};
    private final int[] gIA;
    private SparseIntArray gIy = new SparseIntArray();
    private String gIz;

    public e(String str, int[] iArr) {
        this.gIA = iArr;
        this.gIz = str;
    }

    public void tv(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.gIy != null) {
            this.gIy.clear();
            if (this.gIA != null) {
                for (int i2 : this.gIA) {
                    if (i2 >= 0) {
                        this.gIy.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void bwC() {
        tv(0);
    }

    public void bJ(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.gIy != null) {
            this.gIy.append(i2, i);
        }
    }

    public int tw(int i) {
        if (i >= 0 && this.gIy != null) {
            return this.gIy.get(i, -1);
        }
        return -1;
    }

    public void tx(int i) {
        if (this.gIy != null) {
            this.gIy.delete(i);
        }
    }
}
