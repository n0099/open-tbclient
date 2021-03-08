package com.baidu.tieba.u;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class d {
    public final List<String> nMt;
    public final String nMu;

    public d(List<String> list, String str) {
        if (list != null) {
            this.nMt = new ArrayList(list);
        } else {
            this.nMt = new ArrayList();
        }
        this.nMu = str;
    }
}
