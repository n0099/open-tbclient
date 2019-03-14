package com.baidu.tieba.s;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class d {
    public final List<String> iUf;
    public final String iUg;

    public d(List<String> list, String str) {
        if (list != null) {
            this.iUf = new ArrayList(list);
        } else {
            this.iUf = new ArrayList();
        }
        this.iUg = str;
    }
}
