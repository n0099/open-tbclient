package com.baidu.tieba.r;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class d {
    public final List<String> gKq;
    public final String gKr;

    public d(List<String> list, String str) {
        if (list != null) {
            this.gKq = new ArrayList(list);
        } else {
            this.gKq = new ArrayList();
        }
        this.gKr = str;
    }
}
