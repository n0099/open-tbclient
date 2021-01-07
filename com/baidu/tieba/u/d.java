package com.baidu.tieba.u;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class d {
    public final List<String> nEI;
    public final String nEJ;

    public d(List<String> list, String str) {
        if (list != null) {
            this.nEI = new ArrayList(list);
        } else {
            this.nEI = new ArrayList();
        }
        this.nEJ = str;
    }
}
