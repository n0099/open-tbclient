package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public class e {
    public static final int[] hkL = {3, 8, 13};
    public static final int[] hkM = {2, 12};
    public static final int[] hkN = {20};
    public static final int[] hkO = {3, 13, 23};
    private SparseIntArray hkP = new SparseIntArray();
    private String hkQ;
    private final int[] hkR;

    public e(String str, int[] iArr) {
        this.hkR = iArr;
        this.hkQ = str;
    }

    public void vr(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.hkP != null) {
            this.hkP.clear();
            if (this.hkR != null) {
                for (int i2 : this.hkR) {
                    if (i2 >= 0) {
                        this.hkP.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void bCT() {
        vr(0);
    }

    public void bQ(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.hkP != null) {
            this.hkP.append(i2, i);
        }
    }

    public int vs(int i) {
        if (i >= 0 && this.hkP != null) {
            return this.hkP.get(i, -1);
        }
        return -1;
    }

    public void vt(int i) {
        if (this.hkP != null) {
            this.hkP.delete(i);
        }
    }
}
