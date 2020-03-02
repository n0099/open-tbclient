package com.baidu.tieba.u;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class d {
    public final List<String> kuv;
    public final String kuw;

    public d(List<String> list, String str) {
        if (list != null) {
            this.kuv = new ArrayList(list);
        } else {
            this.kuv = new ArrayList();
        }
        this.kuw = str;
    }
}
