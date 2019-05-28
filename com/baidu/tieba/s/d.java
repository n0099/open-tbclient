package com.baidu.tieba.s;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class d {
    public final List<String> jmS;
    public final String jmT;

    public d(List<String> list, String str) {
        if (list != null) {
            this.jmS = new ArrayList(list);
        } else {
            this.jmS = new ArrayList();
        }
        this.jmT = str;
    }
}
