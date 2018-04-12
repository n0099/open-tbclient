package com.baidu.tieba.r;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class d {
    public final List<String> gJq;
    public final String gJr;

    public d(List<String> list, String str) {
        if (list != null) {
            this.gJq = new ArrayList(list);
        } else {
            this.gJq = new ArrayList();
        }
        this.gJr = str;
    }
}
