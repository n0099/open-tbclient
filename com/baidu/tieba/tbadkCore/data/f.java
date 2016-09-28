package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
/* loaded from: classes.dex */
public class f {
    public static final int[] fuE = {3, 8, 13};
    public static final int[] fuF = {2, 12};
    public static final int[] fuG = {20};
    public static final int[] fuH = {3, 13, 23};
    private SparseIntArray fuI = new SparseIntArray();
    private String fuJ;
    private final int[] fuK;

    public f(String str, int[] iArr) {
        this.fuK = iArr;
        this.fuJ = str;
    }

    public void rI(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.fuI != null) {
            this.fuI.clear();
            if (this.fuK != null) {
                for (int i2 : this.fuK) {
                    if (i2 >= 0) {
                        this.fuI.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void bjo() {
        rI(0);
    }

    public void bq(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.fuI != null) {
            this.fuI.append(i2, i);
        }
    }

    public int rJ(int i) {
        if (i >= 0 && this.fuI != null) {
            return this.fuI.get(i, -1);
        }
        return -1;
    }

    public void rK(int i) {
        if (this.fuI != null) {
            this.fuI.delete(i);
        }
    }

    public void c(int i, int i2, String str, int i3) {
        if (this.fuI != null && i3 >= 0) {
            rK(i);
            ax axVar = new ax("c10376");
            axVar.ab("da_page", this.fuJ);
            axVar.s("position", i3);
            axVar.s("view_true", i2);
            axVar.ab("fid", str);
            TiebaStatic.log(axVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.b bVar, int i, String str) {
        com.baidu.tbadk.distribute.a.Cp().a(bVar, "", 0L, str, "show", i);
        com.baidu.tieba.recapp.report.b.bce().a(com.baidu.tieba.recapp.report.e.a(bVar, "show", i));
    }

    public void d(int i, int i2, String str) {
        com.baidu.tieba.recapp.report.a j = com.baidu.tieba.recapp.report.e.j("store", i2, i);
        j.bN("page", str);
        com.baidu.tieba.recapp.report.b.bce().a(j);
    }
}
