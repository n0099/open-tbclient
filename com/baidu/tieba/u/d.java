package com.baidu.tieba.u;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class d {
    public final List<String> kwl;
    public final String kwm;

    public d(List<String> list, String str) {
        if (list != null) {
            this.kwl = new ArrayList(list);
        } else {
            this.kwl = new ArrayList();
        }
        this.kwm = str;
    }
}
