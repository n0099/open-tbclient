package com.baidu.tieba.q;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class d {
    public final List<String> hnI;
    public final String hnJ;

    public d(List<String> list, String str) {
        if (list != null) {
            this.hnI = new ArrayList(list);
        } else {
            this.hnI = new ArrayList();
        }
        this.hnJ = str;
    }
}
