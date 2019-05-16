package com.baidu.tieba.s;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class d {
    public final List<String> jmR;
    public final String jmS;

    public d(List<String> list, String str) {
        if (list != null) {
            this.jmR = new ArrayList(list);
        } else {
            this.jmR = new ArrayList();
        }
        this.jmS = str;
    }
}
