package com.baidu.tieba.u;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class d {
    public final List<String> kut;
    public final String kuu;

    public d(List<String> list, String str) {
        if (list != null) {
            this.kut = new ArrayList(list);
        } else {
            this.kut = new ArrayList();
        }
        this.kuu = str;
    }
}
