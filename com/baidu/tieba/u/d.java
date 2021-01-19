package com.baidu.tieba.u;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class d {
    public final List<String> nAe;
    public final String nAf;

    public d(List<String> list, String str) {
        if (list != null) {
            this.nAe = new ArrayList(list);
        } else {
            this.nAe = new ArrayList();
        }
        this.nAf = str;
    }
}
