package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
/* loaded from: classes.dex */
public class f {
    public static final int[] fBQ = {3, 8, 13};
    public static final int[] fBR = {2, 12};
    public static final int[] fBS = {20};
    public static final int[] fBT = {3, 13, 23};
    private SparseIntArray fBU = new SparseIntArray();
    private String fBV;
    private final int[] fBW;

    public f(String str, int[] iArr) {
        this.fBW = iArr;
        this.fBV = str;
    }

    public void sb(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.fBU != null) {
            this.fBU.clear();
            if (this.fBW != null) {
                for (int i2 : this.fBW) {
                    if (i2 >= 0) {
                        this.fBU.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void blJ() {
        sb(0);
    }

    public void bv(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.fBU != null) {
            this.fBU.append(i2, i);
        }
    }

    public int sc(int i) {
        if (i >= 0 && this.fBU != null) {
            return this.fBU.get(i, -1);
        }
        return -1;
    }

    public void sd(int i) {
        if (this.fBU != null) {
            this.fBU.delete(i);
        }
    }

    public void c(int i, int i2, String str, int i3) {
        if (this.fBU != null && i3 >= 0) {
            sd(i);
            av avVar = new av("c10376");
            avVar.ab("da_page", this.fBV);
            avVar.s("position", i3);
            avVar.s("view_true", i2);
            avVar.ab("fid", str);
            TiebaStatic.log(avVar);
        }
    }
}
