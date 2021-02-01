package com.baidu.tieba.u;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class d {
    public final List<String> nJO;
    public final String nJP;

    public d(List<String> list, String str) {
        if (list != null) {
            this.nJO = new ArrayList(list);
        } else {
            this.nJO = new ArrayList();
        }
        this.nJP = str;
    }
}
