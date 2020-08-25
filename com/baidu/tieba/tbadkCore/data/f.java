package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
/* loaded from: classes2.dex */
public class f {
    public static final int[] mel = {3, 8, 13};
    public static final int[] men = {2, 12};
    public static final int[] meo = {20};
    public static final int[] mep = {3, 13, 23};
    private SparseIntArray meq = new SparseIntArray();
    private String mer;
    private final int[] mes;

    public f(String str, int[] iArr) {
        this.mes = iArr;
        this.mer = str;
    }

    public void HL(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.meq != null) {
            this.meq.clear();
            if (this.mes != null) {
                for (int i2 : this.mes) {
                    if (i2 >= 0) {
                        this.meq.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void dwl() {
        HL(0);
    }

    public void dk(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.meq != null) {
            this.meq.append(i2, i);
        }
    }

    public int HM(int i) {
        if (i >= 0 && this.meq != null) {
            return this.meq.get(i, -1);
        }
        return -1;
    }

    public void HN(int i) {
        if (this.meq != null) {
            this.meq.delete(i);
        }
    }
}
