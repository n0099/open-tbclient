package com.baidu.tieba.tbadkCore.data;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import java.util.HashSet;
/* loaded from: classes.dex */
public class e {
    private static final int[] dau = {3, 8, 13};
    private static final int[] dav = {2, 7, 12, 17};
    private String daA;
    private HashSet<Integer> daw = new HashSet<>();
    private final boolean dax;
    private final boolean daz;

    public e(String str) {
        this.daA = str;
        this.dax = TextUtils.equals(this.daA, "frs");
        this.daz = TextUtils.equals(this.daA, "pb");
    }

    public void awV() {
        if (this.daw != null) {
            this.daw.clear();
        }
    }

    public boolean li(int i) {
        if ((this.dax || this.daz) && !this.daw.contains(Integer.valueOf(i))) {
            if (this.dax) {
                for (int i2 : dau) {
                    if (i2 == i) {
                        return true;
                    }
                }
                return false;
            } else if (this.daz) {
                for (int i3 : dav) {
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
        if (this.dax || this.daz) {
            this.daw.add(Integer.valueOf(i));
            aq aqVar = new aq("c10376");
            aqVar.ae("da_page", this.daA);
            aqVar.r("position", i);
            aqVar.r("view_true", i2);
            aqVar.ae(ImageViewerConfig.FORUM_ID, str);
            TiebaStatic.log(aqVar);
        }
    }
}
