package com.baidu.tieba.u;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class d {
    public final List<String> lzi;
    public final String lzj;

    public d(List<String> list, String str) {
        if (list != null) {
            this.lzi = new ArrayList(list);
        } else {
            this.lzi = new ArrayList();
        }
        this.lzj = str;
    }
}
