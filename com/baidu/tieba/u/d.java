package com.baidu.tieba.u;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes17.dex */
public class d {
    public final List<String> mbp;
    public final String mbq;

    public d(List<String> list, String str) {
        if (list != null) {
            this.mbp = new ArrayList(list);
        } else {
            this.mbp = new ArrayList();
        }
        this.mbq = str;
    }
}
