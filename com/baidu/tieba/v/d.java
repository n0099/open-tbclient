package com.baidu.tieba.v;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes23.dex */
public class d {
    public final String nAA;
    public final List<String> nAz;

    public d(List<String> list, String str) {
        if (list != null) {
            this.nAz = new ArrayList(list);
        } else {
            this.nAz = new ArrayList();
        }
        this.nAA = str;
    }
}
