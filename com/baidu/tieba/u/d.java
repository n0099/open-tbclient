package com.baidu.tieba.u;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class d {
    public final List<String> nKo;
    public final String nKp;

    public d(List<String> list, String str) {
        if (list != null) {
            this.nKo = new ArrayList(list);
        } else {
            this.nKo = new ArrayList();
        }
        this.nKp = str;
    }
}
