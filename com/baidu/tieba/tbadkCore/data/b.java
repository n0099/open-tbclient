package com.baidu.tieba.tbadkCore.data;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import java.util.HashSet;
/* loaded from: classes.dex */
public class b {
    private static final int[] cYq = {3, 8, 13};
    private static final int[] cYr = {2, 7, 12, 17};
    private HashSet<Integer> cYs = new HashSet<>();
    private final boolean cYt;
    private final boolean cYu;
    private String cYv;

    public b(String str) {
        this.cYv = str;
        this.cYt = TextUtils.equals(this.cYv, "frs");
        this.cYu = TextUtils.equals(this.cYv, "pb");
    }

    public boolean kS(int i) {
        if ((this.cYt || this.cYu) && !this.cYs.contains(Integer.valueOf(i))) {
            if (this.cYt) {
                for (int i2 : cYq) {
                    if (i2 == i) {
                        return true;
                    }
                }
                return false;
            } else if (this.cYu) {
                for (int i3 : cYr) {
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
        if (this.cYt || this.cYu) {
            this.cYs.add(Integer.valueOf(i));
            ap apVar = new ap("c10376");
            apVar.ae("da_page", this.cYv);
            apVar.r("position", i);
            apVar.r("view_true", i2);
            apVar.ae(ImageViewerConfig.FORUM_ID, str);
            TiebaStatic.log(apVar);
        }
    }
}
