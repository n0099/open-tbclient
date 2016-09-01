package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
/* loaded from: classes.dex */
public class f {
    public static final int[] frY = {3, 8, 13};
    public static final int[] frZ = {2, 7, 12, 17};
    public static final int[] fsa = {20};
    public static final int[] fsb = {3, 13, 23};
    private SparseIntArray fsc = new SparseIntArray();
    private String fsd;
    private final int[] fse;

    public f(String str, int[] iArr) {
        this.fse = iArr;
        this.fsd = str;
    }

    public void ru(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.fsc != null) {
            this.fsc.clear();
            if (this.fse != null) {
                for (int i2 : this.fse) {
                    if (i2 >= 0) {
                        this.fsc.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void biD() {
        ru(0);
    }

    public void bo(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.fsc != null) {
            this.fsc.append(i2, i);
        }
    }

    public int rv(int i) {
        if (i >= 0 && this.fsc != null) {
            return this.fsc.get(i, -1);
        }
        return -1;
    }

    public void rw(int i) {
        if (this.fsc != null) {
            this.fsc.delete(i);
        }
    }

    public void c(int i, int i2, String str, int i3) {
        if (this.fsc != null && i3 >= 0) {
            rw(i);
            ay ayVar = new ay("c10376");
            ayVar.ab("da_page", this.fsd);
            ayVar.s("position", i3);
            ayVar.s("view_true", i2);
            ayVar.ab("fid", str);
            TiebaStatic.log(ayVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.b bVar, int i, String str) {
        com.baidu.tbadk.distribute.a.Cp().a(bVar, "", 0L, str, "show", i);
        com.baidu.tieba.recapp.report.b.bbu().a(com.baidu.tieba.recapp.report.e.a(bVar, "show", i));
    }

    public void d(int i, int i2, String str) {
        com.baidu.tieba.recapp.report.a j = com.baidu.tieba.recapp.report.e.j("store", i2, i);
        j.bM("page", str);
        com.baidu.tieba.recapp.report.b.bbu().a(j);
    }
}
