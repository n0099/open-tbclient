package com.baidu.tieba.u;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class d {
    public final List<String> kuH;
    public final String kuI;

    public d(List<String> list, String str) {
        if (list != null) {
            this.kuH = new ArrayList(list);
        } else {
            this.kuH = new ArrayList();
        }
        this.kuI = str;
    }
}
