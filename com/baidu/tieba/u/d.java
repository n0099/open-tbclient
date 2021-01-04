package com.baidu.tieba.u;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class d {
    public final List<String> nEJ;
    public final String nEK;

    public d(List<String> list, String str) {
        if (list != null) {
            this.nEJ = new ArrayList(list);
        } else {
            this.nEJ = new ArrayList();
        }
        this.nEK = str;
    }
}
