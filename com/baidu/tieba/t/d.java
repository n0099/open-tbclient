package com.baidu.tieba.t;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class d {
    public final List<String> ktr;
    public final String kts;

    public d(List<String> list, String str) {
        if (list != null) {
            this.ktr = new ArrayList(list);
        } else {
            this.ktr = new ArrayList();
        }
        this.kts = str;
    }
}
