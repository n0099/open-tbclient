package com.baidu.tieba.u;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes17.dex */
public class d {
    public final List<String> mtc;
    public final String mtd;

    public d(List<String> list, String str) {
        if (list != null) {
            this.mtc = new ArrayList(list);
        } else {
            this.mtc = new ArrayList();
        }
        this.mtd = str;
    }
}
