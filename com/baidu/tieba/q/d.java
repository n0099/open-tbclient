package com.baidu.tieba.q;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class d {
    public final List<String> hwl;
    public final String hwm;

    public d(List<String> list, String str) {
        if (list != null) {
            this.hwl = new ArrayList(list);
        } else {
            this.hwl = new ArrayList();
        }
        this.hwm = str;
    }
}
