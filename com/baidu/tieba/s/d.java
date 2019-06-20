package com.baidu.tieba.s;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class d {
    public final List<String> jmW;
    public final String jmX;

    public d(List<String> list, String str) {
        if (list != null) {
            this.jmW = new ArrayList(list);
        } else {
            this.jmW = new ArrayList();
        }
        this.jmX = str;
    }
}
