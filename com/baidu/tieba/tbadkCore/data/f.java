package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
/* loaded from: classes.dex */
public class f {
    public static final int[] fke = {3, 8, 13};
    public static final int[] fkf = {2, 7, 12, 17};
    public static final int[] fkg = {20};
    public static final int[] fkh = {3, 13, 23};
    private SparseIntArray fki = new SparseIntArray();
    private String fkj;
    private final int[] fkk;

    public f(String str, int[] iArr) {
        this.fkk = iArr;
        this.fkj = str;
    }

    public void qT(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.fki != null) {
            this.fki.clear();
            if (this.fkk != null) {
                for (int i2 : this.fkk) {
                    if (i2 >= 0) {
                        this.fki.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void beY() {
        qT(0);
    }

    public void bj(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.fki != null) {
            this.fki.append(i2, i);
        }
    }

    public int qU(int i) {
        if (i >= 0 && this.fki != null) {
            return this.fki.get(i, -1);
        }
        return -1;
    }

    public void qV(int i) {
        if (this.fki != null) {
            this.fki.delete(i);
        }
    }

    public void c(int i, int i2, String str, int i3) {
        if (this.fki != null && i3 >= 0) {
            qV(i);
            ay ayVar = new ay("c10376");
            ayVar.ab("da_page", this.fkj);
            ayVar.s("position", i3);
            ayVar.s("view_true", i2);
            ayVar.ab("fid", str);
            TiebaStatic.log(ayVar);
        }
    }
}
