package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
/* loaded from: classes.dex */
public class e {
    public static final int[] dGB = {3, 8, 13};
    public static final int[] dGC = {2, 7, 12, 17};
    public static final int[] dGD = {3, 13, 23};
    private SparseIntArray dGE = new SparseIntArray();
    private String dGF;
    private final int[] dGG;

    public e(String str, int[] iArr) {
        this.dGG = iArr;
        this.dGF = str;
    }

    public void mU(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.dGE != null) {
            this.dGE.clear();
            if (this.dGG != null) {
                for (int i2 : this.dGG) {
                    if (i2 >= 0) {
                        this.dGE.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void aEO() {
        mU(0);
    }

    public void aX(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.dGE != null) {
            this.dGE.append(i2, i);
        }
    }

    public int mV(int i) {
        if (i >= 0 && this.dGE != null) {
            return this.dGE.get(i, -1);
        }
        return -1;
    }

    public void c(int i, int i2, String str, int i3) {
        if (this.dGE != null && i3 >= 0) {
            this.dGE.delete(i);
            av avVar = new av("c10376");
            avVar.aa("da_page", this.dGF);
            avVar.r("position", i3);
            avVar.r("view_true", i2);
            avVar.aa(ImageViewerConfig.FORUM_ID, str);
            TiebaStatic.log(avVar);
        }
    }
}
