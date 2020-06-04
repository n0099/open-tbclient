package com.baidu.tieba.u;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class d {
    public final List<String> lAr;
    public final String lAs;

    public d(List<String> list, String str) {
        if (list != null) {
            this.lAr = new ArrayList(list);
        } else {
            this.lAr = new ArrayList();
        }
        this.lAs = str;
    }
}
