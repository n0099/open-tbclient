package com.baidu.tieba.p;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class d {
    public final List<String> gPi;
    public final String gPj;

    public d(List<String> list, String str) {
        if (list != null) {
            this.gPi = new ArrayList(list);
        } else {
            this.gPi = new ArrayList();
        }
        this.gPj = str;
    }
}
