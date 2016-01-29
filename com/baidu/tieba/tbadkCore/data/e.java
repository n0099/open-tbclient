package com.baidu.tieba.tbadkCore.data;

import android.util.SparseIntArray;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
/* loaded from: classes.dex */
public class e {
    public static final int[] dWw = {3, 8, 13};
    public static final int[] dWx = {2, 7, 12, 17};
    public static final int[] dWy = {-1};
    public static final int[] dWz = {3, 13, 23};
    private SparseIntArray dWA = new SparseIntArray();
    private String dWB;
    private final int[] dWC;

    public e(String str, int[] iArr) {
        this.dWC = iArr;
        this.dWB = str;
    }

    public void oe(int i) {
        int[] iArr;
        if (i < 0) {
            i = 0;
        }
        if (this.dWA != null) {
            this.dWA.clear();
            if (this.dWC != null) {
                for (int i2 : this.dWC) {
                    if (i2 >= 0) {
                        this.dWA.append(i2 + i, i2);
                    }
                }
            }
        }
    }

    public void aLU() {
        oe(0);
    }

    public void ba(int i, int i2) {
        if (i >= 0 && i2 >= 0 && this.dWA != null) {
            this.dWA.append(i2, i);
        }
    }

    public int of(int i) {
        if (i >= 0 && this.dWA != null) {
            return this.dWA.get(i, -1);
        }
        return -1;
    }

    public void og(int i) {
        if (this.dWA != null) {
            this.dWA.delete(i);
        }
    }

    public void c(int i, int i2, String str, int i3) {
        if (this.dWA != null && i3 >= 0) {
            og(i);
            au auVar = new au("c10376");
            auVar.aa("da_page", this.dWB);
            auVar.r("position", i3);
            auVar.r("view_true", i2);
            auVar.aa(ImageViewerConfig.FORUM_ID, str);
            TiebaStatic.log(auVar);
        }
    }
}
