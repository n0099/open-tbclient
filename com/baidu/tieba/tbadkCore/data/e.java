package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
/* loaded from: classes.dex */
public class e {
    public static final int[] dzh = {3, 8, 13};
    public static final int[] dzi = {2, 7, 12, 17};
    public static final int[] dzj = {3, 13, 23};
    private SparseIntArray dzk = new SparseIntArray();
    private String dzl;
    private final int[] dzm;

    public e(String str, int[] iArr) {
        this.dzm = iArr;
        this.dzl = str;
    }

    public void mt(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.dzk != null) {
            this.dzk.clear();
            if (this.dzm != null) {
                for (int i2 : this.dzm) {
                    if (i2 >= 0) {
                        this.dzk.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void aCH() {
        mt(0);
    }

    public void aI(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.dzk != null) {
            this.dzk.append(i2, i);
        }
    }

    public int mu(int i) {
        if (i >= 0 && this.dzk != null) {
            return this.dzk.get(i, -1);
        }
        return -1;
    }

    public void c(int i, int i2, String str, int i3) {
        if (this.dzk != null && i3 >= 0) {
            this.dzk.delete(i);
            av avVar = new av("c10376");
            avVar.ab("da_page", this.dzl);
            avVar.r("position", i3);
            avVar.r("view_true", i2);
            avVar.ab(ImageViewerConfig.FORUM_ID, str);
            TiebaStatic.log(avVar);
        }
    }
}
