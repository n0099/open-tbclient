package com.baidu.tieba.p;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class d {
    public final List<String> gPn;
    public final String gPo;

    public d(List<String> list, String str) {
        if (list != null) {
            this.gPn = new ArrayList(list);
        } else {
            this.gPn = new ArrayList();
        }
        this.gPo = str;
    }
}
