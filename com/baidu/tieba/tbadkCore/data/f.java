package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
/* loaded from: classes.dex */
public class f {
    public static final int[] eso = {3, 8, 13};
    public static final int[] esp = {2, 7, 12, 17};
    public static final int[] esq = {20};
    public static final int[] esr = {3, 13, 23};
    private SparseIntArray ess = new SparseIntArray();
    private String est;
    private final int[] esu;

    public f(String str, int[] iArr) {
        this.esu = iArr;
        this.est = str;
    }

    public void pi(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.ess != null) {
            this.ess.clear();
            if (this.esu != null) {
                for (int i2 : this.esu) {
                    if (i2 >= 0) {
                        this.ess.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void aTw() {
        pi(0);
    }

    public void aY(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.ess != null) {
            this.ess.append(i2, i);
        }
    }

    public int pj(int i) {
        if (i >= 0 && this.ess != null) {
            return this.ess.get(i, -1);
        }
        return -1;
    }

    public void pk(int i) {
        if (this.ess != null) {
            this.ess.delete(i);
        }
    }

    public void c(int i, int i2, String str, int i3) {
        if (this.ess != null && i3 >= 0) {
            pk(i);
            aw awVar = new aw("c10376");
            awVar.ac("da_page", this.est);
            awVar.s("position", i3);
            awVar.s("view_true", i2);
            awVar.ac("fid", str);
            TiebaStatic.log(awVar);
        }
    }
}
