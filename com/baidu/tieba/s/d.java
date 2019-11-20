package com.baidu.tieba.s;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class d {
    public final List<String> jvG;
    public final String jvH;

    public d(List<String> list, String str) {
        if (list != null) {
            this.jvG = new ArrayList(list);
        } else {
            this.jvG = new ArrayList();
        }
        this.jvH = str;
    }
}
