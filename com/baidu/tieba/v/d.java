package com.baidu.tieba.v;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes23.dex */
public class d {
    public final List<String> nAB;
    public final String nAC;

    public d(List<String> list, String str) {
        if (list != null) {
            this.nAB = new ArrayList(list);
        } else {
            this.nAB = new ArrayList();
        }
        this.nAC = str;
    }
}
