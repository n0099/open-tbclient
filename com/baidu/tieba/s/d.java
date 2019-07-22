package com.baidu.tieba.s;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class d {
    public final List<String> jtd;
    public final String jte;

    public d(List<String> list, String str) {
        if (list != null) {
            this.jtd = new ArrayList(list);
        } else {
            this.jtd = new ArrayList();
        }
        this.jte = str;
    }
}
