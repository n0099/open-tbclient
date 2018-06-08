package com.baidu.tieba.t;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class d {
    public final List<String> gVS;
    public final String gVT;

    public d(List<String> list, String str) {
        if (list != null) {
            this.gVS = new ArrayList(list);
        } else {
            this.gVS = new ArrayList();
        }
        this.gVT = str;
    }
}
