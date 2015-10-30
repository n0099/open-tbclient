package com.baidu.tieba.tbadkCore.data;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import java.util.HashSet;
/* loaded from: classes.dex */
public class b {
    private static final int[] cYQ = {3, 8, 13};
    private static final int[] cYR = {2, 7, 12, 17};
    private HashSet<Integer> cYS = new HashSet<>();
    private final boolean cYT;
    private final boolean cYU;
    private String cYV;

    public b(String str) {
        this.cYV = str;
        this.cYT = TextUtils.equals(this.cYV, "frs");
        this.cYU = TextUtils.equals(this.cYV, "pb");
    }

    public void awi() {
        if (this.cYS != null) {
            this.cYS.clear();
        }
    }

    public boolean kU(int i) {
        if ((this.cYT || this.cYU) && !this.cYS.contains(Integer.valueOf(i))) {
            if (this.cYT) {
                for (int i2 : cYQ) {
                    if (i2 == i) {
                        return true;
                    }
                }
                return false;
            } else if (this.cYU) {
                for (int i3 : cYR) {
                    if (i3 == i) {
                        return true;
                    }
                }
                return false;
            } else {
                return false;
            }
        }
        return false;
    }

    public void d(int i, int i2, String str) {
        if (this.cYT || this.cYU) {
            this.cYS.add(Integer.valueOf(i));
            aq aqVar = new aq("c10376");
            aqVar.ae("da_page", this.cYV);
            aqVar.r("position", i);
            aqVar.r("view_true", i2);
            aqVar.ae(ImageViewerConfig.FORUM_ID, str);
            TiebaStatic.log(aqVar);
        }
    }
}
