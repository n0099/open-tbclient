package com.baidu.tieba.p;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class d {
    public final List<String> gMA;
    public final String gMB;

    public d(List<String> list, String str) {
        if (list != null) {
            this.gMA = new ArrayList(list);
        } else {
            this.gMA = new ArrayList();
        }
        this.gMB = str;
    }
}
