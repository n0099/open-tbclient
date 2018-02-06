package com.baidu.tieba.q;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class d {
    public final List<String> hnx;
    public final String hny;

    public d(List<String> list, String str) {
        if (list != null) {
            this.hnx = new ArrayList(list);
        } else {
            this.hnx = new ArrayList();
        }
        this.hny = str;
    }
}
