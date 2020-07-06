package com.baidu.tieba.u;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class d {
    public final List<String> lTZ;
    public final String lUa;

    public d(List<String> list, String str) {
        if (list != null) {
            this.lTZ = new ArrayList(list);
        } else {
            this.lTZ = new ArrayList();
        }
        this.lUa = str;
    }
}
