package com.baidu.tieba.u;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class d {
    public final List<String> lgx;
    public final String lgy;

    public d(List<String> list, String str) {
        if (list != null) {
            this.lgx = new ArrayList(list);
        } else {
            this.lgx = new ArrayList();
        }
        this.lgy = str;
    }
}
