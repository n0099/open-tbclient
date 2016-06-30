package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
/* loaded from: classes.dex */
public class f {
    public static final int[] eXc = {3, 8, 13};
    public static final int[] eXd = {2, 7, 12, 17};
    public static final int[] eXe = {20};
    public static final int[] eXf = {3, 13, 23};
    private SparseIntArray eXg = new SparseIntArray();
    private String eXh;
    private final int[] eXi;

    public f(String str, int[] iArr) {
        this.eXi = iArr;
        this.eXh = str;
    }

    public void qy(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.eXg != null) {
            this.eXg.clear();
            if (this.eXi != null) {
                for (int i2 : this.eXi) {
                    if (i2 >= 0) {
                        this.eXg.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void bbJ() {
        qy(0);
    }

    public void bg(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.eXg != null) {
            this.eXg.append(i2, i);
        }
    }

    public int qz(int i) {
        if (i >= 0 && this.eXg != null) {
            return this.eXg.get(i, -1);
        }
        return -1;
    }

    public void qA(int i) {
        if (this.eXg != null) {
            this.eXg.delete(i);
        }
    }

    public void c(int i, int i2, String str, int i3) {
        if (this.eXg != null && i3 >= 0) {
            qA(i);
            ay ayVar = new ay("c10376");
            ayVar.ab("da_page", this.eXh);
            ayVar.s("position", i3);
            ayVar.s("view_true", i2);
            ayVar.ab("fid", str);
            TiebaStatic.log(ayVar);
        }
    }
}
