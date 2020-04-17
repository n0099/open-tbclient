package com.baidu.tieba.u;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class d {
    public final List<String> lgt;
    public final String lgu;

    public d(List<String> list, String str) {
        if (list != null) {
            this.lgt = new ArrayList(list);
        } else {
            this.lgt = new ArrayList();
        }
        this.lgu = str;
    }
}
