package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
/* loaded from: classes.dex */
public class f {
    public static final int[] epe = {3, 8, 13};
    public static final int[] epf = {2, 7, 12, 17};
    public static final int[] epg = {20};
    public static final int[] eph = {3, 13, 23};
    private SparseIntArray epi = new SparseIntArray();
    private String epj;
    private final int[] epk;

    public f(String str, int[] iArr) {
        this.epk = iArr;
        this.epj = str;
    }

    public void pn(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.epi != null) {
            this.epi.clear();
            if (this.epk != null) {
                for (int i2 : this.epk) {
                    if (i2 >= 0) {
                        this.epi.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void aSP() {
        pn(0);
    }

    public void aY(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.epi != null) {
            this.epi.append(i2, i);
        }
    }

    public int po(int i) {
        if (i >= 0 && this.epi != null) {
            return this.epi.get(i, -1);
        }
        return -1;
    }

    public void pp(int i) {
        if (this.epi != null) {
            this.epi.delete(i);
        }
    }

    public void c(int i, int i2, String str, int i3) {
        if (this.epi != null && i3 >= 0) {
            pp(i);
            aw awVar = new aw("c10376");
            awVar.ac("da_page", this.epj);
            awVar.r("position", i3);
            awVar.r("view_true", i2);
            awVar.ac("fid", str);
            TiebaStatic.log(awVar);
        }
    }
}
